package chap11.object03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
	public static void main(String[] args) {
		System.out.println("-------------------------------------");
		System.out.println("ArrayList vs HashSet: 중복 체크 방식 비교");
		System.out.println("-------------------------------------");
		
		/*
		 * 	같은 사번의 SimpleEmployee 객체 2개 생성
		 * 	- emp1과 emp2는 다른 객체(주소가 다름)지만, empId가 같음
		 * 		--> equals()를 오버라이드 했으므로 "같은 직원"으로 판단함
		 */
		
		SimpleEmploy emp1 = new SimpleEmploy("E001", "이순신");
		SimpleEmploy emp2 = new SimpleEmploy("E001", "이순신");
		
		// 1. 기본 확인: == 연산자 (두 변수가 같은 객체인지 확인)
		System.out.println("emp1 == emp2 : " + (emp1 == emp2));
		
		System.out.println("emp1.equals(emp2) : " + (emp1.equals(emp2)));
		
		System.out.println("emp1.hashCode(): " + emp1.hashCode());
		System.out.println("emp2.hashCode(): " + emp2.hashCode());
		System.out.println("hashCode 동일 여부: " + (emp1.hashCode() == emp2.hashCode()) );
		
		// 2. ArrayList의 중복 체크 - equals()만 사용
		System.out.println("2. ArrayList의 중복 체크 - equals()만 사용");
		
		List<SimpleEmploy> list = new ArrayList<>(); 
		list.add(emp1);
		System.out.println(" emp1 추가 완료. 리스트 크기: " + list.size());
		
		// contains() 호출 --> 내부에서 순차 탐색 --> 각 요소.equals() 호출
		boolean listContains = list.contains(emp2);
		System.out.println(listContains);
		System.out.println("list.contains2" + listContains);	// contains는 인자값하고 리스트의 요소들을 순회하며 값을 equals로 비교하는데
		System.out.println(list.contains(emp1));  				// 현재 equals 메소드를 오버라이딩하여 empId을 기준으로 비교하므로 true가 출력됨
		
		/*
		 * 	ArrayList는 중복을 자동으로 막지 않음
		 *  add()는 항상 true 반환
		 */

		list.add(emp2); // 중복이지만 들어감
		System.out.println(" emp2 추가 완료. 리스트 크기: " + list.size());
		
		
		/*
		 * 	HasgSet
		 * 		- set = "집합": 중복을 허용하지 않는 자료구조
		 * 		- HashSet: Hase 기반의 Set
		 * 				   hashCode()로 저장 위치를 결정함
		 * 
		 * 	[ArrayList와의 핵심 차이]
		 * 		 - ArrayList : 순서 있음, 중복 허용, 인덱스로 접근 가능
		 * 		 - HashSett : 순서 있음, 중복 자동 차단, 인덱스로 접근 불가
		 * 
		 * 	[HashSet.add() 내부 동작]
		 * 			1) 객체의 hashCod() 호출 --> 해시 값으로 저장 위치(버킷) 결정
		 * 			2) 해당 버킷이 비워져 있으면 --> 바로 저장 (끝_
		 * 			3) 해당 버킷에 이미 객체가 있으면 --> equals()로 같은 객체인지 확인
		 * 	
		 */
		// 3. HashSet - hashCode() + equals()로 중복 자동 차단
		System.out.println("3. HashSet - hashCode() + equals()로 중복 자동 차단");
		
		Set<SimpleEmploy> set = new HashSet<>();
		
		/*
		/*  emp1 추가
		 * 		1) emp1.hashCod() 호출 --> 해시값 계산 --> 버킷 위치 결정
		 * 		2) 해당 버킷이 비어 있음 --> 바로 저장
		 */
		
		boolean added1 = set.add(emp1);
		System.out.println("set.add(emp1): " + added1);
		System.out.println("set 크기: " + set.size());
		
		/*
		 * 	emp2 추가 시도
		 * 			1) emp2.hashCode() 호출 --> emp1과 같은 해시값 -> 같은 버킷으로 감
		 * 			2) 버킷에는 이미 emp1이 있음 -- emp1.equals(emp2) 호출 --> tru
		 */
		boolean added2 = set.add(emp2);
		System.out.println("set.add(emp2): " + added2);
		System.out.println("set 크기: " + set.size());

	}
}