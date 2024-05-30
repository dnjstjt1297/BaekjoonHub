import java.util.*;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		for(int i=0;i<n;i++) {
			numbers[i] = sc.nextInt();
		}
		
		String answer = "";
        Integer[] arr = new Integer[numbers.length];
        for(int i =0;i<numbers.length;i++) arr[i] = numbers[i];
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                String a = Integer.toString(o1);
                String b = Integer.toString(o2);
                BigInteger n1 = new BigInteger(a+b);
                BigInteger n2 = new BigInteger(b+a);
                int compare = n2.compareTo(n1);
                return compare;
            }
        });
        
        boolean is_all_zero = true;
        for(int e: arr){
            if(e!=0) is_all_zero = false;
            answer += Integer.toString(e);
        }
        if(is_all_zero) answer = "0";
        
        System.out.println(answer);
	}

}