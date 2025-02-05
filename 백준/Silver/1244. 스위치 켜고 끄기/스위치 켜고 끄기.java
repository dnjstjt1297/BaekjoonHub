import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] switchs;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        switchs = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            switchs[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if(s==1) male(t);
            else if(s==2) female(t);
        }

        print();
    }

    public static void male(int number){
        for(int i = number; i<=N;i+=number){
            changeSwitch(i);
        }
    }

    public static void female(int number){
        changeSwitch(number);
        int interval = 1;
        while(number-interval>=1 && number+interval<=N){
            if(switchs[number-interval] != switchs[number+interval]) return;

            changeSwitch(number-interval);
            changeSwitch(number+interval);
            interval++;
        }
    }

    public static void changeSwitch(int number){
        if(switchs[number]==1) switchs[number] = 0;
        else if(switchs[number]==0) switchs[number] = 1;
    }

    public static void print(){
        for(int i = 1; i <= N; i++) {
            System.out.print(switchs[i]+" ");
            if(i%20==0) System.out.println();
        }
        System.out.println();
    }
}
