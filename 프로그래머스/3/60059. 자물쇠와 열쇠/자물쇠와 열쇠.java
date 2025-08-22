class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int m = key.length;
        int n = lock.length;
        
        for(int r = 0; r<4; r++){
            
            for(int i = 0; i<=n+m; i++){
                c : for(int j = 0; j<=n+m; j++){
                    int[][] board = initBoard(n,m, lock);
                    
                    for(int p = i; p<i+m; p++){
                        for(int q = j; q<j+m; q++){
                            board[p][q]+=key[p-i][q-j];
                        }
                    }
                    
                    
                    for(int p = m; p<n+m; p++){
                        for(int q = m; q<n+m; q++){
                            if(board[p][q] == 0 || board[p][q] == 2) continue c;
                        }
                    }
                    
                    
                    
                    return true;
                }
                
            }
            key = rotate(key, m);
            
        
        }
        
        return answer;
    }
    
    public int[][] rotate(int[][] key, int m){
        int[][] result = new int[m][m];
        
        for(int i = 0; i<m; i++){
            for(int j=0; j<m; j++){
                result[i][j] = key[j][m-1-i];
            }
        }
        return result;
    }
    
    public int[][] initBoard(int n, int m, int[][] lock){
        int[][] board = new int[n+2*m][n+2*m];
            
        for(int i = 0; i<n;i++){
            for(int j = 0; j<n; j++){
                board[i+m][j+m] = lock[i][j];
            }
        }
        
        return board;
    }
}