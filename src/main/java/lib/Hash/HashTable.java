package lib.Hash;




public interface HashTable {
    int  HashFunc(int key) ;
    void Insert(DataItem dataItem);
    DataItem Find(int key);
    DataItem Delete(int key) ;
}
