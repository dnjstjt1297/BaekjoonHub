import java.util.*;
import java.io.*;


public class Main {

	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1,o2)->{
			if(o1[1] == o2[1]) return o1[0] - o1[1];
			return o1[1]-o2[1];
			
		});
		
		int ans = 0;
		int start = 0;
		for(int[] e :arr) {
			if(e[0] >= start) {
				ans++;
				start = e[1];
			}
		}
		System.out.println(ans);
	}

}
