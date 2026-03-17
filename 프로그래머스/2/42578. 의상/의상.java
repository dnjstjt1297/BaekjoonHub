import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String,Integer> map = new HashMap<>();
        
        for(String[] c : clothes){
            if(map.containsKey(c[1])){
                map.put(c[1],map.get(c[1])+1);
            }
            else{
                map.put(c[1],1);
            }
        }
        
        for(String s : map.keySet()){
            answer*=(map.get(s)+1);
        }
        
        
        return answer-1;
    }
}