package lu.post.eval.entrypoint.main.controller;

import lombok.RequiredArgsConstructor;
import lu.post.eval.domain.service.HTTPMirrorCaller;
import lu.post.eval.entrypoint.main.transformer.ToHeaderOA;
import lu.post.gen.eval.application.controllers.MirrorControllerApi;
import lu.post.gen.eval.application.model.HeaderOA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MirrorController implements MirrorControllerApi {

    private final HTTPMirrorCaller httpMirrorCaller;

    @Override
    public ResponseEntity<List<HeaderOA>> mirrorOutgoingHeaders(
    ) {
        return new ResponseEntity<>(ToHeaderOA.of(httpMirrorCaller.callGet()), HttpStatus.OK);
    }
}