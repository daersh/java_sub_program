package service;

import DTO.USERDTO;
import repository.UserRepo;

public class UserService {
    static USERDTO user;
    private final UserRepo userRepo = new UserRepo();

    public static void changeUser(USERDTO changedUser) {
        user = changedUser;
    }

    public USERDTO Login(String id, String pw) {
        return userRepo.findUserIDPW(id,pw);
    }

    public int register(String id, String pw) {
        if(userRepo.register(id,pw)==1){
            System.out.println("회원가입 완료! 로그인하세요!");
            return 1;
        }
        return 0;
    }


    //1. 로그인

    //2. 회원가입

    //3. 비밀번호 변경


}
