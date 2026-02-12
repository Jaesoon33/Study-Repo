package chap06.constructor3;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * 	Employee class - 직원 정보를 관리하는 클래스
 * 		- 특징
 * 			- static 필드로 사원번호 자동 생성
 * 				- 클래스 로드 시 1회 초기화
 * 			- 인스턴스 초기화 블록 사용
 * 				- 객체 생성 시 마다 실행됨
 * 				- 모든 생성자에서 공통으로 수행할 작업에 사용
 * 		- 객체 생성 시 실행 순서
 * 			1) static 필드 초기화
 * 			2) 인스턴스 초기화 블록 실행
 * 			3) 생성자 실행
 */

/*
 * 	Employee 클래스 - 직원 정보를 관리하는 클래스
 * 		- 캡슐화 + 유효성 검증 + BigDeciaml */
	


class Employee {
	private static int nextId = 1001;	// 클래스 변수, 공유 변수
	private String employeeId;					// 인스턴스 변수, 객체 변수
	private String name;
	private String department;
	private String Position;
	private BigDecimal salary;
	
	// 인스턴스 초기화 블럭
	{
		employeeId = "EMP-" + nextId++;		// 사원번호 자동 생성(인스턴스 초기화 블록)
	}
	
	/*
	 * 	생성자 1: 기본 생성자
	 * 		동작: 신입사원 기본 정보로 초기화
	 * 			- 이름: "신입사원"
	 * 			- 부서: "미정"
	 * 			- 직급: "사원"
	 * 			- 연봉: 3000만원
	 */
	
	public Employee() {
		this("신입사원", "미정", "사원", 3000);
	}
	
	/*
	 * 	생성자 2: 이름만
	 * 		파라미터 - name (직원 이름)
	 */
	
	public Employee(String name) {
		//super();
		this(name, "미정", "사원", 3000);
	}
	
	/*
	 * 	생성자 3: 이름 및 부서명
	 * 		파라미터 - name (직원 이름), department (부서명)
	 */
	
