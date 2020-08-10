package week02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertionSort {

    private InsertionSort(){}

//    public static <E extends Comparable<E>> void sort(E[] arr){
//
//        for (int i=0;i<arr.length;i++){
//
////            //将arr[i]插入到合适的位置
////            for (int j=0;j-1>=0;j--){
////                if (arr[j].compareTo(arr[j-1])<0)
////                    swap(arr,j,j-1);
////                else break;
////            }
//            //语句优化
//            for (int j=i;j-1>=0&&arr[j].compareTo(arr[j-1])<0;j--)
//                swap(arr,j,j-1);
//        }
//
//    }

//    //该函数不需要对泛型进行约束，因为什么样的数据都可以进行交换,此为常数级别操作
//    private static <E> void swap(E[] arr,int i,int j){
//
//        //t为中间变量
//        E t=arr[i];
//        arr[i]=arr[j];
//        arr[j]=t;
//    }

    public static <E extends Comparable<E>> void sort(E[] arr){

        for (int i=0;i<arr.length;i++){

            E t=arr[i];
            int j;
            for (j=i;j-1>=0 && t.compareTo(arr[j-1])<0;j--){

                //只进行一步交换操作，相比swap()提高效率
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }

    public static void main(String[] args) {

        int[] dateSize={10000,100000};

        for (int n:dateSize) {

            System.out.println(n+" Random Array :" );

            Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
            Integer[] arr2= Arrays.copyOf(arr,arr.length);

            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);

            System.out.println();

            System.out.println(n+" Ordered Array :" );

            arr=ArrayGenerator.generateOrderedArray(n);
            arr2=Arrays.copyOf(arr,arr.length);

            SortingHelper.sortTest("InsertionSort",arr);
            SortingHelper.sortTest("SelectionSort",arr2);

            System.out.println();
        }
    }
}
