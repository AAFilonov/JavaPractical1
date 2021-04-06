package lib.Hash;

import com.sun.org.apache.xpath.internal.objects.XString;

public class DataItem {
    private final int Key;
    public String Value;

    public int GetKey(){
        return this.Key;
    }

    //инициализатор
    {
        Value = "";
    }
    public DataItem(int key){
        this.Key = key;

    }
    public DataItem(int key,String value){
        this.Key = key;
        this.Value= value;
    }
}
