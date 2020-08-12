package week03;

public class Main {
    public static void main(String[] args) {
        //使用泛型，因此增加<Integer>,泛型中不能存放基本数据类型
//        Array<Integer> arr=new Array<>(20);
//        for (int i=0;i<10;i++){
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//
//        arr.add(1,100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        System.out.println(arr);


        ArrayStack<Integer> stack=new ArrayStack<>();

        for (int i =0;i<5;i++){
            stack.push(i);
            System.out.println(stack);
        }
        
        stack.pop();
        System.out.println(stack);
     }
}
