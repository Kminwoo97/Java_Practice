package org.example.wiseSaying.controller;

import org.example.RequestCommand;
import org.example.wiseSaying.entity.WiseSaying;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class WiseSayingController {
    private final BufferedReader br;
    private Long number;
    private static HashMap<Long, WiseSaying> map;

    public WiseSayingController(BufferedReader br) {
        this.br = br;
        number = 0L;
        map = new HashMap<>();
    }

    public void register() throws IOException {
        System.out.print("명언 : ");
        String title = br.readLine();
        System.out.print("작가 : ");
        String author = br.readLine();
        System.out.println(++number+"번 명연이 등록되었습니다.");
        map.put(number, new WiseSaying(number, title, author));
    }

    public void showList() {
        System.out.println("===================");
        System.out.println("번호 / 작가 / 명언");
        List<Long> keyAll = new ArrayList<>(map.keySet());
        Collections.sort(keyAll, Collections.reverseOrder());
        for (Long key : keyAll) {
            System.out.println(map.get(key));
        }
    }

    public void delete(RequestCommand rc) {
        long id = Long.parseLong(rc.getParam("id"));

        if (map.get(id) != null) {
            map.remove(id);
            System.out.println(id+"번 명언이 삭제되었습니다.");
        }else{
            System.out.println(id+"번 명연은 존재하지 않습니다.");
        }
    }

    public void edit(RequestCommand rc) throws IOException {
        Long id = Long.parseLong(rc.getParam("id"));

        WiseSaying cur = map.get(id);
        System.out.println("명연(기존) : " + cur.getTitle());
        System.out.print("명언 : ");
        String title = br.readLine();
        System.out.println("작가(기존) : " + cur.getAuthor());
        System.out.print("작가 : ");
        String author = br.readLine();

        map.put(cur.getNumber(), new WiseSaying(cur.getNumber(), title, author));
    }
}
