package lu.post.eval.domain.model;

import lu.post.eval.domain.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderNameTests {

    @Test
    void itWorkEquals() {
        assertEquals(HeaderName.of("foo"), HeaderName.of("foo"));
    }

    @Test
    void caseInsensitive() {
        assertEquals(HeaderName.of("foo"), HeaderName.of("FoO"));
    }

    @Test
    void notEquals() {
        assertNotEquals(HeaderName.of("foo"), HeaderName.of("bar"));
    }

    @Test
    void refuseNull() {
        Throwable exception = assertThrows(
                InvalidInputException.class,
                () -> HeaderName.of(null));
        assertEquals("Header name can't be null", exception.getMessage());
    }


}
