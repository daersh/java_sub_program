package feat;

import menu.Menu;

import java.io.File;

public class ScanFile {

    public static void Scan(String forderPath) {
        File dir = new File(forderPath);
        String[] file = dir.list();
        System.out.println("파일 목록");
        for(String str: file){
            System.out.println(str);
        }
        System.out.println();
    }
}
