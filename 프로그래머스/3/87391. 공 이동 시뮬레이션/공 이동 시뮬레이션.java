class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = -1;
        int len = queries.length;
        
        /**
        * 1. 위 아래와 양옆 탐색은 독립적이다.
        * 2. 목적지로 부터 거꾸로 이동하는 것을 생각해 퀴리를 반대로 탐색한다.
        */
        
        long sx = x;
        long ex = x;
        long sy = y;
        long ey = y;
        for(int i = len-1; i>=0; i--){
            int command = queries[i][0];
            int dx = queries[i][1];
            
            if(command == 0 || command == 1){
                long[] next = func(command,dx,m,sy,ey);
                sy = next[0];
                ey = next[1];
            }
            else if(command == 2 || command == 3){
                long[] next = func(command,dx,n,sx,ex);
                sx = next[0];
                ex = next[1];
            }
            if(sx<0||sy<0||ex>=n||ey>=m) return 0;
            
        }
        
        answer = (ex-sx+1)*(ey-sy+1);
        return answer;
    }
    
    public long[] func( int command, int dx, int k, long s, long e) {
        if(command == 1 || command == 3) dx = -dx;
        
        if(s == 0 && e == k-1){
            return new long[]{s,e};    
        }
        
        if(s == 0){
            e = e+dx;
            if(e>k-1) e = k-1;
            
        }
        else if(e == k-1){
            s = s+dx;
            if(s<0) s = 0;
            
        }
        else{
            s = s+dx;
            e = e+dx;
        }
        return new long[]{s,e};
    }
}