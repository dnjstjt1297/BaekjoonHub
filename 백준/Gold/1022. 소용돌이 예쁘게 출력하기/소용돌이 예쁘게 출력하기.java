import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        
        
        printValue(r1,c1,r2,c2); 
        
        
	}
	public static int findValue(int col, int row) {
		int max = Math.max(Math.abs(col), Math.abs(row));
		int result = (int)Math.pow(max*2+1, 2);
		
		if(col == max) {
			result -= max - row;
			return result;
		}
		result -= max*2;
		if(row == -max) {
			result -= max - col;
			return result;
		}
		result -= max*2;
		if(col == -max) {
			result -= row + max;
			return result;
		}
		result -= max*2;
		if(row == max) {
			result -= col +max;
			return result;
		}
		
		return result;
	}
	public static void printValue(int r1, int c1, int r2, int c2){
		
		int maxLen = 0;
		int[][] result = new int[r2-r1+1][c2-c1+1];
		int cIdx = 0;
		int rIdx = 0;
		for(int i=r1;i<=r2;i++) {
			for(int j=c1;j<=c2;j++) {
				int value = findValue(i,j);
				result[cIdx][rIdx] = value;
				int len = Integer.toString(value).length();
				maxLen = Math.max(maxLen, len);
				rIdx++;
			}
			cIdx++;
			rIdx=0;
		}
		
		for(int i=0;i<=r2-r1;i++) {
			for(int j=0;j<=c2-c1;j++) {
				int len = Integer.toString(result[i][j]).length();
				for(int k=0; k<maxLen-len;k++) {
					System.out.print(" ");
				}
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

}
