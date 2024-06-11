import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		long sum = 0;
		boolean is_true = true;
		for(int i=0; i<N;i++){
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			long num = Long.parseLong(st.nextToken());
			if(str.equals("in")){
				sum+=num;
			}
			else if(str.equals("out")){
				sum-=num;
				if(sum<0){
					is_true = false;
				}
			}
		}
		if(is_true){
			System.out.println("success");
		}
		else{
			System.out.println("fail");
		}
	}
}