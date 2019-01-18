/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Home;



/**
 *
 * @author way4ward
 */
public class LoadTables2 {
    private String firstname;
    private String lastname;
    private String gender;
    private String offence;
    private String reporter;
   private String penalty;
   private String id;
    
public LoadTables2(String firstname  , String lastname  , String gender  ,  String offence  , String reporter  , String penalty, String id  ){
    this.firstname = firstname;
    this.lastname = lastname;
    this.gender = gender;
    this.offence = offence;
    this.reporter = reporter;
    this.penalty = penalty;
    this.id = id;

}

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the offence
     */
    public String getOffence() {
        return offence;
    }

    /**
     * @param offence the offence to set
     */
    public void setOffence(String offence) {
        this.offence = offence;
    }

    /**
     * @return the reporter
     */
    public String getReporter() {
        return reporter;
    }

    /**
     * @param reporter the reporter to set
     */
    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    /**
     * @return the penalty
     */
    public String getPenalty() {
        return penalty;
    }

    /**
     * @param penalty the penalty to set
     */
    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

   


}
