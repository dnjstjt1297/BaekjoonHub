import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Point{
    long x;
    long y;
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point A = new Point();
        Point B = new Point();
        Point C = new Point();
        Point D = new Point();
        StringTokenizer st = new StringTokenizer(br.readLine());
        A.x = Long.parseLong(st.nextToken());
        A.y = Long.parseLong(st.nextToken());
        B.x = Long.parseLong(st.nextToken());
        B.y = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        C.x = Long.parseLong(st.nextToken());
        C.y = Long.parseLong(st.nextToken());
        D.x = Long.parseLong(st.nextToken());
        D.y = Long.parseLong(st.nextToken());

        if(isCross(A, B, C, D)) System.out.println(1);
        else System.out.println(0);
    }
    public static boolean isCross(Point A, Point B, Point C, Point D) {
        long c1 = getCcw(A.x, A.y, B.x, B.y, C.x, C.y) * getCcw(A.x, A.y, B.x, B.y, D.x, D.y);
        long c2 = getCcw(B.x, B.y, C.x, C.y, D.x, D.y) * getCcw(A.x, A.y, C.x, C.y, D.x, D.y);

        if(c1==0 && c2==0) {
            if ((Math.max(A.x, B.x) >= Math.min(C.x, D.x) && Math.max(C.x, D.x) >= Math.min(A.x, B.x))
                    && (Math.max(A.y, B.y) >= Math.min(C.y, D.y) && Math.max(C.y, D.y) >= Math.min(A.y, B.y))) {
                return true;
            }
            return false;
        }
        else return c1 <= 0 && c2 <= 0;
    }

    public static long getCcw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long cross = x1*y2+x2*y3+x3*y1 - x2*y1-x3*y2-x1*y3;
        if(cross==0) return 0;
        else if(cross>0) return 1;
        else return -1;
    }
}