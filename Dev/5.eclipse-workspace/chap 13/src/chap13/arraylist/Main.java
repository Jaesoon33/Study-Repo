package chap13.arraylist;
import java.util.ArrayList;



/*
 * 	ArrayList - 학생 성적 관리
 * 		- ArrayList 생성
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("-----------------------------");
		System.out.println(" 1. ArrayList - 학생 성적 관리  ");
		System.out.println("-----------------------------");
		
		// 1. ArrayList 생성 + add + size + 출력
		System.out.println(">> 1. ArrayList 생성 + add");
		
		ArrayList<String> names = new ArrayList<String>();	// 크기 지정 X
		names.add("김철수");
		names.add("이영희");
		names.add("박민수");
		names.add("이수정");
		names.add("한지만");
		
		System.out.println(" names: " + names);
		System.out.println(" sizes: " + names.size());
		System.out.println(" isEmpty: " + names.isEmpty());
		
		System.out.println();
		for(String name : names) {
			System.out.println(name + " ");
		System.out.println();
		}
		
		
		// 2. get, set, contains, indexOf
		System.out.println("-----------------------------");
		System.out.println(" >> 2. 조회와 수정  ");
		System.out.println("-----------------------------");
		
		System.out.println(" get(0) : " + names.get(0));
		System.out.println(" get(2) : " + names.get(2));
		
		names.set(1, "이수정");
		System.out.println(" set() 수정 후: " + names);
		
		System.out.println(" contains(): " + names.contains("박민수"));
		System.out.println(" contains(): " + names.contains("홍길동"));
		
		System.out.println(" indexOf(): " + names.indexOf("한지민"));
		System.out.println(" indexOf(): " + names.indexOf("홍길동"));
		
		
		
		// 3. remove
		System.out.println("-----------------------------");
		System.out.println(" >> 3. 삭제  ");
		System.out.println("-----------------------------");
		
		System.out.println(" 삭제 전: " + names + " (size: " + names.size() + ")");
		
		String removed = names.remove(0);		// 인덱스 기준 삭제
		System.out.println(" remove(0) -> " + removed + " 삭제됨");
		System.out.println(" 현재: " + names);
		System.out.println(" 현재: " + names + " (size: " + names.size() + ")");
		
		boolean success = names.remove("이수정");
		System.out.println(" remove(\"이수정\") ->" + success );
		System.out.println(" 현재: " + names);
		System.out.println(" 현재: " + names + " (size: " + names.size() + ")");
		
		
		// 4. ArrayList<Student> - 커스텀 객체 CRUD
		System.out.println("-----------------------------");
		System.out.println(" 4. 커스템 객체 - 성적 관리  ");
		System.out.println("-----------------------------");
		GradeManager gm = new GradeManager("Java 기초반");
		gm.addStudent("김철수", 95);
		gm.addStudent("이영희", 87);
		gm.addStudent("박민수", 72);
		gm.addStudent("정수진", 63);
		gm.addStudent("한지민", 91);
		gm.showAll();
		gm.findStudent("박민수");
		gm.updateScore("박민수", 80);
		gm.showAll();
		gm.removeStudent("정수진");
		gm.showAll();
		gm.showStatistics();
	}
}

