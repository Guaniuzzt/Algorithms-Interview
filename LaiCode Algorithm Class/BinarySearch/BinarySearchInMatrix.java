

public class BinarySearchInMatrix {

    public static void main(String[] args) {

        int[][] test = new int[][]{{1,2,3}, {4, 5,6}};
        int row = method(test, 3)[0];
        int col = method(test, 3)[1];
        System.out.println(row);
        System.out.println(col);

        int row2 = method(test, 7)[0];
        int col2 = method(test, 7)[1];
        System.out.println(row2);
        System.out.println(col2);

    }


    public static int[] method(int[][] matrix, int target){

        if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return new int[]{-1, -1};
        }
        int[] res = new int[]{-1, -1};
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while(left <= right){

            int mid = left + (right - left)/2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;

            if(matrix[row][col] == target){
                res[0] = mid / matrix[0].length;
                res[1] = mid % matrix[0].length;
                break;
            }else if(matrix[row][col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return res;



    }
}
