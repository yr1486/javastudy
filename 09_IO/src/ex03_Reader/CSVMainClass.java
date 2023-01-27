package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {

		
		// C:\storage\product.csv 일기
		
		// 파일 새로 만드는 코드와 다름
		// 이건 파일 읽는 코드임
		File file = new File("C:" + File.separator + "storage","product.csv");
		// "C:" + File.separator + "storage" 이 부분은 스트링임!!
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			// 통로 이름이 br
			
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			String line = null;
			while((line = br.readLine()) != null) {
				String[] items = line.split(","); // 한줄읽어서 라인에 저장 , 컴마가지고 분리해달라
				Map<String, Object> product = new HashMap<String, Object>();
				product.put("model", items[0]);
				product.put("maker", items[1]);
				product.put("price", Integer.parseInt(items[2]));
				
				// 프로덕츠에 저장하기로 함
				products.add(product);
				
			}
			
			System.out.println(products);
		
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}














