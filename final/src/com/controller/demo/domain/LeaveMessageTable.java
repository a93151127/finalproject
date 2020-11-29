package com.controller.demo.domain;

public class LeaveMessageTable {
	private  int companyNumber ;
    private  String companyName ; 
    private String date ; 
    private String title ; 
    private String content ;
    
   public int getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(int companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
public String getDate() {
        return date;
   }
   public  void setDate(String date2) {
        this .date = date2;
   }
   public String getTitle() {
        return title;
   }
   public  void setTitle(String title) {
        this .title = title;
   }
   public String getContent() {
        return content;
   }
   public  void setContent(String content) {
        this .content = content;
   }
}
