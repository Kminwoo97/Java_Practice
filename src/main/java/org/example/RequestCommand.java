package org.example;

import java.util.HashMap;
import java.util.Map;

public class RequestCommand {
    private String actionCode;
    private Map<String, String> params;

    public RequestCommand(String command){
        //물음표(?)를 기준으로 최대 2개만 분리
        String[] split = command.split("\\?", 2);

        //초기화
        actionCode = split[0];//등록, 수정, 삭제 등
        params = new HashMap<>();


        //파라미터 값 없으면 종료
        if(split.length == 1)
            return;

        //파러미터가 2개 이상이라면 &로 분리
        String[] param_split = split[1].split("&");

        //파라미터들의 key=value 형태로 HashMap에 저장한다.
        for (String param : param_split) {
            //파라미터의 구성 -> key=value
            String[] params_split = param.split("=", 2);
            String key = params_split[0];
            String value = params_split[1];

            params.put(key, value);
        }
    }

    //등록, 수정, 삭제 등을 반환
    public String getActionCode() {
        return actionCode;
    }
    //id=1 에서 id값 반환
    public String getParam(String name){
        return params.get(name);
    }
}

//파라미터의 구조
//삭제?id=1&name="ㄴㄹㅇㅁㄴㅇㄹㅁㄴ"
