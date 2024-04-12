import java.util.*;
class Solution {
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {-1,1,0,0};
    static final int[] bx = {-1,1,-1,1};
    static final int[] by = {-1,1,1,-1};
    static int answer = Integer.MAX_VALUE;
    public int solution(String numbers) {
        int[][] board = new int[4][3];
        int entry = 1;
        for(int i=0; i<4;i++){
            for(int j=0;j<3;j++){
                if(entry==10||entry==12)
                    board[i][j] = -1;
                else if(entry==11)
                    board[i][j] = 0;
                else{
                    board[i][j] = entry;
                }
                entry++;
            }
        }
        
        int[][] arr = new int[10][10];
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==-1) continue;
                PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
                    @Override
                    public int compare(int[]o1,int[]o2){
                        return o1[2]-o2[2];
                    }
                });
                int[][] inDegree = new int[4][3];
                for(int p=0;p<4;p++){
                    for(int q=0;q<3;q++){
                        inDegree[p][q] = Integer.MAX_VALUE;
                    }
                }
                inDegree[i][j] = 0;
                pq.add(new int[] {i,j,0});
                while(!pq.isEmpty()){
                    int[] cur = pq.poll();
                    for(int p=0;p<4;p++){
                        int nx=cur[0]+dx[p];
                        int ny=cur[1]+dy[p];
                        if(nx<0||ny<0||nx>=4||ny>=3) continue;
                        if(board[nx][ny]==-1) continue;
                        if(inDegree[nx][ny]>cur[2]+2) {
                            pq.add(new int[]{nx,ny,cur[2]+2});
                            inDegree[nx][ny]= cur[2]+2;
                        }    
                        
                    }
                    for(int p=0;p<4;p++){
                        int nx=cur[0]+bx[p];
                        int ny=cur[1]+by[p];
                        if(nx<0||ny<0||nx>=4||ny>=3) continue;
                        if(board[nx][ny]==-1) continue;
                        if(inDegree[nx][ny]>cur[2]+3){
                            pq.add(new int[]{nx,ny,cur[2]+3});
                            inDegree[nx][ny]= cur[2]+3;
                        }    
                    }
                }
                
                int start = board[i][j];
                for(int p=0;p<4;p++){
                    for(int q=0;q<3;q++){
                        if(board[p][q]==-1) continue;
                        arr[start][board[p][q]] = inDegree[p][q];
                    }
                }
                arr[start][start] = 1;
            }
        }
        
        int left = 4;
        int right = 6;
        int[][][] dp = new int[numbers.length()][10][10];
        for(int i=0;i<numbers.length();i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        answer = func(numbers,0,arr,dp,left,right);
        
        return answer;
    }
    public int func(String numbers, int idx, int[][] arr, int[][][] dp, int left, int right){
        if(idx == numbers.length()) return 0;
        
        if(dp[idx][left][right] !=-1) return dp[idx][left][right];
        
        int num = numbers.charAt(idx)-'0';
        
        int result = Integer.MAX_VALUE;
        
        if(num != right) result = Math.min(func(numbers,idx+1,arr,dp,num,right)+arr[left][num], result);
        if(num != left) result = Math.min(func(numbers,idx+1,arr,dp,left,num)+arr[num][right], result);
        
        dp[idx][left][right] = result;
        return result;
    }
   
}