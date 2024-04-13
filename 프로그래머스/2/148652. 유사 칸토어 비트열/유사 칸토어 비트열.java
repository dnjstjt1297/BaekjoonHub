class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;
        
        for(long i=l;i<=r;i++){
            long tmp =(long) Math.pow(5,n);
            long m = i;
            while(true)
                if(m>2*tmp/5 && m<=3*tmp/5){
                    break;
                }
                else{
                    if(tmp <=5){
                        answer++; 
                        break;
                    }
                    tmp = tmp/5;
                    while(m>tmp){
                        m-=tmp;
                    }
                }
        }
        
        
        return answer;
    }
}