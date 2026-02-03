
package lu.post.eval.domain.transformers;

import lu.post.eval.domain.model.HeaderName;
import lu.post.eval.domain.model.HeaderValue;
import lu.post.eval.domain.model.HeadersBO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ToHeadersBO {

    public static List<HeadersBO> of(Map<String, String> headers) {
        if (headers == null || headers.isEmpty()) {
            return List.of();
        }

        return headers.entrySet().stream()
                .map(entry -> {
                    HeaderName name = HeaderName.of(entry.getKey());
                    HeaderValue value = HeaderValue.of(entry.getValue());
                    return new HeadersBO(name, value);
                })
                .collect(Collectors.toList());
    }
}