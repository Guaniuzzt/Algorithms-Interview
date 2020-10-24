import java.util.ArrayList;
import java.util.List;

public class SpiralOrderTraverseI {

    /*
    Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner.
     Return the list of traversal sequence.

    Assumptions
    AssumptionsThe 2D array is not null and has size of N * N where N >= 0
    Examples

    { {1,  2,  3},

      {4,  5,  6},

      {7,  8,  9} }
    the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
     */

    public static void main(String[] args) {
        int[][] matrix2 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.print(helper(matrix2));
    }

    public static List<Integer> helper(int[][] matrix){
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;

        int right = matrix.length - 1;
        int left = 0;
        int top = 0;
        int down = matrix.length - 1;

        while(left < right && top < down){
            //上部
            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            //右边(不包含头脚)
            for(int i=top+1; i<=down-1; i++){
                res.add(matrix[i][right]);
            }
            //下部
            for(int i=right; i>= left; i--){
                res.add(matrix[down][i]);
            }
            //左边不包含头脚
            for(int i=down-1; i>=top+1; i--){
                res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            down--;
        }

        if(left == right){
            res.add(matrix[top][left]);
        }

        return res;
    }
}
