import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String post = br.readLine();
        Double[] arr = new Double[n];
        for(int i=0; i<n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }


        double answer = 0;

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<post.length(); i++) {
            if(post.charAt(i)>='A' && post.charAt(i)<='Z'){
                stack.push(arr[(post.charAt(i)-'A')]);
            }
            else{
                Double a = stack.pop();
                Double b = stack.pop();
                if(post.charAt(i)=='+'){
                    stack.add(b+a);
                }
                else if (post.charAt(i)=='-'){
                    stack.add(b-a);
                }
                else if (post.charAt(i)=='*'){
                    stack.add(b*a);
                }
                else if (post.charAt(i)=='/'){
                    stack.add(b/a);
                }
            }
        }

        System.out.printf("%.2f",stack.pop());

    }


}
