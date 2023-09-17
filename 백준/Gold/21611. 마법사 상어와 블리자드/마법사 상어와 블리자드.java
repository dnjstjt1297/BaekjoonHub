import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[][] map;
    static int[] changeMap;
    static int[][] spells;
    static int answer =0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][N];
        changeMap = new int [N*N];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx=0;
        int cnt=0;
        changeMap[0]= 0;
        for(int i=1; i<=N/2; i++){
            for(int j=0; j<2*i; j++){
                idx++;
                changeMap[idx] = map[N/2-cnt+j][N/2-i];
            }
            for(int j=0; j<2*i; j++){
                idx++;
                changeMap[idx] = map[N/2+i][N/2-cnt+j];
            }
            for(int j=0; j<2*i; j++){
                idx++;
                changeMap[idx] = map[N/2+cnt-j][N/2+i];
            }
            for(int j=0; j<2*i; j++){
                idx++;
                changeMap[idx] = map[N/2-i][N/2+cnt-j];
            }
            cnt++;
        }


        spells = new int[M][2];
        for(int i =0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            spells[i][0] = Integer.parseInt(st.nextToken());
            spells[i][1] = Integer.parseInt(st.nextToken());
        }
        br.close();

        for(int i=0;i<M;i++){

            blizard(spells[i][0],spells[i][1]);
            while(true){
                pull();
                if(!del()) {
                    break;
                }
            }
            changeGroup();
        }
        bw.write(Integer.toString(answer));
        bw.close();

    }

    public static void blizard(int d, int s){
        if(d==1){
            int idx= 0;
            for(int i=0; i<s ;i++){
                idx += 7+8*i;
                changeMap[idx] = 0;
            }
        }
        else if(d==2){
            int idx= 0;
            for(int i=0; i<s ;i++){
                idx += 3+8*i;
                changeMap[idx] = 0;
            }
        }
        else if(d==3){
            int idx= 0;
            for(int i=0; i<s ;i++){
                idx += 1+8*i;
                changeMap[idx] = 0;
            }
        }
        else if(d==4){
            int idx= 0;
            for(int i=0; i<s ;i++){
                idx += 5+8*i;
                changeMap[idx] = 0;
            }
        }
    }
    public static void pull(){
        int cnt =0;
        for(int i=1;i<N*N;i++){
            if(changeMap[i]==0){
                cnt++;
            }
            else{
                if(cnt==0){
                    continue;
                }
                for(int j=i;j<N*N;j++){
                    changeMap[j-cnt] = changeMap[j];
                }
                for(int j=0;j<cnt;j++){
                    changeMap[N*N-1-j]=0;
                }
                i=i-cnt;
                cnt =0;
            }
        }
    }
    public static boolean del(){
        boolean is_del = false;

        int cnt=1;
        int temp =changeMap[1];

        for(int i=1; i<N*N;i++){
            if(changeMap[i-1]==changeMap[i]){
                cnt++;
                if(i==N*N-1){
                    if(cnt>=4){
                        for(int j=1;j<=cnt;j++){
                            changeMap[i-j]=0;

                        }
                        is_del = true;
                        answer = answer + temp*cnt;
                    }
                }
            }
            else{
                if(cnt>=4){
                    for(int j=1;j<=cnt;j++){
                        changeMap[i-j]=0;

                    }
                    is_del = true;
                    answer = answer + temp*cnt;
                }
                temp = changeMap[i];
                cnt=1;
            }
            if(changeMap[i]==0){
                break;
            }
        }
        return is_del;
    }

    public static void changeGroup(){
        ArrayList<int[]> groups = new ArrayList<>();
        int cnt =1;
        if (changeMap[1] ==0){
            return;
        }

        for(int i=2; i<N*N;i++){
            if(changeMap[i]==0){
                int[] temp = new int[2];
                temp[0] = changeMap[i-1];
                temp[1] = cnt;
                groups.add(temp);
                break;
            }
            if(changeMap[i]==changeMap[i-1]){
                cnt++;
                if(i==N*N-1){
                    int[] temp = new int[2];
                    temp[0] = changeMap[i-1];
                    temp[1] = cnt;
                    groups.add(temp);
                }
            }
            else{
                int[] temp =new int[2];
                temp[0] = changeMap[i-1];
                temp[1] = cnt;
                groups.add(temp);
                cnt =1;
            }
        }
        int idx=1;
        for(int i=0;i<N*N;i++){
            changeMap[i]=0;
        }
        for(int[] e: groups){
            if(idx == N*N){
                break;
            }
            changeMap[idx]=e[1];
            idx++;
            changeMap[idx]=e[0];
            idx++;
        }

    }

}