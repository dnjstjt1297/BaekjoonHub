import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    static long MOD = 1000000007;
    static long[][] mat;
    static HashMap<Long, long[][]> map;
    static {
        mat = new long[][]{
                {0,1},
                {1,1}
        };
        map = new HashMap<>();
        map.put(1L,mat);
        map.put(2L,mulMat(mat,mat));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] answer = powMat(n);
        System.out.println(answer[0][1]);
    }

    public static long[][] mulMat(long[][] mat1, long[][] mat2) {
        long[][] result = new long[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                for(int k = 0; k < mat1[0].length; k++){
                    result[i][j] = (result[i][j] + (mat1[i][k] * mat2[k][j])%MOD) % MOD;
                }
            }
        }
        return result;
    }

    public static long[][] powMat(long n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        long[][] result;
        if(n%2==0){
            result = mulMat(powMat(n/2), powMat(n/2));
        }
        else result = mulMat(mulMat(powMat(n/2), powMat(n/2)),mat);
        map.put(n, result);
        return result;
    }
}