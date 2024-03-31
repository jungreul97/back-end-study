//전체 프로젝트에서 검색하기 CTRL + F(한파일에서),
// CTRL + SHIFT + F

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mini05 {
    static class Student{ // new 생성자 없이 그냥 생성가능함 static 클래스는
        private String name;
        private int kor;
        private int eng;
        private int math;
        //기본 생성자
        public Student(){

        }
        //매개변수 생성자
        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKor() {
            return kor;
        }

        public void setKor(int kor) {
            this.kor = kor;
        }

        public int getEng() {
            return eng;
        }

        public void setEng(int eng) {
            this.eng = eng;
        }

        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }
    }
    static List<Student> list = new ArrayList<>();
    public static void main(String[] args) {
        //1. 1차 객체배열 리스트을 통해 데이타를 관리한다.
        //2. 아래 콘솔과 같이 입력 및 출력되도록 한다.
        //-----------성적 관리 프로그램-------------**
        //1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 :1
        //이름 입력 : 홍길동
        //국어점수 입력 : 70
        //영어점수 입력 : 80
        //수학점수 입력 : 90
        Scanner scanner = new Scanner(System.in);
        while( true ){
            System.out.print("1.입력 2.전체출력 3.검색 4.수정 5.삭제 6.종료 :");
            int menu = scanner.nextInt();
            if( menu == 1 ) { //입력
                System.out.print("이름 입력:");
                String name = scanner.next();
                System.out.print("국어점수 입력:");
                int kor = scanner.nextInt();
                System.out.print("영어점수 입력:");
                int eng = scanner.nextInt();
                System.out.print("수학점수 입력:");
                int math = scanner.nextInt();
                Student student = new Student(name, kor, eng, math);
                list.add(student);
                System.out.println("총 "+list.size()+"개의 정보가 있습니다.");
            }
            else if( menu == 2 ){ //전체출력
                for(Student student : list){
                    printInfo( student );
                }
            }
            else if( menu == 3 ){ //이름으로 검색
                //이름 입력 : 변사또
                System.out.print("이름 입력:");
                String name = scanner.next();
                for(Student student : list){
                    if(student.name.equals( name ) ){
                        printInfo(student);
                        break;
                    }
                }
            }
            else if( menu == 4 ){
                //수정할 사람의 이름 : 홍길동
                //수정할 내용은? 1.국어 2.영어 3.수학 : 1
                //국어점수 수정 : 50
                System.out.print("수정할 이름 입력:");
                String name = scanner.next();
                Student foundStudent = null;
                for(Student student : list){
                    if(student.name.equals( name ) ){
                        foundStudent = student;
                        break;
                    }
                }
                System.out.print("수정할 내용은? 1.국어 2.영어 3.수학 :");
                int subMenu = scanner.nextInt();
                if( subMenu == 1 ){
                    System.out.print("국어점수 수정 :");
                    int kor = scanner.nextInt();
                    foundStudent.setKor( kor );
                }else if( subMenu == 2 ) {
                    System.out.print("영어점수 수정 :");
                    int eng = scanner.nextInt();
                    foundStudent.setEng( eng );
                }else if( subMenu == 3 ){
                    System.out.print("수학점수 수정 :");
                    int math = scanner.nextInt();
                    foundStudent.setMath( math );
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                System.out.println("수정되었습니다.");
                printInfo(foundStudent);
            }
            else if( menu == 5 ){ //삭제
                System.out.print("삭제할 이름 입력:");
                String name = scanner.next();
                int index = 0;
                for(Student student : list){
                    if(student.name.equals( name ) ){
                        //2개 삭제하면, 오류 발생
                        list.remove(index);
                        break;
                    }
                    index++;
                }
            }
            else if( menu == 6 ){ //종료
                System.out.println("종료!");
                break;
            }
        }//while(true)
    }//main 함수
    static void printInfo( Student s ){
        //이름: 홍길동 국어: 70 영어: 80 수학: 90 총점: 240 평균: 80.0
        int sum = s.kor + s.eng + s.math;
        int avr = sum / 3;
        System.out.println( "이름:"+s.name+" 국어:"+s.kor+" 영어:"+s.eng +
                            " 수학:"+s.math+" 총점:"+sum+" 평균:"+avr);
    }
}//class
