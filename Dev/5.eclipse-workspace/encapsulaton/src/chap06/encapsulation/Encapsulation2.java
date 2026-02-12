package chap06.encapsulation;


class Product2 {
	private String name;
	private int price;
	private int quantity;
	private String category;
	
	
	public Product2(String name, int price, int quantity, String category) {
		//super();
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setCategory(category);
	}


	public String getName() {
		return name;
	}


	public int getPrice() {
		return price;
	}


	public int getQuantity() {
		return quantity;
	}


	public String getCategory() {
		return category;
	}


	
	// 유효성 검증 
	public void setName(String name) {
		if(name != null && !name.trim().isEmpty())
			this.name = name;
		else
			throw new IllegalArgumentException("상품명은 필수입니다.");
	}


	public void setPrice(int price) {
		if(price >= 0)
			this.price = price;
		else
			throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
	}


	public void setQuantity(int quantity) {
		if(quantity >= 0)
			this.quantity = quantity;
		else
			throw new IllegalArgumentException("수량은 0 이상이어야 합니다..");
	}


	public void setCategory(String category) {
		this.category = category != null ? category : "미분류";		
	}
	
	// 판매
	public boolean sell(int amount){
		if(amount > 0 && quantity >= amount) {
			quantity -= amount;		// 재고 감소
			return true;
		}
		return false;
	}
	
	// 입고하다
	public void revoke(int amount) {
		if(amount > 0) {
			quantity += amount;
		}
	}
	
	// 재고 가치 계산
	public int getTotalValue() {
		return price * quantity;
	}
	
	public void displayInfo() {
		System.out.println("-----------------------------");
		System.out.println("상품명: " + getName());
		System.out.printf("가격: %,d원\n", getPrice() );
		System.out.println("수량: " + getQuantity());
		System.out.println("카테고리: " + getCategory() );
		System.out.printf("재고 가치: %,d원\n", getTotalValue() );
	}
}


// 학생 성적 관리하는 클래스 
class StudentsWithGrades2{
	 private String name;
	 private String studentId; // 학번
	 private int[] scores; // 점수 배열
	 private int scoreCount; // 현재 점수 개수
	 
	 public StudentsWithGrades2(String name, String studentId, int[] scores) {
		 setName(name);
		 setStudentId(studentId);
		 setScores(scores);
	 }
	 
	 
	 public void setName(String name) {
		 if(name != null && !name.trim().isEmpty())
				this.name = name;  
			else
				throw new IllegalArgumentException("이름은 필수입니다.");
	 }
	 public void setStudentId(String studentId) {
		 if(studentId != null && !name.trim().isEmpty())
				this.studentId = studentId;
			else
				throw new IllegalArgumentException("학번은 필수입니다.");
	 }
	 public void setScores(int[] scores) {
		 this.scores = scores;
	 }
	 public void setScoreCount(int scoreCount) {
		 this.scoreCount = scoreCount;
		 
		 
	 }
	 public String getName() {
		 return name;
	 }
	 public String getStudentId() {
		 return studentId;
	 }
	 public int[] getScores() {
		 return scores;
	 }
	 public int getScoreCount() {
		 return scoreCount;
	 }
	 	 
	 double getAverage() {
		double avg = 0;
		double sum = 0;
		
		for(int i = 0; i< scores.length; i++) {
			sum += scores[i];
		}
		
		avg = sum / scores.length;
		return avg;
	 }
	 
	 void returnArray() {
		 for(int i = 0; i < scores.length; i++) {
			 System.out.print(scores[i] + " ");
		 }
		 System.out.println();
	 }
	 
	 String getGrade() {
		 double avg = getAverage();
		 if(avg >= 90)
			 return "A";
		else if(avg >= 80)
			return "B";
		else if (avg >= 70)
			return "C";
		else if (avg >= 70)
			return "D";
		else
			return "F";
		 
	 }
	 
	 void displayinfo() {
		 System.out.println("\n---------------------------");
		 System.out.println("이름: " + getName());
		 System.out.println("학번: " + getStudentId());
		 System.out.print("점수: ");
		 returnArray();
		 System.out.print("평균: " + getAverage());	 
		 System.out.println("\n등급: " + getGrade());
	 }
	
}





public class Encapsulation2 {
	public static void main(String[] args) {
		System.out.println("================================");
		System.out.println("    1. 캡슐화 적용    ");
		System.out.println("================================");
		System.out.println("---- Product 클래스 테스트 ----");
		
		Product p1 = new Product("노트북", 1500000, 10, "전자제품");
		p1.displayInfo();
		
		System.out.println("\n3개 판매");
		p1.sell(3);
		p1.displayInfo();
		
		System.out.println("\n5개 입고");
		p1.revoke(5);
		p1.displayInfo(); 
		System.out.println("\n가격 변동 시도(음수)");
		try {
			p1.setPrice(-1000);
		}
		catch(IllegalArgumentException e){
			System.out.println(""
					+ "에외 발생: " + e.getMessage());
		}
		
		
		System.out.println("\n\n---- Product 클래스 테스트 ----");
		StudentsWithGrades2 std = new StudentsWithGrades2("이순신", "2026001", new int[] {95, 88, 72, 90}) ;
		std.displayinfo();

	}
}
