package chap13.arraylist;
import java.util.ArrayList;

/*
 *	ArrayList로 학생 성적 관리 - CRUD 기능 제공											 
 */

public class GradeManager {
	private String className;				// 반 이름
	private ArrayList<Student> students;	// 학생 목록
	
	public GradeManager(String className) {
		//super();
		this.className = className; 
		this.students = new ArrayList<>();
	}
	
	// 학생 추가1
	public void addStudent(String name, int score) {
		students.add(new Student(name, score)); 			// 어차피 객체리스트이므로 객체의 속성값을 생성하면서 넘기면 됨
		System.out.printf("  + %s 추가됨 (현재 %d명)\n", name , students.size());
	}
	
	// 학생 삭제
	public void removeStudent(String name) {
		System.out.println("\n\n삭제");
		int cnt = 0;
		for(Student i : students) {
			if(i.getName().equals(name) == true) {
				System.out.printf("- %s 삭제됨\n", i.getName());
				students.remove(cnt);
				break;
			}
			else if(cnt + 1 == students.size()) {
				System.out.println(name + "을 찾을 수 없습니다.");
			}
			cnt ++;
		}
	}
	
	// 학생 검색 
	public Student findStudent(String name){
		System.out.println("\n[검색]");
		for(Student i : students) {
			if(i.getName().equals(name) == true)
				System.out.println("결과: " + i);
		}
		return null;
	}
	
	// 점수 수정
	public void updateScore(String name, int newScore) {
		System.out.println("\n[수정]");
		for(Student i : students) {
			if(i.getName().equals(name) == true) {
				System.out.printf("~ %s 점수 변경: %d -> %d", name, i.getScore(), newScore);
				i.setScore(newScore);
			}
		}

	}
	
	// 전체 출력2
	public void showAll() {		// 결국엔 Student 객체를 이용하므로 객체 내 파라미터없는 메서드들로 인해 성적표 폼이 유지된 체로 출력 된다.
		System.out.println("\n=== " + className + " 성적표 ===");
		for(int i = 0; i < students.size(); i++) {
			System.out.print(i + 1 + ". ");
			System.out.println(students.get(i));
		}
		System.out.println("총 " + students.size() + "명");
	}
	
	// 통계
	public void showStatistics(){
		int count = 0;
		double sum = 0;
		int max_score = 0;
		int min_score = 0;
		int max_index = 0;
		int min_index = 0;
		
		if(students.isEmpty()) {	// 리스트가 비어있는 경우
			System.out.println("등록된 학생이 없습니다.");
			return;
		}
		
		for(Student i : students) {
			if(count == 0) {
				max_score = i.getScore();
				min_score = i.getScore();
			}else {
				if(i.getScore() > max_score) {
					max_score = i.getScore();
					max_index = count;
				}
				if(i.getScore() < min_score) {
					min_score = i.getScore(); 
					min_index = count;
				}
			}
			count ++;
			sum += i.getScore();
		}
		System.out.println("\n통계");
		System.out.printf("평균: %.1f점\n", sum/count);
		System.out.println("최고: " + students.get(max_index));
		System.out.println("최소: " + students.get(min_index));
		
		
	}
	
	// 등록된 학생 수 반환
	public int getCount() { 
		return 0;
	}
	
}
