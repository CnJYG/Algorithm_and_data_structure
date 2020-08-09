package week02;

import java.util.Random;

public class ArrayGenerator {

    private ArrayGenerator(){}

    //生成一个排好序的数列进行线性查找的性能测试
    public static Integer[] generateOrderedArray(int n){

        Integer[] arr=new Integer[n];
        for (int i=0;i<n;i++)
            arr[i]=i;
        return arr;
    }

    //产生n个随机数，且范围在[1，bound]之间
    public static Integer[] generateRandomArray(int n,int bound){

        Integer[] arr=new Integer[n];
        Random rnd=new Random();
        for (int i=0;i<n;i++)
            arr[i]=rnd.nextInt(bound);
        return arr;
    }
}
