import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ex66 {
    public static void main(String[] args) {
        //콜렉션 프레임워크
        //1. 리스트 : List 인터페이스 구현 - ArrayList, LinkedList
        //2. 맵 : Map 인터페이스 구현 - HashMap
        //3. 셋 : Set 인터페이스 구현 - HashSet
        //ArrayList<String> fruits = new ArrayList<>();
        List<String> fruits = new ArrayList<>();
        fruits.add("사과");
        fruits.add("망고");
        fruits.add("딸기");
        System.out.println( fruits.size() );
        fruits.add(0, "레몬");
        fruits.remove( 1 ); //두번째 삭제
        Collections.sort( fruits );
        System.out.println( fruits );
        Collections.sort( fruits, Collections.reverseOrder() );
        System.out.println( fruits );
        //치환
        fruits.set( 1, "복숭아");
        System.out.println( fruits );
        //fruits.clear();
        System.out.println( fruits );
        //열거자 Interator
        Iterator<String> it = fruits.iterator();
        while (it.hasNext()){
            System.out.println( it.next() );
        }
        System.out.println( fruits.contains("망고") );
    }
}
