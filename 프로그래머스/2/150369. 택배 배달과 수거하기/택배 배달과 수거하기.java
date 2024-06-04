class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int last = n-1;
        while(true){
            
            //마지막 배달할 인덱스 찾기
            boolean is_fin = true;
            for(int i=last; i>=0; i--){
                if(deliveries[i] !=0 || pickups[i] !=0) {
                    last = i;
                    is_fin = false;
                    break;
                }
            }
            if(is_fin) break;
            
            
            //배달
            int tmp = cap;
            for(int i = last;i>=0;i--){
                deliveries[i]-=tmp;
                if(deliveries[i]<0){
                    tmp = -deliveries[i];
                    deliveries[i] = 0;
                }
                else{
                    break;
                }
            }
            answer+=last+1;
            
            //수거
            tmp = cap;
            for(int i = last;i>=0;i--){
                pickups[i]-=tmp;
                if(pickups[i]<0){
                    tmp = -pickups[i];
                    pickups[i] = 0;
                }
                else{
                    break;
                }
            }
            answer+=last+1;
        }
        
        return answer;
    }
}