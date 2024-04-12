import java.util.*;
class Node implements Comparable<Node>{
    int x1;
    int y1;
    int x2;
    int y2;
    int cost;
    public Node(int x1,int y1,int x2,int y2, int cost){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node n){
        return this.cost-n.cost;
    }
}
class Solution {
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {-1,1,0,0};
    static int[][][][] inDegree;
    static int n =0;
    static int answer =Integer.MAX_VALUE;
    
    public int solution(int[][] board) {    
        n = board.length;
        inDegree = new int[n][n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int p=0;p<n;p++){
                    for(int q=0; q<n;q++){
                        inDegree[i][j][p][q] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        inDegree[0][0][0][1] = 0;
        inDegree[0][1][0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0,1,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x1+dx[i];
                int ny = cur.y1+dy[i];
                if(nx==cur.x2&&ny==cur.y2) continue;
                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(board[nx][ny]==1) continue;
                int rx=0;
                int ry=0;
                if(nx!=cur.x1) rx = nx;
                if(cur.x2!=cur.x1) rx = cur.x2;
                if(ny!=cur.y1) ry = ny;
                if(cur.y2!=cur.y1) ry = cur.y2;
                if(board[rx][ry]==1) continue;
                if(inDegree[cur.x1][cur.y1][nx][ny]>cur.cost+1){
                    inDegree[cur.x1][cur.y1][nx][ny] = cur.cost+1;
                    inDegree[nx][ny][cur.x1][cur.y1] = cur.cost+1;
                    pq.add(new Node(cur.x1,cur.y1,nx,ny,cur.cost+1));
                }
            }
            for(int i=0;i<4;i++){
                int nx = cur.x2+dx[i];
                int ny = cur.y2+dy[i];
                if(nx==cur.x1&&ny==cur.y1) continue;
                if(nx<0||ny<0||nx>=n||ny>=n) continue;
                if(board[nx][ny]==1) continue;
                int rx=0;
                int ry=0;
                if(nx!=cur.x2) rx = nx;
                if(cur.x1!=cur.x2) rx = cur.x1;
                if(ny!=cur.y2) ry = ny;
                if(cur.y1!=cur.y2) ry = cur.y1;
                if(board[rx][ry]==1) continue;
                if(inDegree[cur.x2][cur.y2][nx][ny]>cur.cost+1){
                    inDegree[cur.x2][cur.y2][nx][ny] = cur.cost+1;
                    inDegree[nx][ny][cur.x2][cur.y2] = cur.cost+1;
                    pq.add(new Node(nx,ny,cur.x2,cur.y2,cur.cost+1));
                }
            }
            
            for(int i=0;i<4;i++){
                int nx1 = cur.x1+dx[i];
                int ny1 = cur.y1+dy[i];
                int nx2 = cur.x2+dx[i];
                int ny2 = cur.y2+dy[i];
                if(nx1<0||ny1<0||nx1>=n||ny1>=n) continue;
                if(nx2<0||ny2<0||nx2>=n||ny2>=n) continue;
                if(board[nx1][ny1]==1) continue;
                if(board[nx2][ny2]==1) continue;
                if(inDegree[nx1][ny1][nx2][ny2]>cur.cost+1){
                    inDegree[nx1][ny1][nx2][ny2] = cur.cost+1;
                    inDegree[nx2][ny2][nx1][ny1] = cur.cost+1;
                    pq.add(new Node(nx1,ny1,nx2,ny2,cur.cost+1));
                }
            }
        }
        for(int i=0;i<4;i++){
            if(n-1+dx[i]>=n||n-1+dy[i]>=n) continue;
            answer = Math.min(inDegree[n-1][n-1][n-1+dx[i]][n-1+dy[i]],answer);
        }
        
        return answer;
    }
}