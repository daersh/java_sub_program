package feat;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class EditFile {
    static Scanner sc = new Scanner(System.in);

    public static void Edit(String forderPath) throws IOException {
        System.out.print("파일 입력: ");
        String file_name =sc.nextLine();
        File file = new File(forderPath+file_name+".txt");
        if(file.exists()){
            Desktop.getDesktop().open(file);
            //EditFile(file);
        }else{
            System.out.println("파일이 존재하지 않습니다.");
        }
    }
}
