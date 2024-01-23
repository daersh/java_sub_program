package menu;

import feat.*;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
/** 파일 관리 프로그림<br>
 * DATA 폴더에 있는 파일을 생성, 삭제, 수정, 스캔, 읽기를 할 수 있는 프로그램이다.<br>
 * @파일관련기능메뉴 <br>
 * @1.생성: 생성할 파일 이름 입력 후 해당 파일 이름이 폴더에 없으면 생성하고, 있으면 메뉴로 돌아간다.
 * @2.스캔: 폴더 내에 있는 모든 파일 이름 출력한다.
 * @3.읽기: 읽을 파일 이름 입력 후 해당 파일이 있으면 파일 안의 내용을 출력하고 없으면 메뉴로 돌아간다.
 * @4.수정: 수정할 파일 이름 입력 후 해당
 * @5.삭제: 삭제할 파일 이름 입력 후 해당 파일이 있으면 삭제, 없으면 메뉴로 돌아간다.
 * @6.종료: 프로그램을 종료한다.
 * */
public class Menu {

    //설명. 폴더 경로
    private static String forderPath = "/Users/hyunwoolee/Documents/GitHub/java_sub_program/prog1/src/main/java/DATA/";

    //설명. 메뉴
    public static void show_menu() throws InterruptedException, IOException {
        while(true) {

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
    }

    //설명. 사용자 메뉴 입력
     static void insert() throws InterruptedException, IOException {
        Scanner sc = new Scanner(System.in);
        int input=0;
        System.out.print("insert: ");

        try {
            input = sc.nextInt();
        }catch (Exception e){
            System.out.println("다시 입력.");
            insert();
        }

        goNext(input);
    }



    // 설명. input값에 따른 실행할 기능
    private static void goNext(int input) throws InterruptedException, IOException {
        switch (input){
            case 1:
                CreateFile.Create_Insert(forderPath);
                break;
            case 2:
                ScanFile.Scan(forderPath);
                break;
            case 3:
                ReadFile.Read(forderPath);
                break;
            case 4:
                EditFile.Edit(forderPath);
                break;
            case 5:
                DeleteFile.Delete(forderPath);
                break;
            case 6:
                System.out.println("프로그램을 종료합니다.");
                Thread.sleep(2000);
                System.exit(0);

            case 7:
                Process p;
                String s;
                String[] cmd = {"/bin/sh","-c","vi /DATA/abcd.txt"};
                p = Runtime.getRuntime().exec(cmd);
                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while ((s = br.readLine()) != null)
                    System.out.println(s);
                p.waitFor();
                System.out.println("exit: " + p.exitValue());
                p.destroy();
            default:
                System.out.println("다시 입력.");
        }

    }

}
