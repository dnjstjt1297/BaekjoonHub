import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int[][] gears = new int[4][8]; 
		for(int i=0;i<4;i++) {
        	String input = br.readLine();
        	for(int j=0;j<8;j++) {
        		gears[i][j] = input.charAt(j)-'0';
        	}
        }
		int K = Integer.parseInt(br.readLine());
		
		int[][] seq = new int[K][2];
		
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			gears = getRotateGears(gears,n,d);
		}
		
		printGearScores(gears);
	}
	public static int[][] getRotateGears(int[][] gears, int n, int d) {
		int[][] newGears = new int[4][8];
		newGears[n-1] = rotateGear(gears[n-1],d);
		
		boolean is_nextL = true;
		boolean is_nextR = true;
		int idx = 0;
		int left = n-1;
		int right = n-1;
		while(left>=0||right<4) {
			d=-d;
			idx++;
			left = n-1-idx;
			right = n-1+idx;
			
			if(left>=0) {
				if(gears[left][2]!=gears[left+1][6] && is_nextL) {
					newGears[left] = rotateGear(gears[left],d);
				}
				else {
					is_nextL = false;
					newGears[left] = gears[left].clone();
				}
			}
			if(right<4) {
				if(gears[right][6]!=gears[right-1][2] && is_nextR) {
					newGears[right] = rotateGear(gears[right],d);
				}
				else {
					is_nextR = false;
					newGears[right] = gears[right].clone();
				}
			}
		}
		
		return newGears;
	}
	
	public static int[] rotateGear(int[] gear, int d){
		int[] newGear = new int[8];
		
		if(d==1) {
			for(int i=1;i<8;i++) {
				newGear[i] = gear[i-1];
			}
			newGear[0] = gear[7];
		}
		else if(d==-1) {
			for(int i=6;i>=0;i--) {
				newGear[i] = gear[i+1];
			}
			newGear[7] = gear[0];
		}
		return newGear;
	}
	
	public static void printGearScores(int[][] gears) {
		int sum =0;
		for(int i=0;i<4;i++) {
			if(gears[i][0] == 1) {
				sum+=Math.pow(2, i);
			}
		}
		
		System.out.println(sum);
	}
}