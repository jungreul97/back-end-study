package mini05;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    //데이터베이스 접속 객체
    Connection conn = null;
    //SQL 쿼리를 구현하는 객체
    Statement stmt = null;
    //쿼리에 대한 응답인 ResultSet을 가져오는 객체
    ResultSet rs = null;

    public StudentDAO(){
        try {
            //MariaDB 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            //데이터베이스 접속
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", //Host
                    "root", //사용자
                    "mysql" //암호
            );
        }catch (Exception e){
            e.printStackTrace();
            try {
                conn.close();
            } catch (Exception ex) {
                e.printStackTrace();
            }
        }
        if( conn != null) {
            System.out.println("데이터베이스 접속 성공!!");
        }
    }

    public int insert(StudentVO vo){
        int result = 0;
        try{
            String sql = "INSERT INTO STUDENT_SCORE (studentno, name, korean, english, math) "+
                    "VALUES ("+vo.getStudentno()+", '"+vo.getName()+"', "+
                    vo.getKorean()+", "+vo.getEnglish()+", "+vo.getMath()+")"; //세미콜론은 넣지 않는다!
            stmt = conn.createStatement();
            //정상수행되면 1을 리턴함.
            //insert,update,delete SQL문은 영향을 줄(ROW) 갯수를 반환함.
            result = stmt.executeUpdate(sql); //쿼리 수행!
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public StudentVO selectOne(String name){
        StudentVO vo = new StudentVO();

        try{
            String sql = "SELECT * FROM STUDENT_SCORE WHERE NAME='"+name+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if( rs.next() ) {
                vo.setStudentno(rs.getInt("studentno"));
                vo.setName(rs.getString("name"));
                vo.setKorean(rs.getInt("korean"));
                vo.setEnglish(rs.getInt("english"));
                vo.setMath(rs.getInt("math"));

            }
        }
        catch (Exception e){ e.printStackTrace(); }
        return vo;
    }
    public int update(StudentVO vo){
        int result = 0;
        try {
            String sql = "UPDATE STUDENT_SCORE SET name='" +
                    vo.getName()+"', korean="+vo.getKorean()+", english="+vo.getEnglish()+",math="+vo.getMath()+ " WHERE studentno="+vo.getStudentno();
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch (Exception e){ e.printStackTrace(); }
        return result;
    }
    public int delete(String name){
        int result = 0;
        try{
            String sql = "DELETE FROM STUDENT_SCORE WHERE NAME='"+name+"'";
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        }
        catch (Exception e){ e.printStackTrace(); }
        return result;
    }
    public List<StudentVO> list(){
        List<StudentVO> list = new ArrayList<>();
        try{
            String sql = "SELECT * FROM STUDENT_SCORE";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                StudentVO vo = new StudentVO();
                vo.setStudentno(rs.getInt("studentno"));
                vo.setName(rs.getString("name"));
                vo.setKorean(rs.getInt("korean"));
                vo.setEnglish(rs.getInt("english"));
                vo.setMath(rs.getInt("math"));
                list.add(vo);
            }
        }
        catch (Exception e){ e.printStackTrace(); }
        return list;
    }
    public void close(){
        if(conn != null ){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}