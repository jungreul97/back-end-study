import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ex65 {
    public static void main(String[] args) {
        //날짜관련 클래스
        //Date => LocalDate, LocalTime, LocalDateTime
        // JDK 1.8이상 지원
        //LocalDate : 날짜
        //LocalTime : 시간
        //LocalDateTime : 날짜시간

        LocalDate now = LocalDate.now(); //현재 날짜 가져옴
        System.out.println( now );
        LocalDate birthDay = LocalDate.of(2000, 12, 1);
        System.out.println( birthDay );
        LocalDate xmas = LocalDate.parse("2023-12-25");
        System.out.println( xmas );
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate xmas2 = LocalDate.parse("2023/12/25",formatter);
        System.out.println( xmas2 );
        //"2023/12/25" "20231225" "2022 12 25" "2022:12:25"
        //안됨.

        LocalTime time = LocalTime.now();
        System.out.println( time );
        //타임존
        LocalTime parisTime = LocalTime.now(ZoneId.of("Europe/Paris"));
        System.out.println( parisTime );
        LocalTime seoulTime = LocalTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println( seoulTime );
        //시간 설정하기
        LocalTime sleepTime = LocalTime.of(23, 30, 0);
        LocalTime getupTime = sleepTime.plusHours( 8 );
        LocalTime inhouseTime = sleepTime.minusHours( 5 );

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println( dateTime );//2024-03-15T10:14:17.909649600
        System.out.println( dateTime.getYear() );
        System.out.println( dateTime.getDayOfWeek() );
        System.out.println( dateTime.getMonthValue() ); //달은 1부터 시작

        //클래스 필드      MySQL(MariaDB)    Oracle
        //String         varchar           varchar2
        //int long       INT               number
        //float double   FLOAT             float
        //Date           DATE              date
        //LocalDate      DATE              date
        //LocalDateTime  DATETIME          date

        //연습문제
        // 12월 25일에 크리스마스 이벤트를 시작한다.
        // 현재날짜 기준으로 D-Day를 출력하시오.
        // 출력예) "크리스마스까지 D-24일입니다"
        LocalDate today = LocalDate.now();
        LocalDate xmas3 = LocalDate.parse("2024-12-25");
        int days = xmas3.getDayOfYear() - today.getDayOfYear();
        System.out.println( days );

        long days2 = ChronoUnit.DAYS.between(today, xmas3);
        System.out.println( days2 );

        LocalDateTime todayTime1 = today.atStartOfDay();
        LocalDateTime todayTime2 = xmas3.atStartOfDay();
        long ms1 = Timestamp.valueOf(todayTime1).getTime();
        long ms2 = Timestamp.valueOf(todayTime2).getTime();
        System.out.println( ms1 );
        System.out.println( ms2 );
        long diff = ms2 - ms1;
        long diffDays = diff / ( 24 * 60 * 60 * 1000 );
        System.out.println( "날짜 차이는 " + diffDays +"일입니다.");
    }
}
