import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][3];
		for(int i=1; i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dpMax = new int[N+1][3];
		int[][] dpMin = new int[N+1][3];
		
		dpMax[1][0] = arr[1][0];
		dpMax[1][1] = arr[1][1];
		dpMax[1][2] = arr[1][2];

		dpMin[1][0] = arr[1][0];
		dpMin[1][1] = arr[1][1];
		dpMin[1][2] = arr[1][2];
		
		for(int i=2;i<=N;i++) {
			dpMax[i][0] = arr[i][0]+Math.max(dpMax[i-1][0], dpMax[i-1][1]);
			dpMax[i][1] = arr[i][1]+Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]),dpMax[i-1][2]);
			dpMax[i][2] = arr[i][2]+Math.max(dpMax[i-1][1], dpMax[i-1][2]);

			dpMin[i][0] = arr[i][0]+Math.min(dpMin[i-1][0], dpMin[i-1][1]);
			dpMin[i][1] = arr[i][1]+Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]),dpMin[i-1][2]);
			dpMin[i][2] = arr[i][2]+Math.min(dpMin[i-1][1], dpMin[i-1][2]);
		}
		int max =0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<3;i++) {
			max = Math.max(dpMax[N][i], max);
			min = Math.min(dpMin[N][i], min);
		}
		System.out.println(max+" "+min);
	}
}