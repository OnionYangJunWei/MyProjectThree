package 扶贫的项目修改版;

import java.util.Scanner;

public class people {
    Scanner sc=new Scanner(System.in);


    public void menu(){
        System.out.println("\t\t\t\t.............欢迎进入某城镇扶贫管理系统.............");
        System.out.println("\t\t\t\t请选择您的身份:");
        System.out.println("\t\t\t\t1.城镇普通人员");
        System.out.println("\t\t\t\t2.初级管理者");
        System.out.println("\t\t\t\t3.超级管理者");
    }
    public void geshi() {//打印表头的格式
        System.out.println("编号\t\t\t\t地址\t\t\t家庭人口数\t\t\t健康程度\t\t\t教育水平\t\t\t贫困原因\t\t\t扶贫标记\t\t\t脱贫日期\t\t\t\t\t扶贫人员编号");
    }
    public void end(){
        System.out.println("正在退出本系统，欢迎下次使用.......");
    }

}
