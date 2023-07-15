package studentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUD {

    ArrayList<Student> std;
    Scanner sc = new Scanner(System.in);

    public StudentCRUD() {
        std = new ArrayList<>();

        Student std1 = new Student(01, "김철수", "컴퓨터공학", "사하구", 3.5);

        std.add(std1);
    }

    // insert
    public void insert(Student s) {
        std.add(s);
    }

    // delete
    public void delete(int index) {
        std.remove(index);
    }

    // select
    public Student select(int index) {
        return std.get(index);
    }

    // update
    public void update(int index, Student s) {
        std.set(index, s);
    }

    // 검색
    public int searchIndex() {
        int index = -1;
        System.out.print("학생의 이름을 입력하세요 : ");
        String name = sc.next();
        for (int i = 0; i < std.size(); i++) {
            if (std.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // 학생정보 입력
    public void studentInfoInsert() {

        Student std = new Student();

        while (true) {

            System.out.println("학생의 정보를 입력하세요~");

            System.out.print("학생의 학번을 입력하세요 : ");
            std.setStudentId(sc.nextInt());
            System.out.print("학생 이름을 입력하세요 : ");
            std.setName(sc.next());
            System.out.print("학생 학과를 입력하세요 : ");
            std.setDepartment(sc.next());
            System.out.print("학생 주소를 입력하세요 : ");
            std.setAddress(sc.next());
            System.out.print("학생 학점 입력하세요 : ");
            std.setCredit(sc.nextDouble());

            insert(std);

            System.out.println("입력된 학생의 정보가 저장되었습니다~");

            System.out.println("그만입력하시려면 0을입력해주세요~");
            if (sc.nextInt() == 0) break;
        }
    }

    // 학생정보 출력
    public void studentInfoOutput() {

        int index = searchIndex();

        if (index < 0) {
            System.out.println("찾는 학생이 없습니다!!");

        } else {
            System.out.println("학번 \t 이름 \t 학과 \t 주소 \t 학점");
            Student std = select(index);
            System.out.println(std);

            System.out.println();
            System.out.println("처음화면으로 돌아기시려면 숫자를 입력하세요~");
        }

    }

    // 전체 학생 정보 조회
    public void studentInfoAllOutput() {

        if (std.isEmpty())
            System.out.println("학생정보가 비어있습니다~");
        else {
            System.out.println("학번 \t 이름 \t 학과 \t 주소 \t 학점");
            for (int i = 0; i < std.size(); i++) {
                System.out.println(std.get(i).toString());
            }
        }
    }

    // 학생정보 수정
    public void studentInfoEdit() {

        int index = searchIndex();

        if (index == -1) {
            System.out.println("찾는 학생이 없습니다.");
        } else {
            Student s = new Student();
            s.setStudentId(std.get(index).getStudentId());
            s.setName(std.get(index).getName());
            s.setDepartment(std.get(index).getDepartment());
            s.setAddress(std.get(index).getAddress());
            s.setCredit(std.get(index).getCredit());

            System.out.println(std.get(index).getName() + "학생의 정보를 수정하세요");
            //학번은 일단 수정못하게
//            System.out.print("학번 : ");
//            s.setStudentId(sc.nextInt());
            System.out.print("이름 : ");
            s.setName(sc.next());
            System.out.print("학과 : ");
            s.setDepartment(sc.next());
            System.out.print("주소 : ");
            s.setAddress(sc.next());
            System.out.print("학점 : ");
            s.setCredit(sc.nextDouble());
            update(index, s);

        }

    }

    // 학생정보 삭제
    public void studentInfoDelete() {

        // 다른 값은 중복이 가능하여 학번만으로 제한 => 학번 중복 검사 필요!

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

            int index = searchIndex();
            String stdName;
            if (index == -1) {
                System.out.println("해당 학번을 가진 학생이 없습니다");
            } else {
                stdName = std.get(index).getName();
                delete(index);
                System.out.println(stdName + " 학생의 정보를 삭제했습니다.");
            }
        }
    }
}
