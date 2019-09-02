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
public class Supervisor extends User {

    private int Supervisor_id;
    private static int cnt = 0;
    private String supervisor_rank;
    private int[] supervising_projects;

    //private int affiliated_Student_id[][];
    public int[] getSupervising_projects() {
        return supervising_projects;
    }

    public void setSupervising_projects(int[] supervising_projects) {
        this.supervising_projects = supervising_projects;
    }

    public Supervisor(String rank, String name, String Department) {
        super(name, Department);
        cnt++;
        Supervisor_id = cnt;
        supervisor_rank = rank;

    }
    public Supervisor(){
        super();
    };
    /**
     * @return the Supervisor_id
     */
    public int getSupervisor_id() {
        return Supervisor_id;
    }

    /**
     * @param Supervisor_id the Supervisor_id to set
     */
    public void setSupervisor_id(int Supervisor_id) {
        this.Supervisor_id = Supervisor_id;
    }

    /**
     * @return the proposed_project_id
     */
    /**
     * @return the supervisor_rank
     */
    public String getSupervisor_rank() {
        return supervisor_rank;
    }

    /**
     * @param supervisor_rank the supervisor_rank to set
     */
    public void setSupervisor_rank(String supervisor_rank) {
        this.supervisor_rank = supervisor_rank;
    }

    //this creates a thesis topic,updates the thesis topics_list;
    public void create_thesis_topic(String desc) {
        //    String desc;
        Thesis_topic topic = new Thesis_topic(Department, desc);
        topic.setSupervisor(this.getSupervisor_id());

        if (getSupervising_projects() != null) {
            int[] proj;
            int l = getSupervising_projects().length;
            proj = new int[l + 1];
            for (int i = 0; i < l; i++) {
                proj[i] = getSupervising_projects()[i];

            }
            proj[l] = topic.getThesis_id();
            setSupervising_projects(proj);
        } else {

            setSupervising_projects(new int[1]);
            getSupervising_projects()[0] = topic.getThesis_id();
        }

    }

}
