package studentManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMainView {
	public static void main(String[] args) {

		StudentController studentController = new StudentController();
		Scanner sc = new Scanner(System.in);

		try {
			while (true) {

				System.out.println("=============================");
				System.out.println("1. 학생정보입력, 2. 학생정보조회, 3. 전체학생정보조회, 4. 학생정보수정, 5. 학생정보삭제");
				System.out.println("(0을 입력하면 종료됩니다~)");

				int inputNumber = sc.nextInt();
				if (inputNumber == 0) {
					System.out.println("0이 입력되었으므로 종료됩니다.");
					return;
				}

				switch (inputNumber) {
				case 1:
					studentController.studentInfoInsert(); // 학생정보입력
					break;
				case 2:
					studentController.studentInfoOutput(); // 학생정보조회(1명)
					break;
				case 3:
					studentController.studentInfoAllOutput(); // 전체학생정보조회
					break;
				case 4:
					studentController.studentInfoEdit(); // 학생정보수정
					break;
				case 5:
					studentController.studentInfoDelete(); // 학생정보삭제
					break;
				default:
					System.out.println("1번 ~ 5번 사이 입력 부탁드립니다^^");
					break;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하세요~");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("오류 메세지를 확인하세여~");
			e.printStackTrace();
		}
	}
}
