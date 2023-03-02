import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== 명언앱 -- ");


        long number = 0L;
        String op;
        String title;
        String author;
        Map<Long, WiseSaying> map = new LinkedHashMap<>();
//        List<WiseSaying> list = new ArrayList<>();
        while(true){
            System.out.print("명령 ) ");
            op = br.readLine().trim();
            if (op.equals("종료")) {
                break;
            } else if (op.equals("등록")) {
                System.out.print("명언 : ");
                title = br.readLine();

                System.out.print("작가 : ");
                author = br.readLine();
                System.out.println(++number+"번 명연이 등록되었습니다.");
                map.put(number, new WiseSaying(number, title, author));
            } else if (op.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                List<Long> keyAll = new ArrayList<>(map.keySet());
                Collections.reverse(keyAll);
                for (Long key : keyAll) {
                    System.out.println(map.get(key));
                }
            } else if(op.contains("삭제?id=")){
                String[] split = op.split("=");
                Long removeNum = Long.parseLong(split[1]);
                if (map.get(removeNum) != null) {
                    map.remove(removeNum);
                    System.out.println(removeNum+"번 명언이 삭제되었습니다.");
                }else{
                    System.out.println(removeNum+"번 명연은 존재하지 않습니다.");
                }
            }
        }
    }
}
class WiseSaying{
    private Long number;
    private String title;
    private String author;

    public WiseSaying(Long number, String title, String author) {
        this.number = number;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return number + " / " + title + " / " +  author;
    }
}
