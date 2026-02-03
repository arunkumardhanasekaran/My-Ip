package lu.post.eval.infra.ip;

import com.fasterxml.jackson.databind.ObjectMapper;
import lu.post.gen.v6.httpbin.model.GetIPResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import lu.post.gen.v6.httpbin.RequestInspectionApi;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class HTTPBinIpClient {

    private static final Logger log = LoggerFactory.getLogger(HTTPBinIpClient.class);

    private final RequestInspectionApi requestInspectionApi;
    private final ObjectMapper objectMapper;

    public HTTPBinIpClient(RequestInspectionApi requestInspectionApi, ObjectMapper objectMapper) {
        this.requestInspectionApi = requestInspectionApi;
        this.objectMapper = objectMapper;
    }

    public String getMyIp() {
        try {
            log.info("Calling HTTPBin to get IP address");

            // Use raw type to avoid compilation issues
            Mono<?> ipMono = requestInspectionApi.ipGet();

            // Block and get the response
            Object response = ipMono.block();

            if (response instanceof Map) {
                @SuppressWarnings("unchecked")
                Map<String, Object> responseMap = (Map<String, Object>) response;

                Object origin = responseMap.get("origin");
                if (origin == null) {
                    throw new RuntimeException("No 'origin' field in HTTPBin response");
                }

                String ip = origin.toString();
                log.info("Retrieved IP from HTTPBin: {}", ip);
                return ip;
            } else if (response instanceof String) {
                // If it's a string, parse it as JSON
                String jsonResponse = (String) response;
                Map<String, Object> responseMap = objectMapper.readValue(jsonResponse, Map.class);
                String ip = responseMap.get("origin").toString();
                log.info("Retrieved IP from HTTPBin: {}", ip);
                return ip;
            } else if (response instanceof GetIPResponse) {
                GetIPResponse getIPResponse = (GetIPResponse) response;
                String ip = getIPResponse.getOrigin();
                log.info("Retrieved IP from HTTPBin: {}", ip);
                return ip;
            } else {
                log.error("Unexpected response type: {}", response.getClass());
                throw new RuntimeException("Unexpected response type from HTTPBin");
            }

        } catch (Exception e) {
            log.error("Failed to get IP from HTTPBin", e);
            throw new RuntimeException("Failed to retrieve IP address: " + e.getMessage(), e);
        }
    }
}