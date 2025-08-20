import java.util.*;

class Solution {
    int answer = 1;
    
    public int solution(int coin, int[] cards) {
        int N = cards.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        boolean[] gets = new boolean[N+1];
        boolean[] gets2 = new boolean[N+1];
        for(int i = 0; i<N/3; i++){
            gets[cards[i]] = true;
            
            if(gets[N+1-cards[i]]){
                pq.add(0);
            }
        }
        
        for(int i =N/3 ; i<N; i++){
            
            gets2[cards[i]] = true;
            if(gets[N+1-cards[i]]){
                pq.add(1);
            }
            else{
                if(gets2[N+1-cards[i]]) pq.add(2);
            }
            
            if(i%2==1){
                if(!pq.isEmpty()){
                    int cur = pq.poll();
                    if(coin>=cur){
                        coin-=cur;
                        answer++;
                    }
                    else{
                        break;
                    }
                }
                else break;
            }
        }
        
        
        return answer;
    }
}