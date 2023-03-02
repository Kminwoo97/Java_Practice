import java.io.*;
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

        //파일 있으면 불러와서 HashMap에 넣는다.
        File f = new File("/Users/mwkim/Desktop/LikeLion/test.txt");
        if (!f.exists()){
            try{
                f.createNewFile();
                System.out.println("파일이 생성되었습니다.");
            }catch (IOException e){
                System.out.println(e);
            }
        }else {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader fileReader = new BufferedReader(fr);
                String line = null;
                while ((line = fileReader.readLine()) != null) {
                    line.trim();
                    String[] split = line.split("/");
                    Long f_num = Long.parseLong(split[0].trim());
                    String f_title = split[0].trim();
                    String f_author = split[1].trim();
                    map.put(f_num, new WiseSaying(f_num, f_title,f_author));
                    number = f_num;
                }
            }catch (IOException e){
                System.out.println(e);
            }finally {
                number++;
            }
        }

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
                System.out.println("===================");
                System.out.println("번호 / 작가 / 명언");
                List<Long> keyAll = new ArrayList<>(map.keySet());
                Collections.sort(keyAll, Collections.reverseOrder());
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
            } else if (op.contains("수정?id=")) {
                String[] split = op.split("=");
                Long editNum = Long.parseLong(split[1]);
                WiseSaying cur = map.get(editNum);
                System.out.println("명연(기존) : " + cur.getTitle());
                System.out.print("명언 : ");
                title = br.readLine();
                System.out.println("작가(기존) : " + cur.getAuthor());
                System.out.print("작가 : ");
                author = br.readLine();

                map.put(cur.getNumber(), new WiseSaying(cur.getNumber(), title, author));
            }
        }

        //HashMap에 있는 것들을 파일에 저장(정확히는 덮어쓰기 했다.)
        try{
            FileWriter fw = new FileWriter(f, false);
            List<Long> keyAll = new ArrayList<>(map.keySet());
            for (Long key : keyAll) {
                fw.write(map.get(key).toString());
                fw.write("\r\n");
            }
            fw.close();
        }catch (IOException e){
            System.out.println(e);
        }

    }

    public boolean isExist(Map<Long,WiseSaying> map, Long num){
        return false;
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
        return number + " / " + author + " / " +  title;
    }

    public Long getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
