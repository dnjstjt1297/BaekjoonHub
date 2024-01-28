import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int N;
    static int[][] status;
    static ArrayList<int[]> divTeamList;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        status = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divTeamList = new ArrayList<>();
        int A[] = new int[N/2];
        divTeam(A,0,0);
        calculate(0);
        System.out.println(min);
    }

    public static void divTeam(int A[], int n, int x){

        if(n==N/2) {
            int[] Aclone =A.clone();
            divTeamList.add(Aclone);
            return;
        }

        for(int i=x; i<N;i++){
            A[n] = i;
            x = i;
            divTeam(A,n+1,x+1);
        }
    }

    public static void calculate(int n){
        if(n>divTeamList.size()/2){
            return;
        }

        int startScore;
        int rinkScore;

        int[] B = new int[2];

        dfs(divTeamList.get(n),B,0,0);
        startScore = score;
        score =0;
        dfs(divTeamList.get(divTeamList.size()-1-n),B,0,0);
        rinkScore = score;
        score =0;
        min = Math.min(min,Math.abs(startScore-rinkScore));
        calculate(n+1);
    }
    static int score=0;
    public static void dfs(int[] A, int B[], int n, int x){
        if(n==2){
             score = score + status[B[0]][B[1]]+status[B[1]][B[0]];
             return;
        }
        for(int i=x; i<A.length;i++){
            B[n] = A[i];
            x=i;
            dfs(A,B,n+1,x+1);
        }

    }

}

