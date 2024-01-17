package feat;

import menu.Menu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    static Scanner sc = new Scanner(System.in);
    public static void Read(String forderPath) throws IOException {
        System.out.print("insert file name: ");

        String str =sc.nextLine();

        File file=new File(forderPath+str+".txt");

        if(file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(file));

            System.out.println("           ** 파일내용 **");
            System.out.println("***********************************");
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println("***********************************");
            reader.close();

        }else {
            System.out.println("해당 파일은 없습니다.");
        }

    }
}
