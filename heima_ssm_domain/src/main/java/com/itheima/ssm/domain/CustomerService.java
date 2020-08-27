package com.itheima.ssm.domain;

import java.util.List;

public class CustomerService {
		private int id;
	    private String customerName;
	
	    private String customerNum;
	    private String phoneNum;
	    private int status;
	    private String statusStr;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		
		public String getCustomerNum() {
			return customerNum;
		}
		public void setCustomerNum(String customerNum) {
			this.customerNum = customerNum;
		}
		public String getPhoneNum() {
			return phoneNum;
		}
		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getStatusStr() {
			if (status ==0 ){
	    		statusStr = "在线";
	    	}else if (status==1){
	    		statusStr = "不在线";
	    	}
			return statusStr;
		}
		public void setStatusStr(String statusStr) {
			this.statusStr = statusStr;
		}
	

}
