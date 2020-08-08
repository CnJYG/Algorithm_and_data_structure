package week01;

public class ArrayGenerator {

    private ArrayGenerator(){}

    //生成一个排好序的数列进行线性查找的性能测试
    public static Integer[] generateOrderedArray(int n){

        Integer[] arr=new Integer[n];
        for (int i=0;i<n;i++)
            arr[i]=i;
        return arr;
    }
}
