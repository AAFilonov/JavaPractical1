package lib.Hash;

public abstract class HashTable {
    protected final int maxSize;



    public int HashFunc(int key) {
        return (key*key) % maxSize;
    }

    public abstract void Insert(DataItem dataItem);
    void Insert(String keyString){
        DataItem dataItem = new DataItem(keyString,this.GetMaxSize());
        this.Insert(dataItem);
    }
    public abstract DataItem Find(int keyInteger);
    DataItem Find(String keyString){
        int keyInteger =  CountIntKey(keyString) ;
        return Find(keyInteger);
    }
    public abstract DataItem Delete(int keyInteger) ;
    DataItem Delete(String keyString){
        int keyInteger =  CountIntKey(keyString) ;
        return Delete(keyInteger);
    }

    private int CountIntKey(String keyString){
        return DataItem.calculateKey(keyString,this.GetMaxSize());
    }
    public int GetMaxSize() {
        return maxSize;
    }

    protected HashTable(int maxSize) {
        this.maxSize =maxSize;
    }

}
