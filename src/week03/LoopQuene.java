package week03;

public class LoopQuene<E> implements Quene<E>{

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQuene(int capacity){
        data=(E[])new Object(capacity+1);
        front=0;
        tail=0;
        size=0;
    }

    public LoopQuene(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }

    @Override
    public int getSize() {
        return size;
    }
}
