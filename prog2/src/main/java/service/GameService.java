package service;

import DTO.USERDTO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class GameService {
    static String map1 = "src/main/java/db/Map1";
    static int []userLoc = null;
    static int map_x=0;
    static int map_y=0;
    static ArrayList<String> map = new ArrayList<>();
    static char [][] mapType = null;
    private static void GameCli(){
        File file=new File(map1+".dat");
        BufferedReader reader=null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            int x=0;
            while ((line = reader.readLine()) != null){
                if(x==0){
                    StringTokenizer st = new StringTokenizer(reader.readLine());
                    map_x = Integer.parseInt(st.nextToken());
                    map_y = Integer.parseInt(st.nextToken());
                    userLoc= new int[]{map_x,map_y};
                    mapType = new char[map_x][map_y];
                    x++;
                    continue;
                }
                map.add(line);

                mapType[x-1]=line.toCharArray();
//                System.out.println(line);
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
        mapLoad();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                int keycode=e.getKeyCode();
                switch(keycode) {
                    case KeyEvent.VK_UP://위로
                        
                        break;
                    case KeyEvent.VK_DOWN://아래로

                        break;
                    case KeyEvent.VK_LEFT://왼쪽

                        break;
                    case KeyEvent.VK_RIGHT://오른쪽

                        break;
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    private static void mapLoad() {
        for (int i = 0; i < map_x; i++) {
            for (int j=0;j< map_y; j++){
                System.out.print(mapType[i][j]);
            }
        }
    }

    public void EnterDungeon(USERDTO user){

    }
}
