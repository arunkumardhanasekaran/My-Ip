package lu.post.eval.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lu.post.eval.domain.bo.MyIpResponseBO;
import lu.post.eval.infra.ip.HTTPBinIpClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class IpService {

    private static final Logger log = LoggerFactory.getLogger(IpService.class);

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