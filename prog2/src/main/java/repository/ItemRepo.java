package repository;

import DTO.ItemDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemRepo {
    ArrayList<ItemDTO> shopItems = new ArrayList<>();
    public void Shop_init(){
        shopItems.add(new ItemDTO(1,"체력포션","체력 30% 회복할 수 있다.",10));
        shopItems.add(new ItemDTO(2,"마나포션","마나 50% 회복할 수 있다.",10));
        shopItems.add(new ItemDTO(3,"강화포션","모든 스텟을 10% 강화할 수 있다.",20));
    }

    public ArrayList<ItemDTO> getShopItems() {
        return shopItems;
    }

    public ItemRepo(){

    }

}
