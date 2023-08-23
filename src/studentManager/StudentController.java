package studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {

	Student student = new Student();
	ArrayList<Student> std;
	Scanner sc = new Scanner(System.in);

	private int studentId; // 학번
	private String name; // 학생 이름
	private String department; // 학과
	private String address; // 주소
	private double credit; // 학점

	public StudentController() {
		std = new ArrayList<>();

		Student std1 = new Student(1, "김철수", "컴퓨터공학", "서울특별시 강남구 대치동 123-12", 3.5);
		Student std2 = new Student(2, "민철기", "통신공학", "부산광역시 해운대구 센텀동로41, 7층 백양산(우동, 센텀벤처타운)", 2.5);

		std.add(std1);
		std.add(std2);
	}

	// 학생정보 입력
	public void studentInfoInsert() {

		while (true) {

			System.out.println("학생의 정보를 입력하세요~");

			System.out.print("학생의 학번을 입력하세요 : ");
			studentId = sc.nextInt();

			// 학번 중복 검사
			for (Student student : std) {
				if (student.getStudentId() == studentId) {
					System.out.println("이미 존재하는 학번입니다~!");
					return;
				}
			}

			System.out.print("학생 이름을 입력하세요 : ");
			name = sc.next();
			System.out.print("학생 학과를 입력하세요 : ");
			department = sc.next();
			sc.nextLine(); // nextLine 문제 임시조치
			System.out.print("학생 주소를 입력하세요 : ");
			address = sc.nextLine();
			System.out.print("학생 학점을 입력하세요 : ");
			credit = sc.nextDouble();

			std.add(new Student(studentId, name, department, address, credit));
			System.out.println("입력된 학생의 정보가 저장되었습니다~");

			System.out.println("계속입력하시겠습니까? 그만입력하시려면 0을 입력해주세요~");
			if (sc.nextInt() == 0)
				break;
		}
	}

	// 학생정보 출력
	public void studentInfoOutput() {

		System.out.println("이름을 입력하세여~!");
		String searchName = sc.next();
		System.out.println("학번을 입력하세여~!");
		int searchId = sc.nextInt();

		if (std.isEmpty()) {
			System.out.println("학생정보가 비어있습니다");
			return;
		}

		for (Student student : std) {
			if (!(student.getStudentId() == searchId && student.getName().equals(searchName))) {
				System.out.println("찾는 학생이 없습니다!!");
				break;

			} else {
				// System.out.println("학번 이름 \t 학과 \t\t\t\t 주소\t\t\t\t 학점");

				// System.out.println(student.getStudentId() + student.getName());
				System.out.println("학번 \t 이름 \t 학과 \t\t 주소 \t\t\t\t\t 학점");

				if (student.getStudentId() == searchId && student.getName().equals(searchName)) {
					System.out.println(student.getStudentId() + "\t" + student.getName() + "\t"
							+ student.getDepartment() + "\t" + student.getAddress() + "\t" + student.getCredit());
				}

				System.out.println();
			}
		}
	}

	// 전체 학생 정보 조회
	public void studentInfoAllOutput() {

		if (std.isEmpty())
			System.out.println("학생정보가 비어있습니다~");
		else {
			System.out.println("학번 \t 이름 \t 학과 \t\t 주소 \t\t\t\t\t 학점");
			// System.out.println("학번 \t 이름 \t 학과 \t\t 주소 \t\t 학점");

			for (int i = 0; i < std.size(); i++) {
				System.out.println(std.get(i).toString());
			}
		}
	}

	// 학생정보 수정
	public void studentInfoEdit() {

		System.out.print("수정할 학생의 이름을 입력하세요 : ");
		String updateName = sc.next();
		System.out.print("수정할 학생의 학번을 입력하세요 : ");
		int updateId = sc.nextInt();

		for (int i = 0; i < std.size(); i++) {
			student = std.get(i);

			if (!(student.getName().equals(updateName) && student.getStudentId() == updateId)) {
				System.out.println("찾는 학생이 없습니다.");

			} else {
				System.out.println(std.get(i).getName() + "학생의 정보를 수정하세요");
				// 학번은 수정못하게
				// System.out.print("학번 : ");
				// s.setStudentId(sc.nextInt());

				System.out.println("혹시 개명하셨으면 \"ok\" 누르세요 그러면 이름 변경 가능해여~ 아니면 아무자판클릭하세여");

				if (sc.next().equals("ok")) {
					System.out.print("이름 : ");
					std.get(i).setName(sc.next());
				}

				System.out.print("학과 : ");
				std.get(i).setDepartment(sc.next());
				// s.setDepartment(sc.next());
				sc.nextLine();
				System.out.print("주소 : ");
				std.get(i).setAddress(sc.nextLine());
				// s.setAddress(sc.nextLine());
				System.out.print("학점 : ");
				std.get(i).setCredit(sc.nextDouble());
				// s.setCredit(sc.nextDouble());
				// std.set(i, s);
				System.out.println(std.get(i).getName() + " 학생의 정보가 변경되었습니다.");
			}
		}
	}

	// 학생정보 삭제
	public void studentInfoDelete() {

		if (std.isEmpty()) {
			System.out.println("입력되어 있는 학생이 아무도 없습니다!!");
			return;
		}

		System.out.println("값을 전체 삭제하려면 0, 부분 삭제하려면 이외의 값 입력하세요 ~");
		int num = sc.nextInt();

		if (num == 0) {
			System.out.println("진짜 모두 삭제할건가요? 그러면 \"yes\" 입력");
			String yes = sc.next();

			if (yes.equals("yes")) {
				std.clear();
				System.out.println("학생정보가 모두 삭제 되었습니다 ㅠㅠ");

			} else {
				System.out.println("전체 삭제가 취소되었습니다^^");
			}

		} else {
			System.out.print("삭제할 학생의 이름을 입력하세요 : ");
			String deleteName = sc.next();
			System.out.print("삭제할 학생의 학번을 입력하세요 : ");
			int deleteId = sc.nextInt();

			for (int i = 0; i < std.size(); i++) {
				student = std.get(i);

				if (!(student.getName().equals(deleteName) && student.getStudentId() == deleteId)) {
					System.out.println("해당하는 이름의 학생이 없습니다");
					System.out.println("해당하는 학번의 학생이 없습니다");
					break;
				}

				if ((student.getName().equals(deleteName) && student.getStudentId() == deleteId)) {
					std.remove(i);
					System.out.println(student.getName() + " 학생의 정보를 삭제했습니다.");
					break;
				}
			}
		}
	}
}
