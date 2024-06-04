class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        long[] arr = new long[1001];
        for(int e : weights){
            arr[e]++;    
        }
        for(int i=100;i<1001;i++){
            answer+=(arr[i]*(arr[i]-1))/2;
            
            if((3*i)%2==0 && 3*i/2<1001){
                answer +=arr[i]*arr[3*i/2];
            }
            if((4*i)%2==0 && 4*i/2<1001){
                answer +=arr[i]*arr[4*i/2];
            }
            if((4*i)%3==0 && 4*i/3<1001){
                answer +=arr[i]*arr[4*i/3];    
            }
            
        }
        
        return answer;
    }
}