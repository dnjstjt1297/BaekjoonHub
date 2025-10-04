class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        a: for(String s : skill_trees){
            int idx = 0;
            boolean[] visited = new boolean['Z'+1];
            for(int i = 0; i<skill.length(); i++){
                visited[skill.charAt(i)] = true;
            }
            
            for(int i =0; i<s.length(); i++){
                if(s.charAt(i)==skill.charAt(idx)){
                    idx++;
                    if(idx == skill.length()) break; 
                }
                else{
                    if(visited[s.charAt(i)]) continue a;
                }
            }
            answer++;
        }
        
        return answer;
    }
}