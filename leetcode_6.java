import java.util.ArrayList;

/**
 * 题目：被围绕的区域
 * 
 * 题目描述：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
   找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

   示例：
   X X X X
   X O O X
   X X O X
   X O X X

   运行你的函数后，矩阵变为：
   X X X X
   X X X X
   X X X X
   X O X X
 */

/**
 * 方法：找边界上的'O'，将其置为'K'，递归查找其四个方向上的元素，若为'O'，则将其置为'K'，
 * 'K'表示这里的'O'不能被填充为'X'，最后所有'O'填充为'X'，将所有'K'填充为'O'即可
 */

public class leetcode_6 {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        // char[][] board = {{'X', 'X', 'X', 'X'}, 
        //                   {'X', 'O', 'O', 'X'}, 
        //                   {'X', 'X', 'O', 'X'},
        //                   {'X', 'O', 'X', 'X'}};
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        leetcode_6 ll = new leetcode_6();
        ll.printArray(board);
        ll.solve(board);
        System.out.println("===============");
        ll.printArray(board);
    }

    public void printArray(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(char c : board[i]){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if((i == 0 || i == board.length-1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O'){
                    board[i][j] = 'K';
                    help(board, i, j);
                }
            }
        }

        // System.out.println("===============");
        // printArray(board);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                if(board[i][j] == 'K'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    public void help(char[][] board, int row, int column){
        
        for(int i = 0; i < 4; i++){
            int x = row + dx[i];
            int y = column + dy[i];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O'){
                
                board[x][y] = 'K';
                help(board, x, y);
            }
        }
    }
}