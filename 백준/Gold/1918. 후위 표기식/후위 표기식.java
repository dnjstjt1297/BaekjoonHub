import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static String str;
	static char[] stack;
	static ArrayList<Character> ans;
	static int[] operand_prio;
	static int top = -1;
	static int prio = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		stack = new char[100];
		operand_prio = new int[101];
		ans = new ArrayList<Character>();
		calculate();
		for(char e: ans)
			System.out.print(e);
	}
	
	public static void calculate() {
		for(int i=0; i<str.length();i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') ans.add(str.charAt(i));
			else if(str.charAt(i)=='(') prio++;
			else if(str.charAt(i)==')') prio--;
			else {
				if(top == -1) {
					top++;
					operand_prio[top]=prio;
					stack[top]=str.charAt(i);
					continue;
				}
				while(top>-1){
					if(operand_prio[top] < prio) break;
					else if(operand_prio[top] > prio) {
						ans.add(stack[top]);
						top--;
					}
					else {
						if(str.charAt(i) == '*' || str.charAt(i) == '/') {
							if(stack[top] == '+' || stack[top] =='-') {
								break;
							}
						}
						ans.add(stack[top]);
						top--;
					}
				}
				top++;
				operand_prio[top]=prio;
				stack[top]=str.charAt(i);
			}
		}
		for(int i= top;i>=0;i--) {
			ans.add(stack[i]);
		}
	}
}