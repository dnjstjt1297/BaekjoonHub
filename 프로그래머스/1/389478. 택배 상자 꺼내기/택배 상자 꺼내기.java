class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int h = 0;
        for(int i = 1; i<=w; i++){
            int a = w*2-2*i+1;
            int b = 2*i-1;

            int k = i;
            int p = 0;
            int target = -1;

            while(k<=n){
                if(k==num){
                    target = p;
                }
                if(p%2==0) k+=a;
                else k+=b;
            
                p++;
            }
            if(target!=-1){
                return p-target;
            }
        }
        return answer;
    }
}