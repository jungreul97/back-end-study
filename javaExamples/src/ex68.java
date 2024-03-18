import java.util.*;

public class ex68 {
    public static void main(String[] args) {
        //맵 Map
        //    : 키와 값으로 된 데이터 구조
        //    : JSON, XML 데이터 구조와 연결 역할
        //    : 인덱스 없고 순서 없음

        //  키-문자열  값타입
        Map<String, String> map = new HashMap<>();
        map.put("username", "hong");
        map.put("password", "1234");
        System.out.println( map );

        System.out.println( map.get("username") );
        System.out.println( map.get("password") );

        //for each
        for( String key: map.keySet() ){
            System.out.println( map.get( key ) );
        }
        //이터레이터
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            System.out.println(map.get(it.next()));
        }

        //연습문제
        //1.
        //1.names라는 arrayList를 만들고
        //2."홍길동", "사임당", "이순신", "변사또" 추가하고,
        //3.맨앞에 "춘향이" 추가하고
        //4."사임당"삭제하고
        //5.arrayList 갯수 size()함수를 이용하여 출력하고
        //6."홍길동"을 "제임스"로 변경하시오. set함수
        //7.오름차순 정렬하시오.
        //8.내림차순 정렬하시오.
        ArrayList<String> names = new ArrayList<>();
        names.add("홍길동");
        names.add("사임당");
        names.add("이순신");
        names.add("변사또");
        System.out.println( names );
        names.add(0,"춘향이");
        System.out.println( names );
        names.remove(2);
        System.out.println( names );
        System.out.println( names.size() );
        System.out.println( names );
        names.set(1, "제임스");
        System.out.println( names );
        Collections.sort( names );
        System.out.println( names );
        Collections.sort( names, Collections.reverseOrder() );
        System.out.println( names );
        //2.
        //철수라는 학생이 데이타를 맵으로 설정해 보자.
        //map의 이름은 student라 하고
        //키값 age : 값 20
        //키값 height : 값 170
        //키값 name : "배철수" 로 데이타를 설정후
        //모든 Key Value를 출력하시오.
        //1.향상된 for문 사용
        //2.이터레이터 사용
        Map<String, String> student = new HashMap<>();
        student.put("age", "20");
        student.put("height", "170");
        student.put("name", "배철수");
        Set<String> keys2 = student.keySet();
        for(String key : keys2){
            System.out.println( student.get( key) );
        }
        it = keys2.iterator();
        while( it.hasNext() ) {
            String key = it.next();
            System.out.println( student.get(key) );
        }
    }
}
