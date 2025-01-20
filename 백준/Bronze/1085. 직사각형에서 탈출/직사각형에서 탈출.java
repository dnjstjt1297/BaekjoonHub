import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int answer = x;
        answer = Math.min(answer, y);
        answer = Math.min(answer, Math.abs(w-x));
        answer = Math.min(answer, Math.abs(h-y));
        System.out.println(answer);
    }

}
