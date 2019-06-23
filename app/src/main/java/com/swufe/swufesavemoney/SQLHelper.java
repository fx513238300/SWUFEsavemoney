package com.swufe.swufesavemoney;
import android.util.Log;

import java.sql.DriverManager;
import java.util.HashMap;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLHelper {

    Connection con;
    Statement stmt ;
    ResultSet rs;
    public List<HashMap<String,String>> moneyList;
    public List<HashMap<String,String>> personList;
    public final String TAG="SQLHelper";

    public List<HashMap<String, String>> getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(List<HashMap<String, String>> moneyList) {
        this.moneyList = moneyList;
    }

    public SQLHelper(){

    }
    //连接数据库
    public Connection getConnection(){
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接，address为数据IP，Port为端口号，DBName为数据名称，UserName为数据库登录账户，Password为数据库登录密码
            con = DriverManager.getConnection("jdbc:mysql://119.3.167.204:3306/mysqlfx", "root","mySQL@2019");
            Log.i(TAG, "run: 连接成功");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i(TAG, "run: 连接失败1");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.i(TAG, "run: 连接失败2");
        }
        return con;
    }

    //获取指定省钱码的money，返回rmb
    public String Content(Connection con,String title) throws SQLException {
        String rmb = "";
        String sql = "select money from money where sqm = '"+ title + "'";
        Log.i(TAG, "queryPlanContent: sql:"+sql);
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            rmb = rs.getString("money");
            Log.i(TAG, "queryPlanContent: content"+rmb);
        }
        return rmb;
    }


    public List<HashMap<String, String>> getMoney(Connection con1)  {
        moneyList = new ArrayList<HashMap<String, String>>();
        try {
            String sql = "select * from money";        //查询“plan”表的所有内容
            Statement stmt = con1.createStatement();        //创建Statement
            ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor

            while (rs.next()) {
                Log.i(TAG, "testConnection: sqm" + rs.getString("sqm"));
                Log.i(TAG, "testConnection: money" + rs.getString("money"));

                String sqm = rs.getString("sqm");
                String money = rs.getString("money");
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("sqm", sqm);
                map.put("money", money);
                moneyList.add(map);
                Log.i(TAG, "testConnection: money" + moneyList);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {

        } finally {
            if (con1 != null)
                try {
                    con1.close();
                } catch (SQLException e) {
                }
        }

        return moneyList;
    }
    public List<HashMap<String, String>> getPerson(Connection con1)  {
        personList = new ArrayList<HashMap<String, String>>();
        try {
            String sql = "select * from user";        //查询“plan”表的所有内容
            Statement stmt = con1.createStatement();        //创建Statement
            ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor

            while (rs.next()) {
                Log.i(TAG, "testConnection: name" + rs.getString("name"));
                Log.i(TAG, "testConnection: password" + rs.getString("password"));

                String name = rs.getString("name");
                String password= rs.getString("password");
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("name", name);
                map.put("password", password);
                personList.add(map);
                Log.i(TAG, "testConnection: person" + personList);

            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {

        } finally {
            if (con1 != null)
                try {
                    con1.close();
                } catch (SQLException e) {
                }
        }

        return personList;
    }

}
