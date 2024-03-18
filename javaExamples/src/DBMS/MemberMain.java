package DBMS;

import java.util.List;

public class MemberMain {
    public static void main(String[] args) {
        //dao 객체 생성
        MemberDAO dao = new MemberDAO();

        // 레코드 추가
//        MemberVO vo = new MemberVO();
//        vo.setMemberno(5);
//        vo.setId("min");
//        vo.setName("김민재");

//        int result = dao.insert(vo);
//        if (result > 0){
//            System.out.println("회원 등록 성공!");
//        }else{
//            System.out.println("회원 등록 실패!");
//        }

        List<MemberVO> list = dao.list();
        for (MemberVO  member : list){
            System.out.println("회원번호 : "+member.getMemberno());
            System.out.println("회원아이디 : "+member.getId());
            System.out.println("회원이름 : "+member.getName());
        }
        // 단건 조회
        MemberVO member = dao.selectOne(3);
        System.out.println("회원번호 : "+member.getMemberno());
        System.out.println("회원아이디 : "+member.getId());
        System.out.println("회원이름 : "+member.getName());

        // 삭제
        int result = dao.delete(5);
        if(result > 0){
            System.out.println("삭제 성공");
        }else{
            System.out.println("삭제실패");
        }

        //자원 해제
        dao.close();
    }
}