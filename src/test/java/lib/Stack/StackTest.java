package lib.Stack;

import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Nested
    @DisplayName("Constructors Tests")
    class Stack_Constructors_Test{
        @Test
        void constructor_default() {
            Stack stack = new Stack();

        }
        @Test
        void constructor_by_params() throws Exception {
            int expected = 1;
            Stack stack = new Stack(expected);
            assertEquals(expected, stack.Peek());
        }

    }




    @Nested
    @DisplayName("Peek tests")
    class PeekTests {


        @Test
        @DisplayName("given - stack with value on top - expect - that value")
        void Peek_ValueFromTop() throws Exception {
            int expected = 10;
            Stack stack = new Stack(expected);

            int actual = stack.Peek();

            assertEquals(expected,actual);
        }

        @Test
        @DisplayName("given: empty stack expect: empty stack exception")
        void Peek_Exception() throws Exception {
            Stack stack = new Stack();

            Exception exception = assertThrows(Exception.class, stack::Peek);

            assertEquals("The stack is empty!", exception.getMessage());
        }


    }

    @Nested
    @DisplayName("Push tests")
    class PushTests {

        @Test
        @DisplayName("given: empty stack do: push value  expect: peek that value")
        void Push_Value() throws Exception {
            int expected = 10;
            Stack stack = new Stack();

            stack.Push(expected);
            int actual = stack.Peek();

            assertEquals(expected,actual);
        }

        @Test
        @DisplayName("given: empty stack do: push 2 values and peek expect: second value")
        void Push_2times() throws Exception {
            Stack stack = new Stack();

            stack.Push(1);
            stack.Push(2);
            int actual  = stack.Peek();

            assertEquals(2, actual);
        }

        @Test
        @DisplayName("given: stack with 1 value  do: push values and peek expect: second value")
        void Push_2times2() throws Exception {
            Stack stack = new Stack(1);

            stack.Push(2);
            int actual  = stack.Peek();

            assertEquals(2, actual);
        }
    }

    @Nested
    @DisplayName("Pop tests")
    class PopTests {


        @Test
        @DisplayName("given - stack with value on top - expect - that value and stack itself is empty")
        void Pop_ValueFromTop() throws Exception {
            int expected = 10;
            Stack stack = new Stack(expected);

            int actual = stack.Pop();

            assertAll(
                    () -> assertEquals(expected,actual),
                    () -> assertTrue(stack.isEmpty())
            );
        }
        @Test
        @DisplayName("given - stack with 2 values in it - expect - that value and second value on top of teh stack")
        void Pop_ValueFromTop2() throws Exception {

            int  expected1 =  1;
            int  expected2 =  2;

            Stack stack = new Stack(expected2);
            stack.Push(expected1);

            int actual = stack.Pop();

            assertAll(
                    () -> assertEquals(expected1,actual),
                    () -> assertEquals(expected2 ,stack.Peek())
            );
        }


        @Test
        @DisplayName("given: empty stack expect: empty stack exception")
        void Pop_Exception() throws Exception {
            Stack stack = new Stack();

            Exception exception = assertThrows(Exception.class, stack::Pop);

            assertEquals("The stack is empty!", exception.getMessage());
        }


    }

}