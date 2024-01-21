package feat;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {

    //설명. 생성할 파일 이름 입력 후, 존재하는 파일이면 돌아가고 없으면 .txt확장자를 가진 파일 생성
    public static void Create_Insert(String forderPath) throws IOException {
        Scanner sc= new Scanner(System.in);
        System.out.print("파일 이름 입력: ");
        String fileInput=sc.next();

        File file = new File(forderPath+fileInput+".txt");
        if(!file.exists()) {
            Create(file, fileInput);
        }else {
            System.out.println("이미 존재합니다. 메뉴로 돌아갑니다.\n");
        }
    }

    private static void Create(File file, String fileInput) throws IOException {
        file.createNewFile();
        System.out.println(fileInput +".txt 파일을 생성했습니다.\n");
    }

}
