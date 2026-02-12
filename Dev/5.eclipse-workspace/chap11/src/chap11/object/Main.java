package chap11.object;

public class Main {
	public static void main(String[] args) {
		// 1. 평소처럼 객체 생성하기
		Member m1 = new Member("A0001", "이순신", 25);
		Member m2 = new Member("ㅠ0001","이순신", 25);
		
		System.out.println(m1);
		System.out.println(m2);
		
		System.out.println();
		
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());
		
		// 같은 id, 같은 이름, r같은 나일 2개 생성System.out.println(m1);
		System.out.println(m2);
		
		
		// Before
		Member bm1 = new Member("A001", "황희", 25);
		Member bm2 = new Member("A001", "황희", 25);
		boolean beforsameHash = bm1.hashCode() == bm2.hashCode();
		System.out.println("  | 재정의 X    | 메모리 주소  |" + (beforsameHash ? "equals호출됨" : "equals 호출 안됨") + " ");
		
		//After
		MemberFixed am1 = new MemberFixed("A001", "황희", 25);
		MemberFixed am2 = new MemberFixed("A001", "황희", 25);
		boolean beforsameHash1 = am1.hashCode() == am2.hashCode();
		System.out.println("  | 재정의 X    | 메모리 주소  |" + (beforsameHash1 ? "equals호출됨" : "equals 호출 안됨") + " ");
	}
	
	
}
