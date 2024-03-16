import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class Main {
	
	static ArrayList<Integer> inOrder;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		inOrder = new ArrayList<>();
		String input;
		while((input = br.readLine()) != null) {
			inOrder.add(Integer.parseInt(input));
		}
		dfs(0,inOrder.size());
		
	}
	public static void dfs(int start, int end) {
		if(start>=end) {
			return;
		}
		
		int mid = -1;
		for(int i = start;i<end;i++) {
			if(inOrder.get(i)>inOrder.get(start)) {
				mid = i;
				break;
			}
		}
		
		if(mid != -1) {
			dfs(start+1,mid);
			dfs(mid,end);
		}
		else {
			dfs(start+1,end);
		}
		System.out.println(inOrder.get(start));
	}
}
