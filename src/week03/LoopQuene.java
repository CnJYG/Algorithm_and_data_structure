package week03;

//循环队列的意义是为了解决出队时时间复杂度为O(n)的问题，使用循环队列之后时间复杂度变为O(1),不需要补齐空缺位置
public class LoopQuene<E> implements Quene<E>{

    private E[] data;
    private int front,tail;
    private int size;

    public LoopQuene(int capacity){
        data=(E[])new Object[capacity+1];
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
    public void enquene(E e) {

        if ((tail+1)%data.length==front)
            resize(getCapacity()*2);

        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    @Override
    public E dequene() {

        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequene from an empty quene.");

        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if (size==getCapacity()/4&&getCapacity()/2!=0)
            resize(getCapacity()/2);
        return ret;
    }

    private void resize(int newCapacity){

        E[] newData=(E[])new Object[newCapacity+1];
        for (int i=0;i<size;i++)
            newData[i]=data[(i+front)%data.length];

        data=newData;
        front=0;
        tail=size;

    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Quene is empty");
        return data[front];

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString(){

        StringBuffer res=new StringBuffer();
        res.append(String.format("Quene :size = %d , capacity = %d \n",size,data.length));
        res.append("front [");
        for (int i =front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if ((i+1)%data.length!=tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
