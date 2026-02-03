package lu.post.eval.infra.mirror;

import lu.post.gen.v6.httpbin.RequestInspectionApi;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HTTPMirrorUsingHTTPBin {

    private static final Logger log = LoggerFactory.getLogger(HTTPMirrorUsingHTTPBin.class);

    private final RequestInspectionApi requestInspectionApi;

    public HTTPMirrorUsingHTTPBin(RequestInspectionApi requestInspectionApi) {
        this.requestInspectionApi = requestInspectionApi;
    }

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