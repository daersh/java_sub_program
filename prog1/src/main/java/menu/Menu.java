package menu;

import feat.*;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    static String forderPath = "/Users/hyunwoolee/Documents/GitHub/java_sub_program/prog1/src/main/java/DATA/";

    public static void show_menu() throws InterruptedException, IOException {
        System.out.println("           ** 메뉴창 **");
        System.out.println("***********************************");
        System.out.println("*     1. 파일 생성                  *");
        System.out.println("*     2. 모든 파일 출력              *");
        System.out.println("*     3. 파일 읽기                  *");
        System.out.println("*     4. 파일 수정                  *");
        System.out.println("*     5. 파일 삭제                  *");
        System.out.println("*     6. 종료                      *");
        System.out.println("***********************************");
        insert();
    }

     static void insert() throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("insert: ");
        int input = sc.nextInt();
        goNext(input);
    }

    private static void goNext(int input) throws InterruptedException, IOException {
        switch (input){
            case 1:
                CreateFile.Create(forderPath);
                show_menu();
                break;
            case 2:
                ScanFile.Scan(forderPath);
                show_menu();
                break;
            case 3:
                ReadFile.Read(forderPath);
                show_menu();
                break;
            case 4:
                EditFile.Edit(forderPath);
                show_menu();
                break;
            case 5:
                DeleteFile.Delete(forderPath);
                show_menu();
                break;
            case 6:
                System.out.println("프로그램을 종료합니다.");
                Thread.sleep(2000);
                System.exit(0);
        }
    }

}