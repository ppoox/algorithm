package _06_gcd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String no;
    private String name;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    private static final String BOOLEAN_Y = "Y";
//    private static final String BOOLEAN_N = "N";
//
//    public static void main(String[] args) {
//        Student st1 = new Student();
//        st1.setNo("1682");
//        st1.setName("손오공");
//
//        Student st2 = new Student();
//        st2.setNo("1772");
//        st2.setName("저팔계");
//
//        Student st3 = new Student();
//        st3.setNo("1813");
//        st3.setName("사오정");
//
//        ArrayList<Student> list = new ArrayList<>();
//        list.add(st1);
//        list.add(st2);
//        list.add(st3);
//
//        for(Student stu : list) {
//            System.out.println(stu.getNo());
//            System.out.println(stu.getName());
//        }
//
//        Scanner scan = new Scanner(System.in);
//        List<String> result = new ArrayList<>();
//
//        while(true) {
//            System.out.println("검색을 계속 하시겠습니까 y, 종료하고싶으면 n");
//            String search = scan.next();
//
//            boolean flag = false;
//
//            if(BOOLEAN_Y.equals(search)) {
//                System.out.println("학생이름을 입력해주세요");
//                String name = scan.next();
//
//                for(Student st : list) {
//                    if(st.getName().equals(name)) {
//                        System.out.println("해당하는 학생의 이름은 " + st.getName());
//                        result.add(st.getName());
//                        flag = true;
//                    }
//                }
//
//            }else {
//                break;
//            }
//
//            if(!flag) {
//                System.out.println("해당하는 학생 이름이 없습니다.");
//            }
//        }
//        System.out.println("종료되었습니다.");
//    }
}
