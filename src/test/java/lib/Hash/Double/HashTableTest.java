package lib.Hash.Double;


import lib.Hash.Double.HashTable_Double;
import lib.Hash.HashTableCommonTest;
import org.junit.jupiter.api.BeforeEach;

class HashTable_Double_Test extends HashTableCommonTest {

    @BeforeEach
    @Override
    public void init() {
        this.hashTable = new HashTable_Double(101);
    }
}