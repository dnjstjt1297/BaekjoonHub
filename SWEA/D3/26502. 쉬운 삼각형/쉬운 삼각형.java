import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while(tc-- > 0) {

            int n = Integer.parseInt(br.readLine());

            int[][] p = new int[n][2];

            for(int i=0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                p[i][0] = Integer.parseInt(st.nextToken());
                p[i][1] = Integer.parseInt(st.nextToken());
            }

            long max = 0;

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {

                    // 세로 변
                    if(i == j) continue;

                    if(p[i][0] == p[j][0]) {

                        for(int k=0;k<n;k++) {

                            if(i == k || j == k) continue;

                            // 가로 변
                            if(p[i][1] == p[k][1]) {

                                long height =
                                        Math.abs((long)p[i][1] - p[j][1]);

                                long width =
                                        Math.abs((long)p[i][0] - p[k][0]);

                                max = Math.max(max, width * height);
                            }
                        }
                    }
                }
            }

            System.out.println(max);
        }
    }
}