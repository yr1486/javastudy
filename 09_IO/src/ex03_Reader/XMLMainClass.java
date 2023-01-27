package ex03_Reader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLMainClass { // 보너스 수업이라 안봐도 됨... 

	public static void main(String[] args) {
		
		// C:storage\product.xml 읽기

		
		try {
			
			// 다큐먼트 생성
			File file = new File("C:" + File.separator + "storage", "product.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//공장이 만드는건 다큐먼트 빌더라 햇다
			
			DocumentBuilder builder = factory.newDocumentBuilder(); // 빌더씨는 다큐먼트 만드는거
			Document document = builder.parse(file); // 빈파일 만드는게 아니라 파일에 있는거 읽어가지고 문서로 가져오는거임
			//produdct.xml을 분석(파싱)한 Document객체
			
			
			// 최상위 요소: <products> 태그
			Element root = document.getDocumentElement(); // 크리에이트는 만드는거고 지금은 가져오고 읽는거니까 겟임
			
			// 최상위 요소의 하위 태그들 : <product> 태그 (Node는 (엘러면트의 줄바꿈들 들어가있는걸 노드라고함) Element와 거의 같은 의미
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			NodeList nodeList = root.getChildNodes();
			for(int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i); //Node는 #text(줄바꿈의미)와 <product>태그 중 하나이다.
				if(node.getNodeType() == Node.ELEMENT_NODE) { //노드가 <product>태그인가?
					Map<String, Object> product = new HashMap<String, Object>();
					NodeList nodeList2 = node.getChildNodes();
					for(int j = 0; j < nodeList2.getLength(); j++) {
						Node node2 = nodeList2.item(j);
						if(node2.getNodeType() == Node.ELEMENT_NODE) {
							String key = node2.getNodeName(); //key는 model,maker,price를 의미함
							product.put(key, node2.getTextContent());
						}

					}
					products.add(product);  // ArrayList에 Map 추가하기
				}

			}			

			System.out.println(products);

		} catch(Exception e) {
			e.printStackTrace();

		}
		
	}
	
}
