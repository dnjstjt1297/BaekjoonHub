class Solution {
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        for(int i=0;i<Math.pow(2,beginning.length);i++){
            for(int j=0;j<Math.pow(2,beginning[0].length);j++){
                if(compare(beginning,target,i,j)){
                    int cnt =0;
                    for(int k=0;k<beginning.length;k++){
                        if((i&(int)Math.pow(2,k))!=0) cnt++;
                    }
                    for(int k=0;k<beginning[0].length;k++){
                        if((j&(int)Math.pow(2,k))!=0) cnt++;
                    }
                    answer = Math.min(answer,cnt);
                };
            }
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    public boolean compare(int[][] beginning, int[][] target, int cols, int rows){
        boolean is_same = true;
        for(int i =0;i<beginning.length;i++){
            for(int j=0;j<beginning[0].length;j++){
                int col = (cols&(int)Math.pow(2,i));
                int row = (rows&(int)Math.pow(2,j));
                if((col == 0 && row == 0) || (col != 0 && row != 0)){
                    if(target[i][j] != beginning[i][j]) is_same = false;
                }
                else{
                    if(target[i][j] == beginning[i][j]) is_same = false;    
                }
            }
        }
        return is_same;
    }
}