class Solution {
    static int answer =Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        
        dfs(picks, minerals, 0, 0, 0, 0, 0);
        
        return answer;
    }
    public void dfs(int[] picks, String[] minerals, int idx, int dia, int iron, int stone, int sum){
        if(dia>picks[0]||iron>picks[1]||stone>picks[2]){
            return;
        }
        if(dia==picks[0]&&iron==picks[1]&&stone==picks[2]){
            answer = Math.min(answer, sum);
            return;
        }
        if(idx==minerals.length){
            answer = Math.min(answer, sum);
            return;
        }
        
        
        int dSum = 0;
        int iSum = 0;
        int sSum = 0;
        int cnt = 0;
        
        for(int i=idx;i<idx+5;i++){
            if(i>=minerals.length) break;
            if(minerals[i].equals("diamond")){
                dSum+=1;
                iSum+=5;
                sSum+=25;
            }
            else if(minerals[i].equals("iron")){
                dSum+=1;
                iSum+=1;
                sSum+=5;
            }
            else if(minerals[i].equals("stone")){
                dSum+=1;
                iSum+=1;
                sSum+=1;
            }
            cnt++;
        }
        
        dfs(picks, minerals, idx+cnt, dia+1, iron, stone, sum+dSum);
        dfs(picks, minerals, idx+cnt, dia, iron+1, stone, sum+iSum);
        dfs(picks, minerals, idx+cnt, dia, iron, stone+1, sum+sSum);
        
    }
    
}