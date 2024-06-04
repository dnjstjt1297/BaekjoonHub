class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0){
            if(storey%10>5){
                answer+=10-storey%10;
                storey = storey/10+1;   
            } 
            else if(storey%10<5){
                answer+=storey%10;
                storey = storey/10;
            }
            else{
                if((storey/10)%10+1>5){
                    answer+=5;
                    storey = storey/10+1;
                }
                else{
                    answer+=5;
                    storey = storey/10;
                }
            }
        }
        return answer;
    }
}