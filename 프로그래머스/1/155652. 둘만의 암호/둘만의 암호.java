class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        boolean[] skips = new boolean['z'+10];
        for(int i = 0; i<skip.length(); i++){
            char c = skip.charAt(i);
            skips[c] = true;
        }
        
        for(int i = 0; i<s.length(); i++){
            
            int k = 0;
            int idx = 0;
            char c = s.charAt(i);
            while(k<index){
                idx++;
                c = (char)((s.charAt(i)+idx - 'a')%('z'-'a'+1)+'a');
                
                if(skips[c]) continue;
                k++;
            }
            
            answer += c;
        }
        
        return answer;
    }
}