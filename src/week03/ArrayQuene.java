package week03;

public class ArrayQuene<E> implements Quene<E>{

    private Array<E> array;

    public ArrayQuene(int capacity){
        array=new Array<>(capacity);
    }

    public ArrayQuene(){
        array =new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enquene(E e) {
        array.addLast(e);
    }

    @Override
    public E dequene() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuffer res=new StringBuffer();
        res.append("Quene: ");
        res.append("front [");
        for (int i=0;i<array.getSize();i++){
            res.append(array.get(i));
            if (i!=array.getSize()-1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        ArrayQuene<Integer> quene=new ArrayQuene<>();
        for (int i=0;i<10;i++){
            quene.enquene(i);
            System.out.println(quene);

            if (i%3==2){
                quene.dequene();
                System.out.println(quene);
            }
        }

    }
}
