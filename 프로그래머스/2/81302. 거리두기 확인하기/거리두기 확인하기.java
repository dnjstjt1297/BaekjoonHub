class Solution {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        outer: for (int t = 0; t < places.length; t++) {
            String[] place = places[t];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {

                        // 상하좌우 인접 검사
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                            if (place[nx].charAt(ny) == 'P') {
                                continue outer;
                            }
                        }

                        // 맨해튼 거리 2 검사 (직선)
                        for (int k = 0; k < 4; k++) {
                            int nx = i + 2 * dx[k];
                            int ny = j + 2 * dy[k];
                            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                            if (place[nx].charAt(ny) == 'P') {
                                int mx = i + dx[k];
                                int my = j + dy[k];
                                if (place[mx].charAt(my) != 'X') {
                                    continue outer;
                                }
                            }
                        }

                        // 대각선 검사
                        int[] dx2 = {1, 1, -1, -1};
                        int[] dy2 = {1, -1, 1, -1};
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx2[k];
                            int ny = j + dy2[k];
                            if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                            if (place[nx].charAt(ny) == 'P') {
                                if (place[i].charAt(ny) != 'X' || place[nx].charAt(j) != 'X') {
                                    continue outer;
                                }
                            }
                        }
                    }
                }
            }

            answer[t] = 1;
        }

        return answer;
    }
}
