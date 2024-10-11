import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        // board는 좌표별로 각 로봇의 방문 시간을 기록 (3차원 배열)
        List<Integer>[][][] board = new ArrayList[101][101][101];
        
        // board 초기화 (각 로봇의 방문 시간을 기록할 리스트 초기화)
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    board[i][j][k] = new ArrayList<>();
                }
            }
        }
        
        return allMove(board, points, routes);
    }

    public int allMove(List<Integer>[][][] board, int[][] points, int[][] routes) {
        for (int i = 1; i <= routes.length; i++) {
            singleMove(board, points, routes[i - 1], i);
        }
        return check(board);
    }

    public void singleMove(List<Integer>[][][] board, int[][] points, int[] route, int robot) {
        int sx = points[route[0] - 1][0]; // 시작 x 좌표
        int sy = points[route[0] - 1][1]; // 시작 y 좌표
        int time = 1; // 시작 시간을 1로 설정
        
        // 시작 좌표에 해당 로봇의 방문 시간 기록
        board[sx][sy][robot].add(time++);
        
        // 경로를 따라 이동
        for (int i = 1; i < route.length; i++) {
            int ex = points[route[i] - 1][0]; // 다음 목적지 x 좌표
            int ey = points[route[i] - 1][1]; // 다음 목적지 y 좌표

            // X축 이동 (최단 경로: r 좌표가 먼저 이동)
            if (ex > sx) {
                for (int j = sx + 1; j <= ex; j++) {
                    board[j][sy][robot].add(time++); // 해당 좌표에 도착한 시간을 기록
                }
            } else {
                for (int j = sx - 1; j >= ex; j--) {
                    board[j][sy][robot].add(time++);
                }
            }
            sx = ex; // 현재 x 좌표를 업데이트

            // Y축 이동
            if (ey > sy) {
                for (int j = sy + 1; j <= ey; j++) {
                    board[sx][j][robot].add(time++);
                }
            } else {
                for (int j = sy - 1; j >= ey; j--) {
                    board[sx][j][robot].add(time++);
                }
            }
            sy = ey; // 현재 y 좌표를 업데이트
        }
    }

    public int check(List<Integer>[][][] board) {
        int result = 0;

        // 각 좌표에 대해 모든 로봇이 방문한 시간을 모아서 충돌 여부 체크
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Map<Integer, Integer> timeCount = new HashMap<>();
                
                // 해당 좌표에 모든 로봇이 방문한 시간을 기록
                for (int robot = 1; robot <= 100; robot++) {
                    for (int time : board[i][j][robot]) {
                        timeCount.put(time, timeCount.getOrDefault(time, 0) + 1);
                    }
                }

                // 충돌 상황 계산 (동시에 여러 로봇이 같은 시간에 방문한 경우)
                for (int count : timeCount.values()) {
                    if (count > 1) {
                        result ++; // 충돌이 발생한 경우, 충돌한 로봇 수 - 1만큼 위험 상황
                    }
                }
            }
        }

        return result;
    }
}