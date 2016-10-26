package com.qlbh.pojo;

public class InforConfig {
	private String dbname;
	private String pass;
	private String user;

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public InforConfig(String dbname, String pass, String user) {
		super();
		this.dbname = dbname != null ? dbname : "qlbh";
		this.pass = pass != null ? pass : "1234";
		this.user = user != null ? user : "root";
	}

	@Override
	public String toString() {
		return "InforConfig [dbname=" + dbname + ", pass=" + pass + ", user=" + user + "]";
	}

	public InforConfig() {
		super();
	}

}
