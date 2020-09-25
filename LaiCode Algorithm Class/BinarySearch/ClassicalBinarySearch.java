package BinarySearch;

public class ClassicalBinarySearch {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        System.out.println(BinarySearch(test, 3));
    }


    public static int BinarySearch(int[] array, int target){

        if(array == null || array.length == 0)
            return -1;

        int i = 0;
        int j = array.length - 1;
        int res = -1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(array[mid] < target){
                i = mid + 1;
            }else if(array[mid] >target){
                j = mid - 1;
            }else {
                res = mid;
                break;
            }
        }

        return res;


    }


}
