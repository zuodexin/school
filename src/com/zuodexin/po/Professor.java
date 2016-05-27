package com.zuodexin.po;

// Generated 2016-5-27 11:22:51 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import com.zuodexin.po.itf.Refreshable;

/**
 * Professor generated by hbm2java
 */
public class Professor implements java.io.Serializable ,Refreshable{

	private int id;
	private Institute institute;
	private String workId;
	private String password;
	private String name;
	private Set<Hire> hires = new HashSet<Hire>(0);
	private Set<Instruct> instructs = new HashSet<Instruct>(0);
	private Set<TeachClass> teachClasses = new HashSet<TeachClass>(0);

	public Professor() {
	}

	public Professor(int id, String workId, String password, String name) {
		this.id = id;
		this.workId = workId;
		this.password = password;
		this.name = name;
	}

	public Professor(int id, Institute institute, String workId,
			String password, String name, Set<Hire> hires,
			Set<Instruct> instructs, Set<TeachClass> teachClasses) {
		this.id = id;
		this.institute = institute;
		this.workId = workId;
		this.password = password;
		this.name = name;
		this.hires = hires;
		this.instructs = instructs;
		this.teachClasses = teachClasses;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Institute getInstitute() {
		return this.institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	public String getWorkId() {
		return this.workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Hire> getHires() {
		return this.hires;
	}

	public void setHires(Set<Hire> hires) {
		this.hires = hires;
	}

	public Set<Instruct> getInstructs() {
		return this.instructs;
	}

	public void setInstructs(Set<Instruct> instructs) {
		this.instructs = instructs;
	}

	public Set<TeachClass> getTeachClasses() {
		return this.teachClasses;
	}

	public void setTeachClasses(Set<TeachClass> teachClasses) {
		this.teachClasses = teachClasses;
	}

}