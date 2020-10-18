public class DetermineIfOneStringIsAnothersSubstring {


    public static void main(String[] args) {
        String large = "absddsdsd";
        String small = "ds";
        System.out.println(strstr(large, small));
    }

    public static int strstr(String large, String small) {
        // Write your solution here
        if(small == null || small.length() == 0){
            return 0;
        }

        if(large == null || large.length() == 0){
            return -1;
        }

        char[] largearray = large.toCharArray();
        char[] smallarray = small.toCharArray();

        for(int i=0; i<largearray.length; i++){

            if(largearray[i] == smallarray[0]){

                int indexl = i;
                int indexs = 0;
                while(indexl < largearray.length && indexs < smallarray.length){
                    if(largearray[indexl] == smallarray[indexs]){
                        indexl++;
                        indexs++;
                    }else{
                        break;
                    }
                }
                if(indexs == smallarray.length){
                    return i;
                }
            }
        }

        return -1;
    }
}
