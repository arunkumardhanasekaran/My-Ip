package lu.post.eval.domain.service;

import lu.post.eval.domain.model.HeadersBO;

import java.util.List;

public interface IHTTMirrorClient {

    List<HeadersBO> mirrorMyGetHeaders();
}
