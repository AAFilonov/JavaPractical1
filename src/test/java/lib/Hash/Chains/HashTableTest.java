package lib.Hash.Chains;


import lib.Hash.Chains.HashTable_Chains;
import lib.Hash.HashTableCommonTest;
import org.junit.jupiter.api.BeforeEach;

class HashTable_Chains_Test extends HashTableCommonTest {

    @BeforeEach
    @Override
    public void init() {
        this.hashTable = new HashTable_Chains(101);
    }
}