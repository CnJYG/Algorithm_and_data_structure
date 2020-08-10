package week02;

public class SortingHelper {

    private SortingHelper(){}

    //用于进行验证排序是否已经完成有效
    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for (int i=1;i<arr.length;i++)
            if (arr[i-1].compareTo(arr[i])>0)
                return false;
            return true;
    }

    //用于以后有多种排序算法时能够进行各种排序算法性能的比较
    public static <E extends Comparable<E>> void  sortTest(String sortname,E[] arr){

        long startTime=System.nanoTime();

        if (sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if (sortname.equals("InsertionSort"))
            InsertionSort.sort(arr);

        long endTime=System.nanoTime();

        double time=(endTime-startTime)/1000000000.0;

        if (!SortingHelper.isSorted(arr))
            throw new RuntimeException(sortname+" failed");
        System.out.println(String.format("%s ,n= %d : %f s",sortname,arr.length,time));
    }
}
