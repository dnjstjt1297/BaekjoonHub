import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        map.put("red",0);
        map.put("orange",1);
        map.put("yellow",2);
        map.put("green",3);
        map.put("blue",4);
        map.put("purple",5);
        
        for (int tc = 1; tc <= T; tc++) {    
        	int s = map.get(sc.next()), t = map.get(sc.next());
        	char result;
        	if(s-t == 0) result = 'E';
        	else if(Math.floorMod(s+3,6)==t || Math.floorMod(s-3,6)==t) result = 'C';
        	else if(Math.floorMod(s+1,6)==t || Math.floorMod(s-1,6)==t) result = 'A';
        	else result = 'X';
        	System.out.println(result);
        }
    }
}