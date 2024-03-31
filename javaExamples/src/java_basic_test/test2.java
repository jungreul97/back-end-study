package java_basic_test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book{
    private String name;
    private String publisher;
    private int price;
    private LocalDate pubDate;

    public Book(String name, String publisher, LocalDate pubDate, int price) {
        this.name = name;
        this.publisher = publisher;
        this.price = price;
        this.pubDate = pubDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }
}
public class test2 {
    static List<Book> list = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("-----도서 재고 관리프로그램-----");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("1.입력 2.전체출력 3.정렬 4.수정:");
            int cmd = sc.nextInt();
            if (cmd == 1){
                System.out.print("책이름 입력:");
                String name = sc.next();
                System.out.print("출판사 입력:");
                String publisher = sc.next();
                System.out.print("출판일 입력:");
                String date = sc.next();
                LocalDate pubdate = LocalDate.parse(date);
                System.out.print("가격 입력:");
                int price = sc.nextInt();

                System.out.println("도서가 입력되었습니다.");
                Book book = new Book(name,publisher,pubdate,price);
                list.add(book);
                System.out.println("총 도서의 수는 "+list.size()+"입니다. ");
            }else if (cmd == 2){
                for(Book book : list){
                    String name = book.getName();
                    String publisher = book.getPublisher();
                    LocalDate date = book.getPubDate();
                    DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");

                    int price = book.getPrice();
                    System.out.println(name+"/"+publisher+"/"+pubdate+"/"+price);
                }
            }else if (cmd == 3){
                System.out.println("책이름 가나다순(1) 출판일 최근순(2)");
            }else if (cmd == 4){
                System.out.println("수정할 책 이름 입력 : ");
                String name = sc.next();
                System.out.println("출판사 입력 : ");
                String publisher = sc.nextLine();
                System.out.print("출판일 입력 : ");
                String date = sc.nextLine();
                LocalDate pubdate = LocalDate.parse(date);
                System.out.print("가격 입력 : ");
                int price = sc.nextInt();
                for(Book book : list){
                    if (book.getName().equals(name)){
                        book.setPublisher(publisher);
                        book.setPrice(price);
                        book.setPubDate(pubdate);
                        break;
                    }
                }
                System.out.println("도서정보가 수정되었습니다.");
            }
        }

    }
}
