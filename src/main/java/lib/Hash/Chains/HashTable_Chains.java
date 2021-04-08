package lib.Hash.Chains;

import lib.Hash.DataItem;

public class HashTable_Chains implements lib.Hash.HashTable {
    private final int maxSize;
    ItemList[] hashList;


    //операции хэш-таблицы

    //преобразует значение ключа в индекс

    public int HashFunc(int key) {
        return (key*key) % maxSize;
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

    public  int  GetMaxSize(){
        return maxSize;
    }


    private void  Init(){
        for (int i=0; i<this.maxSize; i++) {
            this.hashList[i] = new ItemList();
        }
    }
    //конструкторы
    public HashTable_Chains(int maxSize){
        this.maxSize = maxSize;
        this.hashList = new ItemList[maxSize];
        Init();

    }



}
