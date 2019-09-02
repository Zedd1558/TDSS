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
public class Office extends User {
    private String user_id;
    private String job_title;

    /**
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the job_title
     */
    public String getJob_title() {
        return job_title;
    }

    /**
     * @param job_title the job_title to set
     */
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
    
}
