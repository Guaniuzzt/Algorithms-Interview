package BinarySearch;

public class SmallestElementLargerThanTarget {

    static Integer res;

    public static void main(String[] args) {

        int[] test = new int[]{1,2,3,3,3};
        method(test, 3);
        System.out.println(res);
    }



    public static void method(int[] array, int target){

        if(array == null || array.length == 0)
            return ;

        int l = 0;
        int r = array.length - 1;

        while(l < r - 1){

            int mid = l + (r - l) /2 ;
            if(array[mid] == target){
                l = mid;
            }else if(array[mid] < target){
                l = mid;
            }else{
                r = mid;
            }
        }



        if(array[l] > target){
            res = array[l];
        }else if(array[r] > target){
            res = array[r];
        }
    }

}
