package DTO;

public class ItemDTO {
    private int itemNo;
    private String Name;
    private String Info;
    private int price;

    public ItemDTO(int itemNo, String name, String info, int price) {
        this.itemNo = itemNo;
        Name = name;
        Info = info;
        this.price = price;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
