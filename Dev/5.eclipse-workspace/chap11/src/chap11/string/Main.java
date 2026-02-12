package chap11.string;

import java.util.Arrays;

/*
 *  String 클래스 활용과 StringBuilder
 *  
 *  - 핵심 개념
 *  	1) Sting = 불변 객체 --> 변경 시 마다 새 객체 생성 
 */

public class Main {
	public static void main(String[] args) {
		// 1. String 생성과 비교
		
		// 리터럴 방식 --> String Pool에 저장 (같은 문자열 공유)
		String s1 = "Hello";
		String s2 = "Hello";
		
		// new 방식 --> Heap에 새 객체 생성(각각 다른 위치)
		String s3 = new String("Hello");
		
		System.out.println("s1 == s1 (리터럴 비교): " + (s1 == s2));
		System.out.println("s1 == s3 (리터럴 vs new): " + (s1 == s3));
		System.out.println("s1.equals(s3) (내용 비교) " +  s1.equals(s3));
		
		// 2. String 주유 메서드 - 검색
		System.out.println("▶ 2. String 주요 메서드 - 검색");
		System.out.println("-------------------------   -");
		
		String text = "Hello, Java World! Java is i";
		System.out.println(text);
		System.out.println(text.charAt(0));
		System.out.println(text.indexOf("Java"));	// "Java"가 처음 나타내는 인덱스 반환
		System.out.println(text.indexOf("Java"));	// "Java"가 마지막으로 만나는 인덱스 반환
		
		// 3. String 주요 메서드 - 변환
		String sample = " Hello, Java!  ";
		System.out.println("▶ 3. String 주요 메서드 - 반환");
		System.out.println(sample.trim());
		System.out.println(sample.trim().replace("Java","Python"));
		
		// 4. String 
		String csv = "김개발,27,개발팀,서울";
		String[] parts = csv.split(",");
		System.out.println(Arrays.toString((parts)));
		
		String joined = String.join("|", parts);	// 객체 내 요소 이어 붙이기ㅣ
		System.out.println(joined);
		
		// 5. String.valueOf() 타입 변환
		System.out.println(String.valueOf(100));
		System.out.println(String.valueOf(3.14));
		System.out.println(String.valueOf(true));
		Object nullObj = null;
		System.out.println(String.valueOf(nullObj));
		
		// 6. StringBuilder
		StringBuilder sb = new StringBuilder();
		
		sb.append("Hello")
		.append(", ")
		.append("Java")
		.append("!");
		System.out.println(sb.toString());
		
		sb.insert(7, "Beautiful");
		System.out.println(sb);
	}
}
