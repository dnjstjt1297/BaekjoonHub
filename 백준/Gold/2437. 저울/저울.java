import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		if(arr[0] !=1) {
			System.out.println(1);
			return;
		}
		int n=1;
		int idx =0;
		while(true) {
			for(int i=idx; i<N; i++) {
				if(arr[i]>n) break;
				else if(arr[i]<n) idx=i;
				else if(arr[i]==n) {
					n++;
					i--;
				}
			}
			int temp = n;
			for(int i = idx; i>=0; i--) {
				temp = temp - arr[i];
			}
			if(temp>0) break;
			n++;
		}
		
		System.out.println(n);
	}
}