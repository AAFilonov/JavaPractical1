package lib.Hash;

import lib.Hash.Chains.HashTable_Chains;
import lib.Hash.Double.HashTable_Double;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public abstract class HashTableCommonTest {

    protected HashTable hashTable;

    @BeforeEach
    public abstract void init();


    @ParameterizedTest
    @ValueSource(ints = {1})
        // six numbers
    void testInsert_WhenInsertVal_ThenThrowNoException(int expected) throws Exception {

        DataItem dataItem = new DataItem(expected, "argument");

        hashTable.Insert(dataItem);


    }





    @ParameterizedTest
    @ValueSource(ints = {1, 3,-1, -20})
        // six numbers
    void test_find(int val) throws Exception {
        DataItem dataItemExpected = new DataItem(val, "argument");
        hashTable.Insert(dataItemExpected);

        DataItem actual = hashTable.Find(val);

        Assertions.assertEquals(dataItemExpected, actual);
    }


    @ParameterizedTest
    @ValueSource(ints = {1})
        // six numbers
    void test_delete_is_Ok(int expected) throws Exception {
        DataItem dataItemExpected = new DataItem(expected, "argument");
        hashTable.Insert(dataItemExpected);

        DataItem actual = hashTable.Delete(expected);

        Assertions.assertEquals(dataItemExpected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
        // six numbers
    void test_delete_really_delete(int value) throws Exception {

        DataItem dataItemExpected = new DataItem(value, "argument");
        hashTable.Insert(dataItemExpected);

        hashTable.Delete(value);
        DataItem actual = hashTable.Find(value);

        Assertions.assertNull(actual);
    }


}



