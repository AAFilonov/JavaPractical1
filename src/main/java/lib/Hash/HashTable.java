package lib.Hash;




public interface HashTable {
    int  HashFunc(int key) throws Exception;
    void Insert(DataItem dataItem) throws Exception;
    DataItem Find(int key)throws Exception;
    DataItem Delete(int key) throws Exception;
}
