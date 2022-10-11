package 扶贫的项目修改版;

import java.util.Scanner;

public class prog {
    public static void  main(String[] args){

        login();
    }

    public static void login(){
        Scanner sc=new Scanner(System.in);
        people cp=new Common_people();
        people pa=new primary_admin();
        people sa=new super_admin();
        people p=new people();

        p.menu();
            System.out.println("请输入:1.普通用户登录，2.初级管理者登录，3.超级管理者登录");
            String a=sc.next();
            switch (a){
                case "1":cp.menu();break;//进入到普通用户的菜单界面
                case "2":pa.menu();break;//进入到初级管理者的菜单界面
                case "3":sa.menu();break;//进入到超级管理者的菜单界面
            }
    }
}
