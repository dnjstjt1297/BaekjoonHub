import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;


public class Main {
	static int T;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		int[] res = new int[T];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			double k = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
			if(k==0) {
				if(r1==r2) res[i] = -1;
				else res[i] = 0;
			}
			else {
				if(k>Math.abs(r1-r2)) {
					if(k==r1+r2) res[i] = 1;
					else if(k>r1+r2) res[i] = 0;
					else res[i]= 2;
				}
				if(k==Math.abs(r1-r2)) res[i] = 1;
				else if(k<Math.abs(r1-r2)) res[i] =0;
			}
		}
		for(int e: res) {
			System.out.println(e);
		}
	}
}
