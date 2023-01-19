// 숫자야구게임 만들기
package quiz04_230113;

import java.util.Scanner;

public class Quiz230113 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int strike = 0;
		int ball = 0;
		
		int[] answer;
		answer = new int[3];
		
		while(true) {
			for(int i = 0; i < answer.length; i++) {
				answer[i] = (int)(Math.random() * 9) + 1;
				
				if(i == 1 && answer[i] == answer[i - 1]) {
					i--;
					continue;
				}
				
				if(i == 2 && (answer[i] == answer[i - 1] || answer[i] == answer[i - 2])) {
						i--;
						continue;
				}
			}
	//			System.out.println("정답 배열 : { " + answer[0] + ", " + answer[1] + ", " + answer[2] + " }");
			
				System.out.println("**************************************");
				System.out.println("           !숫자 야구 게임!       ");
				System.out.println("**************************************");
				System.out.println(" 1 ~ 9 사이의 숫자를 3개 입력하세요! ");
				System.out.println("**************************************");
				System.out.println("   새 게임 : 0 입력, 종료 : 10 입력 ");
				System.out.println("**************************************");
				
				
				System.out.print(" >> 첫 번째 숫자 : ");
	
				int num1 = scanner.nextInt();
	
				if(num1 == 10) {
					System.out.println("=====================================");
					System.out.println("        게임이 종료되었습니다.");
					System.out.println("=====================================");
					System.out.println("          새 게임 : 0 입력");
					System.out.println("=====================================");
					System.out.print(">> 0을 입력하세요 : ");
					int num4 = scanner.nextInt();
					if(num4 == 0) {
						continue;
					} else {
						return;
					}
				}
				if(num1 == 0) {
					System.out.println("=====================================");
					System.out.println("         새 게임을 시작합니다.");
					System.out.println("=====================================");
					continue;
				}
				
				if(num1 < 1 && num1 > 10) {
					System.out.println("입력한 숫자가 조건에 맞지 않습니다. 1 ~ 9 사이의 숫자를 입력하세요!");
					num1 = scanner.nextInt();
					System.out.println();
				}
				
				System.out.print(" >> 두 번째 숫자 : ");
				int num2 = scanner.nextInt();
				
				if(num2 == 10) {
					System.out.println("=====================================");
					System.out.println("        게임이 종료되었습니다.");
					System.out.println("=====================================");
					System.out.println("        새 게임 하려면 : 0 입력");
					System.out.println("=====================================");
					System.out.print(">> 0을 입력하세요 : ");
					int num4 = scanner.nextInt();
					if(num4 == 0) {
						continue;
					} else {
						System.out.println("=====================================");
						System.out.println("        완전히 종료되었습니다.");
						System.out.println("=====================================");
						return;
					}
				}
				if(num2 == 0) {
					System.out.println("=====================================");
					System.out.println("         새 게임을 시작합니다.");
					System.out.println("=====================================");
					continue;
				}
			
				if(num1 == num2) {
					System.out.println("이전에 입력한 숫자와 중복됩니다. 다른 숫자를 입력하세요!");
					num2 = scanner.nextInt();
					System.out.println();
				} else {
					System.out.print(" >> 세 번째 숫자 : ");
					int num3 = scanner.nextInt();
					
					if(num3 == 10) {
						System.out.println("=====================================");
						System.out.println("        게임이 종료되었습니다.");
						System.out.println("=====================================");
						System.out.println("          새 게임 : 0 입력");
						System.out.println("=====================================");
						System.out.print(">> 0을 입력하세요 : ");
						int num4 = scanner.nextInt();
						if(num4 == 0) {
							continue;
						} else {
							return;
						}
					}
					if(num3 == 0) {
						System.out.println("=====================================");
						System.out.println("         새 게임을 시작합니다.");
						System.out.println("=====================================");
						continue;
					}
					
					if(num3 == num2 || num3 == num1) {
						System.out.print("이전에 입력한 숫자와 중복됩니다. 다른 숫자를 입력하세요!");
						num3 = scanner.nextInt();
						System.out.println();
					} else {
						if(answer[0] == num1) {
							strike += 1;
						}
						if(answer[1] == num2) {
							strike += 1;
						}
						if(answer[2] == num3) {
							strike += 1;
						}
						if(answer[0] == num2 || answer[0] == num3) {
							ball += 1;
						}
						if(answer[1] == num1 || answer[1] == num3) {
							ball += 1;
						}
						if(answer[2] == num1 || answer[2] == num2) {
							ball += 1;
						}
						System.out.println("======================================");
						System.out.println(" 결과는 " + strike + " 스트라이크 " + ball + " 볼 입니다!");
						System.out.println("======================================");
					}
				}
			}
		}
	}

