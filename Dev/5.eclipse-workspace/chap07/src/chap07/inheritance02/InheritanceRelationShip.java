package chap07.inheritance02;


/*
 * 	클래스와 클래스간의 관계(RealtionShip)
 * 		1) is-a 관계 - 상속
 * 			- Circle/Rectangle/Triangle is a Shape | Square is a Rectangle
 * 		2) has-a 관계 - 집합
 * 			- SquareCalculator has a Shape
 */

/*
 * 	목표
 * 	  - 상속과 오버라이딩 활용해서 프로그램 구현
 * 	  - 다형성 개념 일부 경험하기 (배열)
 * 	  - 다단계 상속 이해하기
 * 	  - 객체 지향적 설계 이해
 * 
 *  구현
 *    - 다양한 도형의 넓이와 둘레를 계산하는 프로그램을 구현
 *    - 기본 도형(Shape) 클래스를 상속받아 원, 사각형, 삼각형, 정사각형을 만듬
 */

class Shape {
	String name;
	String color;
	
	public Shape(String name, String color) {
		//super();
		this.name = name;
		this.color = color;
	}
	
	public double getArea() {
		return 0;
	}
	
	public double getPerimeter() {
		return 0;
	}
	
	public String describe() {
		return color + "색 " + name;
	}
	
	public void printInfo() {
		System.out.println("----------------------------");
		System.out.println("  도형: " + describe());
		System.out.printf("  넓이: %.2f\n", getArea());
		System.out.printf("  둘레: %.2f\n", getArea());
		System.out.println("----------------------------");
	}
}

/*
 * 	 원 클래스 (Shape 상속)
 * 		- 넓이: PI * Radius * Radius
 * 		- 둘레: 2 * PI * Radius
 */

class Circle extends Shape {
	// 추가 필드
	double radius;

	// 생성자
	public Circle(String color, double radius) {
		super("원", color);		// 부모 생성자 호출, name 필드의 값을 parameter 값이 아니라 직접 값을 넣음
		this.radius = radius;	// Circle 고유 필드 초기화
	}
	
	@Override
	public double getArea() {
		System.out.println("    >> [Circle.getArea() 호출됨!]");  		// 동적 바인딩 확인용
		return Math.PI * radius * radius;
	}
	
	@Override
	public double getPerimeter() {
		System.out.println("    >> [Circle.getArea() 호출됨!]");  		// 동적 바인딩 확인용
		return Math.PI * radius * 2;
	}
	
	@Override
	public String describe() {
		return color + "색 원 (반지름: " + radius + ")";
	}
}

/*
 *	사각형 클래스 (Shape 상속)
 *		- 넓이 = width * height, 둘레 = 2 * width + 2 * height 
 */

class Rectangle extends Shape {
	// 추가 필드
	double width;
	double height;
	
	public Rectangle(String color, double width, double height) {
		super("사각형", color);		// 부모 생성자 호출
		this.width = width;
		this.height = height;
	}
	
	@Override
	public double getArea() {
		System.out.println("    >> [Rectangle.getArea() 호출됨!]");  		// 동적 바인딩 확인용
		return width * height;		
	}
	
	@Override
	public double getPerimeter() {
		System.out.println("    >> [Rectangle.getArea() 호출됨!]");  		// 동적 바인딩 확인용
		return 2 * (width + height);
	}
	
	@Override
	public String describe() {
		return color + "색 사각형 (" + width + ", " + height + ")";
	}
}

/*
 * 	삼각형 클래스
 * 		- 넓이 = 0.5 * 밑변 * 높이
 * 		- 둘레 = 세 변의 합(side_v)
 */
class Triangle extends Shape {
	// 추가 필드
	double base;
	double height;
	double side1, side2, side3;
	
	// 생성자
	public Triangle(String color, double base, double height, double side1, double side2, double side3) {
		super("삼각형", color); 	// 부모 생성자 호출
		this.base = base;		// 밑변
		this.height = height;	// 높이
		this.side1 = side1;		// 세 변의 길이
		this.side2 = side2;
		this.side3 = side3;
	}

	@Override
	public double getArea() {
		System.out.println("    >> [Triangle.getArea() 호출됨!]");  		// 동적 바인딩 확인용
		return base * height * 0.5;
	}
	
	@Override
	public double getPerimeter() {
		System.out.println("    >> [Triangle.getArea() 호출됨!]");  		// 동적 바인딩 확인용
		return side1 + side2 + side3;
	}
	
	@Override
	public String describe() {
		return color + "색 삼각형";
	}
}

// square 정사각형
//		- width와 height에 같은 값을 넣어 정사각형을 구함

class Square extends Rectangle {
	
	// 생성자
	public Square(String color, double side) {
		super(color, side, side);
	}
	
	@Override
	public String describe() {
		return color + "색 정사각형, 한 변: " + width + ")";
	}
}


/*
 * 	객체들을 관리하는 클래스
 * 		- 도형값들을 계산
 * 		- 다형성
 */
class ShapeCalculator {
	Shape[] shapes;		// 도형 저장 배열 (다형성: Circle, Rectangle 등 모두 저장 가능)
	int count; 			// 현재 저장된 도형 개수
	
	public ShapeCalculator(int maxShapes) {
		this.shapes = new Shape[maxShapes];	 // 최대 maxShapes개의 배열 생성
		this.count = 0;  // 초기 도형의 개수는 0
	}
	
	// 도형 추가 메서드
	public void addShape(Shape shape) {
		if(count < shapes.length) {		// 배열에 빈 공간이 있으면
			shapes[count] = shape;		// 객체를 배열에 저장
			count ++;					// count 증가 --> 인스턴스 필드이므로 값이 유지 됨			
		}
		else {
			System.out.println("더 이상 도형을 추가할 수 없습니다.");
		}
	}
	
