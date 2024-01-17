package feat;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateFile {
    static Scanner sc= new Scanner(System.in);

    public static void Create(String forderPath) throws IOException {
        System.out.print("파일 이름 입력: ");
        String fileInput= sc.next();
        File file = new File(forderPath+fileInput+".txt");
        if(!file.exists()) {
            file.createNewFile();
            System.out.println(fileInput+".txt 파일을 생성했습니다.");
        }else {
            System.out.println("이미 존재합니다.");
        }
    }
}
