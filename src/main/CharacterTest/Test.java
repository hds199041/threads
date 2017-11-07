package CharacterTest;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Test {

	public static void main(String[] args) {

		for(int i=1;i<=26;i++){
			char c=(char)(i+64);
			System.out.print(c);
		}
		for(int i=1;i<=26;i++){
			char c=(char)(i+96);
			System.out.print(c);
		}
		
		System.out.println("-------------------------");
		for (int i = 0; i < 127; i++) {
			char c=(char)i;
			System.out.println(i+"="+Character.valueOf(c).toString());
		}
	}

}
