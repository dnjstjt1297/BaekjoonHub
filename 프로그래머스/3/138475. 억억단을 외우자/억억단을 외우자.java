class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] ukukdan = new int[e+1];    
        
        ukukdan[1] = 1;
        for(int i=2;i<=e;i++){
            ukukdan[i]+=2;
            int tmp = 2;
            for(int j=tmp*i;j<=e;j=i*tmp){
                if(j==i*i)
                    ukukdan[j]+=1;
                else
                    ukukdan[j]+=2;
                tmp++;
            }
        }
        
        int[] results = new int[e+1];
        for(int i=0;i<starts.length;i++){
            if(results[starts[i]]!=0){
                answer[i] = results[starts[i]];
                continue;
            }
            int max = 0;
            int maxIdx = 0;
            for(int j=starts[i];j<=e;j++){
                if(ukukdan[j]>max){
                    max = ukukdan[j];
                    maxIdx = j;
                }
            }
            for(int j=starts[i];j<=maxIdx;j++){
                results[j] = maxIdx;
            }
            answer[i] = maxIdx;
        }
        
        return answer;
    }
}