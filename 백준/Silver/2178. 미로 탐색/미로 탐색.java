
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(bfs(board, N, M));
    }

    public static int bfs(char[][] board, int N, int M) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(e -> e[2]));
        boolean[][] visited = new boolean[N][M];
        pq.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            if(cur[0] == N-1 && cur[1] == M-1){
                return cur[2];
            }

            for(int i =0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0||ny<0||nx>=N||ny>=M) continue;
                if(board[nx][ny] == '0') continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                pq.offer(new int[]{nx,ny,cur[2]+1});
            }
        }
        return -1;
    }
}