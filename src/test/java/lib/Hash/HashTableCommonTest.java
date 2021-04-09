package lib.Hash;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


public abstract class HashTableCommonTest {

    protected HashTable hashTable;
    protected int hashTableMaxValue;
    @BeforeEach
    public abstract void init();

    @Nested
    class InsertTests {
        @ParameterizedTest
        @ValueSource(ints = {1, 3,0, -1, -20,Integer.MAX_VALUE})
        void testInsert_WhenInsertSingleItem_ThenDoNotThrowAnyExceptions(int expected) {

            DataItem dataItem = new DataItem(expected, "argument");

            hashTable.Insert(dataItem);
        }

        @Test
        void testInsert_WhenInsertMultipleItems_ThenDoNotThrowAnyExceptions() {

            DataItem dataItem1 = new DataItem(1, "argument");
            DataItem dataItem2 = new DataItem(2, "argument");
            DataItem dataItem3 = new DataItem(3, "argument");

            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);
        }

        @Test
        void testInsert_WhenInsertMultipleSameItems_ThenDoNotThrowAnyExceptions() {

            DataItem dataItem1 = new DataItem(2, "argument");
            DataItem dataItem2 = new DataItem(2, "argument");
            DataItem dataItem3 = new DataItem(2, "argument");

            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);
        }


        @ParameterizedTest
         @ValueSource(strings = {"1", "expected","Vasilii", "vasilii", "asdfg"})
        void testInsertSingleString(String expected) {

            hashTable.Insert(expected);
        }

        @Test
        void testInsertMultipleString() {


            hashTable.Insert("argument1");
            hashTable.Insert("argument2");
            hashTable.Insert("argument3");
        }

        @Test
        void testInsertMultipleSameString() {

            hashTable.Insert("argument");
            hashTable.Insert("argument");
            hashTable.Insert("argument");
        }

    }

    @Nested
    class FindTests {
        @ParameterizedTest
        @ValueSource(ints = {1, 3, -1, -20})
        void testFindByInt_WhenNoItemsInserted_ThenReturnNull(int val) {

            DataItem actual = hashTable.Find(val);

            assertNull(actual);
        }
        @ParameterizedTest
        @ValueSource(ints = {1, 3, -1, -20})
        void testFindByInt_WhenSingleItemsInserted_ThenReturnItem(int val) {
            DataItem dataItemExpected = new DataItem(val, "argument");
            hashTable.Insert(dataItemExpected);

            DataItem actual = hashTable.Find(val);

            Assertions.assertEquals(dataItemExpected, actual);
        }
        @Test
        void testFindByInt_WhenManyItemsInserted() {

            DataItem dataItem1 = new DataItem(1, "argument1");
            DataItem dataItem2 = new DataItem(2, "argument2");
            DataItem dataItem3 = new DataItem(3, "argument3");
            DataItem dataItemExpected = new DataItem(6, "expected");
            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);
            hashTable.Insert(dataItemExpected);

            DataItem actual = hashTable.Find(6);

            Assertions.assertEquals(dataItemExpected, actual);
        }
        @Test
        void testFindByInt_WhenManySameItemsInserted_ThenReturnFirst() {

            DataItem dataItem1 = new DataItem(2, "argument1");
            DataItem dataItem2 = new DataItem(2, "argument2");
            DataItem dataItem3 = new DataItem(2, "argument3");

            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);


            DataItem actual = hashTable.Find(2);

            Assertions.assertEquals(dataItem1, actual);
        }
        @Test
        void testFindByInt_WhenManySameItemsInsertedAdeFirstDeleted_ThenReturnSecond() {

            DataItem dataItem1 = new DataItem(2, "argument1");
            DataItem dataItem2 = new DataItem(2, "argument2");
            DataItem dataItem3 = new DataItem(2, "argument3");

            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);
            hashTable.Delete(2);

            DataItem actual = hashTable.Find(2);

            Assertions.assertEquals(dataItem2, actual);
        }

        @Test
        void testFindByString_WhenNoItemsInserted_ThenReturnSecond() {
            DataItem actual = hashTable.Find("val");

            assertNull(actual);
        }
        @ParameterizedTest
         @ValueSource(strings = {"1", "expected","Vasilii", "vasilii", "asdfg"})
        void testFindByString_WhenSingleItemsInserted_ThenReturnItem(String val) {

            hashTable.Insert(val);

            DataItem actual = hashTable.Find(val);

            Assertions.assertEquals(val, actual.GetValue());
        }
        @ParameterizedTest
        @ValueSource(strings = {"1", "expected","Vasilii", "vasilii", "asdfg"})
        void testFindByString_WhenManyItemsInserted(String expected) {

            hashTable.Insert( "argument1");
            hashTable.Insert( "argument2");
            hashTable.Insert( "argument3");
            hashTable.Insert(expected);

            DataItem actual = hashTable.Find(expected);

            Assertions.assertEquals(expected, actual.GetValue());
        }
        @Test
        void testFindByString_WhenManySameItemsInserted_ThenReturnFirst() {


            DataItem dataItem1 = new DataItem( "argument",hashTableMaxValue);
            DataItem dataItem2 = new DataItem( "argument",hashTableMaxValue);
            DataItem dataItem3 = new DataItem( "argument",hashTableMaxValue);

            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);


            DataItem actual = hashTable.Find("argument");

            Assertions.assertEquals(dataItem1, actual);
        }
        @Test
        void testFindByStringInUpperCase_WhenItemInLoverCaseInserted_ThenReturnItem() {

            DataItem dataItem1 = new DataItem( "ArGuMeNt",hashTableMaxValue);

            hashTable.Insert(dataItem1);
            DataItem actual = hashTable.Find("argument");

            Assertions.assertEquals(dataItem1, actual);
        }
    }

    @Nested
    class DeleteTests {

        @ParameterizedTest
        @ValueSource(ints = {1, 3, -1, -20})
        void testDeleteByInt_WhenNoItemsInserted(int val) {

            DataItem actual = hashTable.Delete(val);

            assertNull(actual);
        }

        @Test
        void testDeleteByInt_WhenSingleItemInserted() {

            DataItem dataItemExpected = new DataItem(1, "argument");
            hashTable.Insert(dataItemExpected);

            hashTable.Delete(1);
            DataItem actual = hashTable.Find(1);

            Assertions.assertNull(actual);
        }

        @Test
        void testDeleteByInt_WhenManyItemsInserted() {

            DataItem dataItem1 = new DataItem(1, "argument1");
            DataItem dataItem2 = new DataItem(2, "argument2");
            DataItem dataItem3 = new DataItem(3, "argument3");
            DataItem dataItemExpected = new DataItem(6, "expected");
            hashTable.Insert(dataItem1);
            hashTable.Insert(dataItem2);
            hashTable.Insert(dataItem3);
            hashTable.Insert(dataItemExpected);

            hashTable.Delete(6);
            DataItem actual = hashTable.Find(6);

            assertNull(actual);
        }


        @ParameterizedTest
        @ValueSource(strings = {"1", "expected","Vasilii", "vasilii", "asdfg"})
        void testDeleteByString_WhenNoItemsInserted(String val) {

            DataItem actual = hashTable.Delete(val);

            assertNull(actual);
        }

        @Test
        void testDeleteByString_WhenSingleItemInserted() {


            hashTable.Insert("argument");

            hashTable.Delete("argument");
            DataItem actual = hashTable.Find(1);

            Assertions.assertNull(actual);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "expected","Vasilii", "vasilii", "asdfg"})
        void testDeleteByString_WhenManyItemsInserted(String expected) {

            hashTable.Insert( "argument1");
            hashTable.Insert( "argument2");
            hashTable.Insert( "argument3");
            hashTable.Insert(expected);

            hashTable.Delete(expected);
            DataItem actual = hashTable.Find(expected);

            assertNull(actual);
        }

    }
}



