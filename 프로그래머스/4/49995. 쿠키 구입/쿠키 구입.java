class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        
        int sum = 0;
        for(int i=0;i<cookie.length;i++) sum+=cookie[i];
        for(int i=0;i<cookie.length;i++){
            int left = 0;
            int right = cookie.length-1;
            int lSum = 0;
            for(int j=0;j<=i;j++){
                lSum+=cookie[j];
            }
            int rSum = sum-lSum;
            while(true){
                if(left>i||right<=i) break;
                if(lSum==rSum){
                    answer = Math.max(answer,lSum);
                    break;
                }
                else if(lSum<rSum){
                    rSum-=cookie[right];
                    right--;
                }
                else{
                    lSum -= cookie[left];
                    left++;
                }
            }
        }
        
        return answer;
    }
}