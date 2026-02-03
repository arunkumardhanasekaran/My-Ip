package lu.post.eval.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lu.post.eval.domain.model.HeadersBO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HTTPMirrorCaller {

    private final IHTTMirrorClient mirrorClient;

    @Async
    public List<HeadersBO> callGet() {
        return mirrorClient.mirrorMyGetHeaders();
    }
}