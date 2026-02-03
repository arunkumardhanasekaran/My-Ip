package lu.post.eval.domain.service;

import lu.post.eval.domain.bo.MyIpResponseBO;
import lu.post.eval.infra.ip.HTTPBinIpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IpServiceTest {

    @Test
    void testGetMyIp() throws Exception {
        String expectedIp = "123.123.123.123";
        HTTPBinIpClient mockClient = Mockito.mock(HTTPBinIpClient.class);
        Mockito.when(mockClient.getMyIp()).thenReturn(expectedIp);

        IpService ipService = new IpService(mockClient);

        CompletableFuture<MyIpResponseBO> future = ipService.getMyIp();
        MyIpResponseBO response = future.get();

        assertEquals(expectedIp, response.getMyIp());
    }
}
