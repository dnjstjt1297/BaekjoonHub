class Solution {
    public String[] solution(int[][] line) {
        
        long maxx = Long.MIN_VALUE;
        long maxy = Long.MIN_VALUE;
        long minx = Long.MAX_VALUE;
        long miny = Long.MAX_VALUE;
        
        for(int i = 0; i<line.length;i++){
            for(int j = i+1; j<line.length;j++){
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                if(a*d-b*c==0) continue;
                if((b*f-e*d)%(a*d-b*c)!=0) continue;
                if((e*c-a*f)%(a*d-b*c)!=0) continue;
                long x = (b*f-e*d)/(a*d-b*c);
                long y = (e*c-a*f)/(a*d-b*c);
                maxx = Math.max(x,maxx);
                maxy = Math.max(y,maxy);
                minx = Math.min(x,minx);
                miny = Math.min(y,miny);
            }
        }
        
        char[][] board = new char[(int)(maxy-miny+1)][(int)(maxx-minx+1)];
        for(int i = 0; i<board.length; i++){
            for(int j =0;j<board[0].length; j++){
                board[i][j] = '.';
            }
        }
        
        for(int i = 0; i<line.length;i++){
            for(int j = i+1; j<line.length;j++){
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                if(a*d-b*c==0) continue;
                if((b*f-e*d)%(a*d-b*c)!=0) continue;
                if((e*c-a*f)%(a*d-b*c)!=0) continue;
                long x = (b*f-e*d)/(a*d-b*c);
                long y = (e*c-a*f)/(a*d-b*c);
                board[(int)(maxy-y)][(int)(x-minx)] = '*';
            }
        }
        
        String[] answer = new String[(int)(maxy-miny+1)];
        for(int i = 0; i<board.length;i++){
            answer[i] = "";
            for(int j = 0; j<board[0].length; j++){
                answer[i]+=board[i][j];
            }
        }
        
        
        
        return answer;
    }
}