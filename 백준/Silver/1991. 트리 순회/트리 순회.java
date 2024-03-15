import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class Main {
	static int N;
	static char[][] tree;
	static Stack<Character> stack;
	static ArrayList<Character> resPre;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new char['Z'+1][2];
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int P = st.nextToken().charAt(0);
			tree[P][0] = st.nextToken().charAt(0);
			tree[P][1] = st.nextToken().charAt(0);
		}
		
		stack = new Stack<>();
		stack.add('A');
		preOrder();
		for(char e: resPre) {
			System.out.print(e);
		}
		System.out.println();
		
		inOrder('A');
		System.out.println();
		
		postOrder('A');
		System.out.println();
		
	}
	
	public static void preOrder() {
		resPre = new ArrayList<>();
		while(!stack.empty()) {
			char node = stack.pop();
			resPre.add(node);
			int nextIdx = node;
			for(int i =1; i>=0; i--) {
				if(tree[nextIdx][i] == '.') continue;
				stack.add(tree[nextIdx][i]);
			}
		}
	}
	public static void inOrder(char start) {
		if(tree[start][0] != '.')
			inOrder(tree[start][0]);
		System.out.print(start);
		if(tree[start][1] != '.') 
			inOrder(tree[start][1]);
	}
	public static void postOrder(char start) {
		if(tree[start][0] != '.')
			postOrder(tree[start][0]);
		if(tree[start][1] != '.')
			postOrder(tree[start][1]);
		System.out.print(start);
	}
}