public class FibonacciNumberLite {

    /*
    Time: O(1 + 2^2 + 2^3 + ... + 2 ^ (n-1)) = 2^n //Recursion tree 里所有节点的时间复杂度之和
    Space: O(1 + 1 + ...+ n-1) = n   //Recursion tree 里一条直上直下的路径上所有节点的空间复杂度之和
     */

    public static void main(String[] args) {

        int res = method(4);
        System.out.println(res);
    }

    public static int method(int K){

        if(K < 0)
            return 0;

        if(K == 0)
            return 0;

        if(K == 1)
            return 1;

        return method(K - 1) + method(K - 2);

    }
}
