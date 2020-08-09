package week02;

public class SelectionSort {

    private SelectionSort(){}

    //使用extends进行泛型约束是因为有一些数据类型不能进行比较，只有实现了Comparable接口的才可以
    public static <E extends Comparable<E>> void sort(E[] arr){

        for (int i=0;i<arr.length;i++){

            //选择arr[i...n]中的最小值的索引
            int minIndex=i;
            for (int j=i;j<arr.length;j++){

                //此为常数级别操作
                if (arr[j].compareTo(arr[minIndex])<0)
                    minIndex=j;
            }

            swap(arr,i,minIndex);
        }
    }

    //该函数不需要对泛型进行约束，因为什么样的数据都可以进行交换,此为常数级别操作
    private static <E> void swap(E[] arr,int i,int j){

        //t为中间变量
        E t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

    public static void main(String[] args) {

//        //使用泛型后不能使用基本数据类型。
//        Integer[] arr={1,4,5,6,3,7};
//        SelectionSort.sort(arr);
//
//        for (int a:arr) {
//            System.out.println(a+" ");
//        }
//
//        Student[] students={new Student("a",98),
//                            new Student("b",100),
//                            new Student("C",66)};
//        SelectionSort.sort(students);
//        for (Student student:students) {
//            System.out.println(student+" ");
//        }
        
        //验证性能,dataSize进行比较，验证算法复杂度是否为O(n方)
        int[] dateSize={10000,100000};
        for (int n:dateSize) {
            Integer[] arr=ArrayGenerator.generateRandomArray(n,n);
            SortingHelper.sortTest("SelectionSort",arr);
        }

    }
}
