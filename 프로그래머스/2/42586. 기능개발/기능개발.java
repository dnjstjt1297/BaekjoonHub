import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        
        List<Integer> result = new ArrayList<>();
        
        int top = 0;
        
        for(int i =0; i<100; i++){
            if(top==progresses.length) break;
            int num = 0;
            while(true){
                if(top==progresses.length) break;
                if(progresses[top]+speeds[top]*i<100) break;
                num++;
                top++;
            }
            if(num!=0){
                result.add(num);
            }
        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}