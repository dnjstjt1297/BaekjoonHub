
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Message{
    private static Message instance = new Message();
    private String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    private String end = "라고 답변하였지.";
    private String reStrEnd[] = {"\"재귀함수가 뭔가요?\"",
        "\"재귀함수는 자기 자신을 호출하는 함수라네\""};
    private String reStr[] = {"\"재귀함수가 뭔가요?\"",
        "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
        "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
        "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""};
    public String getStart() {
        return start;
    }
    public String getEnd() {
        return end;
    }
    public String[] getReStrEnd() {
        return reStrEnd;
    }
    public String[] getReStr() {
        return reStr;
    }
    public static Message getInstance(){
        return instance;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        recurMessage(Message.getInstance(),N,0);
    }

    public static void recurMessage(Message message, int N, int cnt){
        if(cnt==0) System.out.println(message.getStart());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt; i++) sb.append("____");

        if(cnt>=N){
            for(int i=0;i<message.getReStrEnd().length;i++){
                System.out.println(sb+message.getReStrEnd()[i]);
            }
            System.out.println(sb+message.getEnd());
            return;
        }
        else if(cnt<N){
            for(int i =0; i<message.getReStr().length; i++){
                System.out.println(sb+message.getReStr()[i]);
            }
            recurMessage(message, N, cnt+1);
        }
        System.out.println(sb+message.getEnd());
    }
}
