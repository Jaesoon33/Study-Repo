package chap05.array;


public class muiltiDimensionalArrays {
	public static void main(String[] args) {
		
		// 1. 2차원 배열 선언과 초기화
		/* 방법 1. 크기를 지정하여 생성
		 * 	- 모든 요소가 기본값(0)으로 초기화됨
		 *  - 장점: 나중에 값을 할당할 때 유용
		 */
		
//		int[][] matrix1 = new int[3][4];		// 3행 4열
//		
//		/*
//		 * 방법 2. 선언과 동시에 초기화 (가장 많이 사용)
//		 * 	- 중괄호 안의 각 배열이 하나의 행이 됨
//		 *  - 장점: 간결하고 직관적
//		 */
//		
//		int[][] matrix2 = {
//				{1, 2, 3, 4},		// 0번째 행
//				{5, 6, 7, 8},		// 1번째 행
//				{9, 10, 11, 12}		// 2번째 행
//		};
//		
//		/* 
//		 * 방법 3. new 키워드와 함께 초기화
//		 */
//		int[][] matrix3 = new int[][] {
//			{1, 2, 3},
//			{4, 5 ,6}
//		};
//		
		// 2차원 배열 접근 방법
		/*
		 * matrix[Row index][Column index]
		 * matrix.length --> ROW의 개수
		 * matrix[i].length --> i번째 행의 열 개수 
		 */
		
//		System.out.println("matrix2 행 개수: " + matrix2.length);
//		System.out.println("matrix2 0행의 열 개수: " + matrix2[0].length);
//		
		
		// 2. 2차원 배열 순회
		System.out.println("\n --- 2. 2차원 배열 순회 ---");
		
		int[][] scores = {
				{95, 88, 76},
				{82, 91, 78},
				{88, 85, 90}
		};
		
		/*
		 * 	방법 1: 일반 for문 (index 접근이 필요할 때)
		 *  	- 장점: index를 사용하여 위치 확인 가능, 값 수정 가능
		 *  	- 적절한 상황: 특정 위치의 값을 수정하거나 인덱스가 필요할 때
		 */
		System.out.println("일반 for문");
		for(int i = 0; i < scores.length; i++) {
			for(int j = 0; j < scores[i].length; j++)
				System.out.printf("scores[%d][%d] = %d\n", i, j, scores[i][j]);
		}
		
		
		/*
		 * 	방법 2: 향상된 for문 (읽기 전용)
		 * 	- 장점: 코드가 간결하고 가독성이 좋음
		 *  - 적합한 상황: 모든 요소를 순차적으로 읽을 떄
		 *  - 단점: 인덱스를 알 수 없고, 요소 수정이 어려움
		 */
		
		System.out.println("\n향상된 for문");
		for(int i = 0; i < scores.length; i++) {
			for(int a:scores[i])
				System.out.print(a + " ");
			System.out.println();
		};
		
		for(int[] row : scores) {		// row: 각 행(1차원 배열)
			for(int score : row) {		// score: 각 요소
				System.out.printf("%4d", score);
			}
			System.out.println();
		}
		
		// 3. 행별 합계, 열별 합계
		System.out.println("\n--- 3. 행별, 열별 합계 계산 ---");
		
		String[] students = {"이순신", "이도", "이방원"};
		String[] subjects = {"국어", "영어", "수학"};
		
		// 성적표 출력
		System.out.println("\n[ 성적표 ]");
		System.out.printf("%-8s", "이름");
		for(String subject : subjects) {
			System.out.printf("%6s", subject);
		}
		System.out.printf("%8s%8s\n", "총점", "평균");
		System.out.println("-".repeat(50));
		
		
		for(int i = 0; i < scores.length; i++) {
			System.out.printf("%-8s", students[i]);
			int rowSum=0;
			for(int j = 0; j < scores[i].length; j++) {
				System.out.printf("%6d", scores[i][j]);
				rowSum += scores[i][j];
			}
			System.out.printf("%8d%10.1f\n",rowSum, (double)rowSum/scores[i].length);
		}
		
		
		// 과목별 평균
		System.out.println("-".repeat(50));
		System.out.printf("%-6s", "과목평균");
		for(int i = 0; i < scores.length; i++) {	// 해당 열을 순회
			int sumCol = 0;
			for(int j = 0; j < scores[i].length; j++) {	// 해당 행을 순회
				sumCol += scores[j][i];	// 열의 값들을 순회
			}
			System.out.printf("%6.1f", ((double)sumCol / scores.length));
		}

	}
}
