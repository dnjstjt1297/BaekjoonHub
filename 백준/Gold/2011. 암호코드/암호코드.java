import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ccrypt = br.readLine().toCharArray();
        int [] crypt = new int[ccrypt.length];
        for(int i = 0; i < crypt.length; i++) {
            crypt[i] = ccrypt[i] - '0';
        }

        int n = crypt.length;
        int[] dp = new int[n+1];


        if(crypt[0] == 0){
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;

        for(int j = 2; j<=n; j++){
            if(crypt[j-1] != 0){
                dp[j] = dp[j-1];
            }
            int l = crypt[j-2]*10+crypt[j-1];
            if(l>=10 && l<=26){
                dp[j] = (dp[j-2] + dp[j])%MOD;
            }
        }
        System.out.println(dp[n]);

    }
}
