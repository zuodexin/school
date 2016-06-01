package com.zuodexin.controller;

import com.zuodexin.biz.ProfessorBiz;

public class ProfessorController {
	static private ProfessorController professorController; 
	private ProfessorBiz biz;
	
	private ProfessorController(){
		
	}
	static public ProfessorController getInstance(){
		if(professorController==null)
			professorController=new ProfessorController();
		return professorController;
	}
	public ProfessorBiz getBiz() {
		return biz;
	}
	public void setBiz(ProfessorBiz biz) {
		this.biz = biz;
	}
	
}
