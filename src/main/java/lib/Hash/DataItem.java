package lib.Hash;

import com.sun.org.apache.xpath.internal.objects.XString;

import static java.lang.Math.pow;

public class DataItem {
    private int Key;
    public String Value;

    public int GetKey(){
        return this.Key;
    }
    int calculateKey( int limit){
        char[] KeyS = this.Value.toLowerCase().toCharArray();
        int sum=0, i=0;
        for (char c :KeyS){
            int pow27 = (int) pow(27,i);
            i++;
            sum +=  ((int) c)*pow27;
        }
        sum %=limit;
       return sum;
    }
    //инициализатор
    {
        Value = "";
    }
    public DataItem(String value,int limit){
        this.Value= value;
        this.Key = calculateKey(limit);

    }
    public DataItem(int key){
        this.Key = key;

    }
    public DataItem(int key,String value){
        this.Key = key;
        this.Value= value;
    }
}
