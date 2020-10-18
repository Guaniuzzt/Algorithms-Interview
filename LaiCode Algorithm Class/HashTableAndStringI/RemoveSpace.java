public class RemoveSpace {

    /*
    挡板法：
    三个区间由slow, fast指针隔开
    0~slow 不包含slow： 已经确认要保存的字符
    slow ~ fast 不包含fast：还未被确认是否要被使用的空间，用来存放fast指针指向的内容
    fast： 正在被判断内容的指针
    fast(not included)~end: 将要被判断的内容
     */

    public static void main(String[] args) {

        String test = "  a b  cc d   e   ";
        System.out.print(method(test));

    }


    public static String method(String input){
        if(input == null || input.length() == 0){
            return input;
        }

        char[] array = input.toCharArray();
        int slow = 0;
        for(int fast=0; fast<array.length; fast++){
            if(array[fast] == ' ' && (slow == 0 || array[fast - 1] == ' ')){
                continue;
            }
            array[slow++] = array[fast];
        }
        if(slow > 0 && array[slow - 1] == ' '){
            slow--;
        }
        return new String(array, 0, slow);
    }
}
