

public class CloestInArray {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,6};
        System.out.println(method(test, 4));
        //System.out.println(method(test, 7));
        //System.out.println(method(test, 1));
        int[] test2 = new int[]{1,2};
        //System.out.println(method(test2, 0));
    }



    public static int method(int[] array, int target){

        if(array == null || array.length ==0)
            return -1;

        int i = 0;
        int j =  array.length -1;
        int mid = -1;
        while(i < j - 1){          //条件设置i< j - 1, 后面变化不加减，确保弹出时|i- j| = 1,
            mid = i + (j - i) / 2;  //如果条件设置i < j，后面变化加减1，弹出时会导致i = j，排除了可能值
            if(array[mid] == target){
                return mid;
            }else if(array[mid] > target){
                j = mid;
            }else{
                i = mid;
            }
        }

        if(array[i] == target){
            return i;
        }else if(array[j] == target){
            return j;
        }else{
            if(Math.abs(array[i] - target) < Math.abs(array[j] - target)){
                return i;
            }else{
                return j;
            }
        }


    }
}
