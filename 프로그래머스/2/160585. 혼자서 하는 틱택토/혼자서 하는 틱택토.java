class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int no = 0;
        int nx = 0;
        for(int i =0; i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j) == 'O') no++;
                if(board[i].charAt(j) == 'X') nx++;
            }
        }
        if(no!=nx){
            if(no!=nx+1){
                return 0;    
            }
        }
        boolean is_wo = false;
        boolean is_wx = false;
        for(int i =0; i<3;i++){
            if(board[i].charAt(0)=='O'&&board[i].charAt(1)=='O'&&board[i].charAt(2)=='O'){
                is_wo = true;
            }
            if(board[0].charAt(i)=='O'&&board[1].charAt(i)=='O'&&board[2].charAt(i)=='O'){
                is_wo = true;
            }
            if(board[i].charAt(0)=='X'&&board[i].charAt(1)=='X'&&board[i].charAt(2)=='X'){
                is_wx = true;
            }
            if(board[0].charAt(i)=='X'&&board[1].charAt(i)=='X'&&board[2].charAt(i)=='X'){
                is_wx = true;
            }
        }
        if(board[0].charAt(0)=='O'&&board[1].charAt(1)=='O'&&board[2].charAt(2)=='O'){
            is_wo = true;
        }
        if(board[0].charAt(0)=='X'&&board[1].charAt(1)=='X'&&board[2].charAt(2)=='X'){
            is_wx = true;
        }
        if(board[0].charAt(2)=='O'&&board[1].charAt(1)=='O'&&board[2].charAt(0)=='O'){
            is_wo = true;
        }
        if(board[0].charAt(2)=='X'&&board[1].charAt(1)=='X'&&board[2].charAt(0)=='X'){
            is_wx = true;
        }
        if(is_wo&&is_wx) return 0;
        if(is_wo&&no==nx) return 0;
        if(is_wx&&no==nx+1) return 0;
        
        return 1;
    }
    
}