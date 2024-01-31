package service;

import DTO.USERDTO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LobbyService {
    GameService gameService = new GameService();
    ShopService shopService =new ShopService();
    String Lobby = "src/main/java/db/Lobby.dat";
    public void Lobby(USERDTO user){
        while (true){
            printLobby(user);
            Scanner sc =new Scanner(System.in);
            int input = sc.nextInt();
            switch (input){
                case 1:
                    System.out.println("던전으로 들어갑니다.");
                    gameService.EnterDungeon(user); break;
                case 2:
                    System.out.println("상점으로 이동");
                    shopService.printShop();
                    break;
                case 3: break;
                case 4: break;
                case 5: return;
                default:
            }
        }
    }

    private void printLobby(USERDTO user) {
        File file = new File(Lobby);
        BufferedReader reader =null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            int cnt=0;
            while ((line = reader.readLine()) != null){
                System.out.print(line);
                switch (cnt){
                    case 1: System.out.println(user.getUid()); break;
                    case 2: System.out.println(user.getLevel()); break;
                    case 3: System.out.println(user.getEXP());break;
                    case 4: System.out.println(user.getProfession());break;
                    case 6: System.out.println(user.getHP());break;
                    case 7: System.out.println(user.getMP());break;
                    case 8: System.out.println(user.getSTR());break;
                    case 9: System.out.println(user.getINT());break;
                    case 10: System.out.println(user.getDEX());break;
                    default: System.out.println();
                }
                cnt++;
            }
            System.out.print("insert:");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(reader!=null)
                    reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
