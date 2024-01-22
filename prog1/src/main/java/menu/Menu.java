package menu;

import feat.*;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

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
