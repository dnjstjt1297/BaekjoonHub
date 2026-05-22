import java.util.*;

class Solution {

    int[] dx = {0,0,-1,1};
    int[] dy = {-1,1,0,0};

    public int solution(String[] storage, String[] requests) {

        int n = storage.length;
        int m = storage[0].length();

        // 바깥 패딩
        char[][] map = new char[n+2][m+2];

        for(int i=0;i<n+2;i++){
            Arrays.fill(map[i], '.');
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i+1][j+1] = storage[i].charAt(j);
            }
        }

        int remain = n*m;

        for(String req : requests){

            char target = req.charAt(0);

            // 크레인
            if(req.length() == 2){

                for(int i=1;i<=n;i++){
                    for(int j=1;j<=m;j++){
                        if(map[i][j] == target){
                            map[i][j] = '.';
                            remain--;
                        }
                    }
                }
            }

            // 지게차
            else{

                boolean[][] outside = new boolean[n+2][m+2];

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{0,0});
                outside[0][0] = true;

                // 외부 공기 BFS
                while(!q.isEmpty()){

                    int[] cur = q.poll();

                    for(int d=0; d<4; d++){

                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];

                        if(nx<0 || ny<0 || nx>=n+2 || ny>=m+2){
                            continue;
                        }

                        if(outside[nx][ny]){
                            continue;
                        }

                        if(map[nx][ny] != '.'){
                            continue;
                        }

                        outside[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                    }
                }

                List<int[]> remove = new ArrayList<>();

                // 접근 가능한 컨테이너 제거
                for(int i=1;i<=n;i++){

                    for(int j=1;j<=m;j++){

                        if(map[i][j] != target){
                            continue;
                        }

                        for(int d=0; d<4; d++){

                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if(outside[nx][ny]){
                                remove.add(new int[]{i,j});
                                break;
                            }
                        }
                    }
                }

                for(int[] r : remove){
                    map[r[0]][r[1]] = '.';
                    remain--;
                }
            }
        }

        return remain;
    }
}