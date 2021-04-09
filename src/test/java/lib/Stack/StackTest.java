package lib.Stack;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack;

    @BeforeEach
    private void Init() {
        stack = new Stack();
    }

    @Nested
    @DisplayName("IsEmpty Tests")
    class Stack_IsEmpty_Tests {
        @Test
        public void testIsEmpty_WhenNoValuesInStack_ThenReturnFalse() {

            assertTrue(stack.isEmpty());
        }

        @Test
        public void testIsEmpty_WhenPushSingleValue_ThenReturnFalse() {

            stack.Push(1);
            assertFalse(stack.isEmpty());
        }

        @Test
        public void testIsEmpty_WhenPushMultipleValues_ThenReturnFalse() {
            stack.Push(1);
            stack.Push(12);
            stack.Push(3);
            assertFalse(stack.isEmpty());
        }

    }

    @Nested
    class PushTests {

        @ParameterizedTest
        @ValueSource(ints = {1, 3, 0, 5, -3, -15, Integer.MAX_VALUE})
            // six numbers
        void testPush_WhenPushSingleValue_ThenNotThrowAnyExceptions(int expected) throws Exception {
           stack.Push(expected);
        }

        @Test
        void testPush_WhenPushSingleValue_ThenPeekReturnThisValue() throws Exception {
            stack.Push(10);

            int actual = stack.Peek();

            assertEquals(10, actual);
        }

        @Test
        void testPush_WhenPushMultipleValues_ThenPeekReturnLastPushedValue() throws Exception {
            Stack stack = new Stack();

            stack.Push(1);
            stack.Push(3);
            stack.Push(2);
            int actual = stack.Peek();

            assertEquals(2, actual);
        }


    }

    @Nested
    class PeekTests {


        @Test
        void testPeek_WhenSingleValuePushed_ThenReturnThatValue() throws Exception {
            stack.Push(10);

            int actual = stack.Peek();

            assertEquals(10, actual);
        }

        @Test
        void testPeek_WhenStackIsEmpty_ThenThrowsException() throws Exception {


            Exception exception = assertThrows(Exception.class, stack::Peek);

            assertEquals("The stack is empty!", exception.getMessage());
        }


    }

    @Nested
    class PopTests {


        @Test
        void testPop_WhenSingleValuePushed_ThenReturnThisValue() throws Exception {

            stack.Push(10);
            int actual = stack.Pop();

            Assertions.assertEquals(10, actual);


        }

        @Test
        void testPop_WhenSingleValuePushed_ThenStacIsEmptyReturnsTrue() throws Exception {

            stack.Push(10);
            stack.Pop();

            boolean actual = stack.isEmpty();

            assertTrue(actual);


        }

        @Test
        void testPop_WhenMultipleValuesPushedA_and_OneValuePoped_ThenPeekReturnsSecondValue() throws Exception {
            stack.Push(1);
            stack.Push(2);

            stack.Pop();
            int actual = stack.Peek();

            Assertions.assertEquals(1, actual);
        }


        @Test
        void testPop_WhenStackIsEmpty_ThenThrowException() throws Exception {

            Exception exception = assertThrows(Exception.class, stack::Pop);

            assertEquals("The stack is empty!", exception.getMessage());
        }


    }

    @Test
    void testConstructor_is_Ok() {
        Stack stack = new Stack();

    }


}