package lu.post.eval.infra.mirror;

import lu.post.gen.v6.httpbin.RequestInspectionApi;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HTTPMirrorUsingHTTPBinTest {

    @Mock
    private RequestInspectionApi requestInspectionApi;

    private HTTPMirrorUsingHTTPBin service;

    @BeforeEach
    void setUp() {
        service = new HTTPMirrorUsingHTTPBin(requestInspectionApi);
    }

    @Test
    void shouldReturnFirstIp_whenMultipleIpsReturned() {
        GetIPResponse response = new GetIPResponse();
        response.setOrigin("1.2.3.4, 5.6.7.8");

        when(requestInspectionApi.ipGet())
                .thenReturn(Mono.just(response));

        String ip = service.getMyIp();

        assertEquals("1.2.3.4", ip);
    }

    @Test
    void shouldThrowException_whenOriginIsNull() {
        GetIPResponse response = new GetIPResponse();
        response.setOrigin(null);

        when(requestInspectionApi.ipGet())
                .thenReturn(Mono.just(response));

        RuntimeException exception =
                assertThrows(RuntimeException.class, service::getMyIp);

        assertTrue(exception.getMessage().contains("Failed to retrieve IP"));
    }

    @Test
    void shouldThrowException_whenHttpBinFails() {
        CompletableFuture<GetIPResponse> failedFuture =
                CompletableFuture.failedFuture(
                        new RuntimeException("HTTPBin error"));

        when(requestInspectionApi.ipGet())
                .thenReturn(Mono.error(new RuntimeException("HTTPBin error")));

        RuntimeException exception =
                assertThrows(RuntimeException.class, service::getMyIp);

        assertTrue(exception.getMessage().contains("Failed to retrieve IP"));
    }

    @Test
    void shouldTrimIpCorrectly() {
        GetIPResponse response = new GetIPResponse();
        response.setOrigin("  9.9.9.9  ");

        when(requestInspectionApi.ipGet())
                .thenReturn(Mono.just(response));

        String ip = service.getMyIp();

        assertEquals("9.9.9.9", ip.trim());
    }
}