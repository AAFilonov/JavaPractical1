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
    @ValueSource(ints = {1, 3,-1, -20})
    void testInsertSingleItem(int expected) {

        DataItem dataItem = new DataItem(expected, "argument");

        hashTable.Insert(dataItem);
    }

    @Test
    void testInsertMultipleItems() {

        DataItem dataItem1 = new DataItem(1, "argument");
        DataItem dataItem2 = new DataItem(2, "argument");
        DataItem dataItem3 = new DataItem(3, "argument");

        hashTable.Insert(dataItem1);
        hashTable.Insert(dataItem2);
        hashTable.Insert(dataItem3);
    }

    @Test
    void testInsertMultipleSameItems() {

        DataItem dataItem1 = new DataItem(2, "argument");
        DataItem dataItem2 = new DataItem(2, "argument");
        DataItem dataItem3 = new DataItem(2, "argument");

        hashTable.Insert(dataItem1);
        hashTable.Insert(dataItem2);
        hashTable.Insert(dataItem3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 3,-1, -20})
    void testFind_WhenNoItemsInserted(int val){

        DataItem actual = hashTable.Find(val);

        assertNull(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3,-1, -20})
    void testFind_WhenSingleItemsInserted(int val){
        DataItem dataItemExpected = new DataItem(val, "argument");
        hashTable.Insert(dataItemExpected);

        DataItem actual = hashTable.Find(val);

        Assertions.assertEquals(dataItemExpected, actual);
    }

    @Test
    void testFind_WhenManyItemsInserted(){

        DataItem dataItem1= new DataItem(1, "argument1");
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

    @ParameterizedTest
    @ValueSource(ints = {1, 3,-1, -20})
    void testDelete_WhenNoItemsInserted(int val){

        DataItem actual = hashTable.Delete(val);

        assertNull(actual);
    }

    @Test
    void testDelete_WhenSingleItemInserted() {

        DataItem dataItemExpected = new DataItem(1, "argument");
        hashTable.Insert(dataItemExpected);

        hashTable.Delete(1);
        DataItem actual = hashTable.Find(1);

        Assertions.assertNull(actual);
    }

    @Test
    void testDelete_WhenManyItemsInserted(){

        DataItem dataItem1= new DataItem(1, "argument1");
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

}



