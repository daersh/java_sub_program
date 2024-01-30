package DTO;

import aggregate.Profession;

import java.io.Serializable;

public class USERDTO implements Serializable {
    private int no;
    private String uid;
    private String pw;

    private int level;
    private int EXP;
    private Profession profession;
    private int HP;
    private int MP;
    private int STR;
    private int INT;
    private int DEX;

    public USERDTO(int no, String uid, String pw) {
        this.no = no;
        this.uid = uid;
        this.pw = pw;
        level = 1;
        EXP = 0;
        profession = Profession.NOOB;
        HP = 10;
        MP = 10;
        STR = 5;
        INT = 5;
        DEX = 5;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getEXP() {
        return EXP;
    }

    public void setEXP(int EXP) {
        this.EXP = EXP;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getINT() {
        return INT;
    }

    public void setINT(int INT) {
        this.INT = INT;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    @Override
    public String toString() {
        return "USERDTO{" +
                "no=" + no +
                ", uid='" + uid + '\'' +
                ", pw='" + pw + '\'' +
                ", level=" + level +
                ", EXP=" + EXP +
                ", profession=" + profession +
                ", HP=" + HP +
                ", MP=" + MP +
                ", STR=" + STR +
                ", INT=" + INT +
                ", DEX=" + DEX +
                '}';
    }
}
