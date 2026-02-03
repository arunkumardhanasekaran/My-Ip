package lu.post.eval.entrypoint.main.controller;

import lombok.extern.slf4j.Slf4j;
import lu.post.eval.domain.bo.MyIpResponseBO;
import lu.post.eval.domain.service.IpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/java-eval-api")
public class MyIpController {

    private final IpService ipService;

    public MyIpController(IpService ipService) {
        this.ipService = ipService;
    }

    @GetMapping("/my-ip")
    public ResponseEntity<Map<String, String>> getMyIp() throws ExecutionException, InterruptedException {
        log.info("Received request for /my-ip endpoint");

        CompletableFuture<MyIpResponseBO> ipFuture = ipService.getMyIp();
        MyIpResponseBO responseBO = ipFuture.get();

        Map<String, String> response = new HashMap<>();
        response.put("myIp", responseBO.getMyIp());

        log.info("Returning IP response: {}", responseBO.getMyIp());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}