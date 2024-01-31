package service;

import DTO.ItemDTO;
import repository.ItemRepo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ShopService {
    ItemRepo itemRepo = new ItemRepo();
    ArrayList<ItemDTO> items;
    void printShop(){
        itemRepo.Shop_init();
        items = itemRepo.getShopItems();
        File file = new File("src/main/java/db/Shop.dat");
        BufferedReader reader = null;
        while (true) {
            try {
                reader = new BufferedReader(new FileReader(file));
                String line = null;
                int cnt = 0;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    switch (cnt) {
                        case 1:
                            for (int i = 0; i < items.size(); i++) {
                                System.out.printf("* %d. %s(%s): %d\n", i + 1, items.get(i).getName(), items.get(i).getInfo(), items.get(i).getPrice());
                            }
                            break;
                    }
                    cnt++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (reader != null)
                        reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print("insert:");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            int v = select(input);
            if(v==0) break;
        }
    }

    private int select(int input) {
        switch (input){
            case 1:
                Scanner sc = new Scanner(System.in);
                System.out.print("구매할 품목 선택: ");
                int selectItem= sc.nextInt();
                if(selectItem<=0 || selectItem>items.size())
                {
                    System.out.println("잘못된 입력");break;
                }
                System.out.print("구매할 갯수 선택: ");
                int selectNum = sc.nextInt();
                System.out.printf("%s 아이템 %d 개 %d원 입니다.\n",items.get(selectItem-1).getName(), selectNum,items.get(selectItem-1).getPrice()*selectNum);
                return 1;
            case 2:
                return 0;
        }
        return 0;
    }
}


