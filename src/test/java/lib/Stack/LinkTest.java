package lib.Stack;

import lib.Stack.Link;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LinkTest {



    @Nested
    @DisplayName("link can  be initialized by any constructor")
    class Link_Constructors_Test{
        @Test
        void constructor_default() {
            Link lnk = new Link();

        }
        @Test
        void constructor_by_key() {
            int key = 10;

            Link lnk = new Link(key);

            Assertions.assertAll("first name",
                    () -> assertEquals(10,lnk.key),
                    () -> assertNull(lnk.next)
            );
        }
        @Test
        void constructor_by_params() {
            int key = 10;
            Link next = new Link();

            Link lnk = new Link(key,next);

            Assertions.assertAll("first name",
                    () -> assertEquals(10,lnk.key),
                    () -> assertEquals(next,lnk.next)
            );
        }

    }

}