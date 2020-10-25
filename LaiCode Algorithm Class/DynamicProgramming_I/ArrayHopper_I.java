public class ArrayHopper_I {

    public static void main(String[] args) {
        int[] test = new int[]{1,2,0};
        System.out.println(canJump(test));
    }

    public static boolean canJump(int[] array) {
        // Write your solution here

        if(array.length == 1){
            return true;
        }

        boolean[] flag = new boolean[array.length];
        flag[flag.length - 1] = true;
        for(int i=flag.length -2; i>=0; i--){
            if(i + array[i] >= array.length - 1){
                flag[i] = true;
            }else{
                for(int steps = array[i]; steps>=0; steps--){
                    if(flag[i+steps]){
                        flag[i] = true;
                        break;
                    }
                }


            }
        }
        return flag[0];
    }
}
