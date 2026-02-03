package lu.post.eval.infra.ip;

import com.fasterxml.jackson.databind.ObjectMapper;
import lu.post.gen.v6.httpbin.RequestInspectionApi;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HTTPBinIpClientTest {

    @Mock
    private RequestInspectionApi requestInspectionApi;

    private HTTPBinIpClient client;

    @BeforeEach
    void setUp() {
        client = new HTTPBinIpClient(requestInspectionApi, new ObjectMapper());
    }

    @Test
    void shouldReturnIp_whenResponseIsGetIPResponse() {
        GetIPResponse response = new GetIPResponse();
        response.setOrigin("9.10.11.12");

        when(requestInspectionApi.ipGet())
                .thenReturn(Mono.just(response));

        String ip = client.getMyIp();

        assertEquals("9.10.11.12", ip);
    }

    @Test
    void shouldThrowException_whenHttpBinFails() {
        when(requestInspectionApi.ipGet())
                .thenReturn(Mono.error(new RuntimeException("HTTP error")));

        RuntimeException exception =
                assertThrows(RuntimeException.class, () -> client.getMyIp());

        assertTrue(exception.getMessage().contains("Failed to retrieve IP"));
    }
}