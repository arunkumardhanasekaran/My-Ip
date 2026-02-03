package lu.post.eval.entrypoint.main.controller;

import lu.post.gen.eval.application.controllers.InfoControllerApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController implements InfoControllerApi {

    @Override
    public ResponseEntity<Void> ping() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
