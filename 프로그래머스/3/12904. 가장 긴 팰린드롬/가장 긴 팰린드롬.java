class Solution
{
    static String[] tree;
    static String subS="";
    static int answer =0;
    public int solution(String s)
    {
        int answer =1;
        
        for(int i=0;i<s.length();i++){
            int interval = 1;
            int left = i;
            int right = i+1;
            while(left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    interval++;
                    right++;
                }
                else{
                    left--;
                    break;
                }
            }
            while(left>=0&&right<s.length()){
                if(s.charAt(left)==s.charAt(right)){
                    interval+=2;
                    right++;
                    left--;
                }
                else{
                    break;
                }
            }
            answer = Math.max(answer,interval);
        }
        return answer;
    }
    
}