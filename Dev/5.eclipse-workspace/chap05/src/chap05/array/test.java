package chap05.array;

public class test {
	public static void main(String[] args) {
		String []a = {"강아지", "고양이", new String("강아지"), "강아지"};
		
		for(int i = 0; i< a.length; i++)
			System.out.println(a[i]);
		if(a[0] == a[2])
			System.out.println('1');
		else
			System.out.println('2');
	}
	
	
}
