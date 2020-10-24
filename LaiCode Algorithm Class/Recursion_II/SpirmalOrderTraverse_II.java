import java.util.ArrayList;
import java.util.List;

/*
    m x n matrix
 */

public class SpirmalOrderTraverse_II {

    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here

        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;

        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down - 1; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            for (int i = down - 1; i >= up + 1; i--) {
                res.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }

        if (left > right || up > down) {   // m == n  && m % 2 == 1
            return res;
        }

        if (left == right) {       // m == n || m < n
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][left]);
            }
        } else if (up == down) {   // m > n
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
        }

        return res;
    }
}
