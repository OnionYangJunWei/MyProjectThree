package 扶贫的项目修改版;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DateBase {
    public static ArrayList peoplelogin() {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery("select * from common_people");
            while (result.next()) {
                A.add(result.getString(1));
                A.add(result.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                result.close();
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }

    public static ArrayList Common_peoplesearch(int pid) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery("select * from people where pid=" + pid);
            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                result.close();
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }

    public static int Commonchange_information(int pid) {
        Scanner sc = new Scanner(System.in);
        ArrayList A = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库的连接pid,addresss,fimaly,health,education,cause,flag,date,hid
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            st = conn.createStatement();
            rs = st.executeQuery("select * from people where pid=" + pid);

            if (rs.next()) {



                System.out.println("请输入需要修改的地址");
                String address = sc.next();

                System.out.println("请输入需要修改的家庭人口数");
                int fimaly = sc.nextInt();

                System.out.println("请输入需要修改的健康状况");
                String health = sc.next();

                System.out.println("请输入需要修改的教育水平");
                String eduction = sc.next();

                System.out.println("请输入需要修改的贫困原因");
                String cause = sc.next();

                System.out.println("请输入需要修改的是否脱贫标记");
                int flag = sc.nextInt();

                System.out.println("请输入需要修改的脱贫日期（注：格式为年-月-日）");
                Date date = Date.valueOf(sc.next());

                System.out.println("请输入需要修改的帮扶人员编号");
                int hid = sc.nextInt();

                String sql = "update people set addresss=?,fimaly=?,health=?,education=?,cause=?,flag=?,date =?,hid=? where pid=? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, address);
                ps.setInt(2, fimaly);
                ps.setString(3, health);
                ps.setString(4, eduction);
                ps.setString(5, cause);
                ps.setInt(6, flag);
                ps.setDate(7, date);
                ps.setInt(8, hid);
                ps.setInt(9, pid);

                int count = ps.executeUpdate();
                if(count>0){
                    return count;
                }else{
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
//修改贫困用户的密码
    public static int Commonchange_password(int pid) {
        Scanner sc = new Scanner(System.in);
        ArrayList A = new ArrayList();
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库的连接pid,addresss,fimaly,health,education,cause,flag,date,hid
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            st = conn.createStatement();
            rs = st.executeQuery("select * from common_people where id=" + pid);

            if (rs.next()) {



                System.out.println("请输入需要修改的密码");
                String mima=sc.next();

                String sql = "update common_people set mima=? where id=? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, mima);
                ps.setInt(2, pid);

                int count = ps.executeUpdate();
                if(count>0){
                    return count;
                }else{
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

  /*******************************************************************************************************************
    *********************************进入到初级管理者代码界面****************************************************************/

  public static ArrayList primarylogin() {
      ArrayList A = new ArrayList();
      Connection conn = null;
      Statement stat = null;
      ResultSet result = null;

      try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
          stat = conn.createStatement();
          result = stat.executeQuery("select * from primary_people");
          while (result.next()) {
              A.add(result.getString(1));
              A.add(result.getString(2));
          }
      } catch (Exception e) {
          e.printStackTrace();
      } finally {
          try {
              conn.close();
              result.close();
              stat.close();
          } catch (SQLException throwables) {
              throwables.printStackTrace();
          }
      }
      return A;
  }
//查询所有贫困户信息的数据库连接
    public ArrayList search_allpeople() {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery("select * from people");


            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stat.close();
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }

    public ArrayList search_ID(int ID) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        String sql = "select * from people where pid=" + ID;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
            return A;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stat.close();
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }
//    根据地址查询贫困户信息的数据库连接
    public ArrayList search_address(String address) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        address = "'" + address + "'";
        String sql = "select * from people where addresss=" + address;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
            return A;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }

    //根据家庭人口数量的引用数据库
    public ArrayList search_family(int family) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        String sql = "select * from people where fimaly=" + family;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
            return A;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }


    //根据教育程度的引用数据库
    public ArrayList search_education(String eduction) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        eduction = "'" + eduction + "'";

        String sql = "select * from people where education=" + eduction;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
            return A;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }


    //根据脱贫标记的引用数据库
    public ArrayList search_flag(int flag) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        String sql = "select * from people where flag=" + flag;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }
            return A;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }

    //根据日期的引用数据库
    public ArrayList search_date(String date) {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        date = "'" + date + "'";
        String sql = "select * from people where date=" + date;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery(sql);

            while (result.next()) {
                for (int i = 1; i <= 9; i++) {
                    A.add(result.getString(i));
                }
            }

            return A;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stat.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }
//增加贫困人员信息的数据库连接
public void add_information(int pid, String address, int fimaly, String health, String education, String cause, int flag, String date, int hid) throws SQLException {


    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;


    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
        st = con.createStatement();
        rs = st.executeQuery("select * from people where pid =" + pid);

        if (!rs.next()) {
            String sq1 = "insert into people (pid,addresss,fimaly,health,education,cause,flag,date,hid) values(?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sq1);
            ps.setInt(1, pid);
            ps.setString(2, address);
            ps.setInt(3, fimaly);
            ps.setString(4, health);
            ps.setString(5, education);
            ps.setString(6, cause);
            ps.setInt(7, flag);
            ps.setString(8, date);
            ps.setInt(9, hid);

            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println("插入成功！");
                add_information_common(pid);
            }
        } else {
            System.out.println("插入失败！该贫困户id已存在");
        }


    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null)
                con.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


    //增加贫困人员信息的时候增加一个账号
    public void add_information_common(int pid) throws SQLException {


        Connection con = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            st = con.createStatement();
            rs = st.executeQuery("select * from common_people where id =" + pid);
            int mima=123456;

            if (!rs.next()) {
                String sq1 = "insert into common_people (id,mima) values(?,?)";
                ps = con.prepareStatement(sq1);
                ps.setInt(1, pid);
                ps.setString(2, String.valueOf(mima));


                int result = ps.executeUpdate();
                if (result != 0) {
                    System.out.println("基础账户创建成功！");
                }
            } else {
                System.out.println("基础账户创建失败");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
                if (ps != null)
                    ps.close();
                if (rs != null)
                    rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//删除贫困户信息的数据库连接
    public void delete_information(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库的连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            st = conn.createStatement();
            rs = st.executeQuery("select * from people ");
            String sql = "delete from people where pid=?";             // 预处理sql语句
            PreparedStatement presta = conn.prepareStatement(sql);


            presta.setInt(1, id);

            // 执行SQL语句，实现数据添加
            boolean a = presta.execute();
            if (a == true) {
                System.out.println("删除失败");
            } else {
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//修改贫困户信息的数据库连接
public void update_information(int id) {
    Scanner sc = new Scanner(System.in);
    ArrayList A = new ArrayList();

    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    try {
        // 获取数据库的连接pid,addresss,fimaly,health,education,cause,flag,date,hid
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
        st = conn.createStatement();
        rs = st.executeQuery("select * from people where pid=" + id);

        if (rs.next()) {
            System.out.println("存在该用户");
            System.out.println("请输入需要修改的地址");
            String address = sc.next();

            System.out.println("请输入需要修改的家庭人口数");
            int fimaly = sc.nextInt();

            System.out.println("请输入需要修改的健康状况");
            String health = sc.next();

            System.out.println("请输入需要修改的教育水平");
            String eduction = sc.next();

            System.out.println("请输入需要修改的贫困原因");
            String cause = sc.next();

            System.out.println("请输入需要修改的是否脱贫标记");
            int flag = sc.nextInt();

            System.out.println("请输入需要修改的脱贫日期（注：格式为年-月-日）");
            Date date = Date.valueOf(sc.next());

            System.out.println("请输入需要修改的帮扶人员编号");
            int hid = sc.nextInt();
            String sql = "update people set addresss=?,fimaly=?,health=?,education=?,cause=?,flag=?,date =?,hid=? where pid=? ";
            ps = conn.prepareStatement(sql);

            ps.setString(1, address);
            ps.setInt(2, fimaly);
            ps.setString(3, health);
            ps.setString(4, eduction);
            ps.setString(5, cause);
            ps.setInt(6, flag);
            ps.setDate(7, date);
            ps.setInt(8, hid);
            ps.setInt(9, id);

            int count = ps.executeUpdate();
            if (count > 0)
                System.out.println("修改成功");
            else
                System.out.println("失败");
        } else {
            System.out.println("不存在该用户");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
//修改初级用户密码的数据库连接
public static int update_primary_password(int pid) {
    Scanner sc = new Scanner(System.in);
    ArrayList A = new ArrayList();
    Connection conn = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;
    try {
        // 获取数据库的连接pid,addresss,fimaly,health,education,cause,flag,date,hid
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
        st = conn.createStatement();
        rs = st.executeQuery("select * from primary_people where id=" + pid);

        if (rs.next()) {

            System.out.println("请输入需要修改的密码");
            String mima=sc.next();

            String sql = "update primary_people set mima=? where id=? ";
            ps = conn.prepareStatement(sql);

            ps.setString(1, mima);
            ps.setInt(2, pid);

            int count = ps.executeUpdate();
            if(count>0){
                return count;
            }else{
                return 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}

/**************************************************************************************************************/
public static ArrayList admin_login() {
    ArrayList A = new ArrayList();
    Connection conn = null;
    Statement stat = null;
    ResultSet result = null;

    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
        stat = conn.createStatement();
        result = stat.executeQuery("select * from admin");


        while (result.next()) {

            A.add(result.getString(1));
            A.add(result.getString(2));
        }


    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            stat.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            result.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    return A;
}
//查询所有初级管理者的数据库连接
    public ArrayList search_primary() {
        ArrayList A = new ArrayList();
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            stat = conn.createStatement();
            result = stat.executeQuery("select * from primary_people");


            while (result.next()) {
                for (int i = 1; i <= 2; i++) {
                    A.add(result.getString(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                stat.close();
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return A;
    }

//    增加新的初级用户
public void add_primary(int pid,String  mima) throws SQLException {
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null;

    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
        st = con.createStatement();
        rs = st.executeQuery("select * from primary_people where id=" + pid);

        if (!rs.next()) {
            String sq1 = "insert into primary_people (id,mima) values(?,?)";
            ps = con.prepareStatement(sq1);
            ps.setInt(1, pid);
            ps.setString(2, mima);

            int result = ps.executeUpdate();
            if (result != 0) {
                System.out.println("插入成功！");
            }
        } else {
            System.out.println("插入失败！该初级管理者id已存在");
        }


    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (con != null)
                con.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    //删除初级管理员信息的数据库连接
    public void delete_primary(int id) {

        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库的连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            st = conn.createStatement();
            rs = st.executeQuery("select * from primary_people");
            String sql = "delete from people where pid=?";             // 预处理sql语句
            PreparedStatement presta = conn.prepareStatement(sql);


            presta.setInt(1, id);

            // 执行SQL语句，实现数据添加
            boolean a = presta.execute();
            if (a == true) {
                System.out.println("删除失败");
            } else {
                System.out.println("删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改超级用户密码的数据库连接
    public static int update_admin_password(String pid) {
        Scanner sc = new Scanner(System.in);
        ArrayList A = new ArrayList();
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // 获取数据库的连接pid,addresss,fimaly,health,education,cause,flag,date,hid
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectone", "root", "123456");
            st = conn.createStatement();
            rs = st.executeQuery("select * from admin where id=" + pid);

            if (rs.next()) {

                System.out.println("请输入需要修改的密码");
                String mima=sc.next();

                String sql = "update admin set mima=? where id=? ";
                ps = conn.prepareStatement(sql);

                ps.setString(1, mima);
                ps.setInt(2, Integer.parseInt(pid));

                int count = ps.executeUpdate();
                if(count>0){
                    return count;
                }else{
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}

