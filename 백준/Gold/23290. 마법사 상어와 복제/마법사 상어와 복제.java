import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int BOARD_LEN = 4;
    static final int SHARK_MOVE_CNT = 3;

    static int[] dx = {0,-1,-1,-1,0,1,1,1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] sdx = {-1,0,1,0};
    static int[] sdy = {0,-1,0,1};
    static int m, s;
    static ArrayList<Integer>[][] prevFishes;
    static ArrayList<Integer>[][] fishes;
    static int[][] fishesTrace;
    static int[] shark;

    static int sharkEatFish = -1;
    static int[][] sharkPath;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        fishes = new ArrayList[BOARD_LEN][BOARD_LEN];
        for(int i = 0; i < BOARD_LEN; i++) {
            for(int j = 0; j < BOARD_LEN; j++) {
                fishes[i][j] = new ArrayList<>();
            }
        }

        fishesTrace = new int[BOARD_LEN][BOARD_LEN];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken())-1;
            fishes[x][y].add(dist);
        }
        st = new StringTokenizer(br.readLine());
        shark = new int[2];
        shark[0] = Integer.parseInt(st.nextToken())-1;
        shark[1] = Integer.parseInt(st.nextToken())-1;

        System.out.println(run());
    }

    public static void moveFish(){
        ArrayList<Integer>[][] nextFishes = new ArrayList[BOARD_LEN][BOARD_LEN];
        for(int i = 0; i < BOARD_LEN; i++) {
            for(int j = 0; j < BOARD_LEN; j++) {
                nextFishes[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<BOARD_LEN;i++){
            for(int j=0;j<BOARD_LEN;j++){
                oaa: for(int f: fishes[i][j]){
                    for(int k=0;k<8;k++) {
                        int nx = i + dx[(f-k)&7];
                        int ny = j + dy[(f-k)&7];
                        if(nx<0||ny<0||nx>=BOARD_LEN||ny>=BOARD_LEN
                                || fishesTrace[nx][ny]!=0 || (nx==shark[0] && ny==shark[1])) continue;
                        nextFishes[nx][ny].add((f-k)&7);
                        continue oaa;
                    }
                    nextFishes[i][j].add(f);
                }
            }
        }

        prevFishes = fishes;
        fishes = nextFishes;
    }

    public static void findSharkPath(int[][] path, int idx, int x, int y){
        if(idx >= SHARK_MOVE_CNT) {
            int sum = 0;
            boolean[][] visited = new boolean[BOARD_LEN][BOARD_LEN];
            for(int i=0;i<SHARK_MOVE_CNT;i++){
                if(!visited[path[i][0]][path[i][1]]) sum += fishes[path[i][0]][path[i][1]].size();
                visited[path[i][0]][path[i][1]] = true;
            }
            if(sharkEatFish < sum){
                sharkEatFish = sum;
                sharkPath = new int[3][2];
                for(int i=0;i<3;i++) sharkPath[i] = path[i].clone();
            }
            return;
        }

        for(int i = 0; i<4; i++){
            int nx = x + sdx[i];
            int ny = y + sdy[i];
            if(nx<0|| ny<0 || nx>=BOARD_LEN || ny>=BOARD_LEN) continue;
            path[idx][0] = nx;
            path[idx][1] = ny;
            findSharkPath(path,idx+1, nx, ny);
        }
    }

    public static void moveShark(int trace){
        for(int i = 0; i<SHARK_MOVE_CNT; i++){
            if(!fishes[sharkPath[i][0]][sharkPath[i][1]].isEmpty()) {
                fishes[sharkPath[i][0]][sharkPath[i][1]].clear();
                fishesTrace[sharkPath[i][0]][sharkPath[i][1]] = trace;
            }
        }
        shark[0] = sharkPath[2][0];
        shark[1] = sharkPath[2][1];
    }

    public static void removeTrace(int trace){
        for(int i = 0; i<BOARD_LEN; i++){
            for(int j = 0; j<BOARD_LEN; j++){
                if(fishesTrace[i][j]==trace-2) fishesTrace[i][j] = 0;
            }
        }
    }

    public static void copyMagic(){
        for(int i = 0; i<BOARD_LEN;i++){
            for(int j = 0; j<BOARD_LEN; j++){
                fishes[i][j].addAll(prevFishes[i][j]);
            }
        }
    }

    public static int run(){
        for(int i = 1; i<=s;i++){
            moveFish();
            findSharkPath(new int[3][2],0,shark[0],shark[1]);
            moveShark(i);
            removeTrace(i);
            copyMagic();
            sharkEatFish = -1;
        }

        int res = 0;
        for(int i = 0; i<BOARD_LEN; i++){
            for(int j = 0; j<BOARD_LEN; j++){
                res = res + fishes[i][j].size();
            }
        }
        return res;
    }
}