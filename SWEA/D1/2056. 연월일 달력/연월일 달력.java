import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			
			String answer="";
			
			String str = sc.next();
			
			boolean is_valid = true;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)<'0' || str.charAt(i)>'9') {
					is_valid = false;
					break;
				}
			}
			
			
			String year = str.substring(0,4);
			answer+=year;
			answer+="/";
			
			String month = str.substring(4,6);
			answer+=month;
			answer+="/";
			if(month.charAt(0)=='1') {
				if(month.charAt(1)>'2') {
					is_valid = false;
				}
			}
			else if(month.charAt(0)=='0') {
				if(month.charAt(1)=='0') {
					is_valid = false;
				}
			}
			else {
				is_valid = false;
			}
			
			
			String day = str.substring(6,8);
			answer+=day;
			if(month.equals("02")) {
				if(day.charAt(0)=='2') {
					if(day.charAt(1)>'8') {
						is_valid = false;
					}
				}
				else if(day.charAt(0)>'2') {
					is_valid = false;
				}
				else if(day.charAt(0)=='0') {
					if(day.charAt(1)=='0')
						is_valid = false;
				}
			}
			else if(month.equals("04")||month.equals("06")||month.equals("09")||month.equals("11")) {
				if(day.charAt(0)=='3') {
					if(day.charAt(1)>'0') {
						is_valid = false;
					}
				}
				else if(day.charAt(0)>'3') {
					is_valid = false;
				}
				else if(day.charAt(0)=='0') {
					if(day.charAt(1)=='0')
						is_valid = false;
				}
			}
			else {
				if(day.charAt(0)=='3') {
					if(day.charAt(1)>'1') {
						is_valid = false;
					}
				}
				else if(day.charAt(0)>'3') {
					is_valid = false;
				}
				else if(day.charAt(0)=='0') {
					if(day.charAt(1)=='0')
						is_valid = false;
				}
			}
			
			if(!is_valid) System.out.println("#"+test_case+" "+-1);
			else System.out.println("#"+test_case+" "+answer);
			
		}
	}
}

