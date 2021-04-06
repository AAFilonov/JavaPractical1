package lib.Hash.HashDouble;

import lib.Hash.DataItem;

public class HashTable implements lib.Hash.HashTable {
    private final int maxSize;
    DataItem[] hashArray;
    DataItem nonItem;
    private final int SecondHashConstant;

    //операции хэш-таблицы

    //преобразует значение ключа в индекс

    public int HashFunc(int key) {
        return key % maxSize;
    }

    private int HashFunc2(int key) {

        return SecondHashConstant - (key %SecondHashConstant);
    }
    public void Insert(DataItem dataItem) {
        int index = HashFunc(dataItem.GetKey());
        int i=0;
        int step = SecondHashConstant - (dataItem.GetKey() %SecondHashConstant);
        while ( hashArray[(index+step*i)%maxSize]!=null){
            i++;

        }
        hashArray[(index+step*i)%maxSize] = dataItem;

    }

    public DataItem Find(int key) {
        int index = HashFunc(key);
        int i=0;
        int step = HashFunc2(key);

        while ( hashArray[(index+step*i)%maxSize]!=null){
            if(hashArray[(index+step*i)%maxSize].GetKey()==key) //сравниваем ключ в ячейке с искомым
            {
                return   hashArray[(index+step*i)%maxSize];
            }

            i++;
        }
        //уткнулись в пустую ячейку = элемент не нашелся
        return null;
    }

    public DataItem Delete(int key) {
        int index = HashFunc(key);
        int i=0;
        int step = SecondHashConstant - (key %SecondHashConstant);

        while ( hashArray[(index+step*i)%maxSize]!=null){
            if(hashArray[(index+step*i)%maxSize].GetKey()==key) //сравниваем ключ в ячейке с искомым
            {
                DataItem tmp = hashArray[(index+step*i)%maxSize];
                hashArray[(index+step*i)%maxSize] = nonItem;
                return tmp;
            }

            i++;
        }
        //уткнулись в пустую ячейку = элемент не нашелся
        return null;
    }

    //вспомогательные методы
    int GetMaxSize(){
        return maxSize;
    }

    HashTable(int maxSize){
        this.maxSize = maxSize;
        hashArray = new DataItem[maxSize];
        nonItem= new DataItem(-1,"No data");
        SecondHashConstant = maxSize/2;
    }

}
