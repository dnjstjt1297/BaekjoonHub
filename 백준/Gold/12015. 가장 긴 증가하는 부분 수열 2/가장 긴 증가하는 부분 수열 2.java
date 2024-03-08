import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] A;
	static ArrayList<Integer> ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		ans = new ArrayList<Integer>();
		ans.add(A[0]);
		lis();
		System.out.println(ans.size());
	}
	
	public static void lis() {
		int start, end, mid;
		for(int i =1; i<N;i++) {
			if (A[i]>ans.get(ans.size()-1)) {
				ans.add(A[i]);
				continue;
			}
			start = 0;
			end = ans.size()-1;
			mid = (start+end)/2;
			while(start<end) {
				mid = (start+end)/2;
				if(A[i] <= ans.get(mid)) end = mid;
				else start = mid+1;
			}
			ans.set(end,A[i]);
		}
	}
}