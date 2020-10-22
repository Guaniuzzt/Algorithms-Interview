import java.util.Arrays;

public class ReorderArray {


    public static void main(String[] args) {

        int[] test = new int[]{1,2,3,4,5};
        System.out.print(Arrays.toString(reorder(test)));

    }


    public static int[] reorder(int[] array) {
        // Write your solution here
        if(array == null || array.length <= 3)
            return array;


        int i = 0;
        int j = array.length / 2;

        int[] res = new int[array.length];

        if(array.length % 2 ==0){//偶数长度
            for(int index = 0; index < res.length; index++){
                if(index % 2 == 0){
                    res[index] = array[i++];
                }else{
                    res[index] = array[j++];
                }
            }
        }else{
            int index;
            for(index=0; index<res.length - 1; index++){
                if(index % 2 == 0){
                    res[index] = array[i++];
                }else{
                    res[index] = array[j++];
                }
            }
            res[index] = array[j];
        }

        return res;

    }
}
