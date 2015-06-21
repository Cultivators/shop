package cn.cultivator.shop.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */

public class Forder implements java.io.Serializable {

	// Fields

	private Integer fid;
	private String fname;
	private String fphone;
	private String fremark;
	private String femail;
	private Timestamp fdate;
	private Double ftotal;
	private String fpost;
	private Users users;
	private Status status;
	private Set<Sorder> sorders = new HashSet<Sorder>();
	
	

	// Constructors

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<Sorder> getSorders() {
		return sorders;
	}

	public void setSorders(Set<Sorder> sorders) {
		this.sorders = sorders;
	}

	/** default constructor */
	public Forder() {
	}

	/** full constructor */


	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFphone() {
		return this.fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}

	public String getFremark() {
		return this.fremark;
	}

	public void setFremark(String fremark) {
		this.fremark = fremark;
	}

	public String getFemail() {
		return this.femail;
	}

	public void setFemail(String femail) {
		this.femail = femail;
	}

	public Timestamp getFdate() {
		return this.fdate;
	}

	public void setFdate(Timestamp fdate) {
		this.fdate = fdate;
	}

	public Double getFtotal() {
		return this.ftotal;
	}

	public void setFtotal(Double ftotal) {
		this.ftotal = ftotal;
	}

	public String getFpost() {
		return this.fpost;
	}

	public void setFpost(String fpost) {
		this.fpost = fpost;
	}

}