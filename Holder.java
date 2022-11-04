public class Holder { //a holder class because sometimes i need to return two different class objects
    Object a, b, c;

    public Holder(Object a, Object b){
        this.a = a;
        this.b = b;
    }
    public Holder(Object a, Object b, Object c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Object get(int i){
        if(i == 0){
            return a;
        }
        else if(i == 1){
            return b;
        }
        else if(i == 3){
            return c;
        }
        else{
            return null;
        }
    }
}
