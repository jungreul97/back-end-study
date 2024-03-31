import java.time.LocalDate;
import java.util.*;

public class 연습장 {
    public static void makecalendar(int year,int month){
        LocalDate calenderday = LocalDate.of(year,month,1);
        int start  = calenderday.getDayOfWeek().getValue();
        int last = calenderday.lengthOfMonth();
        for(int i = 0;i<start;i++){
            System.out.print(" ");
        }
        int date = 1;
        for(int i=0;i<last;i++,date++){
            System.out.print(date);
            start++;
            if (start%7 == 0){
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        makecalendar(2024,3);

    }
}
