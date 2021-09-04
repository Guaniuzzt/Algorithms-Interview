public class test {


    public static void main(String[] args) {
        String testword = "wooooooow";
        System.out.print(test(testword));

    }

    public static String test(String input){

        if(input == null || input.length() == 0){
            return input;
        }
        StringBuilder sb = new StringBuilder();
        int times = 1;
        sb.append(input.charAt(0));
        char pre = input.charAt(0);
        for(int i=1; i<input.length(); i++){
            char cur = input.charAt(i);
            if( cur != pre){  //不同直接加入
                sb.append(cur);
                pre = cur;
            }else{  //先判断重复次数，后分两种情况
                while(i < input.length() && input.charAt(i) == pre){
                    times++;
                    i++;
                }
                sb.append(cur);
                pre = cur;
                times = 1;
            }
        }
        return test2(sb);
    }
    //考虑重复出现两次的情况
    public static String test2(StringBuilder sb) {

        StringBuilder sb2 = new StringBuilder();
        boolean flag = false;
        char pre = sb.charAt(0);
        sb2.append(pre);
        for (int i = 1; i < sb.length(); i++) {
            char cur = sb.charAt(i);
            if (cur == pre) {
                if (flag == false) {
                    sb2.append(cur);
                    flag = true;
                    pre = cur;
                } else {
                    flag = false;
                    pre = cur;
                }
            } else {
                sb2.append(cur);
                pre = cur;
            }
        }
        return new String(sb2);
    }

}
