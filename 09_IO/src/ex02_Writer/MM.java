package ex02_Writer;

import org.json.JSONArray;
import org.json.JSONObject;

public class MM {

	
	public static void ex01() {
		
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
	
	public static void ex04() {
		
		String str = "[{\"model\":\"세탁기\",\"maker\":\"삼성\",\"price\":100},{\"model\":\"냉장고\",\"maker\":\"LG\",\"price\":200}]";
		
		JSONArray products = new JSONArray(str);
		
		
	}
	public static void main(String[] args) {
		ex04();
		
	}

}









