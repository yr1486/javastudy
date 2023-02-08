package api;

public class Accident {


/*
 
        String occrrncDt;  // 발생월일시 (2019011622)

        String occrrncDayCd;  // 발생요일코드 (4)

        int dthDnvCnt;  // 사망자수 (0)

        int injpsnCnt;  // 부상자수 (1)
        
        
        

 
 */


JSONObject obj = new JSONObject(sb.toString());

JSONObject body = obj.getJSONObject("response").getJSONObject("body"); // 리스펀 대괄호 값과 바디의 값을 출력하는.. 기호 같은..

JSONArray items = body.getJSONArray("items");  // 배열만 담을 수 있으니까.

}