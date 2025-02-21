import java.util.*;
import java.io.*;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static final int INF = 1000000007;

    static int N;
    static int[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problemNum = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            board = new int[N][N];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra(new int[]{0,0}, new int[]{N-1,N-1});
            System.out.println("Problem "+problemNum+": "+result);
            problemNum++;
        }
    }

    public static int dijkstra(int[] start, int[] end){
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                dist[i][j] = INF;
            }
        }
        dist[start[0]][start[1]] = board[start[0]][start[1]];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o[0]][o[1]]));
        pq.offer(start);
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[0] == end[0] && cur[1] == end[1]){
                return dist[cur[0]][cur[1]];
            }

            for(int i = 0; i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(dist[nx][ny] > dist[cur[0]][cur[1]]+board[nx][ny]){
                    dist[nx][ny] = dist[cur[0]][cur[1]]+board[nx][ny];
                    pq.offer(new int[]{nx, ny});
                }
            }
        }
        return -1;
    }
}