import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static int N, L, R;
    static int[][] board;
    static boolean[][] visited = new boolean[N][N];
    static boolean isEixt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int result = 0;
        int i = 0;
        while(i<2000){
            allMoves();
            if(isEixt) return(result);
            result++;
        }
        return result;
    }

    public static void allMoves(){
        visited = new boolean[N][N];
        isEixt = true;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i,j);
                }
            }
        }
    }

    public static void bfs(int sx, int sy) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<int[]> path = new ArrayList<>();
        q.add(new int[]{sx, sy});
        path.add(new int[]{sx, sy});
        int sum = board[sx][sy];
        visited[sx][sy] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                if(visited[nx][ny]) continue;
                int abs = Math.abs(board[nx][ny] - board[cur[0]][cur[1]]);
                if(abs>=L && abs<=R) {
                    q.add(new int[]{nx, ny});
                    path.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum += board[nx][ny];
                }
            }
        }
        int nextPeoples = sum/path.size();
        for(int[] e : path){
            board[e[0]][e[1]] = nextPeoples;
        }
        if(path.size()>=2) isEixt = false;
    }
}