import java.util.*;
import java.io.*;

class Stack{
	int top;
	int size;
	char[] stack;
	
	public Stack(int size) {
		this.top = -1;
		this.size = size;
		this.stack = new char[size];
	}
	
	public char pop() {
		char result;
		
		if(top>=0) {
			result = stack[top]; 
			top--;
		}
		else result = 'N';
		
		return result;
	}
	
	public boolean push(char e) {
		if(top<size-1) {
			top++;
			stack[top] = e;
			return true;
		}
		else return false;
	}
	
	public boolean isEmpty() {
		if(top==-1) return true;
		else return false;
	}
	
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		Stack s;
		for(int i=0;i<T;i++) {
			String input = br.readLine();
			
			String output = "YES";
			s = new Stack(50);
			
			for(int j=0; j<input.length(); j++) {
				char entry = input.charAt(j);
				
				if(entry=='(') {
					if(!s.push(entry)) {
						output = "NO";
						break;
					}
				}
				else if(entry==')'){
					char pop = s.pop();
					if(pop == 'N') {
						output = "NO";
						break;
					}
				}
			}
			
			if(!s.isEmpty()) output = "NO";
			
			System.out.println(output);
			
		}
		
	}
}