package lu.post.eval.domain.model;

import java.util.Objects;
import lu.post.eval.domain.exception.InvalidInputException;

public class HeaderValue {

    private final String value;

    private HeaderValue(String value) {
        this.value = value;
    }

    public static HeaderValue of(String value) {
        validate(value);
        return new HeaderValue(value);
    }

    private static void validate(String value) {
        if (value == null) {
            throw new InvalidInputException("Header value can't be null");
        }
    }

    public String get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeaderValue)) return false;
        HeaderValue that = (HeaderValue) o;
        return Objects.equals(get(), that.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }

    @Override
    public String toString() {
        return get();
    }
}