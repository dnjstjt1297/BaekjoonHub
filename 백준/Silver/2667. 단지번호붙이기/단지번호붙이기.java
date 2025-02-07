
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0;i < N;i++) {
            String input = br.readLine();
            for(int j = 0;j < N;j++) board[i][j] = input.charAt(j) - '0';
        }

        ArrayList<Integer> groups = new ArrayList<>();
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                if(board[i][j] == 0) continue;
                if(visited[i][j]) continue;
                int group = 0;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                visited[i][j] = true;
                group++;
                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    for(int k = 0;k < 4;k++) {
                        int nx = cur[0] + dx[k];
                        int ny = cur[1] + dy[k];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if(board[nx][ny] == 0) continue;
                        if(visited[nx][ny]) continue;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        group++;
                    }
                }
                groups.add(group);
            }
        }
        Collections.sort(groups);
        System.out.println(groups.size());
        for(int i : groups ) System.out.println(i);
    }
}
