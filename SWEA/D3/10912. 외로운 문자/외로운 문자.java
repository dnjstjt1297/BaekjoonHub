import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String S = sc.next();
			boolean[] visited = new boolean[S.length()];
			
			ArrayList<Character> result = new ArrayList<>();
			for(int i =0; i<S.length();i++) {
				if(visited[i]) continue;
				visited[i] = true;
				boolean is_pair = false;
				for(int j=i;j<S.length();j++) {
					if(visited[j]) continue;
					if(S.charAt(i)==S.charAt(j)) {
						visited[j] = true;
						is_pair = true;
                        break;
					}
				}
				if(!is_pair) result.add(S.charAt(i));
			}
			Collections.sort(result);
			
			String answer ="";
			for(char e: result) {
				answer+=e;
			}
			if(answer.equals("")) {
				answer+="Good";
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}
