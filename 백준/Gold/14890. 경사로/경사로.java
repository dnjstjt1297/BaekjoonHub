import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[][] loads = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				loads[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findLoad(loads,N,L);
	}
	
	public static void findLoad(int[][] loads, int N, int L) {
		
		int result =0;
		
		for(int i=0;i<N;i++) {
			int curHight = loads[i][0];
			
			int upCnt = 1;
			int downCnt = L;
			boolean is_road = true;
			for(int j=1;j<N;j++) {
				int nextHight = loads[i][j];
				if(curHight==nextHight) {
					if(downCnt>=L) upCnt++;
					downCnt++;
				}
				else if(curHight==nextHight+1) {
					if(downCnt<L) {
						is_road = false;
						break;
					}
					upCnt = 0;
					downCnt = 1;
				}
				else if(curHight==nextHight-1) {
					if(upCnt<L) {
						is_road = false;
						break;
					}
					upCnt = 1;
					downCnt = L;
				}
				else {
					is_road = false;
					break;
				}
				curHight = nextHight;
			}
			if(downCnt<L) {
				is_road = false;
			}
			if(is_road) 
				result++;
			
			
			curHight = loads[0][i];
			upCnt = 1;
			downCnt = L;
			is_road = true;
			for(int j=1;j<N;j++) {
				int nextHight = loads[j][i];
				if(curHight==nextHight) {
					if(downCnt>=L) upCnt++;
					downCnt++;
				}
				else if(curHight==nextHight+1) {
					if(downCnt<L) {
						is_road = false;
						break;
					}
					upCnt = 0;
					downCnt = 1;
				}
				else if(curHight==nextHight-1) {
					if(upCnt<L) {
						is_road = false;
						break;
					}
					upCnt = 1;
					downCnt = L;
				}
				else {
					is_road = false;
					break;
				}
				curHight = nextHight;
			}
			if(downCnt<L) {
				is_road = false;
			}
			if(is_road) 
				result++;
			
			
			
		}
		
		System.out.println(result);
	}
	
}