
package lu.post.eval.entrypoint.main.transformer;

import lu.post.eval.domain.model.HeadersBO;
import lu.post.gen.eval.application.model.HeaderOA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public class ToHeaderOA {
    public static List<HeaderOA> of(List<HeadersBO> headersBOS) {
        return headersBOS.stream()
                .map(headersBO -> new HeaderOA()
                        .name(headersBO.getName().get())
                        .value(headersBO.getValue().get()))
                .collect(Collectors.toList());
    }
}