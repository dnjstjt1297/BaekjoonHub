import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		
		boolean tag = false;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<input.length();i++) {
			char c = input.charAt(i);
			
			if(c=='<') {
				System.out.print(sb.reverse());
				tag = true;
				sb = new StringBuilder();
				sb.append(c);
			}
			else if(c=='>') {
				sb.append(c);
				System.out.print(sb);
				tag = false;
				sb= new StringBuilder();
			}
			else if(c==' ') {
				if(tag==false)
					System.out.print(sb.reverse()+" ");
				else 
					System.out.print(sb+" ");
				sb= new StringBuilder();
			}
			else {
				sb.append(c);
			}
				
		}
		System.out.println(sb.reverse());
		
	}
	
}