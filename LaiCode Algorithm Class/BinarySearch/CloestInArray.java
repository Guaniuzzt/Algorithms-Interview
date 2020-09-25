package BinarySearch;

public class CloestInArray {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,6};
        System.out.println(method(test, 4));
        System.out.println(method(test, 7));
        System.out.println(method(test, 1));
    }



    public static int method(int[] array, int target){

        if(array == null || array.length ==0)
            return -1;

        int i = 0;
        int j =  array.length -1;
        int res = -1;
        while(i < j - 1){

            int mid = i + (j - 1)/2;
            if(array[mid] == target){
                res = mid;
                break;
            }else if(array[mid] > target){
                j = mid;
            }else{
                i = mid;
            }
        }

        if(res != -1){
            return res;
        }else{
            return Math.abs(array[i] - target) < Math.abs(array[j] - target) ? i : j;
        }
    }
}
