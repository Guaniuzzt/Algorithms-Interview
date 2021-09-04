import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {


    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,7},{2,4,8,9},{3,5,11,15},{6,8,13,18}};
        KthSmallestNumberInSortedMatrix test = new KthSmallestNumberInSortedMatrix();
        int res = test.kthSmallest(matrix, 4);
        System.out.println(res);
    }

    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        boolean[][] tag = new boolean[matrix.length][matrix[0].length];
        PriorityQueue<Cell> minheap = new PriorityQueue<>(k, new Comparator<Cell>(){

            @Override
            public int compare(Cell a, Cell b){
                if(a.val == b.val){
                    return 0;
                }
                return a.val < b.val ? -1 : 1;
            }
        });

        minheap.offer(new Cell(0, 0, matrix[0][0]));
        Cell cur = new Cell(0,0,0);
        while(true){
            cur = minheap.poll();
            k--;
            if(k == 0){
                return cur.val;
            }
            int row = cur.row;
            int col = cur.col;

            if(row+1 < matrix.length && tag[row+1][col] != true){
                minheap.offer(new Cell(row+1, col, matrix[row+1][col]));
                tag[row+1][col] = true;
            }

            if(col+1 < matrix[0].length && tag[row][col+1] != true){
                minheap.offer(new Cell(row, col+1, matrix[row][col+1]));
                tag[row][col+1] = true;
            }
        }




    }

    static class Cell{

        int row;
        int col;
        int val;

        public Cell(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

}



