package lu.post.eval.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lu.post.eval.domain.exception.InvalidInputException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class HeaderName {
    @EqualsAndHashCode.Exclude
    public String name;

    @EqualsAndHashCode.Include
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
}