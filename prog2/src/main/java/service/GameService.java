package service;

import DTO.USERDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GameService {
    static String map1 = "src/main/java/db/Map1";
    private static void LobbyCLI(){
        ArrayList<String> arr = new ArrayList<>();
        File file=new File(map1+".dat");
        BufferedReader reader=null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void EnterDungeon(USERDTO user){

    }
}