	public Employee(String name, String department) {
		//super();
		this(name, department, "사원", 3000);
	}
	
	
	/*
	 *  생성자 4: 주 생성자
	 *  	- 연봉 변환 
	 *  		- salaryInTenThousand --> 원 단위로 변환
	 *  	ex) 3000 (만원) --> 30,000,000 (원)
	 */
	public Employee(String name, String department, String position, int salaryInTenThousand) {
		//super();
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 필수입니다.");
		}
		if(salaryInTenThousand < 0) {
			throw new IllegalArgumentException("연봉은 0 이상이어야 합니다.");
		}
		
		
		this.name = name;
		this.department = department;
		this.department  = position;
		this.salary = BigDecimal.valueOf(salaryInTenThousand).multiply(BigDecimal.valueOf(10000));
	}
		
	// 직원 정보 출력
	void displayInfo(){
		NumberFormat formater = NumberFormat.getNumberInstance(Locale.KOREA);
		System.out.println("---------------------");
		System.out.println("이름: " + name);
		System.out.println("부서: " + department);
		System.out.println("직위: " + Position);
		System.out.println("연봉: " +  formater.format(salary) + "원");
	}

	// Getter 메서드 (encapsulation)
	
	public static int getNextId() {
		return nextId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getPosition() {
		return Position;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	// Setter 메서드 (encapsulation)s

	public void setName(String name) {
		if(name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("이름은 필수입니다.");
		}
		else
			this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public void setSalary(int salaryInTenThousand) {
		if(salaryInTenThousand < 0) {
			throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
		}
		this.salary = BigDecimal.valueOf(salaryInTenThousand).multiply(BigDecimal.valueOf(10000));
	}
}

/*
 *  Computer 클래스 - PC 사양을 관리하는 클래스 
 *  	- builder 패턴 적용
 *  	
 *  	- 매직 넘버(Magic Number) 제거
 *  		- 코드에 직접 쓰인 의미 불명확한 숫자
 *  
 *   	- 상수로 정의하면
 *   		- 의미가 명확해짐
 *   		- 값 변경 시 한 곳만 수정하면 됨
 *   		- 오타 방지
 *	  
 */
class Computer{
	// 인스턴스 필드
	private String brand;
	private String cpu;
	private int ramGB;
	private int storageGB;
	private BigDecimal price;
	
	private static final String DEFAULT_BRAND = "Generic";
	private static final String DEFAULT_CPU = "Unknown CPU";
	private static final int DEFAULT_RAM = 8;
	private static final int DEFAULT_STORAGE = 256;
	private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(500000);
	
	
	public Computer() {
		this(DEFAULT_BRAND,DEFAULT_CPU, DEFAULT_RAM, DEFAULT_STORAGE, DEFAULT_PRICE);
	}

	public Computer(String brand) {
		this(brand, DEFAULT_CPU , DEFAULT_RAM, DEFAULT_STORAGE, DEFAULT_PRICE);

	}

	public Computer(String brand, String cpu) {
		this(brand, cpu, DEFAULT_RAM, DEFAULT_STORAGE, DEFAULT_PRICE);

	}

	/*
	 * 	가격은 스펙 기반 자동 계산
	 * 		- 기본가: 30만원
	 * 		- RAM 1GB당: 1만원 추가
	 * 		- 저장소 16GB당: 100만원 추가
	 */
	public Computer(String brand, String cpu, int ramGB, int storageGB) {
		this(brand, cpu, ramGB, storageGB, BigDecimal.ZERO);
	}

	public Computer(String brand, String cpu, int ramGB, int storageGB, BigDecimal price) {
		//super();
		// 유효성 검증
		if(ramGB <= 0) {
			throw new IllegalArgumentException("RAM은 0 보다 커야 합니다.");
		}
		if(storageGB <= 0) {
			throw new IllegalArgumentException("STORAGE는 0 보다 커야 합니다.");
		}
		if(price != null && price.compareTo(BigDecimal.ZERO) < 0) { // price가 null이 아니고 값이 0보다 작지 않아야 함
			throw new IllegalArgumentException("가격은 0 보다 커야 합니다.");
		}
		
		this.brand = brand != null ? brand : DEFAULT_BRAND;
		this.cpu = cpu != null ? cpu : DEFAULT_CPU;
		this.ramGB = ramGB;
		this.storageGB = storageGB;
		this.price = price != null ? price : BigDecimal.ZERO;
	}
	
	/*
	 *	생성자 6: 편의 생성자 (double 가격)
	 *		- 사용자가 double로 가격을 줄 수 있음
	 *		- 내부적으로 BigDecimal로 변환 
	 */
	
	public Computer(String brand, String cpu, int ramGB, int storageGB, double price) {		// 가격의 입력 값이 double 형일 때 Bigdecimal 형태로 변환
		this(brand, cpu, ramGB, storageGB, BigDecimal.valueOf(price));
	}

	void displayInfo(){
		NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
		System.out.println("---------------------");
		System.out.println("브랜드: " + brand);
		System.out.println("CPU: " + cpu);
		System.out.printf("RAM: %dGB\n", ramGB);
		System.out.printf("저장소: %dGB\n", storageGB);
		System.out.println("가격: " + formatter.format(price) + "원");
	}
	
	/*
	 * 	builder() - Builder 객체 생성
	 */
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder{
		private String brand = DEFAULT_BRAND;
		private String cpu = DEFAULT_CPU;
		private int ramGB = DEFAULT_RAM;
		private int storageGB = DEFAULT_STORAGE;
		private BigDecimal price = DEFAULT_PRICE;
		
		// 각 필드 설정 메서드
		public Builder brand(String brand) {
			this.brand = brand;
			return this;
		}
		public Builder cpu(String cpu) {
			this.cpu = cpu;
			return this;
		}
		public Builder ramGB(int ramGB) {
			this.ramGB = ramGB;
			return this;
		}
		public Builder storageGB(int storageGB) {
			this.storageGB = storageGB;
			return this;
		}
		public Builder price(BigDecimal price) {
			this.price = price;
			return this;
		}
		public Builder price(double price) {
			this.price = BigDecimal.valueOf(price);
			return this;
		}
		
		
		// 최종적으로 객체를 생성하는 메서드
		public Computer build() {
			return new Computer(brand, cpu, ramGB, storageGB, price);
		}
		
		// Setter 메서드 (필요한 것만) -- 가격은 세일 등으로 자주 변경되기 때문 브랜드나 이름은 거의 변경 없음
		
		public void setPrice(double price) {
			if(price < 0) {
				throw new IllegalArgumentException("가격은 0 이상이어야 합니다.");
			}
			this.price = BigDecimal.valueOf(price);
		}
		
		
		void displayInfo(){
			NumberFormat formatter = NumberFormat.getNumberInstance(Locale.KOREA);
			System.out.println("---------------------");
			System.out.println("브랜드: " + brand);
			System.out.println("CPU: " + cpu);
			System.out.printf("RAM: %dGB\n", ramGB);
			System.out.printf("저장소: %dGB\n", storageGB);
			System.out.println("가격: " + formatter.format(price) + "원");
		}
	}
}

public class PConstructor {
	public static void main(String[] args) {
		System.out.println("--- Employee 클래스 테스트 ---");
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee("이순신");
		Employee employee3 = new Employee("신사임당", "개발팀");
		Employee employee4 = new Employee("이도", "기획팀", "팀장", 6000);
		
		employee1.displayInfo();
		System.out.println();
		
		employee2.displayInfo();
		System.out.println();
		
		employee3.displayInfo();
		System.out.println();
		
		employee4.displayInfo();
		System.out.println();
		
		Computer pc1 = new Computer();
		Computer pc2 = new Computer("Apple");
		Computer pc3 = new Computer("Samsung", "Intel i7");
		Computer pc4 = new Computer("LG", "AMd Ryzen 9", 32, 10000);
		//Computer pc5 = new Computer("Dell", "Intel i9", 64, 20000, 350);
		
		System.out.println("--- Computer 클래스 테스트 ---");
		
		pc1.displayInfo();
		System.out.println();
		
		pc2.displayInfo();
		System.out.println();
		
		pc3.displayInfo();
		System.out.println();
		
		pc4.displayInfo();
		System.out.println();
		
		//pc5.displayInfo();
		System.out.println();
		
		// Builder 패턴으로 Computer 객체 생성
		System.out.println("---- Builder 패턴으로 Computer 객체 생성 ----");
		
		Computer gaming = Computer.builder()
				.brand("ASUS ROG")
				.cpu("Intel i9-13900k")
				.ramGB(64)
				.storageGB(2000)
				.price(450000)
				.build();
		
		Computer office = Computer.builder()
				.brand("LG")
				.cpu("Intel i5-13900k")
				.ramGB(16)
				.storageGB(512)
				.price(890000)
				.build();
		
		// 일부 값만 설정
		Computer budget = Computer.builder()
				.brand("조립 PC")
				.ramGB(8)
				.storageGB(256)
				.build();
		
		
		gaming.displayInfo();
		office.displayInfo();
		budget.displayInfo();
	}
}