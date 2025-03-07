class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int i=0, j = 0;
        while(i<str1.length() || j< str2.length()){
            if(i<str1.length()) answer+=str1.charAt(i++);
            if(j<str2.length()) answer+=str2.charAt(j++);
        }
        
        return answer;
    }
}