public class selfIncrease {

    /*
    1、赋值=，最后计算
    2、=右边的从左到右加载值依次压入操作数栈
    3、实际先算哪个看运算优先级
    4、自增自减都是直接通过修改变量的值，不经过操作数栈
    5、最后的赋值之前，临时结果也是存储在操作数栈中

     */


    public static void main(String[] args){
        int i=1;
        //i = i++;  //i++返回1  所以i=1
        i = ++i;
        int j = i++; //j先等于i=1, i=i+1=2
        int k = i+ ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);

    }
}
