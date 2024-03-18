public class ex54 {
    public static void main(String[] args) {
        // 예외처리 Exception Handling
        // : 예상치못한 오류 - 개발/실행단계에서 처리가능함.

        // 1. try-catch (finally)
        // 2. throws 구문

        // 패턴
        // try {
        //      예외가 발생할 만한 코드 예) 통신, I/O, 스레드, 연산, 배열 인덱스 오류
        // }
        // catch( 예외클래스 객체 ){
        //      예외발생시 처리하는 실행문 - 예외내용 출력 또는 메모리 정리
        // }

        String name = null; // 널 null : 값이 없다. 존재하지 않음, 연산불가.
        System.out.println( name ); // null
        System.out.println(name.toLowerCase());

        try{
            System.out.println(name.toLowerCase());
        }catch (Exception e){
            // 예외 내용 출력
            System.out.println(e.getMessage());
            // 예외 경로 출력
            e.getStackTrace();
        }
        System.out.println("여기~");
    }
}
