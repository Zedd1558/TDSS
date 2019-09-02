/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisselectionsystem;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 * 
 * @author DOLPHIN
 */
public class Dbconn {
   
    
    public static Connection getDbconn()
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            Connection conn  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","thesis_system","1234");
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        return null;
    }
    public static boolean insertStudent(int ID, String pw, String name, String dept,String cg)
    {
        try{
        String insertString = "insert into student values(?,?,?,?,null,?,null,null,null,null,null,null)";
        Connection conn = getDbconn();
        PreparedStatement pst = conn.prepareStatement(insertString);
        pst.setInt(1,ID);
        pst.setString(2,pw);
        pst.setString(3,name);
        pst.setString(4,dept);
        pst.setString(5,cg);
        int i = pst.executeUpdate();
        System.out.println(i+ " rows updated.");
        return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
    public static boolean insertSupervisor(int ID, String pw, String name, String dept, String rank)
    {
        try{
        String insertString = "insert into supervisor values(?,?,?,?,?)";
        Connection conn = getDbconn();
        PreparedStatement pst = conn.prepareStatement(insertString);
        pst.setInt(1,ID);
        pst.setString(2,pw);
        pst.setString(3,name);
        pst.setString(4,dept);
        pst.setString(5,rank);
        int i = pst.executeUpdate();
        System.out.println(i+ " rows updated.");
        return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
    public static boolean insertThesis(int ID,String name, int superID ,String dept, String desc)
    {
        try{
        String insertString = "insert into thesis_topic values(?,?,?,?,?,null,null,null)";
        Connection conn = getDbconn();
        PreparedStatement pst = conn.prepareStatement(insertString);
        pst.setInt(1,ID);
        pst.setString(2,name);
        pst.setInt(3,superID);
        pst.setString(4,dept);
        pst.setString(5,desc);
        int i = pst.executeUpdate();
        System.out.println(i+" rows updated.");
        return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
    public static boolean insertPreference(int ID, int partner,int partner2, int p1, int p2, int p3, int p4)
    {
        try{
            String insertString = "update student set partner_id = ?,partner_id2 = ?,pref1 = ? , pref2 = ?, pref3 = ?, pref4 = ? ";
            insertString = insertString + " where id = ? ";
            Connection conn = getDbconn();
            PreparedStatement pst = conn.prepareStatement(insertString);
            pst.setInt(1,partner);
            pst.setInt(2,partner2);
            pst.setInt(3,p1);
            pst.setInt(4,p2);
            pst.setInt(5,p3);
            pst.setInt(6,p4);
            pst.setInt(7,ID);
            int i = pst.executeUpdate();
            return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }
    public static String supervisorLogin(int id)
    {
        try{
            String rss= "select pw from supervisor where id = "+ id;
            Connection conn = getDbconn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(rss) ;
            if(rs.next()) return rs.getString(1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
        return null;
    }
    public static String studentLogin(int id)
    {
        try{
            String rss= "select pw from student where id = "+ id;
            Connection conn = getDbconn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(rss) ;
            if(rs.next()) return rs.getString(1);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
        return null;
    }
    public static boolean sendFeedback(int id, String fb,String st)
    {
        try{
        String insertString = "insert into feedback values (?,?,?)";
        Connection conn = getDbconn();
        PreparedStatement pst = conn.prepareStatement(insertString);
        pst.setInt(1,id);
        pst.setString(2,st);
        pst.setString(3,fb);
        //pst.setString(4,dept);
        //pst.setString(5,desc);
        int i = pst.executeUpdate();
        System.out.println(i+" rows updated.");
        return true;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
    }
}
