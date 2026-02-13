package chap13.hashset;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		System.out.println("-----------------------------");
		System.out.println(" 2. HashSet - 로또 번호 생성 ");
		System.out.println("-----------------------------");
		
		// 1. HashSet 기본 - add 중복 거부
		System.out.println(">> 1. HashSet 기본 - add와 중복이 안들어 감");
		System.out.println("-----------------------------");
		
		HashSet<Integer> lottoNumbers = new HashSet<>();		// 로또 번호 저장용 Set
		System.out.println("-----------------------------");
		
		Random random = new Random(42);		// 42의 시드 값을 가지는 난수 생성
		while(lottoNumbers.size() < 6) {	// 6개 까지 반복
			int num = random.nextInt(45) +1;		// nextInt(45) -> 0 ~ 44 +1 -> 1 ~ 45
			boolean added = lottoNumbers.add(num);	// 중복의 값을 뽑은 경우 added -> false
			if(!added) {	// 중복 발생
				System.out.println("    중복 발생 ! " + num + " -> 무시됨");
			}
		}

		System.out.println("  로또 번호: " + new TreeSet<>(lottoNumbers));		// TreeSet으로 정렬해서 출력
		System.out.println("  size: " + lottoNumbers.size());
		
		System.out.println("\n -- add 반환값 --");
		HashSet<String> fruits = new HashSet<String>();			// 과일 이름 저장용 Set
		
		System.out.println(fruits.add("사과"));
		System.out.println(fruits.add("바나나"));
		System.out.println(fruits.add("사과"));		// false: 미지 존재하는 값
		System.out.println(fruits);					// 중복이 제거된 결과 출력
		
		System.out.println(">> 2. 조회와 삭제");
		System.out.println(fruits.contains("사과"));
		System.out.println(fruits.contains("포도"));
		
		fruits.add("포도");
		fruits.add("딸기");
		System.out.println(" 추가 후: " + fruits);
		
		fruits.remove("바나나");
		System.out.println(" 삭제 후: " + fruits);
		
		
		
	}
}
