package practice;

import java.io.File;

public class MM {

	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "ex001");
		
	}
	
	public static void main(String[] args) {
		ex01();
		
		
	}

}
