
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] cmds = new String[n];
        for (int i = 0; i < n; i++) {
            cmds[i] = br.readLine();
        }

        for(int i = 0; i < cmds.length; i++) {
            String password = getPassword(cmds[i]);
            System.out.println(password);
        }
    }

    public static String getPassword(String cmd) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for(int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i);
            if(c=='<'){
                if(!s1.empty()){
                    char tmp = s1.pop();
                    s2.push(tmp);
                }
            }
            else if(c=='>'){
                if(!s2.empty()){
                    char tmp = s2.pop();
                    s1.push(tmp);
                }
            }
            else if(c=='-'){
                if(!s1.empty()) s1.pop();
            }
            else s1.push(c);

        }
        StringBuilder sb = new StringBuilder();
        while(!s1.empty()) sb.append(s1.pop());
        sb.reverse();
        while(!s2.empty()) sb.append(s2.pop());

        return sb.toString();
    }

}
