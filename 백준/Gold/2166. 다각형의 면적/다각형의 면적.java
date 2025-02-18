import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[][] points = new long[N+1][2];
        for(int i = 0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }
        points[N] = points[0].clone();

        double result = getPolygonArea(points,N);
        System.out.printf("%.1f",result);
    }

    public static double getPolygonArea(long[][] points, int N) {
        double area = 0;

        for(int i = 0; i<N; ++i){
            area += points[i][0]*points[i+1][1]-points[i][1]*points[i+1][0];
        }
        area = Math.abs(area);
        return area/2;
    }
}