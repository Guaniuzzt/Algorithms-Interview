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

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] flag = new boolean[row][col];
        PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>(){

            @Override
            public int compare(Cell o1, Cell o2){

                if(o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value? -1 : 1;
            }
        });

        pq.offer(new Cell(0, 0, matrix[0][0]));
        Cell temp = new Cell(0, 0, 0);
        while(k != 0){
            temp = pq.poll();
            k--;
            int temprow = temp.row;
            int tempcol = temp.col;

            if(temprow + 1 < row && flag[temprow+1][tempcol] != true){
                pq.offer(new Cell(temprow+1, tempcol,matrix[temprow+1][tempcol]));
                flag[temprow+1][tempcol] = true;
            }

            if(tempcol+1 < col && flag[temprow][tempcol+1] != true){
                pq.offer(new Cell(temprow, tempcol+1,matrix[temprow][tempcol+1]));
                flag[temprow][tempcol + 1] = true;
            }
        }

        return temp.value;

    }



    public int method(int[][] matrix, int k){

        PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell o1, Cell o2) {
                if(o1.value == o2.value){
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });

        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        pq.offer(new Cell(0,0,matrix[0][0]));
        int row = 0;
        int col = 0;
        Cell cur = new Cell(0,0,0);
        while(k != 0){
            k--;
            cur = pq.poll();

            if(cur.row + 1 < matrix.length &&  flag[cur.row + 1][cur.col] != true){
                pq.offer(new Cell(cur.row+1,cur.col, matrix[cur.row+1][cur.col]));
                flag[cur.row+1][cur.col] = true;
            }
            if(cur.col +1 < matrix[0].length && flag[cur.row][cur.col+1] != true){
                pq.offer(new Cell(cur.row, cur.col+1, matrix[cur.row][cur.col+1]));
                flag[cur.row][cur.col+1] = true;
            }
        }
        return cur.value;
    }
}


class Cell{
    int col;
    int row;
    int value;

    public Cell(int row , int col, int value){
        this.col = col;
        this.row = row;
        this.value = value;
    }
}
