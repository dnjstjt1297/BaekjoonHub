class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int solution(String dirs) {
        int answer = 0;
        int N = dirs.length();
        
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            if(dirs.charAt(i) == 'U') arr[i] = 0;
            else if(dirs.charAt(i) == 'D') arr[i] = 1;
            else if(dirs.charAt(i) == 'L') arr[i] = 2;
            else if(dirs.charAt(i) == 'R') arr[i] = 3;
        }
        
        boolean[][][] visited = new boolean[11][11][4];
        int x = 5;
        int y = 5;
        for(int i = 0;i<N;i++){
            int nx = x + dx[arr[i]];
            int ny = y + dy[arr[i]];
            if(nx<0||ny<0||nx>10||ny>10) continue;
            
            int d1 = arr[i];
            int d2 = 0;
            if(d1==0) d2 = 1;
            if(d1==1) d2 = 0;
            if(d1==2) d2 = 3;
            if(d1==3) d2 = 2;
            
            if(!visited[nx][ny][d2] && !visited[x][y][d1]){
                visited[nx][ny][d2] = true;
                visited[x][y][d1] = true;
                answer++;
            }
            x = nx;
            y = ny;
        }
        
        System.out.println(answer);
        return answer;
    }
}