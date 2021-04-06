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
            while (Current.next != null) {
                if (Current.data.GetKey() == key)
                    return Current.data;
                else
                    Current = Current.next;
            }
        }
        return null;
    }

    public DataItem Delete(int key) {
        if (!this.isEmpty()) {
            Link Current = this.Head;
          //Не проверяется если первый эленент сожержит ключ



            while (Current.next != null) {
                if (Current.next.data.GetKey() == key) {
                    DataItem tmp = Current.next.data;
                    Current.next = Current.next.next;
                    return tmp;
                } else
                    Current = Current.next;
            }
        }
        return null;
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
