import java.util.Arrays;

public class Move0sToTheEnd {

    public static void main(String[] args) {

        int[] array = new int[]{0,1,1,0,1,0,1,0};
        method(array);
        System.out.println(Arrays.toString(array));
    }



    public static void method(int[] array){
        if(array == null || array.length == 0)
            return;

        int i = 0;
        int j = array.length - 1;

        while(i <= j){

            if(array[i] != 1){
                swap(array, i, j--);
            }else{
                i++;
            }

        }
    }


    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
