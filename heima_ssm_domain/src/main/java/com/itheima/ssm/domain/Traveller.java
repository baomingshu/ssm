package com.itheima.ssm.domain;

public class Traveller {

	private int id;
	private String name;
	private String sex;
	private String phoneNum;
	private Integer credentialsType;//证件类型，0身份证，1护照，2军官证
	private String credentialsTypeStr;
	private String credentialsTypeNum;
	private Integer travellerType;
	private String credentialsNum;//旅客类型 0身份证 1护照 2军官证
	private String travellerTypeStr;
	public String getCredentialsNum() {
		return credentialsNum;
	}
	public void setCredentialsNum(String credentialsNum) {
		this.credentialsNum = credentialsNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Integer getCredentialsType() {
		return credentialsType;
	}
	public void setCredentialsType(Integer credentialsType) {
		this.credentialsType = credentialsType;
	}
	public String getCredentialsTypeStr() {
		if (credentialsType !=null){
			if (credentialsType ==0){
				credentialsTypeStr ="身份证";
			}else if (credentialsType ==1){
				credentialsTypeStr="护照";
			}else if (credentialsType ==2){
				credentialsTypeStr="军官证";
			}
			
		}
		
		
		return credentialsTypeStr;
	}
	public void setCredentialsTypeStr(String credentialsTypeStr) {
		this.credentialsTypeStr = credentialsTypeStr;
	}
	public String getCredentialsTypeNum() {
		return credentialsTypeNum;
	}
	public void setCredentialsTypeNum(String credentialsTypeNum) {
		this.credentialsTypeNum = credentialsTypeNum;
	}
	public Integer getTravellerType() {
		return travellerType;
	}
	public void setTravellerType(Integer travellerType) {
		this.travellerType = travellerType;
	}
	public String getTravellerTypeStr() {
		if (travellerType !=null){
			if(travellerType ==0){
				travellerTypeStr ="成人";	
			}else if(travellerType==1){
				travellerTypeStr ="儿童";
			}
		}
		
		return travellerTypeStr;
	}
	public void setTravellerTypeStr(String travellerTypeStr) {
		this.travellerTypeStr = travellerTypeStr;
	}
	
}
