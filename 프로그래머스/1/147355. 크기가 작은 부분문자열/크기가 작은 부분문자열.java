class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long b = Long.parseLong(p);
        int i = 0;
        while(true){
            if(i+p.length() > t.length()) break;
            long a = Long.parseLong(t.substring(i,i+p.length()));
            if(a<=b) answer++;
            i++;
        }
        
        return answer;
    }
}