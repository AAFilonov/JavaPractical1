package lib.Stack;

class Link {
    int key;
    Link next;
    //инициализатор
    {
        key=0;
        next = null;
    }
    //конструкторы
    Link(){

    }
    Link(int key){
        this.key=key;
    }
    Link(int key, Link next){
        this.key=key;
        this.next=next;
    }
}
