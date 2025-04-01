import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final long MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        long[][] result = pow(n - 1);
        System.out.println(result[1][1]);
    }

    public static long[][] pow(long n) {
        long[][] result = {{1, 0}, {0, 1}}; // 단위 행렬
        long[][] base = {{0, 1}, {1, 1}};   // 피보나치용 초기 행렬

        while (n > 0) {
            if (n % 2 == 1) result = matMul(result, base);
            base = matMul(base, base);
            n /= 2;
        }

        return result;
    }

    public static long[][] matMul(long[][] a, long[][] b) {
        long[][] result = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return result;
    }
}
