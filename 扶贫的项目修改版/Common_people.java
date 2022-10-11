package 扶贫的项目修改版;

import 扶贫的项目.DateBase;

import java.util.ArrayList;
import java.util.Scanner;

public class Common_people extends people {
    Scanner sc=new Scanner(System.in);
    DateBase d = new DateBase();
    static String cid;
    prog p=new prog();

    @Override
    public void menu() {

        System.out.println("\t\t\t\t............欢迎进入普通用户登录界面..........");
        ArrayList B=Common_people.onelogin();

            if(B==null){
                System.out.println("用户名或者密码错误,退出系统");

            }else{
                System.out.println("输入正确，正在进入系统........");
                menu1();
            }
            System.out.println("正在退出系统.....");
        }



public void menu1(){
        System.out.println("1.查询个人信息");
        System.out.println("2.修改个人信息");
        System.out.println("3.修改个人密码");
        System.out.println("4.返回到上一级菜单");
        System.out.println("5.退出该系统");
    System.out.println("请输入:");
    String b=sc.next();


        switch (b){
            case "1":search_information();break;//选择进入到查询信息的界面
            case "2":change_information();break;//选择进入到修改信息的界面
            case "3":change_password();break;//选择进入到修改密码的界面
            case "4":p.login();break;//返回到上一级菜单
            case "5":end();break;
        }
}


    public static  ArrayList onelogin() {//登录的主要界面，用来输入用户名和密码

        Scanner sc = new Scanner(System.in);
        ArrayList A= 扶贫的项目修改版.DateBase.peoplelogin();

        System.out.println("请输入用户账号");
        cid=sc.nextLine();
        System.out.println("请输入用户密码");
        String mima = sc.nextLine();



        if (A.contains(cid)) {
            int n = A.indexOf(cid) + 1;

            if (A.get(n).equals(mima)) {
                System.out.println("\t\t\t\t\t\t\t\t用户账号和密码正确");
                ArrayList ver = new ArrayList();
                ver.add(A.get(n));
                ver.add(A.get(n - 1));
                return ver;
            } else {
                System.out.println("用户账号或者密码错误");

            }
        } else {
            System.out.println("用户账号或者密码错误");
            return null;
        }
        return null;
    }
//查询个人信息的方法
    public void  search_information(){
        ArrayList B= 扶贫的项目修改版.DateBase.Common_peoplesearch(Integer.parseInt(cid));
        int i=0;
        geshi();
        for(Object j:B){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }
        }
        System.out.println("打印完成..........");
        System.out.println("1.返回上一级菜单");
        System.out.println("2.退出系统");
            System.out.println("请输入:");
            String b=sc.next();
            switch (b){
                case "1":menu1();break;
                case "2":end();break;
            }
    }

    public void change_information(){

        int count=扶贫的项目修改版.DateBase.Commonchange_information(Integer.parseInt(cid));
        if(count>0){
            System.out.println("修改数据信息成功");
            System.out.println("1.返回上一级菜单");
            System.out.println("2.退出系统");
            System.out.println("(注：输入其他字符将自动退出本系统)");
                System.out.println("请输入:");
                String b=sc.next();
                switch (b){
                    case "1":menu1(); break;
                    case "2":break;
                }
        }else{
            System.out.println("修改数据信息失败");
            System.out.println("自动返回上一级菜单");
            menu1();
        }
    }

    public void change_password(){
        int count= 扶贫的项目修改版.DateBase.Commonchange_password(Integer.parseInt(cid));
        if(count>0){
            System.out.println("修改密码成功");
            System.out.println("1.返回上一级菜单");
            System.out.println("2.退出系统");
                System.out.println("请输入:");
                String b=sc.next();
                switch (b){
                    case "1":menu1(); break;
                    case "2":break;
                }
        }else{
            System.out.println("修改密码失败");
            System.out.println("自动返回上一级菜单");
            menu1();
        }

    }
}
