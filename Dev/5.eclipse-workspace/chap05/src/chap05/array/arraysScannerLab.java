package chap05.array;

import java.util.Scanner;



public class arraysScannerLab {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int arraySize;
		System.out.println("=== 배열 실습 (Scanner 버전) === \n\n");
		// 1. 배열 생성 및 값 입력
		System.out.println("--- 1. 배열 생성 및 값 입력 ---");
				
//		System.out.print("배열의 크기를 입력하세요: ");
//		while(!input.hasNextInt()) {
//			System.out.print("잘못된 입력입니다.");
//			System.out.print(" 정수를 입력하세요: ");
//			input.next();
//		}
//		
//		arraySize = input.nextInt();
//		while(arraySize <= 0) {
//			System.out.print("배열 크기는 1 이상이어야 합니다.\n");
//			System.out.print("배열의 크기를 입력하세요: ");
//			input.next();
//		}		
//		arraySize = input.nextInt();
		
		
//		int status = 1;
//		do {
//			arraySize = input.nextInt();
//			
//			
//			if(!input.hasNext())
//				status = 1;
//			if(arraySize <= 0)
//				status = 2;
//			else
//				status = 0;
//			
//			if(status == 1) {
//				System.out.print("잘못된 입력입니다.");
//				System.out.print(" 정수를 입력하세요: ");
//				input.next();
//			}
//			while(status == 2) {
//				System.out.print("배열 크기는 1 이상이어야 합니다.\n");
//				System.out.print("배열의 크기를 입력하세요: ");
//				input.next();
//			}
//		}while(status != 0);	
		
		while(true) {
			System.out.print("배열의 크기를 입력하세요: ");
			while(!input.hasNextInt()) {
				System.out.print("잘못된 입력입니다. 정수를 입력하세요: ");
				input.next();
			}
			arraySize = input.nextInt();
			
			if(arraySize > 0) {
				break;
			}
			System.out.println("배열 크기는 1 이상이어야 합니다.");
		}
			
			
		int arrays[] = new int[arraySize];
		
		System.out.printf("%d개의 정수를 입력하세요: \n", arraySize);
		for(int i = 0; i < arrays.length; i++) {
			System.out.printf("numbers[%d] = ", i);
			while(!input.hasNextInt()) {
				System.out.print("잘못된 입력입니다.");
				System.out.print(" 정수를 입력하세요: ");
				input.next();
			}
			arrays[i] = input.nextInt();
		}
		System.out.println();
		System.out.print("입력된 배열: ");
		for(int i = 0; i < arrays.length; i++)
			System.out.print(arrays[i] + " ");
		System.out.println();
		
		// 2. 합계와 평균 계산
		System.out.println("\n--- 2. 합계와 평균 계산 ---");
		
		int sum = 0;
		for(int i:arrays) {
			sum += i;
		}
		System.out.println("합계: " + sum);
		System.out.printf("평균: %.2f\n",((double)sum/arrays.length));
		
		// 3. 최대값과 최소값 찾기
		System.out.println("\n--- 3. 최대값과 최소값 찾기 ---");
		int max = arrays[0];		// 현재까지 발견된 최대값
		int min = arrays[0];		// 현재까지 발견된 최소
		int maxIndex = 0;			// 최대값이 위치한 인덱스
		int minIndex = 0;			// 최소값이 위치한 인덱스
		
		for(int i = 1; i < arrays.length; i++) {
			if(arrays[i] > max) {		// 최대값 갱신 (현재 요소가 기존 최대값보다 큰 경우)
				max = arrays[i];
				maxIndex = i;
			}
			if(arrays[i] < min) {		// 최소값 갱신 (현재 요소가 기존 최소값보다 작은 경우)
				min = arrays[i];
				minIndex = i;
			}
		}
		System.out.println("최대값: " + max + " (인덱스: " + maxIndex + ")");
		System.out.println("최소값: " + min + " (인덱스: " + minIndex + ")");
		
		
		input.close();
	}
}
