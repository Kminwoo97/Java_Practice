package org.example;

import org.example.system.controller.SystemController;
import org.example.wiseSaying.controller.WiseSayingController;

import java.io.*;

public class App {
    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== 명언앱 -- ");

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(br );

        /*
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
         */

        while(true){
            System.out.print("명령 ) ");
            String command = br.readLine().trim();
            RequestCommand rc = new RequestCommand(command);
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.register();
            } else if (command.equals("목록")) {
                wiseSayingController.showList();
            } else if(command.contains("삭제?id=")){
                wiseSayingController.delete(rc);
            } else if (command.contains("수정?id=")) {
                wiseSayingController.edit(rc);
            }
        }

        /*
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
         */

    }
}
