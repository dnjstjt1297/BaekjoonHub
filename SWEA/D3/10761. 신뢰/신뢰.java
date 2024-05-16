
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileInputStream;

class Location {
	char type;
	int idx;
	public Location(char type, int idx) {
		this.type = type;
		this.idx = idx;
	}
	
}

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			ArrayList<Integer> Os = new ArrayList<>();
			ArrayList<Integer> Bs = new ArrayList<>();
			
			char[] sequence = new char[N];
			
			for(int i=0;i<N;i++) {
				char type = sc.next().charAt(0);
				int idx = sc.nextInt();
				sequence[i] = type;
				if(type == 'O') Os.add(idx);
				else if (type == 'B') Bs.add(idx);
			}
			int answer = 0;
			
			int k = 0;
			int cO = 1;
			int cB = 1;
			int Bidx = 0;
			int Oidx = 0;
			
			
			for(int i=0;i<N;i++) {
				char type = sequence[i];
				int time = 0;
				for(int j=i;j<N;j++) {
					if(type == sequence[j]) {
						if(type == 'B') {
							answer+=Math.abs(Bs.get(Bidx)-cB);
							answer+=1;
							time+=Math.abs(Bs.get(Bidx)-cB);
							time+=1;
							cB = Bs.get(Bidx);
							Bidx++;
						}
						else if(type == 'O') {
							answer+=Math.abs(Os.get(Oidx)-cO);
							answer+=1;
							time+=Math.abs(Os.get(Oidx)-cO);
							time+=1;
							cO = Os.get(Oidx);
							Oidx++;
						}
						if(j==N-1) {
							i = j;
						}
					}
					else {
						if(sequence[j]=='B') {
							if(Math.abs(Bs.get(Bidx)-cB)<=time) {
								cB = Bs.get(Bidx);
							}
							else {
								if(Bs.get(Bidx)<cB)
									cB = cB-time;
								else
									cB = cB+time;
							}
						}
						else if(sequence[j]=='O') {
							if(Math.abs(Os.get(Oidx)-cO)<=time) {
								cO = Os.get(Oidx);
							}
							else {
								if(Os.get(Oidx)<cO)
									cO = cO-time;
								else
									cO = cO+time;
							}
						}
						i = j-1;
						break;
					}
					
				}
			}

			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
