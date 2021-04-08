package lib.Hash.Chains;
import lib.Hash.HashTableCommonTest;
import org.junit.jupiter.api.BeforeEach;

class HashTable_Chains_Test extends HashTableCommonTest {

    @BeforeEach
    @Override
    public void init() {
        this.hashTableMaxValue = 101;
        this.hashTable = new HashTable_Chains(hashTableMaxValue);
    }
}