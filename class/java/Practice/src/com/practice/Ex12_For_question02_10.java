package com.practice;

public class Ex12_For_question02_10 {
	public static void main(String[] args) {
		int j = 1;
		int k = 10;
		int i = 1;
		int sum = 0;
		// 단일 for문, 초기값과 끝값 때문에 j,k 선언했음
		for (i = j; i <= k; i++) {
			sum += i;
			if (i == k) {
				System.out.printf("%3d~%3d : %3d \n", j, k, sum);
				j += 10;
				k += 10;
				sum = 0;
			}
			if (k > 100)
				break;
		}

		System.out.println();

		int sum1 = 0;
		int p = 0;
		// 이중 for문
		for (int l = 1; l <= 100; l += 10) {
			for (p = l; p < l + 10; p++) {
				sum1 += p;
			}
			System.out.printf("%3d~%3d: %3d\n", l, p - 1, sum1);
			sum1 = 0;
		}

	}

}
