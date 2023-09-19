import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int N,K,L;
    static int[][] locations;
    static int[] times;
    static char[] directions;
    static ArrayList<int[]> snake;
    static int headDrection;
    static int answer =0;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N= Integer.parseInt(br.readLine());
        K= Integer.parseInt(br.readLine());

        locations = new int[K][2];
        for(int i=0; i<K;i++){
            st = new StringTokenizer(br.readLine());
            locations[i][0] = Integer.parseInt(st.nextToken());
            locations[i][1] = Integer.parseInt(st.nextToken());
        }
        L= Integer.parseInt(br.readLine());


        times = new int[L];
        directions = new char[L];

        for(int i=0; i<L;i++){
            st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            directions[i] = st.nextToken().charAt(0);
        }
        br.close();


        snake = new ArrayList<>();
        snake.add(new int[]{1,1});
        headDrection = 4;


        int idx = 0;
        boolean go;
        while(answer<=10000){
            if( idx < L&&answer==times[idx]){
                if(headDrection==1 && directions[idx]=='L'){
                    headDrection = 3;
                }
                else if(headDrection==1 && directions[idx]=='D'){
                    headDrection = 4;
                }
                else if(headDrection==2 && directions[idx]=='L'){
                    headDrection = 4;
                }
                else if(headDrection==2 && directions[idx]=='D'){
                    headDrection = 3;
                }
                else if(headDrection==3 && directions[idx]=='L'){
                    headDrection = 2;
                }
                else if(headDrection==3 && directions[idx]=='D'){
                    headDrection = 1;
                }
                else if(headDrection==4 && directions[idx]=='L'){
                    headDrection = 1;
                }
                else if(headDrection==4 && directions[idx]=='D'){
                    headDrection = 2;
                }
                idx++;
            }
            go = move(headDrection);
            if(!go){
                break;
            }
        }
        bw.write(Integer.toString(answer));
        bw.close();
    }
    public static boolean move(int headDrection){
        int[] head;
        head = snake.get(snake.size()-1).clone();

        answer++;
        if(headDrection == 1){
            if(head[0]-1 == 0){
                return false;
            }
            for(int[] e: snake){
                if(e[0] == head[0]-1 && e[1]==head[1]) {
                    return false;
                }
            }
            snake.add(new int[]{head[0]-1,head[1]});
            for(int i =0; i<K;i++){
                if(head[0]-1 == locations[i][0] && head[1] == locations[i][1]){
                    locations[i][0]=0;
                    locations[i][1]=0;
                    return true;
                }
            }
            snake.remove(0);
        }
        else if (headDrection == 2){
            if(head[0]+1 == N+1){
                return false;
            }
            for(int[] e: snake){
                if(e[0] == head[0]+1 && e[1]==head[1]) {
                    return false;
                }
            }
            snake.add(new int[]{head[0]+1,head[1]});
            for(int i =0; i<K;i++){
                if(head[0]+1 == locations[i][0] && head[1] == locations[i][1]){
                    locations[i][0]=0;
                    locations[i][1]=0;
                    return true;
                }
            }
            snake.remove(0);
        }
        else if(headDrection == 3){
            if(head[1]-1 == 0){
                return false;
            }
            for(int[] e: snake){
                if(e[1] == head[1]-1 && e[0]==head[0]) {
                    return false;
                }
            }
            snake.add(new int[]{head[0],head[1]-1});
            for(int i =0; i<K;i++){
                if(head[1]-1 == locations[i][1] && head[0] == locations[i][0]){
                    locations[i][0]=0;
                    locations[i][1]=0;
                    return true;
                }
            }
            snake.remove(0);
        }
        else if(headDrection == 4){
            if(head[1]+1 == N+1){
                return false;
            }
            for(int[] e: snake){
                if(e[1] == head[1]+1 && e[0]==head[0]) {
                    return false;
                }
            }
            snake.add(new int[]{head[0],head[1]+1});
            for(int i =0; i<K;i++){
                if(head[1]+1 == locations[i][1] && head[0] == locations[i][0]){
                    locations[i][0]=0;
                    locations[i][1]=0;
                    return true;
                }
            }
            snake.remove(0);
        }
        return true;
    }

}

