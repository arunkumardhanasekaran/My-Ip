package lu.post.eval.infra.mirror;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.post.gen.v6.httpbin.RequestInspectionApi;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HTTPMirrorUsingHTTPBin {

    private final RequestInspectionApi requestInspectionApi;

    public String getMyIp() {
        try {
            log.info("Calling HTTPBin to get IP address");

            GetIPResponse response = requestInspectionApi.ipGet().toFuture().join();
            if (response == null) {
                throw new RuntimeException("Null response from HTTPBin");
            }

            String ip = response.getOrigin();
            if (ip == null) {
                throw new RuntimeException("No 'origin' field in HTTPBin response: " + response);
            }

            if (ip.contains(",")) {
                ip = ip.split(",")[0].trim();
            }

            log.info("Retrieved IP from HTTPBin: {}", ip);
            return ip;

        } catch (Exception e) {
            log.error("Failed to get IP from HTTPBin", e);
            throw new RuntimeException("Failed to retrieve IP address: " + e.getMessage(), e);
        }
    }
}