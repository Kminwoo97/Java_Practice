import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        System.out.println("== 명언앱 -- ");
        String op;
        while(true){
            System.out.print("명령) ");
            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
            if (op.equals("종료")) {
                break;
            }

        }
    }
}
