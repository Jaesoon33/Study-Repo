package chap06.overload;

class Printer {	
	void print(int value) {
		System.out.println("정수: " + value);
	}
	
	void print(double value) {
		System.out.println("실수: " + value);
	}
	
	void print(String value) {
		System.out.println("문자열: " + value);
	}
	
	void print(boolean value) {
		System.out.println("불리언: " + value);
	}
	
	
	// int형 배열 출력
	void print(String value, int times) {
		for(int i = 0; i < times; i++)
			System.out.println(value);
	}
	
	void print(int[] value) {
		System.out.print("배열: [");
		for(int i = 0; i < value.length; i++) {
			if(! (i + 1 == value.length))
				System.out.print(value[i] + ", ");
			else
				System.out.print(value[i]);
		}
		System.out.print("]");
	}
}

class Advancedcalculaotr {
	int add(int a, int b){
		return a + b;
	}
	
	int add(int a, int b ,int c){
		return a + b + c;
	}
	
	double add(double a, double b){
		return a + b;
	}
	
	int add(int... numbers) {
		int sum = 0;
		for(int n : numbers) {
			sum += n;
		}
		return sum;
	}
	
	int multiply(int a, int b) {
		return a * b;
	}
	
	double multiply(double a, double b) {
		return a * b;
	}
	
	int multiply(int arr[]) {
		int temp = 1;
		for(int i = 0; i < arr.length; i++) {
			temp *= arr[i];
		}
		return temp;
	}
	
	double average(double a, double b) {
		return (a + b) / 2;
	}
	
	double average(double a, double b, double c) {
		return (a + b + c) / 3;
	}
	
	double average(int[] arr) { 	// double로 파라미터값을 받으면 아래 가변인자 사용하는 메서드랑 중복됨
									// 가변길이의 double 타입의 인자들을 파라미터로 받기 때문
		double total = 0;
		for(int i = 0; i < arr.length; i++)
			total += arr[i];
		return total/arr.length;
	}
	
	double average(double...numbers) {
		double sum = 0;
		double temp = 0;
		for(double d : numbers) {
			sum += d;
			temp ++;
		}
		return sum / temp;
	}
	
}


		


public class MethodOverloading {
	public static void main(String[] args) {
		System.out.println("-------------------------------");
		System.out.println("          메서드 오버로딩          ");
		System.out.println("-------------------------------");
		
		System.out.println("------ 1. Printer 오버로딩 ------\n");
		
		Printer printer = new Printer();
		printer.print(42);
		printer.print(3.14);
		printer.print("Hello, Java!");
		printer.print("반복 출력", 3);
		
		int[] array = {1, 2, 3, 4, 5};
		printer.print(array);
		System.out.println();
		
		
		Advancedcalculaotr calc = new Advancedcalculaotr();
		
		System.out.println("add(1, 2) = " + calc.add(1, 2));
		System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));
		System.out.println("add(1.5, 2.5) = " + calc.add(1.5, 2.5));
		System.out.println("add(1, 2, 3, 4, 5) = " + calc.add(1, 2, 3, 4, 5));
		System.out.println();
		
		System.out.println("multiply(3, 4) = " + calc.multiply(3, 4));
		System.out.println("multiply(2.5, 4.0) = " + calc.multiply(2.5, 4.0));
		System.out.println("multiply([2, 3, 4]) = " + calc.multiply(new int[] {2, 3, 4}));
		System.out.println();
		
		System.out.println("average(80, 90) = " + calc.average(80, 90));
		System.out.println("average(70, 80, 90) = " + calc.average(70, 80, 90));
		System.out.println("average([85, 90, 78, 92]) = " + calc.average(new double[] {85, 90, 78, 92}));
		System.out.println("average(85.5, 90.0, 78.5, 92.0) = " + calc.average(85.5, 90.0, 78.5, 92.0));
	}
}
