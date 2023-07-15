package studentManager;

public class Student {

    private int studentId;  // 학번
    private String name;    // 학생 이름
    private String department;  // 학과
    private String address; // 주소
    private double credit; // 학점

    public Student() {

    }

    public Student(int studentId, String name, String department, String address, double credit) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.address = address;
        this.credit = credit;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return " " + studentId + " \t " + name + "\t " + department + "\t " + address + "\t " + credit;
    }
}

