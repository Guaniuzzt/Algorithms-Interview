

public class LastOccurence {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,2,2,3};
        int[] test2 = new int[]{1,3,4};
        int[] test3 = new int[]{2};

        System.out.println(method(test, 2));
        System.out.println(method(test2, 2));
        System.out.println(method(test3, 2));
    }

    public static int method(int[] array, int target){

        if(array == null || array.length == 0 || array[0] > target){
            return -1;
        }


        int i=0;
        int j=array.length - 1;
        while(i < j - 1){
            int mid = i + (j - i)/2;
            if(array[mid] == target){
                i = mid;
            }else if(array[mid] < target){
                i = mid;
            }else{
                j = mid;
            }
        }

        if(array[j] == target){
            return j;
        }else if(array[i] == target){
            return i;
        }else{
            return -1;
        }


    }
}
