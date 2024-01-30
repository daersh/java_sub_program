package repository;

import DTO.USERDTO;

import java.io.*;
import java.util.ArrayList;

public class UserRepo {
    private ArrayList<USERDTO> userdtos =new ArrayList<>();
    private String dataPath = "src/main/java/db/userDB.dat";

    public UserRepo() {
        File file = new File(dataPath);
        if(!file.exists()) {
            ArrayList<USERDTO> members = new ArrayList<>();
            members.add(new USERDTO(1,"user1","pass1"));
            saveUser(members);
            System.out.println("saved!");
        }

        loadUser();
    }

    /** 1. 파일에서 유저 정보를 불러오는 메서드 */
    private void loadUser() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(dataPath)));
            System.out.println("유저 정보 불러오는중..");
            System.out.println(ois.available());
            /* 설명. 파일로부터 모든 회원 정보를 읽어 memberList에 추가(add) */
            while (true) {
                USERDTO us = (USERDTO) ois.readObject();
                System.out.println("us = " + us);
                userdtos.add(us);
            }
        }
        catch (EOFException e){
                System.out.println("insert fin");
            }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Exception during user loading: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //2. 유저 아이디,비밀번호 일치 확인
    public int findUserID(String id){
        for (USERDTO userdto : userdtos){
            if(userdto.getUid().equals(id)){
                System.out.println("ID 중복 발견");
                return 1;
            }
        }
        System.out.println("중복되는 ID 없습니다.");
        return 0;
    }
    public USERDTO findUserIDPW(String id,String pw) {
        for (USERDTO userdto : userdtos){
            if(userdto.getUid().equals(id)){
                System.out.println("ID 확인 완료");
                if(userdto.getPw().equals(pw)){
                    System.out.println("PW 확인 완료!");
                    return userdto;
                }
                System.out.println("PW 불일치!");
                return null;
            }
        }
        System.out.println("유저 정보 없습니다.");
        return null;
    }

    //3. 유저 정보들 저장
    private void saveUser(ArrayList<USERDTO> members) {
        ObjectOutputStream oos = null;
        if(members.isEmpty()) return;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(dataPath)));

            /* 설명. 넘어온 회원 수만큼 객체 출력하기 */
            for(USERDTO m: members) {
                oos.writeObject(m);
            }
            oos.flush();                // 출력 시에는 flush 해 줄것
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int register(String id, String pw) {
        if(findUserID(id)==0){
            int no = userdtos.size();
            USERDTO user = new USERDTO(no,id,pw);
            userdtos.add(user);
            saveUser(userdtos);

            return 1;
        }
        return 0;
    }


}
