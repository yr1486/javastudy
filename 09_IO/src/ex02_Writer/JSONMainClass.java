package ex02_Writer;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {
	
		
		/*
		 	아주 중요함
		 	JSON
		 	json ==> 가벼운 데이터 주고받는 형식
		 	1. JavaScript Object Notation
		 	2. 객체는 {} 중괄호로 표기하고, 배열은 [] 대괄호로 표기한다
		 	3. 맵이랑 비슷함 키와 밸류 처럼
		 		property (프로퍼티) 와 value (값) 로 데이터를 구성한다
		 	
		 */

		/*
		 	JSON-Java (JSON in Java) 라이브러리
		 	1. 객체를 저장하는 클래스 : JSONObject 클래스 (Map 기반으로 제작된 클래스여서 맵이랑 사용이 비슷해)
		 	2. 배열을 저장하는 클래스 : JSONArray 클래스
		 */

	public static void ex01() {

		// 목표. 아래 JSON 만들기
		
		/*
		 	{
		 		"model": "세탁기",
		 		"maker": "삼성",
		 		"price": 100
		 	}

		 */
		
		/*
		맵과 아주 똑같은 걸 볼 수 있음
		Map<String, Object> product1 = new HashMap<String, Object>();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		 */
		
		
		JSONObject product = new JSONObject();
		
		product.put("model", "세탁기");
		product.put("maker", "삼성");
		product.put("price", 100);
		// 맵과 같이 순서대로 저장되지 않음
		System.out.println(product.toString());
		// 객체를 중괄호 안에 담아줌
		
	}
	
	public static void ex02() {

		// 목표. 아래 JSON 만들기
		
		/*
		 	[
			 	{
			 		"model": "세탁기",
			 		"maker": "삼성",
			 		"price": 100
			 	},
			 	{
			 		"model": "냉장고",
			 		"maker": "LG",
			 		"price": 200
			 	}
			]

		 */

	
	
		JSONObject product1 = new JSONObject();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		JSONObject product2 = new JSONObject();
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		JSONArray products = new JSONArray();
		products.put(product1);
		products.put(product2);
		
		System.out.println(products.toString());
		
	}
	
	public static void ex03() {
		// String 형식의 JSON 데이터
		
		//{"name":"james","age":30,"height":180.5,"isAlive":true}
		// 이렇게 밖에다가 쓴다음에 따로 써놓은 String str = "";에 ""안해 복붙해서 넣어주면 자바가 알아서 아래 형태로 바꿔줌 
		
		// String 형식의 JSON 데이터
		String str = "{\"name\":\"james\",\"age\":30,\"height\":180.5,\"isAlive\":true}";
		
		// JSONObject 객체 생성
		JSONObject obj = new JSONObject(str);
		
		// JSONObject 객체를 구성하는 프로퍼티 값 가져오기
		String name = obj.getString("name");
		//String name = (String)obj.get("name"); ==> 이코드도 가능해
		//String name = obj.get("name"); ==> 맵처럼 한다하면 이코드인데 json에서 왜 안되냐면 string과 타입이 안맞아서!!! 
		// String str = "{\"name\":\"james\",\"age\":30,\"height\":180.5,\"isAlive\":true}"; 이게 오브젝트로 타입이 되어 있기 때문에
		
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		boolean isAlive = obj.getBoolean("isAlive");
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(isAlive);
	}
	
	public static void ex04() {
		
		// [{"model":"세탁기","maker":"삼성","price":100},{"model":"냉장고","maker":"LG","price":200}]
		
		// String 형식의 JSON 데이터 , 이번엔 배열 형태
		String str = "[{\"model\":\"세탁기\",\"maker\":\"삼성\",\"price\":100},{\"model\":\"냉장고\",\"maker\":\"LG\",\"price\":200}]";
		
		// JSONArray 객체 생성
		JSONArray products = new JSONArray(str);
		
		//배열이면 for문이 자동으로 생각나야함
		
		// 1. 일반 for문
		for(int i=0; i<products.length(); i++) {
			JSONObject obj = products.getJSONObject(i); // 가져와야하는게 제이슨오브젝트니까!!
			
			String model = obj.getString("model");
			String maker = obj.getString("maker");
			int price = obj.getInt("price");
			
			System.out.println(model + "," + maker + "," + price);
		}
		// 2. 향상 for문
		// 향샹 for문을 사용하려면 JSONObject를 object로 쓴 후 캐스팅 해가야함 오브젝트는 캐스팅해서 쓰기
		for(Object obj : products) {
			JSONObject product = (JSONObject)obj;
			
			String model = product.getString("model");
			String maker = product.getString("maker");
			int price = product.getInt("price");
			
			System.out.println(model + "," + maker + "," + price);
		}
	}
	
	public static void ex05() {
		
		// 이 파일을 제이슨 파일로 만들기
		
		Map<String, Object> product1 = new HashMap<String, Object>();
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String, Object> product2 = new HashMap<String, Object>();
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String, Object> product3 = new HashMap<String, Object>();
		product3.put("model", "TV");
		product3.put("maker", "삼성");
		product3.put("price", 300);
		
		List<Map<String, Object>> products = Arrays.asList(product1, product2, product3);
		
		// 컬랙션과 맵은 아예 따로 달라
		// 컬렉션 안에 리스트 와 셋 이 있어!!! 리스트와 셋은 컬렉션껄써도댕, 가져다 쓸수 있어
		
		JSONArray arr = new JSONArray(products);
		String content = arr.toString();
		
		// product.json 자, 파일로 보내보자
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "product.json");
		
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			bw.write(content);
			System.out.println("product.json 파일이 생성되었다!!");
			
		} catch(IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) {
		ex05();
	}

}


















