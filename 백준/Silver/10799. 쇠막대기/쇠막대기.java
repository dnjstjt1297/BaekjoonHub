import java.util.*;
import java.io.*;


class Stack{
	int size;
	int[] stack;
	int top = -1;
	
	public Stack(int size) {
		this.size = size;
		this.stack = new int[size];
	}
	
	
	public void push(int entry) {
		top++;
		if(top<size-1) stack[top] = entry;
	}
	
	public int pop() {
		return stack[top--];
	}
	
	public boolean isEmpty() {
		if(top==-1) return true;
		else return false;
	}
	
}

public class Main{
	static int MAX_STACK_SIZE = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String input = br.readLine();
		int answer = calculate(input);
		
		System.out.println(answer);
	}
	
	public static int calculate(String input) {
		int result = 0;
		
		Stack stack = new Stack(MAX_STACK_SIZE);
		int start,end;
		int cnt = 0;
		
		for(int i=0;i<input.length();i++) {
			char entry = input.charAt(i);
			if(entry == '(') {
				if(stack.top==stack.size-1) {
					System.out.println("stack overflow");
					break;
				}
				
				stack.push(i);
				cnt++;
			}
			else if(entry == ')') {
				if(stack.isEmpty()) {
					System.out.println("stack underflow");
					break;
				}
				
				start = stack.pop();
				end = i;
				if(start+1==end) {
					cnt--;
					result+=cnt;
				}
				else {
					result++;
					cnt--;
				}
			}
		}
		
		
		return result;
	}
}


