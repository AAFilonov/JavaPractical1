package lib.Hash.Chains;

import lib.Hash.DataItem;

class Link {
    DataItem data;
    Link next;
    //инициализатор
    {
        next = null;
    }
    //конструкторы
    Link(DataItem data){
        this.data=data;
    }



    Link(DataItem data, Link next){
        this.data=data;
        this.next =next;
    }


    public DataItem DeleteInListByKey(int key) {
        if(this.next == null){
            return null;
        }
        else{
            if(this.next.data.GetKey()==key){
                DataItem tmp = this.next.data;
                this.next =null;
                return  tmp;
            }
            else
                return  this.next.DeleteInListByKey(key);
        }
    }
    public DataItem FindByKey(int key ){
     try{
         return CheckSelfByKey(key);
        }
     catch (NullPointerException e){
         return CheckNextByKey(key);
     }
    }

    private DataItem CheckSelfByKey(int key ){
        if(this.data.GetKey()==key){
            return this.data;
        }
        else
            throw new NullPointerException("Exception: key not found");
    }
    private DataItem CheckNextByKey(int key ){
        if(this.next == null){
            return null;
        }
        else{
            return this.next.CheckSelfByKey(key);
        }
    }

}