package lib.Stack;

public class Stack {
    //поля
    private Link top;

    //методы
    public void Push(int key){

        Link lnk = new Link(key);
        if(this.top==null){
            top = lnk;
            return;
        }

        Link tmp = top;
        top = lnk;
        lnk.next=tmp;
    }

    public int Peek() throws Exception {
        if(top==null){
            throw new Exception("The stack is empty!");
        }
        return top.key;
    }
    public int Pop() throws Exception {
        if(top==null){
            throw new Exception("The stack is empty!");
        }

        int topKey = top.key;
        top = top.next;
        return topKey;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    //инициализатор
    {
       top = null;
    }

    //конструкторы
    public Stack(){

    }
    public Stack(int key){
        this.top= new Link(key);
    }

}
