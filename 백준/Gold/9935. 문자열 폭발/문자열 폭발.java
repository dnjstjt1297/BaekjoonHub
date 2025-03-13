import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();

        StringBuilder sb = new StringBuilder();
        int pLen = P.length();

        for (int i = 0; i < S.length(); i++) {
            sb.append(S.charAt(i));
            if (sb.length() >= pLen) {
                if (sb.substring(sb.length() - pLen).equals(P)) {
                    sb.delete(sb.length() - pLen, sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}