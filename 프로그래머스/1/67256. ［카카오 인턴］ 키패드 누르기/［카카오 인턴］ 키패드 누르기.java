class Solution {
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] map = new int[12][12];
        
        map[1][2] = 1;
        map[1][5] = 2;
        map[1][8] = 3;
        map[1][0] = 4;
        map[4][2] = 2;
        map[4][5] = 1;
        map[4][8] = 2;
        map[4][0] = 3;
        map[7][2] = 3;
        map[7][5] = 2;
        map[7][8] = 1;
        map[7][0] = 2;
        map[11][2] = 4;
        map[11][5] = 3;
        map[11][8] = 2;
        map[11][0] = 1;
        map[3][2] = 1;
        map[3][5] = 2;
        map[3][8] = 3;
        map[3][0] = 4;
        map[6][2] = 2;
        map[6][5] = 1;
        map[6][8] = 2;
        map[6][0] = 3;
        map[9][2] = 3;
        map[9][5] = 2;
        map[9][8] = 1;
        map[9][0] = 2;
        map[10][2] = 4;
        map[10][5] = 3;
        map[10][8] = 2;
        map[10][0] = 1;
        map[2][5] = 1;
        map[2][8] = 2;
        map[2][0] = 3;
        map[5][2] = 1;
        map[5][8] = 1;
        map[5][0] = 2;
        map[8][0] = 1;
        map[8][2] = 2;
        map[8][5] = 1;
        map[0][2] = 3;
        map[0][5] = 2;
        map[0][8] = 1;
        
        int l = 11;
        int r = 10;
        for(int i=0; i<numbers.length;i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                l = numbers[i];
                answer+='L';
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                r = numbers[i];
                answer+='R';
            }
            else{
                int a = map[l][numbers[i]];
                int b = map[r][numbers[i]];
                if(a==b){
                    if(hand.equals("right")){
                        r = numbers[i];
                        answer+='R';
                    }
                    else if(hand.equals("left")){
                        l = numbers[i];
                        answer+='L';
                    }    
                }
                else if(a>b){
                    r = numbers[i];
                    answer+='R';
                }
                else{
                    l = numbers[i];
                    answer+='L';         
                }
                
            }
        }
        return answer;
    }
    
}