package lu.post.eval.domain.service;

import lu.post.eval.domain.model.HeadersBO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HTTPMirrorClientImpl implements IHTTMirrorClient {

    @Override
    public List<HeadersBO> mirrorMyGetHeaders() {
        // Minimal implementation to satisfy Spring wiring.
        // Replace with real HTTP call (RestTemplate, WebClient, Feign, etc.) as needed.
        return Collections.emptyList();
    }
}