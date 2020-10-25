public class MaxProductOfCuttingRope {



    public static int method(int length){

        if(length ==0 || length == 1){
            return length;
        }

        int[] M = new int[length + 1];
        M[0] = 0;
        M[1] = 1;

        for(int i=2; i<=length; i++){
            //计算长度为i时，切割相乘最大值
            int curmax = 0;
            for(int j=1; j<i; j++){   //j:不处理的长度，范围必定小于i
                curmax = Math.max(curmax, Math.max((i-j), M[i-j])* j); //(i-j)==不处理切割的长度
                                                                        //M[i-j],长度为i-j切割相乘最大值
            }
            M[i] = curmax;
        }
        return M[length];
    }

}
