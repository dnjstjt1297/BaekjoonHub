import java.util.*;
import java.io.*;

class Horse{
    int x;
    int y;
    int direction;
}

public class Main {
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Horse[] horses = new Horse[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            horses[i] = new Horse();
            horses[i].x = Integer.parseInt(st.nextToken()) - 1;
            horses[i].y = Integer.parseInt(st.nextToken()) - 1;
            horses[i].direction = Integer.parseInt(st.nextToken()) - 1;
        }

        int answer = run(board, N, K, horses);
        System.out.println(answer);
    }

   public static int run(int[][] board, int N, int K, Horse[] horses) {
        Deque<Integer>[] q = new ArrayDeque[N*N];

        for(int i=0; i<N*N; i++) q[i] = new ArrayDeque<>();

        for(int i=0; i<K; i++) {
            q[horses[i].x*N+horses[i].y].add(i);
        }

        int seq = 0;
        int turn = 1;
        while(turn <= 1000) {
            int cur = q[horses[seq].x * N + horses[seq].y].getLast();
            if(cur == seq) {
                int nx = horses[seq].x + dx[horses[seq].direction];
                int ny = horses[seq].y + dy[horses[seq].direction];
                int color = 0;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) color = 2;
                else {
                    if (board[nx][ny] == 2) color = 2;
                    else if (board[nx][ny] == 1) color = 1;
                }


                boolean isNext = true;
                if(color==2){
                    switch (horses[seq].direction){
                        case 0: horses[seq].direction=1; break;
                        case 1: horses[seq].direction=0; break;
                        case 2: horses[seq].direction=3; break;
                        case 3: horses[seq].direction=2; break;
                    }
                    nx = horses[seq].x + dx[horses[seq].direction];
                    ny = horses[seq].y + dy[horses[seq].direction];
                    color = 0;
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) color = 2;
                    else {
                        if (board[nx][ny] == 2) color = 2;
                        else if (board[nx][ny] == 1) color = 1;
                    }
                    if(color==2) isNext = false;
                }

                int x = horses[seq].x, y = horses[seq].y;

                if (isNext && color == 0) {
                    while (!q[x*N + y].isEmpty()) {
                        cur = q[x*N + y].pollLast();
                        horses[cur].x = nx;
                        horses[cur].y = ny;
                        q[nx * N + ny].addFirst(cur);
                    }
                    if (q[seq].size() >= 4) return turn;
                } else if (isNext && color == 1) {
                    while (!q[x*N + y].isEmpty()) {
                        cur = q[x * N + y].pollFirst();
                        horses[cur].x = nx;
                        horses[cur].y = ny;
                        q[nx * N + ny].addFirst(cur);
                    }
                }
            }
            for(int i=0; i<N*N; i++) {
                if (q[i].size() >= 4) return turn;
            }
            seq+=1;
            if(seq==K){
                turn++;
                seq = 0;
            }
        }

       return -1;
    }
}
