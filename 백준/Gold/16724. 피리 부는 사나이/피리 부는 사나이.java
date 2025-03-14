import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                if(line.charAt(j) == 'U') board[i][j] = 0;
                else if(line.charAt(j) == 'D') board[i][j] = 1;
                else if(line.charAt(j) == 'L') board[i][j] = 2;
                else if(line.charAt(j) == 'R') board[i][j] = 3;
            }
        }
        visited = new boolean[N][M];


        int answer = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                ArrayList<int[]> path = new ArrayList<>();
                visited[i][j] = true;
                path.add(new int[] {i, j});

                while(!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int nx = cur[0] + dx[board[cur[0]][cur[1]]];
                    int ny = cur[1] + dy[board[cur[0]][cur[1]]];
                    if(visited[nx][ny]){
                        for(int[] p : path) {
                            if(p[0] == nx && p[1] == ny) answer++;
                        }
                        break;
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    path.add(new int[] {nx, ny});
                }
            }
        }
        System.out.println(answer);
    }

}