package week03;

//使用泛型<E>
//各方法的时间复杂度参见note.pdf
public class Array<E> {

    private E[] data;
    private int size;

    //构造函数，传入数组的容量capacity构造Array，size变量相当于C++中的数组指针
    public Array(int capacity){

        //不能直接指定为：new E[capacity],java不允许
        data=(E[])new Object[capacity];
        size=0;
    }

    //无参数的构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获得数组的元素个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e){

        add(size,e);
    }

    //在数组元素的开头添加新元素
    public void addFirst(E e){

        add(0,e);
    }

    //在index位置添加新元素e添加新元素
    public void add(int index,E e){

        //判断是否已经达到数组的最大容量
        if (size==data.length)
//            //使用静态数组的情况下:
//            throw new IllegalArgumentException("add failed.Array is full.");
            //使用动态数组，当full的时候进行扩容
            resize(2*data.length);


        //判断index是否准确
        if (index<0||index>size)
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<=size");

        for (int i=size-1;i>=index;i--)
            data[i+1]=data[i];

        data[index]=e;
        size++;
    }

    E get(int index){

        if (index<0||index>size)
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<=size");
        return data[index];
    }

    void set(int index,E e){

        if (index<0||index>size)
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<=size");
        data[index]=e;
    }

    //判断数组中是否包含元素e
    public boolean contains(E e){
        for (int i=0;i<size;i++){
            //改成类对象E，比较要用equals()
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    //查找数组中元素e所在的索引，如果不存在元素e，返回-1
    public int find(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //删除index位置的元素，并返回该元素的内容
    public E remove(int index){
        if (index<0||index>size)
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<=size");

        E ret=data[index];
        for (int i = index+1;i<size;i++)
            data[i-1]=data[i];

        size--;
        //引用问题,loitering objects!=memory leak
        data[size]=null;

        //引入动态数组，使内存进一步优化减少
        //将2改为4，表示将激进的数组容量修改变成慵懒的数组容量修改，详见:week03\amortized_time_complexity_note.pdf
        //且要防止数组容量变为0：增加“&&data.length/2!=0"判断
        if (size==data.length/4&&data.length/2!=0)
            resize(data.length/2);
        return ret;
    }

    public E removeFirst(){
        //无需进行输入index的合法性验证，因为在remove()方法中已经进行验证
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    public int removeElement(E e){
        //判断是否存在该元素
        int index=find(e);
        if (index!=-1)
            remove(index);
        return -1;
    }

    @Override
    public String toString(){

        StringBuffer res=new StringBuffer();
        res.append(String.format("Array:size = %d , capacity = %d \n",size,data.length));
        res.append('[');
        for (int i =0;i<size;i++){
            res.append(data[i]);
            if (i!=size-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){

        E[] newData=(E[])new Object[newCapacity];
        for (int i=0;i<size;i++)
            newData[i]=data[i];

        data=newData;
    }
}
