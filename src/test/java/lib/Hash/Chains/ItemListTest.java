package lib.Hash.Chains;

import lib.Hash.Chains.HashTable_Chains;
import lib.Hash.DataItem;
import lib.Hash.Double.HashTable_Double;
import lib.Hash.HashTable;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

class ItemListTest {
    private ItemList itemList;

    @BeforeEach
    private void Init(){
        itemList = new ItemList();
    }



     @ParameterizedTest
     @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
     public void testInsert( int val){
         DataItem dataItem = new DataItem(val);
         itemList.Insert(dataItem);
     }


    @ParameterizedTest
    @ValueSource(ints = {1})
    void testFind_WhenValueIsInserted_ReturnValue(int val){
        DataItem dataItem = new DataItem(val);

        itemList.Insert(dataItem);
        DataItem actual = itemList.Find(val);

        Assertions.assertEquals(dataItem,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {5})
    void testFind_WhenListIsNotEmpty_ThenReturnNull(int val){
        DataItem dataItem = new DataItem(1);

        itemList.Insert(dataItem);
        DataItem actual = itemList.Find(val);

        Assertions.assertNull(actual);
    }
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testFind_WhenListIsEmpty_ThenReturnNull(int val){

        DataItem actual = itemList.Find(val);

        Assertions.assertNull(actual);
    }

    @Test
    void testIsEmptyWhenEmpty(){
        boolean actual = itemList.isEmpty();

        Assertions.assertTrue(actual);
    }
    @Test
    void testIsEmptyWhenNotEmpty(){
        itemList.Insert(new DataItem(1));
        itemList.Insert(new DataItem(2));
        itemList.Insert(new DataItem(3));

        boolean actual = itemList.isEmpty();

        Assertions.assertFalse(actual);
    }
}