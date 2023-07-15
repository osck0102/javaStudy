package studentManager;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {

        StudentCRUD studentCRUD = new StudentCRUD();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("=============================");
            System.out.println("1. 학생정보입력, 2. 학생정보조회, 3. 학생정보전체조회, 4. 학생정보수정, 5. 학생정보삭제");
            System.out.println("(0을 입력하면 종료됩니다~)");

            int inputNumber = sc.nextInt();
            if (inputNumber == 0) {
                System.out.println("0이 입력되었으므로 종료됩니다.");
                return;
            }

            switch (inputNumber) {
                case 1:
                    studentCRUD.studentInfoInsert();
                    break;
                case 2:
                    studentCRUD.studentInfoOutput();
                    break;
                case 3:
                    studentCRUD.studentInfoAllOutput();
                    break;
                case 4:
                    studentCRUD.studentInfoEdit();
                    break;
                case 5:
                    studentCRUD.studentInfoDelete();
                    break;
                default:
                    break;
            }
        }
    }
}
