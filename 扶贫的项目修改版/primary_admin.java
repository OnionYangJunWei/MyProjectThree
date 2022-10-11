package 扶贫的项目修改版;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class primary_admin extends people{
    DateBase d=new DateBase();
    static String pid;
    @Override
    public void menu() {
        System.out.println("\t\t\t\t............欢迎进入初级管理者登录界面..........");
        ArrayList B=primarylogin();
        if(B==null){
            System.out.println("用户名或者密码错误");
        }else{
            System.out.println("输入正确");
            System.out.println("正在进入初级管理者操作界面.............");
            menu1();
        }

    }

    public static  ArrayList primarylogin() {//登录的主要界面，用来输入用户名和密码

        Scanner sc = new Scanner(System.in);
        ArrayList A= 扶贫的项目修改版.DateBase.primarylogin();

        System.out.println("请输入用户账号");
        pid=sc.nextLine();
        System.out.println("请输入用户密码");
        String mima = sc.nextLine();

        if (A.contains(pid)) {
            int n = A.indexOf(pid) + 1;

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
        System.out.println("1.查询贫困户信息");
        System.out.println("2.增加贫困户信息");
        System.out.println("3.删除贫困户信息");
        System.out.println("4.修改贫困户信息");
        System.out.println("5.修改个人密码");
        System.out.println("6.返回上一级菜单");
        System.out.println("7.退出系统");
        System.out.println("请输入:");
        String b=sc.next();


            switch (b){
                case "1":search_people();break;
                case "2":add_information();break;
                case "3":delete_information();break;
                case "4":update_information();break;
                case "5":update_mima();break;
                case "6":menu();break;
                case "7":end();break;
            }
    }

//    查询贫困户信息的一级菜单
    public void search_people(){
        System.out.println("1.查询所有贫困户信息");
        System.out.println("2.根据条件查询贫困户信息");
        System.out.println("3.返回上一级菜单");
        System.out.println("4.退出系统");
        System.out.println("请输入:");
        String b=sc.next();

            switch (b){
                case "1":search_allpeople();break;
                case "2":;search_condition();break;
                case "3":menu1();break;
                case "4":break;
            }
    }
//    打印所有贫困户信息的方法
    public void search_allpeople(){
        ArrayList A=d.search_allpeople();
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        System.out.println("打印完成............");
        System.out.println("1.返回上一级菜单");
        System.out.println("2.退出系统");
        System.out.println("请输入:");
        String b=sc.next();

            switch (b){
                case "1":search_people();break;
                case "2":break;
            }
    }
//条件查询的菜单
    public void search_condition(){
        System.out.println("1.根据ID(编号)查询");
        System.out.println("2.根据地址查询");
        System.out.println("3.根据家庭人口查询");
        System.out.println("4.根据教育水平查询");
        System.out.println("5.根据是否脱贫标记查询");
        System.out.println("6.根据脱贫日期查询");
        System.out.println("7.返回上一级菜单");
        System.out.println("8.退出系统");
        System.out.println("请输入:");
        String b=sc.next();
            switch (b){
                case "1":search_ID();break;
                case "2":search_address();break;
                case "3":search_family();break;
                case "4":search_education();break;
                case "5":search_flag();break;
                case "6":search_date();break;
                case "7":search_people();break;
                default:break;
            }
    }
//根据条件查询中的结尾代码方法
    public void search_personal_menu(){
        System.out.println("打印完成......");
        System.out.println("1.返回上一级菜单");
        System.out.println("2.退出系统");
        System.out.println("请输入:");
        String b=sc.next();
        int a=sc.nextInt();

            switch (b){
                case "1":search_condition();break;
                case "2":break;
            }
    }
//    根据ID查询贫困户信息的方法
    public void search_ID(){
        int ID;
        System.out.println("请输入需要查询的贫困户ID");
        ID=sc.nextInt();
        ArrayList A=d.search_ID(ID);
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        search_personal_menu();
    }
//    根据地址查询贫困户信息的方法
    public void search_address(){
        System.out.println("请输入需要查询的贫困户地址");
        String address=sc.next();
        ArrayList A=d.search_address(address);
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        search_personal_menu();
    }
//    根据家庭人数查询贫困户信息的方法
    public void search_family(){
        System.out.println("请输入需要查询的贫困户家庭人数");
        int family=sc.nextInt();
        ArrayList A=d.search_family(family);
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        search_personal_menu();
    }
//    根据教育程度查询贫困户信息的方法
    public void search_education(){
        System.out.println("请输入需要查询的贫困户教育程度");
        String education=sc.next();
        ArrayList A=d.search_education(education);
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        search_personal_menu();
    }
//    根据扶贫标记查询贫困户信息的方法
    public void search_flag(){
        System.out.println("1.打印已脱贫的贫困户信息");
        System.out.println("2.打印未脱贫的贫困户信息");
        int flag=sc.nextInt();
        ArrayList A=d.search_flag(flag);
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        search_personal_menu();
    }
//    根据脱贫日期查询贫困户信息
    public void search_date(){
        System.out.println("请输入需要查询的日期（输入格式为（年-月-日））");
        String date=sc.next();
        ArrayList A=d.search_date(date);
        int i=0;
        geshi();
        for(Object j:A){
            System.out.print(j+"\t\t\t\t");
            i++;
            if(i%9==0){
                System.out.println();
            }

        }
        search_personal_menu();
    }
//    增加贫困户信息的方法
public void add_information() {
    int pid;
    String addresss;
    int fimaly;
    String health;
    String education;
    String cause;
    int flag;
    String date;
    int hid;
    System.out.println("请输入需要添加的学号");
    pid = sc.nextInt();
    String sc1 = sc.nextLine();

    System.out.println("请输入需要添加的地址");
    addresss = sc.next();

    System.out.println("请输入需要添加的家庭人口数量");
    fimaly = sc.nextInt();

    System.out.println("请输入需要添加的健康信息");
    health = sc.next();

    System.out.println("请输入需要添加的教育程度信息");
    education = sc.next();

    System.out.println("请输入需要添加的贫困原因");
    cause = sc.next();

    System.out.println("请输入需要添加的脱贫标记");
    flag = sc.nextInt();

    System.out.println("请输入需要添加的脱贫日期(输入格式：年-月-日)");
    date = sc.next();

    System.out.println("请输入需要添加的帮扶人员编号");
    hid = sc.nextInt();

    try {
        d.add_information(pid, addresss, fimaly, health, education, cause, flag, date, hid);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    System.out.println("1.继续添加\n2.返回上一级菜单\n3.退出系统");
    while(1==1){
        System.out.println("请输入:");
        String b=sc.next();
        switch (b){
            case "1":
                add_information();
                break;
            case "2":
                menu1();
                break;
            default:
                break;
        }
        if(b=="1"||b=="2"||b=="3"){
            break;
        }else{
            continue;
        }
    }
    }
//    删除贫困户信息的方法
public void delete_information(){
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入需要删除的人员信息ID");
    int id=sc.nextInt();
    d.delete_information(id);
    System.out.println("1.继续删除数据信息\n2.返回上一级菜单\n3.退出系统");
        System.out.println("请输入:");
        String b=sc.next();
        switch (b){
            case "1":delete_information();break;
            case "2":menu1();break;
            case "3":end();break;
        }
}

//修改贫困户信息的方法
public void update_information(){
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入需要修改的人员信息ID");
    int id=sc.nextInt();
    d.update_information(id);
    System.out.println("1.继续修改数据信息\n2.返回上一级菜单\n3.退出系统");
        System.out.println("请输入:");
        String b=sc.next();
        switch (b){
            case "1":update_information();break;
            case "2":menu1();break;
            case "3":end();break;
        }
}
//修改个人密码的方法
public void update_mima(){
    int count=DateBase.update_primary_password((Integer.parseInt(pid)));
    if(count>0){
        System.out.println("修改密码成功");
        System.out.println("1.返回上一级菜单");
        System.out.println("2.退出系统");
            System.out.println("请输入:");
            String b=sc.next();
            switch (b){
                case "1":menu1();
                case "2":end();break;
            }

    }else{
        System.out.println("修改密码失败");
        System.out.println("自动返回上一级菜单");
        menu1();
    }
}
}
