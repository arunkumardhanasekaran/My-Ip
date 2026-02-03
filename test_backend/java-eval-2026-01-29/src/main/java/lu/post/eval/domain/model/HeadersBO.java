package lu.post.eval.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;

@RequiredArgsConstructor
@Getter
public class HeadersBO {

    @NonNull
    private HeaderName name;

    @NonNull
    private HeaderValue value;
}