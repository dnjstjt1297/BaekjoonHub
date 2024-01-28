import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N,M,H;
    static int[][] abList;
    static int count=-1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        abList = new int[M+3][2];
        for(int i=0; i<M+3;i++){
            if(i>=M){
                abList[i][0] = -1;
                abList[i][1] = -1;
                continue;
            }
            st = new StringTokenizer(br.readLine());
            abList[i][0] = Integer.parseInt(st.nextToken());
            abList[i][1] = Integer.parseInt(st.nextToken());
        }
        bfs(0,0);
        if(min !=4)
            System.out.println(min);
        else
            System.out.println(-1);
    }
    static public boolean is_allPass(){
        int curB;
        for(int i=1; i<=N;i++){
            curB = i;
            for(int j=1;j<=H;j++) {
                for (int[] e : abList) {
                    if (j == e[0]) {
                        if (curB == e[1]) {
                            curB += 1;
                        }else if (curB - 1 == e[1]) {
                            curB -= 1;
                        }
                    }
                }
            }
            if(curB!=i){
                return false;
            }
        }
        return true;
    }

    static int min = 4;
    static public void bfs(int n,int start){
        if(n>=min || start>(N-1)*H){
            return;
        }
        if(is_allPass()){
            min = Math.min(n,min);
        }
        if(n>2) return;
        int x = start/(N-1)+1;
        int y = start%(N-1)+1;
        for(int[] e: abList){
            if(e[0]==x){
                if(e[1]==y || e[1] == y+1|| e[1] == y-1){
                    bfs(n,start+1);
                    return;
                }
            }
        }
        bfs(n,start+1);
        abList[M+n][0] = x;
        abList[M+n][1] = y;
        bfs(n+1,start+1);
        abList[M+n][0] = -1;
        abList[M+n][1] = -1;

    }
}

