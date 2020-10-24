public class StringShuffling {


    /*
    A1B2C3D4 => ABCD1234
    Time: O(nlogn) merge的时候logn 层 每层 n
    Space: O(n)

     */

    public static void main(String[] args) {
        String test = "A1B2C3D4";
        System.out.println(method(test));
    }


    public static String method(String input){
        if(input == null || input.length() <= 1)
            return input;

        char[] array = input.toCharArray();
        char[] res = divide(array, 0, array.length-1);
        return new String(res);
    }

    public static char[] divide(char[] array, int left, int right){

        if(left >= right){
            return new char[]{array[left]};
        }
        int mid = left + (right - left) / 2;
        char[] leftarray = divide(array, left, mid);
        char[] rightarray = divide(array, mid+1, right);
        return merge(leftarray, rightarray);

    }

    public static char[] merge(char[] c1, char[] c2){

        char[] res = new char[c1.length + c2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i != c1.length && j != c2.length){
            if(compare(c1[i], c2[j])){
                res[index++] = c1[i++];
            }else{
                res[index++] = c2[j++];
            }
        }

        while(i != c1.length){
            res[index++] = c1[i++];
        }

        while(j != c2.length){
            res[index++] = c2[j++];
        }

        return res;

    }



    public static boolean compare(char c1 , char c2){
        if(Character.isDigit(c1) && Character.isDigit(c2)){
           if(c1 <= c2)
               return true;
           else
               return false;
        }else if(Character.isLetter(c1) && Character.isLetter(c2)){
            if(c1 <= c2){
                return true;
            }else{
                return false;
            }
        }else{
            if(Character.isLetter(c1))
                return true;
            else
                return false;
        }
    }
}