	// 모든 도형 정보 출력
	public void printAllShapes() {
		for(int i = 0; i < count; i++) {
			shapes[i].printInfo();		// 다형성: 각 도형 타입에 맞는 printInfo() 호출
			shapes[i].describe();
		}
	}
	
	// 모든 도형의 넓이 합계
	public double getTotalArea() {
		double total = 0;
		for(int i = 0; i < count; i++) {
			total += shapes[i].getArea();	// 다형성: 각 도형 타입에 맞는 getArea() 호출 후 합산
		}
		return total;
	}
	
	// 모든 도형의 둘레 합계
	public double getTotalPerimeter() {
		double total = 0;
		for(int i = 0; i < count; i++) {
			total += shapes[i].getPerimeter();	// 다형성: 각 도형 타입에 맞는 getArea() 호출 후 합산
		}
		return total;
	}
	
	public void printSummary() {
		System.out.println("================================");
		System.out.printf("    총 도형 수: %d개\n", count);
		System.out.printf("    총 넓이: %.2f\n", getTotalArea());
		System.out.printf("    총 둘레: %.2f\n", getTotalPerimeter());
		System.out.println("================================");
	}
	
}



public class InheritanceRelationShip {
	public static void main(String[] args) {
		ShapeCalculator calculator = new ShapeCalculator(10);
		
		System.out.println("▶테스트 1: 도형 생성 및 추가");
		System.out.println("----------------------------");
		
		// 원 객체
		Circle circle = new Circle("빨간", 5);
		calculator.addShape(circle);
		System.out.println("원 추가 완료");
		
		// 사각형 객체
		Rectangle rectangle = new Rectangle("파란", 4, 6);
		calculator.addShape(rectangle);
		System.out.println("사각형 출력 완료");
		
		// 정사각형 객체
		Square square = new Square("초록", 5);
		calculator.addShape(square);
		System.out.println("정사각형 출력 완료");
		
		// 삼각형 객체
		Triangle triangle = new Triangle("노란", 6, 4, 5, 5, 6);
		calculator.addShape(triangle);
		System.out.println("삼각형 출력 완료");
		
		calculator.printAllShapes();  // count = 4 유지 --> 4개 도형 모두  ㄹ
		
		System.out.println("▶테스트 2: 개별 도형 정보");
		System.out.println("----------------------------");
		
		circle.printInfo();
		rectangle.printInfo();
		square.printInfo();
		triangle.printInfo();
		
		calculator.printSummary();
		
		System.out.println("▶테스트 3: 업캐스팅");
		System.out.println("----------------------------");
		
		// 업캐스팅: 자식 객체를 부모 타입 변수에 저장
		Shape shape1 = new Circle("보라", 3);		// Circle  -->  Shape  (자동)
		Shape shape2 = new Rectangle("분홍", 2, 4);
		
		System.out.println("★ 다형성: 같은 printInfo()메서드, 다른결과!");
		shape1.printInfo();
		shape2.printInfo();

		System.out.println("▶테스트 4: 다운캐스팅");
		System.out.println("----------------------------");
		
		// 다운캐스팅: 부모타입 --> 자식 타입 (명시적 변환 필요)
		
		// 방법1: 전통적인 방식 (instanceof + 캐스팅)
		System.out.println("방법1: 전통적인 방식 (instanceof + 캐스팅)");
		System.out.println("----------------------------");
		if(shape1 instanceof Circle) {		// 타입을 체크
			Circle c = (Circle)shape1;		// 다운 캐스팅: Shape --> Circle
			System.out.println("원의 반지름: " + c.radius);	// Circle 클래스의 멤버 접근 가능
		}
		
		// 방법2: Java 16+ 패턴 매칭 (더 간결)
		System.out.println("방법2: Java 16+ 패턴 매칭 (더 간결)");
		if(shape2 instanceof Rectangle rect) {
			System.out.println("사각형 가로: " + rect.width + ", 세로" + rect.height);
		}
		
		// 잘못된 다운캐스팅의 예 --> shape2는 실제로 Rectangle이므로 Circle로 캐스팅 불가
//		 Circle wrongCast = (Circle)shape2;
		
		// 모두 Shape 타입 변수지만, 실제 객체에 따라 다른 메서드 실행
		
		System.out.println("▶테스트 5: 동적 바인딩 (Dynamic Binding)");
		System.out.println("--------------------------------------");	
		System.out.println("★ 핵심: 참조 타입이 아닌 실제 객체의 메서드가 호출된다!\n");
		
		// 모두 Shape 타입 변수지만, 실제 객체에 따라 다른 메서드 실행
		Shape[] testShapes = {
			new Circle("빨강", 2),			// 실제 객체: Circle
			new Rectangle("파랑", 3, 4),		// 실제 객체: Rectangle
			new Square("초록", 5),			// 실제 객체: Square
			new Triangle("노랑", 6, 4, 5, 5, 6)  // 실제 객체: Triangle
		};
		
		System.out.println("변수 타입은 모두 Shape이지만, getArea()는 각 객체의 메서드 호출!\n");
		
		for(Shape s : testShapes) {		// array form -> available to use for-each sentence 
			System.out.println(" " + s.describe() + " -> getArea() 호출:");
			double area = s.getArea();		// 동적 바인딩 --> 어떤 클래스의 메서드가 호출되는지 출력됨
			System.out.printf("      결과 = %.2f%n%n", area);
		}
		
		
				
		
			
	}
}
