import java.util.*;

class Solution {
    int[] answer;
    int idx = 0;
    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        int[][] board = new int[rows][columns];
        
        int cnt = 0;
        for(int i =0; i<rows; i++){
            for(int j= 0; j<columns; j++){
                board[i][j] = ++cnt;
            }
        }
        
        for(int i = 0; i<queries.length; i++){
            board = rotate(rows, columns, queries[i][0]-1, queries[i][1]-1,queries[i][2]-1, queries[i][3]-1, board);
        }
        
        return answer;
    }
    
    public int[][] rotate(int n, int m, int x1, int y1, int x2, int y2,
                        int[][] board){
        
        int[][] result = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                result[i][j] = board[i][j];
            }
        }
        
        for(int i = y1+1; i<=y2; i++){
            result[x1][i] = board[x1][i-1];
            answer[idx] = Math.min(result[x1][i],answer[idx]);
        }
        
        for(int i = y1; i<y2; i++){
            result[x2][i] = board[x2][i+1];
            answer[idx] = Math.min(result[x2][i],answer[idx]);
        }
        
        for(int i = x1+1; i<=x2; i++){
            result[i][y2] = board[i-1][y2];
            answer[idx] = Math.min(result[i][y2],answer[idx]);
        }
        
        for(int i = x1; i<x2; i++){
            result[i][y1] = board[i+1][y1];
            answer[idx] = Math.min(result[i][y1],answer[idx]);
        }
        idx++;
        
        return result;
    }
}