package ex04_builder;

public class MainClass {

	public static void main(String[] args) {

		// Builder builder = new Builder();
		User user = User.builder()
						.id("admin")
						.pw("123456")
						.build();
		
		System.out.println(user);
						

	}

}
