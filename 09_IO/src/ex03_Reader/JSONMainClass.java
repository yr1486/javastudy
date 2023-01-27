package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;


public class JSONMainClass {

	public static void main(String[] args) {

		// C:\storage\product.json 읽기
		
		File file = new File ("C:" + File.separator + "storage", "product.json"); // 앞에는 파일경로, 뒤에는 파일
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));

			String line = null;
			StringBuilder sb = new StringBuilder(); // 스트링빌더에 보관
			while((line = br.readLine()) != null) {
				sb.append(line);
			}

			JSONArray arr = new JSONArray(sb.toString()); // 객체가 3개 들어있는 어레이 배열
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			for(int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);

				products.add(obj.toMap()); // 맵으로 바꿔주겠다 JSON오브젝트 obj를 맵으로 바꿔서 List에 저장하기

			}

			System.out.println(products);

		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}



















