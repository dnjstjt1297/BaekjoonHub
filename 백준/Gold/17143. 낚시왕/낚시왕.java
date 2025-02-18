import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Shark{
    int s, d, z;
    public Shark(int s, int d, int z) {
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class Main {

    static int R,C,M;
    static Shark[][] sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new Shark[R+1][C+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[x][y] = new Shark(s, d, z);
        }

        int result = 0;
        for(int i = 1; i<=C; i++){

            result+=fishing(i);
            moveAndEat();
        }
        System.out.println(result);
    }

    public static int fishing(int people){
        int result = 0;
        for(int i=1;i<=R;i++){
            if(sharks[i][people]!=null) {
                result += sharks[i][people].z;
                sharks[i][people] = null;
                break;
            }
        }
        return result;
    }

    public static void moveAndEat(){
        Shark[][] nextSharks = new Shark[R+1][C+1];

        for(int i = 1; i <= R; i++){
            for(int j = 1; j <= C; j++){
                if(sharks[i][j]!=null){
                    Shark shark = sharks[i][j];
                    int[] nextLoc = findNextLoc(i,j,shark.d,shark.s);
                    shark.d = nextLoc[2];
                    if(nextSharks[nextLoc[0]][nextLoc[1]]!=null) {
                        if (shark.z > nextSharks[nextLoc[0]][nextLoc[1]].z) nextSharks[nextLoc[0]][nextLoc[1]] = shark;
                    }
                    else nextSharks[nextLoc[0]][nextLoc[1]] = shark;

                }
            }
        }
        sharks = nextSharks;
    }

    public static int[] findNextLoc(int x, int y, int d, int s){
        int xy = (d==1||d==2)?x:y;
        int rc = (d==1||d==2)?R:C;
        int flag = (s/(rc-1))%2;
        int moving = s%(rc-1);

        if(flag == 1){
            xy = rc-xy+1;
            d = d==1?2:d==2?1:d==3?4:d==4?3:0;
        }

        if(d==1||d==4){
            if(xy-moving>=1) xy = xy-moving;
            else{
                moving = moving-xy+1;
                xy = moving+1;
                d = d==1?2:3;
            }
        }
        else{
            if(xy+moving<=rc) xy = xy+moving;
            else{
                moving = moving-(rc-xy);
                xy = rc-moving;
                d = d==2?1:4;
            }
        }
        if(d==1||d==2) return new int[]{xy,y,d};
        else return new int[]{x,xy,d};
    }

}