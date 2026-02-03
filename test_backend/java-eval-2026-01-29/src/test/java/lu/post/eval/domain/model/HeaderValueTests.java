package lu.post.eval.domain.model;

import lu.post.eval.domain.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderValueTests {

    @Test
    void itWorkEquals() {
        assertEquals(HeaderValue.of("foo"), HeaderValue.of("foo"));
    }

    @Test
    void caseSensitive() {
        assertNotEquals(HeaderValue.of("foo"), HeaderValue.of("FoO"));
    }

    @Test
    void notEquals() {
        assertNotEquals(HeaderValue.of("foo"), HeaderValue.of("bar"));
    }

    @Test
    void refuseNull() {
        Throwable exception = assertThrows(
                InvalidInputException.class,
                () -> HeaderName.of(null));
        assertEquals("Header name can't be null", exception.getMessage());
    }
}
