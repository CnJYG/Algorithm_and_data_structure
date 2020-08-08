package week01;

public class LinearSearch {
    
    private LinearSearch(){}
    
    public static <E> int search(E[] data,E target){

        for (int i=0;i<data.length;i++)
            if (data[i].equals(target))
                return i;
        return -1;    
    }

    public static void main(String[] args) {
        
//        Integer[] data={24,18,12,9,16,66,32,4};
//
//        int res=LinearSearch.search(data,16);
//        System.out.println("res = " + res);
//
//        Student[] students={new Student("one"),
//                             new Student("two"),
//                              new Student("three")};
//        Student one=new Student("one");
//        int res2=LinearSearch.search(students,one);
//        System.out.println("res2 = " + res2);

        //测试性能
        int[] dataSize={1000000,10000000};

        //比较两次结果可以得出，该过程的时间复杂度是O(n),即数据增加10倍，时间增加10倍
        for (int n:dataSize) {
            Integer[] data=ArrayGenerator.generateOrderedArray(n);

            long startTime=System.nanoTime();
                        for (int k=0;k<100;k++)
                LinearSearch.search(data,10000000);
            long endTime=System.nanoTime();

            double time=(endTime-startTime)/1000000000.0;
            System.out.println("n="+n+",100runs,"+"time = " + time+"s");
        }
    }
}
