import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Fish {
    int num;
    int dist;
    boolean isAlive = true;
}

public class Main {
    static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Fish[][] fishes = new Fish[4][4];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                fishes[i][j] = new Fish();
            }
        }
        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 8; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (j % 2 == 0) fishes[i][j / 2].num = val;
                else fishes[i][j / 2].dist = val-1;
            }
        }

        moveShark(fishes,0,0,0);
        System.out.println(maxScore);

    }

    private static void moveFishes(Fish[][] fishes, int sx, int sy) {
        for(int i = 1; i <= 16; i++) {
            int[] curLoc = findFishLoc(fishes, i);
            if(curLoc == null) continue;
            int x = curLoc[0];
            int y = curLoc[1];
            Fish cur = fishes[x][y];
            if(!cur.isAlive) continue;

            for(int cntClock=0; cntClock<8; cntClock++) {
                int nx = x + dx[cur.dist];
                int ny = y + dy[cur.dist];
                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (sx==nx && sy==ny)){
                    cur.dist++;
                    if(cur.dist == 8) cur.dist = 0;
                    continue;
                }

                Fish next = fishes[nx][ny];
                fishes[nx][ny] = cur;
                fishes[x][y] = next;
                break;
            }
        }
    }

    private static int[] findFishLoc(Fish[][] fish, int num){
        for(int i = 0; i<4; i++){
            for(int j = 0; j<4; j++){
                if(fish[i][j].num == num) return new int[]{i, j};
            }
        }
        return null;
    }

    static int maxScore = 0;
    public static void moveShark(Fish[][] fishes, int x, int y, int score){
        if(fishes[x][y].isAlive) maxScore = Math.max(maxScore, score+fishes[x][y].num);
        fishes[x][y].isAlive = false;

        moveFishes(fishes, x, y);
        int tmp = 1;
        while(true){
            int nx = x+dx[fishes[x][y].dist]*tmp;
            int ny = y+dy[fishes[x][y].dist]*tmp;
            tmp++;
            if(nx<0 || ny<0 || nx>=4 || ny>=4) break;
            if(!fishes[nx][ny].isAlive) continue;

            Fish[][] copyFishes = new Fish[4][4];
            for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    Fish copyFish = new Fish();
                    copyFish.num = fishes[i][j].num;
                    copyFish.dist = fishes[i][j].dist;
                    copyFish.isAlive = fishes[i][j].isAlive;
                    copyFishes[i][j] = copyFish;
                }
            }
            moveShark(copyFishes, nx, ny, score+fishes[x][y].num);
        }
    }
}