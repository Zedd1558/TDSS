/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisselectionsystem;
import java.util.Arrays;
import java.util.Comparator;


/**
 *
 * @author HP
 */
public class topic_list {
    public Thesis_topic[] list;
    /*static private Comparator<Student> CGPA;
     static {
        CGPA = new Comparator<Student>(){
            @Override
            public int compare(Student s1, Student s2){
               // return s1.getCGPA().compareTo(s2.getCGPA());
               if(s1.getCGPA()>s1.getCGPA())
                   return 1;
               else 
                   return 0;
            }
        };
     }*/
    private int sz;
    public  topic_list()
    {
        list=new Thesis_topic[100];
        sz=0;
    }
    public  topic_list(int size)
    {
        list=new Thesis_topic[size];
        sz=0;
    }
    public void add(Thesis_topic th)
    {
       if(sz<list.length)
       {
           list[sz]=th;
       }
       else
       {
           Thesis_topic ls[]=new Thesis_topic[list.length+100];
           list=ls;
           list[sz]=th;
       }
       sz++;
    }
    public void assign_students(Student[] st)//takes an array of students form main,sorts them using their cgpa and preference and then assigns them a topic
    {
       
         Arrays.sort(st);
         System.out.println("call hoyise");
        // System.out.println("ki"+st.length+" sd");
        for(int i=0;i<st.length;i++)
        {
            st[i].assigned=false;
        }
         for(int i=0;i<st.length;i++)
         {
            // System.out.println("eikhane");
             System.out.println("");
             System.out.println("id: "+st[i].getStudent_id()+" "+st[i].getCGPA()+" partners: "+st[i].getPartner_id()+" "+st[i].getPartner_id2());
             if(st[i].assigned==true)
                 System.out.print("yes");
             else
                 System.out.print("no");
             if(st[i].assigned==true)
                 continue;
             //System.out.println(st[i].preference[0]+" fefe");
           
                 
             for(int j=0;j<st[i].preference.length;j++)
             {
                // System.out.println("bal");
                 //int key;
                 boolean p=false;
                 
                 
                 for(int k=0;k<list.length&&list[k]!=null;k++)
                 {
                     
                   //  System.out.println(list[k].getDescription()+" "+list[k].getThesis_id());
                   //  System.out.println(sz+" dsd");
                    //if(list[k]==null)
                       //  System.out.println("sd");
                   //  if(st[i].preference==null)
                       //  System.out.println("sdsd");
                     if(list[k].getThesis_id()==st[i].preference[j]&&list[k].no_of_st==0)
                     {
                        // System.out.println("sddsdsdsd "+list[k].getThesis_id());
                         st[i].setAssigned_project(list[k].getThesis_id());
                         st[i].assigned=true;
                         //do the same for his partner;
                         int part;
                         int part_id=0;
                         int part_id2=0;
                         for( part=0;part<st.length;part++)
                         {
                             if(st[part].getStudent_id()==st[i].getPartner_id())
                             {
                                 st[part].setAssigned_project(list[k].getThesis_id());
                                 st[part].assigned=true;
                                 part_id=part;
                                 System.out.println("partner 1");
                               //  break;
                             }
                             else if(st[part].getStudent_id()==st[i].getPartner_id2())
                             {
                                 st[part].setAssigned_project(list[k].getThesis_id());
                                 st[part].assigned=true;
                                 part_id2=part;
                                 System.out.println("partner 2");    
                               //  break;
                             }
                         }
                         
                         
                         //
                        // System.out.println(k+" d1s "+i+" "+part_id);
                        //System.out.println("thesis stuff "+list[k].getDescription()+" "+list[k].getThesis_id());
                       // System.out.println("student stuff "+st[i].getUserName()+" "+st[i].getStudent_id());
                         list[k].assign_st(st[i].getStudent_id());
                         
                         list[k].assign_st(st[part_id].getStudent_id());
                         list[k].assign_st(st[part_id2].getStudent_id());
                         list[k].no_of_st=3;
                         p=true;
                     }
                 }
                 if(p==true)
                     break;
             }
             
         }
         
    
    }
}
