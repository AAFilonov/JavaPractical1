package lib.Hash.Double;

import lib.Hash.DataItem;

public class HashTable_Double implements lib.Hash.HashTable {
    private final int maxSize;
    DataItem[] hashArray;
    DataItem nonItem;
    private final int SecondHashConstant;


    public int HashFunc(int key) {

        return (key*key) % maxSize;
    }
    private int HashFunc2(int key) {

        return SecondHashConstant - ((key*key) % SecondHashConstant);
    }

    public void Insert(DataItem dataItem) {
      // if(isAlreadyInserted(dataItem.GetKey()))      throw new Exception("Exception: Item with key" + Integer.toString(dataItem.GetKey()) +" already exist") ;

        int index = GetNextEmptyCellIndex(dataItem.GetKey());
        hashArray[index] = dataItem;
    }

    //TODO избавиться от возврата -1
    public DataItem Find(int key)  {
        int index = GetCellIndexByKey(key);
        if (index != -1)
            return hashArray[index];
        else
            return null;
    }
    public DataItem Delete(int key)  {
        int index = GetCellIndexByKey(key);
        if (index != -1) {
            DataItem cell = hashArray[index];
            DeleteCell(index);
            return cell;
        }
        else
            return null;
    }

    public int GetMaxSize() {
        return maxSize;
    }
    public  boolean isAlreadyInserted(int key){
        return Find(key) != null;
    }
    //конструкторы
    public HashTable_Double(int maxSize) {
        this.maxSize = maxSize;
        hashArray = new DataItem[maxSize];
        nonItem = new DataItem(-1, "No data");
        SecondHashConstant = maxSize / 2;
    }
    //TODO вынести подсчет индекса (beginIndex + step * i) % this.maxSize в отдельный метод

    //вспомогательные методы
    private int GetNextEmptyCellIndex(int key) {

        int beginIndex = HashFunc(key);
        int step = HashFunc2(key);

        int i = 0;
        int cellIndex = (beginIndex + step * i) % this.maxSize;


        cellIndex = (beginIndex + step * i) % this.maxSize;
        while (hashArray[cellIndex] != null) {
            i++;
            cellIndex = (beginIndex + step * i) % this.maxSize;
        }

        return cellIndex;
    }

    private int GetCellIndexByKey(int key)  {
        int beginIndex = HashFunc(key);
        int step = HashFunc2(key);

        int i = 0;
        int cellIndex = (beginIndex + step * i) % this.maxSize;

        while (hashArray[cellIndex] != null) {
            if (hashArray[cellIndex].GetKey() == key) return cellIndex;
            else {
                i++;
                cellIndex = (beginIndex + step * i) % this.maxSize;
            }
        }

        return -1;
    }

    private void DeleteCell(int index) {
        hashArray[index] = nonItem;
    }

}
