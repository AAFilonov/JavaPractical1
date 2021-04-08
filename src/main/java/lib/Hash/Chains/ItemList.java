package lib.Hash.Chains;
import lib.Hash.DataItem;

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
            return this.Head.FindByKey(key);
        }
        return null;
    }

    public DataItem Delete(int key) {
        if (!this.isEmpty()) {

            DataItem tmp = CheckHead(key);
            if (tmp == null)
            tmp  = this.Head.DeleteInListByKey(key);

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
