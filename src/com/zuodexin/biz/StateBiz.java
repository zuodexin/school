package com.zuodexin.biz;

import com.zuodexin.dao.StateDao;
import com.zuodexin.po.State;

public class StateBiz extends Biz{
	public static final String SEMESTER_START="SemesterStart";
	public static final String SEMESTER_END="SemesterEnd";
	public static final String SYSTEM_CLOSE="SystemClose";
	public StateBiz(){
		this.entityDao=new StateDao();
	}
	public void activateState(State state){
		StateDao stateDao=(StateDao) this.entityDao;
		State a_state=stateDao.findActiveState();
		if(state!=null&&a_state!=null&&state.getId()!=a_state.getId()){
			a_state.setActive(false);
			state.setActive(true);
			stateDao.updateOne(a_state);
			stateDao.updateOne(state);
		}
	}
	public boolean isSelectCourseAllowed(){
		StateDao stateDao=(StateDao) this.entityDao;
		State a_state=stateDao.findActiveState();
		return a_state.isCanSelectCourse();
	}
	public boolean isTeachClassAllowed(){
		StateDao stateDao=(StateDao) this.entityDao;
		State a_state=stateDao.findActiveState();
		return a_state.isCanTeachClass();
	}
	public boolean isGaveGradeAllowed(){
		StateDao stateDao=(StateDao) this.entityDao;
		State a_state=stateDao.findActiveState();
		return a_state.isCanGaveGrade();
	}
	public State getActiveState(){
		StateDao stateDao=(StateDao) this.entityDao;
		State a_state=stateDao.findActiveState();
		return a_state;
	}
}
