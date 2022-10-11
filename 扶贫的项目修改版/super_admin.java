package 扶贫的项目修改版;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class super_admin extends people {
    Scanner sc=new Scanner(System.in);
    ArrayList A=new ArrayList();
    DateBase d=new DateBase();
    static String aid;
    @Override
    public void menu() {
        System.out.println("欢迎进入超级管理者界面.......");
        ArrayList B=onelogin() ;
        if(B==null){
            System.out.println("用户名或者密码错误");

        }else{
            System.out.println("输入正确");
            System.out.println("正在进入系统.............");
            menu1();
        }
    }


    public static  ArrayList onelogin() {//登录的主要界面，用来输入用户名和密码

        Scanner sc = new Scanner(System.in);
        ArrayList A= 扶贫的项目修改版.DateBase.admin_login();
        System.out.println("请输入用户账号");
        String id=sc.next();
        System.out.println("请输入用户密码");
        String mima = sc.next();



        if (A.contains(id)) {
            int n = A.indexOf(id) + 1;

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

    public void menu1(){
        System.out.println("1.查询所有初级用户");
        System.out.println("2.增加新的初级用户");
        System.out.println("3.删除初级用户");
        System.out.println("4.修改本系统超级管理员密码");
        System.out.println("5.退出系统");
        System.out.println("请输入:");
        String b=sc.next();

            switch (b){
                case "1":search_primary();break;
                case "2":add_information();break;
                case "3":delete_primary();break;
                case "4":update_mima();break;
                case "5":end();break;
            }
    }
//查询所有初级管理者的方法
    public void search_primary(){
        ArrayList A=d.search_primary();
        int i=0;
        System.out.println("编号\t\t\t\t\t密码");
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%2==0){
                System.out.println();
            }

        }
        System.out.println("打印完成............");
        System.out.println("1.返回上一级菜单");
        System.out.println("2.退出系统");
        System.out.println("请输入:");
        String b=sc.next();
            switch (b){
                case "1":menu1();break;
                case "2":break;
            }
    }
//    增加新的初级管理员的方法
public void add_information() {
        int id;
        String mima;
    System.out.println("请输入需要添加的ID");
    id = sc.nextInt();
    String sc1 = sc.nextLine();

    System.out.println("请输入添加ID的密码");
    mima = sc.next();


    try {
        d.add_primary(id,mima);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    System.out.println("1.继续添加\n2.返回上一级菜单\n3.退出系统");
        System.out.println("请输入:");
        String b=sc.next();
        switch (b){
            case "1":add_information();; break;
            case "2":menu1();break;
            case "3":break;
        }
}

//删除初级管理员的方法
public void delete_primary(){
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入需要删除的人员信息ID");
    int id=sc.nextInt();
    d.delete_primary(id);
    System.out.println("1.继续删除数据信息\n2.返回上一级菜单\n3.退出系统");

        System.out.println("请输入:");
        String b=sc.next();
        switch (b){
            case "1":delete_primary();break;
            case "2":menu1();break;
            case "3":break;
        }
}
//修改本系统超级管理员的密码
public void update_mima(){
        System.out.println("请再次输入你的账号");
        String id=sc.next();
    int count=d.update_admin_password(id);
    if(count>0){
        System.out.println("修改密码成功");
        System.out.println("1.返回上一级菜单");
        System.out.println("2.退出系统");
            System.out.println("请输入:");
            String b=sc.next();
            switch (b){
                case "1":menu1();break;
                case "2":break;
            }

    }else{
        System.out.println("修改密码失败");
        System.out.println("自动返回上一级菜单");
        menu1();
    }
}
}
