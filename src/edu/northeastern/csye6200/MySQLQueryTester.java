package edu.northeastern.csye6200;

import java.sql.ResultSet;  
import java.sql.SQLException;

public class MySQLQueryTester {  
    
    static String sql = null;  
    static MySQLConnector db1 = null;  
    static ResultSet ret = null;  
    
    public static void main(String[] args) {  
        sql = "select * from account";//SQL语句  
        db1 = new MySQLConnector(sql);//创建 MySQLConnector 对象
        
        try {  
            ret = db1.pst.executeQuery();//执行语句，得到结果集  
            while (ret.next()) {  
                String id = ret.getString(1);  
                String firstName = ret.getString(2);  
                String lastName = ret.getString(3);  
                String accountId = ret.getString(4);
                String password = ret.getString(5);
                //System.out.println("id" + "\t" + "firstName" + "\t" + "lastName" + "\t" + "accountId" + "\t" + "password"); 
                //打印数据
                System.out.println(id + "\t" + firstName + "\t" + lastName + "\t" + accountId + "\t" + password);  
            }
            ret.close();  
            db1.close();//关闭连接  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
    
}
