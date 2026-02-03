package lu.post.eval.domain.model;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class HeadersBO {

    @NonNull
    private final HeaderName name;

    @NonNull
    private final HeaderValue value;

    public HeadersBO(@NonNull HeaderName name, @NonNull HeaderValue value) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.value = Objects.requireNonNull(value, "value must not be null");
    }

    public HeaderName getName() {
        return name;
    }

    public HeaderValue getValue() {
        return value;
    }
}