import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static boolean[][][] visited;

    static int zeroCnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] tomatoes = new int[h][n][m];
        visited = new boolean[h][n][m];
        ArrayList<int[]> ones = new ArrayList<>();
        for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<m; k++){
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoes[i][j][k] == 1){
                        ones.add(new int[]{i, j, k});
                    }
                }
            }
        }

        int answer = 0;
        while(true){
            ones = spread(tomatoes,ones,h,n,m);
            if(!ones.isEmpty()) answer++;
            else break;
        }
        boolean com = isComplete(tomatoes,h,n,m);

        if (com) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean isComplete(int[][][] tomatoes, int h, int n, int m){
        boolean isAnswer = true;
        go: for(int i = 0; i<h; i++){
            for(int j = 0; j<n; j++){
                for(int k = 0; k<m; k++){
                    if(tomatoes[i][j][k] == 0){
                        isAnswer = false;
                        break go;
                    }
                }
            }
        }
        return isAnswer;
    }


    public static ArrayList<int[]> spread(int[][][] tomatoes, ArrayList<int[]> ones, int h, int n, int m){
        ArrayList<int[]> spreadList = new ArrayList<>();

        for(int[] one: ones){
            for(int i =0;i<6; i++){
                int nx = one[0] + dx[i];
                int ny = one[1] + dy[i];
                int nz = one[2] + dz[i];
                if(nx<0||ny<0||nz<0 || nx>=h || ny>=n || nz>=m) continue;
                if(tomatoes[nx][ny][nz] !=0) continue;
                if(visited[nx][ny][nz]) continue;
                spreadList.add(new int[]{nx, ny, nz});
                visited[nx][ny][nz] = true;
            }
        }

        for(int[] spread : spreadList){
            tomatoes[spread[0]][spread[1]][spread[2]] = 1;
        }

        return spreadList;
    }
}