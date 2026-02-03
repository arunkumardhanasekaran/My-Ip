package lu.post.eval.domain.service;

import lombok.extern.slf4j.Slf4j;
import lu.post.eval.domain.bo.MyIpResponseBO;
import lu.post.eval.infra.ip.HTTPBinIpClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class IpService {

    private final HTTPBinIpClient ipClient;

    public IpService(HTTPBinIpClient ipClient) {
        this.ipClient = ipClient;
    }

    @Async
    public CompletableFuture<MyIpResponseBO> getMyIp() {
        log.info("Getting IP from HTTPBin");
        String ip = ipClient.getMyIp();
        return CompletableFuture.completedFuture(new MyIpResponseBO(ip));
    }
}