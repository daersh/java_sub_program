package feat;
import menu.Menu;
import java.io.File;
/**폴더 안에 있는 모든 파일 이름 출력*/
public class ScanFile {

    public static void Scan(String forderPath) {
        File dir = new File(forderPath);

        String[] file = dir.list();
        System.out.println("\n           ** 파일 목록 **");
        System.out.println("***********************************");
        for(String str: file){
            System.out.println(str);
        }
        System.out.println("***********************************\n");

    }
}
