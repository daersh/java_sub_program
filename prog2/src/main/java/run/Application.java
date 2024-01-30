package run;


import DTO.USERDTO;
import service.UserService;
import view.LoginWindow;

import java.util.Scanner;

public class Application {

    private static final UserService userService = new UserService();
static USERDTO user = null;

    public static void main(String[] args) {
//        testLoginCLI();
        LoginWindow.OnLoginWindow();

    }


    private static void testLoginCLI() {
        while (true) {
            System.out.println("====== login ======");
            System.out.println("= 1. register     =");
            System.out.println("= 2. login        =");
            System.out.println("= 3. start        =");
            System.out.println("===================");
            System.out.print("select:");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            if (selectMenu(input) == 1) {
                System.out.println("Link start");
                LoginWindow.OnLoginWindow();
            }
        }
    }

    private static int selectMenu(int input) {
        Scanner sc= new Scanner(System.in);
        String id,pw;
        switch (input){

            case 1:
                System.out.print("ID:");
                id = sc.nextLine();
                System.out.print("PW: ");
                pw = sc.nextLine();
                if(userService.register(id,pw)==1){
                    System.out.println("회원가입 성공");
                }else{
                    System.out.println("회원가입 실패");
                }
                break;
            case 2:
                System.out.print("ID:");
                id = sc.nextLine();
                System.out.print("PW: ");
                pw = sc.nextLine();
                user = userService.Login(id,pw);
                if(user!=null){
                    System.out.println("Login success");
                }else{
                    System.out.println("Login fail");
                }
                break;
            case 3:
                if(user == null){
                    System.out.println("login first...");
                }else{
                    return 1;
                }
                break;
            default:
                System.out.println("Not correct input...");
        }
        return 0;
    }
}
