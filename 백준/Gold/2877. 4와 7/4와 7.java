import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        long K = Integer.parseInt(br.readLine());
        findNum(K);
	}
	public static void findNum(long K) {
		long digit=1;
		String result = "";
		while(K>0) {
			K-=(long)Math.pow(2,digit);
			digit++;
		}
		digit--;
		K = Math.abs(K);
		
		int idx = 0;
		while(idx<digit) {
			if(K%2==0)
				result='7'+result;
			else
				result='4'+result;
			K/=2;
			idx++;
		}
		System.out.println(result);
	}
}