package week03;

import java.util.Random;

public class Main {

    private static double testQuene(Quene<Integer> q,int opCount){

        long startTime=System.nanoTime();

        Random random=new Random();
        for (int i=0;i<opCount;i++)
            q.enquene(random.nextInt(Integer.MAX_VALUE));

        for (int i=0;i<opCount;i++)
            q.dequene();

        long endTime=System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

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


//        ArrayStack<Integer> stack=new ArrayStack<>();
//
//        for (int i =0;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//
//        stack.pop();
//        System.out.println(stack);


        //测试两种队列的性能
        int opCount=100000;

        ArrayQuene<Integer> arrayQuene=new ArrayQuene<>();
        double time1=testQuene(arrayQuene,opCount);
        System.out.println(" ArrayQuene , time: "+time1+" s");

        LoopQuene<Integer> loopQuene=new LoopQuene<>();
        double time2=testQuene(loopQuene,opCount);
        System.out.println(" LoopQuene , time: "+time2+" s");
     }
}
