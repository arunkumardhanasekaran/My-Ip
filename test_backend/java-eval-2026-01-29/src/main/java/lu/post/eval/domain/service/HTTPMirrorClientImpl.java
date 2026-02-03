package lu.post.eval.domain.service;

import lu.post.eval.domain.model.HeadersBO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class HTTPMirrorClientImpl implements IHTTMirrorClient {

    @Override
    public List<HeadersBO> mirrorMyGetHeaders() {
        // added to satisfy wiring
        return Collections.emptyList();
    }
}