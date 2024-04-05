class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] arr = new int[board.length+1][board[0].length+1];
        for(int[] e: skill){
            int type = e[0];
            int r1 = e[1];
            int c1 = e[2];
            int r2 = e[3];
            int c2 = e[4];
            int degree = e[5];
            if(type==1) degree *= -1;
            arr[r1][c1] += degree;
            arr[r1][c2+1] += -degree;
            arr[r2+1][c1] += -degree;
            arr[r2+1][c2+1] += degree;
            
        }
        for(int i=1;i<=board.length;i++){
            for(int j=0;j<=board[0].length;j++){
                arr[i][j] +=arr[i-1][j];
            }
        }
        for(int i=0;i<=board.length;i++){
            for(int j=1;j<=board[0].length;j++){
                arr[i][j] +=arr[i][j-1];
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]+=arr[i][j];
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]>0) answer++;
            }   
        }
        
        return answer;
    }
}