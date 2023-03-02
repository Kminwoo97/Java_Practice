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
        String title;
        String author;
        while(true){
            System.out.print("명령 ) ");
            st = new StringTokenizer(br.readLine());

            op = st.nextToken();
            if (op.equals("종료")) {
                break;
            } else if (op.equals("등록")) {
                System.out.print("명언 : ");
                st = new StringTokenizer(br.readLine());
                title = st.nextToken();
                System.out.print("작가 : ");
                st = new StringTokenizer(br.readLine());
                author = st.nextToken();
            }
        }
    }
}
