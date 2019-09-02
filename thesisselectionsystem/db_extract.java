/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisselectionsystem;
import java.sql.*;
/**
 *
 * @author HP
 */
public class  db_extract {
    static String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";//ei address kaj na korle call me zahid"
    static Connection con=null;
    static Statement stat=null;
    static ResultSet result=null;
    public static Supervisor[] get_supervisor()
    {
        Supervisor sp_arr[]=null;//new Supervisor[100];
        try{
            
       
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            
            String qr="select count(*) from supervisor";
            result=stat.executeQuery(qr);
           // result.next();
            int row_num=10;//result.getInt(1);
            sp_arr=new Supervisor[100];
            //sp_arr[0].setSupervisor_id(1);
            qr="select * from Supervisor";
            result=stat.executeQuery(qr);
            int cnt=0;
            ResultSetMetaData metadata=result.getMetaData();
            int col_num=metadata.getColumnCount();
            //System.out.println(col_num);
            while(result.next())
            {
               // System.out.println(result.getInt("id"));
                int x=result.getInt("id");
               // System.out.println(x);
               
                String str=result.getString("name");
               // System.out.println(str);
             //  if(sp_arr[cnt]==null)
                    //System.out.println("bal");
               Supervisor sp1=new Supervisor(); 
               System.out.println();
                sp1.setSupervisor_id(x);
                sp1.setUserName(str);
                sp1.setDepartment(result.getString("dept"));
                sp1.setSupervisor_rank(result.getString(5));
                sp_arr[cnt]=sp1;
                String qr2="select thesis_topic.id from thesis_topic,supervisor where thesis_topic.supervisor=supervisor.id";
                String qr3="select count(*) from ("+qr2+")";
               /* ResultSet res2=stat.executeQuery(qr3);
                //res2.next();
               // int row_num1=res2.getInt(1);
                int pr[]= new int[100];
                res2=stat.executeQuery(qr2);
                int cn=0;
                while(res2.next())
                {
                    pr[cn++]=res2.getInt(1);
                    cn++;
                }*/
                //sp_arr[cnt].setSupervising_projects(pr);
                cnt++;
               // assign_projects(sp_arr,cnt-1);
            }
            
            
           // metadata=result.getMetaData();
          
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return sp_arr;
    }
    public static void assign_projects(Supervisor[] sp_arr,int c)
    {
        try{
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
             String qr2="select thesis_topic.id from thesis_topic,supervisor where thesis_topic.supervisor=supervisor.id and supervisor.id="+sp_arr[c].getSupervisor_id();
         //String qr3="select count(*) from ("+qr2+")";
          ResultSet res2=stat.executeQuery(qr2);
                //res2.next();
                //int row_num1=res2.getInt(1);
                int pr[]= new int[100];
                //res2=stat.executeQuery(qr2);
                int cn=0;
                while(res2.next())
                {
                    pr[cn++]=res2.getInt(1);
                    cn++;
                }
                sp_arr[c].setSupervising_projects(pr);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static Student[] get_student()
    {
        Student st_arr[]=null;
        try{
            
       
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            
            //String qr="select count(*) from student";
            //result=stat.executeQuery(qr);
          // result.next();
            int row_num=100;
            st_arr=new Student[row_num];
            String qr="select * from student";
            ResultSet result=stat.executeQuery(qr);
            int cnt=0;
            ResultSetMetaData metadata=result.getMetaData();
            int col_num=metadata.getColumnCount();
            //System.out.println("kiu?");
            while(result.next())
            {
               // System.out.println("kiu?");
                Student dt=new Student();
                dt.setStudent_id(result.getInt("id"));
               dt.setUserName(result.getString("name"));
                dt.setDepartment(result.getString("dept"));
                dt.setPartner_id(result.getInt("partner_id"));
                dt.setPartner_id2(result.getInt("partner_id2"));
                dt.setCGPA(result.getString("CGPA"));
                dt.setAssigned_project(result.getInt("as_proj"));
                dt.give_preference(result.getInt("pref1"));
               dt.give_preference(result.getInt("pref2"));
                dt.give_preference(result.getInt("pref3"));
                dt.give_preference(result.getInt("pref4"));
                st_arr[cnt]=dt;
                //System.out.println(st_arr[cnt].getStudent_id());
                cnt++;
            }
           
           // System.out.println(st_arr[10].getStudent_id());
           // metadata=result.getMetaData();
         // return st_arr;
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                //result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return st_arr;
    }
    
    
    public static topic_list get_topic_list()
    {
        topic_list topic=null;
        try{
            
       
            con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            
            String qr="select count(*) from thesis_topic";
            result=stat.executeQuery(qr);
           // result.next();
            int row_num=100;
            topic=new topic_list(row_num);
            qr="select * from thesis_topic";
            result=stat.executeQuery(qr);
            int cnt=0;
            ResultSetMetaData metadata=result.getMetaData();
            int col_num=metadata.getColumnCount();
            while(result.next())
            {
                Thesis_topic ths=new Thesis_topic();
                ths.setThesis_id(result.getInt("id"));
                ths.setSupervisor(result.getInt("supervisor"));
                ths.setDepartment(result.getString("department"));
                ths.setDescription(result.getString("description"));
              //  if(result.getInt(5)==null)
                int as[]=new int[3];
                as[0]=result.getInt("assigned_student1");
                boolean a=true;
                boolean b=true;
                boolean c=true;
                if(result.wasNull()==true)
                {
                    a=false;
                }
                as[1]=result.getInt("assigned_student2");
                if(result.wasNull()==true)
                {
                    b=false;
                }
                as[2]=result.getInt("assigned_student3");
                if(result.wasNull()==true)
                {
                    c=false;
                }
                if(a&&b&&c)
                    ths.setAssigned_Students(as);
                topic.add(ths);
                cnt++;
            }
           
            
           // metadata=result.getMetaData();
          
            
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                //result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return topic;
    }
    public static void modify(Student[] st,Supervisor[] sp,topic_list tp)
    {
        try{
             con=DriverManager.getConnection(DB_URL,"thesis_system","1234");
            stat=con.createStatement();
            for(int i=0;i<st.length&&st[i]!=null;i++){
                System.out.println(st[i].getAssigned_project());
                String qr="update student set as_proj="+st[i].getAssigned_project()+" where id="+st[i].getStudent_id();
                stat.executeQuery(qr);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                //result.close();
                stat.close();
                con.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
        
        
    }
}
