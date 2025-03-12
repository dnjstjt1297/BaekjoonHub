import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);
        z(0, 0, size, r, c);
        System.out.println(answer);
    }

    public static void z(int x, int y, int size, int r, int c) {
        if (size == 1) {
            return;
        }

        int half = size / 2;
        int blockSize = half * half;

        if (r < x + half && c < y + half) {
            // 1사분면
            z(x, y, half, r, c);
        } else if (r < x + half && c >= y + half) {
            // 2사분면
            answer += blockSize;
            z(x, y + half, half, r, c);
        } else if (r >= x + half && c < y + half) {
            // 3사분면
            answer += blockSize * 2;
            z(x + half, y, half, r, c);
        } else {
            // 4사분면
            answer += blockSize * 3;
            z(x + half, y + half, half, r, c);
        }
    }
}