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
public class Student extends User implements Comparable {

    public int getPartner_id2() {
        return partner_id2;
    }

    public void setPartner_id2(int partner_id2) {
        this.partner_id2 = partner_id2;
    }

    private  int student_id=0;
    public static int cnt=0;
    private String semester;
    private String batch;
    private int partner_id;
    private int partner_id2;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private String CGPA;
    boolean assigned=false;
    //private thesis_preferance;
    private int assigned_project;
    public int[] preference = new int[10];//stores thesis id;
    private int preference_size = 0;
    
    @Override
    public boolean equals(Object obj)
    {
        return (((Student)obj).getCGPA()==this.getCGPA());
    }
    @Override
    public int compareTo(Object obj)
    {
        Student st=(Student)obj;
        return st.getCGPA().compareTo(this.getCGPA());
    }
    public Student(String name,String dept,String semester,String batch,int partner_id,int partner_id2,String CGPA)
    {
        super(name,dept);
        this.semester=semester;
        this.batch=batch;
        this.partner_id=partner_id;
        this.CGPA=CGPA;
        this.partner_id2=partner_id2;
        student_id=cnt++;
    }
    public Student()
    {
        super();
        assigned=false;
    }
    public int getAssigned_project() {
        return assigned_project;
    }

    public void setAssigned_project(int assigned_project) {
        this.assigned_project = assigned_project;
        this.assigned=true;
    }

    public int[] getPreference() {
        return preference;
    }

    public void setPreference(int[] preference, int partner,int partner2) {
        this.preference = preference;
        this.partner_id = partner;
        this.setPartner_id2(partner2);
    }
    public void setPreference(int[] preference) {
        this.preference = preference;
        //this.partner_id = partner;
    }
        
    public String getCGPA() {
        return CGPA;
    }

    public void setCGPA(String CGPA) {
        this.CGPA = CGPA;
    }

    /**
     * @return the student_id
     */
    public int getStudent_id() {
        return student_id;
    }

    /**
     * @param student_id the student_id to set
     */
    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the partner_id
     */
    public int getPartner_id() {
        return partner_id;
    }

    /**
     * @param partner_id the partner_id to set
     */
    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    /**
     * @param thesis_id
     */
    public void give_preference(int thesis_id) {

        getPreference()[preference_size++] = thesis_id;
    }

}
