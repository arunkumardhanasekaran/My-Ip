package lu.post.eval.infra.configuration.client;

import lu.post.gen.v6.httpbin.HttpMethodsApi;
import lu.post.gen.v6.httpbin.RequestInspectionApi;
import lu.post.gen.v6.httpbin.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

;

@Configuration
public class HTTBinAPIConfig {

    @Bean
    public HttpMethodsApi httpMethodsApi() {
        return new HttpMethodsApi(new ApiClient());
    }

    // TODO : use to get my IP from HTTPbin
    @Bean
    public RequestInspectionApi requestInspectionApi() {
        return new RequestInspectionApi(new ApiClient());
    }
}
