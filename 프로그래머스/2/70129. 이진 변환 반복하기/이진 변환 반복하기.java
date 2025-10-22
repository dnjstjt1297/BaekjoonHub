class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")){
            int cnt = 0;
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i)=='0'){
                    cnt++;
                }
            }
            s = Integer.toBinaryString(s.length()-cnt);
            answer[1]+=cnt;
            answer[0]++;
        }
        
        return answer;
    }
}