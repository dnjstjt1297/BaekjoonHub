import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer;
    
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(long i = left; i<=right; i++){
            long a = i%n;
            long b = i/n;
            if(a<=b){
                arr.add((int)b+1);
            }
            else{
                arr.add((int)a+1);
            }
        }
        
        answer = new int[arr.size()];
        for(int i = 0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }
        
        return answer;
    }
}