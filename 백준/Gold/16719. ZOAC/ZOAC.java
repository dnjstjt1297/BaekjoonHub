import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String input = br.readLine();
        addValue(input);
	}
	public static void addValue(String str) {
		char[] values = new char[str.length()];
		Arrays.fill(values,'*');
		
		int idx = 0;
		while(idx<str.length()) {
			PriorityQueue<char[]> pq = new PriorityQueue<>(new Comparator<char[]>() {
				@Override
				public int compare(char[] o1, char[] o2) {
					String a = "";
					String b = "";
					for(int i=0;i<o1.length;i++) {
						if(o1[i]!='*') {
							a+=o1[i];
						}
					}
					for(int i=0;i<o2.length;i++) {
						if(o2[i]!='*') {
							b+=o2[i];
						}
					}
					return a.compareTo(b);
				}
			});
			
			for(int i=0;i<str.length();i++) {
				if(values[i]=='*') {
					char[] copyValues = values.clone();
					copyValues[i] = str.charAt(i);
					pq.add(copyValues);
					
				}
			}
			
			if(!pq.isEmpty())
				values = pq.poll();
			printValues(values);
			idx++;
		}
		
	}
	public static void printValues(char[] values) {
		for(int i=0;i<values.length;i++) {
			if(values[i]!='*') {
				System.out.print(values[i]);
			}
		}
		System.out.println();
	}
}
