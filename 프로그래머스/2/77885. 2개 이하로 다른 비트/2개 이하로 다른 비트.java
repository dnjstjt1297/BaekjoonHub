class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i]%2==0) answer[i] = numbers[i]+1;
            else{
                long a = numbers[i];
                int n = 0;
                while(a>0){
                    if(a%2==0){
                        break;     
                    }
                    a/=2;
                    n++;
                }
                answer[i] = numbers[i]+(long)Math.pow(2,n-1);
            }
        }
        return answer;
    }
}