package lu.post.eval.domain.model;

import java.util.Objects;
import lu.post.eval.domain.exception.InvalidInputException;

public class HeaderName {
    public String name;

    private HeaderName(String name) {
        this.name = name;
    }

    public String get() {
        // According to https://www.rfc-editor.org/rfc/rfc9110.html header name should be case-insensitive
        return name != null ? name.toLowerCase() : null;
    }

    public static HeaderName of(String value) {
        validate(value);
        return new HeaderName(value);
    }

    private static void validate(String value) {
        if (value == null) {
            throw new InvalidInputException("Header name can't be null");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HeaderName)) return false;
        HeaderName that = (HeaderName) o;
        return Objects.equals(get(), that.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(get());
    }
}