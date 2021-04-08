package lib.Hash;

import static java.lang.Math.pow;

public class DataItem {
    private int Key;
    private String Value;


    public static int calculateKey( String value ,int limit){
        char[] KeyS = value.toLowerCase().toCharArray();
        int sum=0, i=0;
        for (char c :KeyS){
            int pow27 = (int) pow(27,i);
            i++;
            sum +=  ((int) c)*pow27;
        }
        sum %=limit;
       return sum;
    }
    private void  SetCalculatedKey( int limit){
        this.Key = calculateKey(this.Value, limit);
    }

    public int GetKey(){
        return this.Key;
    }
    public String GetValue(){
        return this.Value;
    }

    //инициализатор
    {
        Value = "";
    }
    public DataItem(String value,int limit){
        this.Value= value;
        SetCalculatedKey(limit);

    }
    public DataItem(int key){
        this.Key = key;

    }
    public DataItem(int key,String value){
        this.Key = key;
        this.Value= value;
    }
}
