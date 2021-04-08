package lib.Hash.Chains;


import lib.Hash.DataItem;

import javax.xml.crypto.Data;

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


    public DataItem DeleteNextByKey(int key) {
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
                return  this.next.DeleteNextByKey(key);
        }
    }
}


public class ItemList {
    Link Head;

    public void Insert( DataItem dataItem){
        if(this.isEmpty()){
            this.Head = new Link(dataItem, null);
        }
        else
        {
            Link Current = this.Head;
            while (Current.next!=null){
                Current = Current.next;
            }
            Current.next = new Link(dataItem, null);
        }
    }
    public  DataItem Find(int key){
        if (!this.isEmpty()) {

            Link Current = this.Head;
            do {
                if (Current.data.GetKey() == key) {
                    return Current.data;
                } else Current = Current.next;
            } while(Current!=null);
        }
        return null;
    }

    public DataItem Delete(int key) {
        if (!this.isEmpty()) {

            DataItem tmp = CheckHead(key);
            if (tmp == null)
            tmp  = this.Head.DeleteNextByKey(key);

            return tmp;

        }
        return null;
    }
    DataItem CheckHead(int key){
        if(this.Head.data.GetKey()==key){
            DataItem tmp =this.Head.data;
            this.Head = this.Head.next;
            return tmp;
        }
        else return null;
    }



    public  boolean isEmpty(){
        return Head==null;
    }


    ItemList(){
        this.Head = null;
    }
    ItemList(DataItem dataItem){
        this.Head = new Link(dataItem, null);
    }


}
