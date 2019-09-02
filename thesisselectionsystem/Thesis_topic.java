/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisselectionsystem;

/**
 *
 * @author HP
 */
public class Thesis_topic {

    private int thesis_id;
    public static int cnt=0;
    private int supervisor;
    private String Department;
    public int assigned_Students[]=new int[100];
    public int no_of_st=0;
    static int assign_in=0;
    private String description;
    public static topic_list list_pointer;

    public int getThesis_id() {
        return thesis_id;
    }
    
    
    public void assign_st(int st)
    {
       assigned_Students[assign_in++]=st;
       no_of_st++;
    }
    
    
    public void setThesis_id(int thesis_id) {
        this.thesis_id = thesis_id;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public int[] getAssigned_Students() {
        return assigned_Students;
    }

    public void setAssigned_Students(int[] assigned_Students) {
        this.assigned_Students = assigned_Students;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Thesis_topic()
    {
        
    }
    public Thesis_topic(String dept,String desc)
    {
        Department=dept;
        description=desc;
        thesis_id=cnt++;
        //supervisor=sup;
        list_pointer.add(this);
        
    }
    
    

}
