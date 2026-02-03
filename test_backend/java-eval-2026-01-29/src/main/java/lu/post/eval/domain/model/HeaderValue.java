package lu.post.eval.domain.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lu.post.eval.domain.exception.InvalidInputException;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "value")
public class HeaderValue {

    public String value;

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
}