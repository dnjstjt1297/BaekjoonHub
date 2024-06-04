import java.util.*;
class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = -1;
        
        if(k>=enemy.length){
            answer = enemy.length;
            return answer;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++) pq.add(enemy[i]);
        
        for(int i=k;i<enemy.length;i++){
            int next = pq.poll();
            if(next<enemy[i]){
                pq.add(enemy[i]);
                n-=next;
            }
            else{
                pq.add(next);
                n-=enemy[i];
            }
            if(n<0){
                answer = i;
                break;
            }
        }

        if(answer == -1) answer = enemy.length;
    
        return answer;
    }
}