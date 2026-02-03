package lu.post.eval.domain.service;

import lu.post.eval.domain.model.HeadersBO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class HTTPMirrorCaller {

    private static final Logger log = LoggerFactory.getLogger(HTTPMirrorCaller.class);

    private final IHTTMirrorClient mirrorClient;

    public HTTPMirrorCaller(IHTTMirrorClient mirrorClient) {
        this.mirrorClient = mirrorClient;
    }

    @Async
    public List<HeadersBO> callGet() {
        return mirrorClient.mirrorMyGetHeaders();
    }
}
