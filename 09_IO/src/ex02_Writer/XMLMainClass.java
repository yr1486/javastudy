package ex02_Writer;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XMLMainClass {
	
	/*
	 	1. eXtensible MarKup Language
	 	2. HTML(표준 마크업 언어)의 확장 버전이다
	 	3. 정해진 태그 외 사용자 정의 태그의 사용이 가능하다
	 */

	
	/*
	 	목표
	 	1. 경로
	 	C:\storage\product.xml
	 	2. 내용
	 	<products>
	 		<product>
	 			<model>세탁기<\model>
	 			<maker>삼성<\maker>
	 			<price>100<\price>
	 		<\product>
	 		<product>
	 			<model>냉장고<\model>
	 			<maker>LG<\maker>
	 			<price>200<\price>
	 		<\product>
	 		<product>
	 			<model>TV<\model>
	 			<maker>삼성<\maker>
	 			<price>300<\price>
	 		<\product>
	 	<\products>
	 */
	
	// product.xml 라는 파일을 다큐먼트라고 부른다
	// 꺽쇠를 태그라고 부르고 각종 태그들을 엘러먼트라고 부른다
	// 모든 부분 탭으로 들어간 부분을 엘러먼츠라 한다
	// 문서를 객체로 보는 것 ==> 자바로 문서를 객체로 봐서 생성하는것 ==> dom (돔)처리 방식이라 한다
	// 태그와 태그 사이에 있는 문구를 <model>세탁기<\model> 여기서는 세탁기 그걸 텍스트컨텐트 라고 한다 textContent
	
	
	
	
	public static void main(String[] args) {

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
		
		List<Map<String, Object>> productList = Arrays.asList(product1, product2, product3);
		
		
		try {
			
			// 다큐먼트 생성 (Document는 XML문서 자체를 의미한다)
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // 공장짓고 문서만드는사람이 문서 만들고
			DocumentBuilder builder = factory.newDocumentBuilder(); //다큐먼트를 만들어주는 빌더까지
			Document document = builder.newDocument(); //다큐먼트는 빌더씨가 만든다.....
			document.setXmlStandalone(true); // standalone="no" 제거하기 , ==> 그냥 메모장에 뜨는 문구 제거하는거
			
			
			// <products> 태그 : Element 생성  ==> 문서에 들어가는건 다 엘러먼트라고 부르기로함
			
			Element products = document.createElement("products"); //모든엘러먼트들은 다큐먼트가 만든다
			document.appendChild(products); // 만들어서 집어넣기
			
			// 이제 동일한 태그가 3번 나오는 상황이 되야함
			// productList 순회
			
			for(Map<String, Object> map : productList) {
				
				// <product> 태그 : Element 생성
				Element product = document.createElement("product");
				products.appendChild(product);
				
				// <model> 태그 : Element 생성
				Element model = document.createElement("model");
				product.appendChild(model);
				model.setTextContent((String)map.get("model")); // 위에서 오브젝트라고 선언했기 때문에 get메소드와 setTextContent 의 타입이 안맞기 때문에 앞에 String을 써줘야함 캐스팅 해줘야함
				
				// <maker> 태그 : Element 생성
				Element maker = document.createElement("maker");
				product.appendChild(maker);
				maker.setTextContent((String)map.get("maker")); // 얘도 똑같이 캐스팅
				
				// <price> 태그 : Element 생성
				Element price = document.createElement("price");
				product.appendChild(price);
				price.setTextContent((int)map.get("price") + ""); //빈문자열 더해주면 스트링 되니까 스트링 만들어주기 또는 int자리에 위에처럼 String 쓰면됨
				
				// 아직 태그안에 들어갈 글을 안썼음
				// 태그 사이에, 태그안에 있는 이 글 "세탁기"를 텍스트콘텐트 라고 부른다 textContent ==> text()
			}
				
			
			// XML 설정
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "UTF-8");
			transformer.setOutputProperty("indent", "yes"); // 들여쓰기
			transformer.setOutputProperty("doctype-public", "yes"); // standalone="no" 제거하기 위해서 document.setXmlStandalone(true);를 추가하면 개행(줄바꿈)이 안 되므로 추가한 코드
			
			
			// XML 문서 만들기
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdir();
			}
			File file = new File(dir, "product.xml");
			Source source = new DOMSource(document);
			StreamResult streamResult = new StreamResult(file);
			transformer.transform(source, streamResult);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
// 자바로 xml 문서를 만드는 과정임




















