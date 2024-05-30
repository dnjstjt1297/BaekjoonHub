import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        Integer[] arr = new Integer[numbers.length];
        for(int i =0;i<numbers.length;i++) arr[i] = numbers[i];
        
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                String a = Integer.toString(o1);
                String b = Integer.toString(o2);
                int n1 = Integer.parseInt(a+b);
                int n2 = Integer.parseInt(b+a);
                return n2-n1;
            }
        });
        
        boolean is_all_zero = true;
        for(int e: arr){
            if(e!=0) is_all_zero = false;
            answer += Integer.toString(e);
        }
        if(is_all_zero) answer = "0";
        
        return answer;
    }
}