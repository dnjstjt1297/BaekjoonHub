import java.util.*;
import java.io.*;

class Game{
    static class Tank{
        private int x;
        private int y;
        private int direction;

        public Tank(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private int H, W;
    private int N;
    private char[][] board;
    private char[] commands;
    private Tank tank;

    public Game(char[][] board, char[] commands, int H, int W, int N){
        this.board = board;
        this.commands = commands;
        this.H = H;
        this.W = W;
        this.N = N;
    }

    public void run(){
        initTank();
        for(int i = 0; i < N; i++){
            char command = commands[i];
            if(command == 'S') shoot();
            else move(command);
        }
        setBoardTank();
    }

    private void initTank(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++) {
                if (board[i][j] == '^') {
                    tank = new Tank(i, j, 0);
                    board[i][j] = '.';
                } else if (board[i][j] == 'v') {
                    tank = new Tank(i, j, 1);
                    board[i][j] = '.';
                } else if (board[i][j] == '<') {
                    tank = new Tank(i, j, 2);
                    board[i][j] = '.';
                } else if (board[i][j] == '>') {
                    tank = new Tank(i, j, 3);
                    board[i][j] = '.';
                }
            }
        }
    }

    private void setBoardTank(){
        switch(tank.direction){
            case 0:{
                board[tank.x][tank.y] = '^';
                break;
            }
            case 1:{
                board[tank.x][tank.y] = 'v';
                break;
            }
            case 2:{
                board[tank.x][tank.y] = '<';
                break;
            }
            case 3:{
                board[tank.x][tank.y] = '>';
                break;
            }
        }

    }

    private void move(char command){
        int nDirection;
        switch(command){
            case 'U': nDirection = 0; break;
            case 'D': nDirection = 1; break;
            case 'L': nDirection = 2; break;
            case 'R': nDirection = 3; break;
            default: nDirection = -1;
        }
        tank.direction = nDirection;

        int nx = tank.x+dx[nDirection];
        int ny = tank.y+dy[nDirection];
        if(nx < 0 || ny < 0 || nx>=H || ny>=W) return;
        if(board[nx][ny] == '-' || board[nx][ny] == '*' || board[nx][ny] == '#') return;
        tank.x = nx; tank.y = ny;
    }

    private void shoot(){
        switch(tank.direction){
            case 0: {
                for(int i = tank.x; i>=0;i--){
                    if(board[i][tank.y]=='*'){
                        board[i][tank.y] = '.';
                        break;
                    }
                    else if(board[i][tank.y]=='#') break;
                }
                break;
            }
            case 1: {
                for(int i = tank.x; i<H;i++){
                    if(board[i][tank.y]=='*'){
                        board[i][tank.y] = '.';
                        break;
                    }
                    else if(board[i][tank.y]=='#') break;
                }
                break;
            }
            case 2: {
                for(int i = tank.y; i>=0;i--){
                    if(board[tank.x][i]=='*'){
                        board[tank.x][i] = '.';
                        break;
                    }
                    else if(board[tank.x][i]=='#') break;
                }
                break;
            }
            case 3: {
                for (int i = tank.y; i < W; i++) {
                    if(board[tank.x][i]=='*'){
                        board[tank.x][i] = '.';
                        break;
                    }
                    else if(board[tank.x][i]=='#') break;
                }
                break;
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T;t++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] board = new char[H][W];

            for(int i = 0;i<H;i++){
                String input = br.readLine();
                for(int j = 0;j<W;j++) board[i][j] = input.charAt(j);
            }
            int N = Integer.parseInt(br.readLine());
            char[] commands = br.readLine().toCharArray();
            Game game = new Game(board, commands, H, W, N);
            game.run();
            System.out.print("#"+t+" ");
            game.printBoard();
        }
    }
}