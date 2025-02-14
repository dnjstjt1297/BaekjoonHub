import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final long[][] mat = {
            {0,1,1,0,0,0,0,0},
            {1,0,1,1,0,0,0,0},
            {1,1,0,1,1,0,0,0},
            {0,1,1,0,1,1,0,0},
            {0,0,1,1,0,1,1,0},
            {0,0,0,1,1,0,0,1},
            {0,0,0,0,1,0,0,1},
            {0,0,0,0,0,1,1,0},
    };

    static final long[][] mat2 ={
            {2,1,1,2,1,0,0,0},
            {1,3,2,1,2,1,0,0},
            {1,2,4,2,1,2,1,0},
            {2,1,2,4,2,1,1,1},
            {1,2,1,2,4,1,0,2},
            {0,1,2,1,1,3,2,0},
            {0,0,1,1,0,2,2,0},
            {0,0,0,1,2,0,0,2},
    };
    static int len = 8;

    static final int MOD = 1000000007;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        long[][][] dp = new long[30][len][len];
        dp[0] = mat;
        for(int i = 1; i < 30; i++) {
            dp[i] = multiplyMat(dp[i-1], dp[i-1]);
        }

        long[][] result = new long[len][len];
        for(int i = 0; i < len; i++) result[i][i] = 1;

        List<Integer> pows = findPows(N);
        for(Integer p : pows) {
            result = multiplyMat(result, dp[p]);
        }

        System.out.println(result[0][0]);

    }

    public static long[][] multiplyMat(long[][] mat, long[][] mat2){
        long[][] result = new long[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                long sum = 0;
                for(int k = 0; k < mat[0].length; k++) sum = (sum + (mat[i][k] * mat2[k][j]))%MOD;
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static List<Integer> findPows(int n){
        ArrayList<Integer> result = new ArrayList<>();
        int tmp = 1, pow = 0;
        while(n>1){
            if(n>tmp){
                tmp*=2; pow++;
            }
            else{
                if(tmp>n){
                    tmp/=2; pow--;
                }
                result.add(pow);
                n-=tmp; pow = 0; tmp = 1;
            }
        }
        if(n==1) result.add(0);
        return result;
    }

}