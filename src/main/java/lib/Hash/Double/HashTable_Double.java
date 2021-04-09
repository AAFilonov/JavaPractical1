package lib.Hash.Double;

import lib.Hash.DataItem;

public class HashTable_Double extends lib.Hash.HashTable {

    DataItem[] hashArray;
    DataItem nonItem;
    private final int SecondHashConstant;



    private int HashFunc2(int key) {

        return SecondHashConstant - ((key*key) % SecondHashConstant);
    }
    @Override
    public void Insert(DataItem dataItem) {
        int index = GetNextEmptyCellIndex(dataItem.GetKey());
        hashArray[index] = dataItem;
    }
    @Override
    public DataItem Find(int key)  {
        int index = GetCellIndexByKey(key);
        if (index != -1)
            return hashArray[index];
        else
            return null;
    }
    @Override
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



    public  boolean isAlreadyInserted(int key){
        return Find(key) != null;
    }
    //конструкторы
    public HashTable_Double(int maxSize) {
        super (maxSize);
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
        //TODO избавиться от возврата -1
        return -1;
    }

    private void DeleteCell(int index) {
        hashArray[index] = nonItem;
    }

}
