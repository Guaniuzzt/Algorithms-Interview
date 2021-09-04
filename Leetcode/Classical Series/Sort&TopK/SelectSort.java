public class SelectSort {

    //Time: n^2
    //Space: 1

    public int[] solve(int[] array) {
        // Write your solution here
        if(array == null || array.length == 0){
            return array;
        }

        for(int i=0; i<array.length; i++){
            int min = i;
            for(int j=i+1; j<array.length; j++){
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return array;
    }
}
