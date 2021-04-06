package lib.Hash.HashChains;

import lib.Hash.DataItem;

public class HashTable implements lib.Hash.HashTable {
    private final int maxSize;
    ItemList[] hashList;


    //операции хэш-таблицы

    //преобразует значение ключа в индекс

    public int HashFunc(int key) {
        return key % maxSize;
    }

    public void Insert(DataItem dataItem) {
        int index = HashFunc(dataItem.GetKey());
        hashList[index].Insert(dataItem);
    }
    public DataItem Find(int key) {
        int index = HashFunc(key);
        return hashList[index].Find(key);
    }

    public DataItem Delete(int key) {
        int index = HashFunc(key);
        return   hashList[index].Delete(key);

    }

    //вспомогательные методы
    int GetMaxSize(){
        return maxSize;
    }

    HashTable(int maxSize){
        this.maxSize = maxSize;
        hashList = new ItemList[maxSize];

    }

}