import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int len = (int)Math.pow(2, N);
        int[][] arr = new int[len][len];
        for(int i=0;i<len;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<len;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<R;i++) {
        	st = new StringTokenizer(br.readLine());
        	int k = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(st.nextToken());
        	changeArr(arr, k,l);
        }
        printArr(arr);
    
	}
	public static void changeArr(int[][] arr, int k, int l) {
		int[][] copyArr = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
		
		int subLen = (int) Math.pow(2, l);
		int len = arr.length/subLen;
		
		for(int i=0; i<len;i++) {
			for(int j=0;j<len;j++) {
				int c = subLen*i;
				int r = subLen*j;
				for(int p=0;p<subLen;p++) {
					for(int q=0;q<subLen;q++) {
						int cc = c+p;
						int cr = r+q;
						
						int nc = -1;
						int nr = -1;
						if(k==1) {
							nc = c+subLen-1-p;
							nr = r+q;
						}
						else if(k==2) {
							nc = c+p;
							nr = r+subLen-1-q;
						}
						else if(k==3){
							nc = c+subLen-1-q;
							nr = r+p;
						}	
						else if(k==4) {
							nc = c+q;
							nr = r+subLen-1-p;
						}
						else if(k==5) {
							nc = subLen*(len-1)-c+p;
							nr = r+q;
						}
						else if(k==6) {
							nc = c+p;
							nr = subLen*(len-1)-r+q;
						}
						else if(k==7) {
							nc = subLen*(len-1)-r+p;
							nr = c+q;
						}
						else if(k==8) {
							nc = r+p;
							nr = subLen*(len-1)-c+q;
						}
						
						if(nc!=-1&&nr!=-1)
							arr[cc][cr] = copyArr[nc][nr]; 
						
					}
					
				}
				
			}
			
		}
		
	}
	public static void printArr(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
