package com.zuodeixn.biz;

import java.util.List;

import org.junit.Test;

import com.zuodexin.biz.CourseBiz;
import com.zuodexin.biz.ProfessorBiz;
import com.zuodexin.po.Course;
import com.zuodexin.po.Instruct;
import com.zuodexin.po.Professor;
import com.zuodexin.po.Schoolclass;
import com.zuodexin.po.Student;
import com.zuodexin.po.TeachClass;

public class TestProfessorBiz {
	ProfessorBiz professorBiz;
	
	@Test
	public void testAddProfessor(){
		Professor professor=new Professor();
		professor.setName("教授甲");
		professor.setPassword("123");
		professor.setWorkId("2121");
		professorBiz=new ProfessorBiz();
		professorBiz.addEntity(professor);
	}
	@Test
	public void testLogin() {
		professorBiz=new ProfessorBiz();
		if(professorBiz.Login("2121", "1213")){
			System.out.println("登录成功");
		}
		else{
			System.out.println("用户名或密码错误");
		}	
	}
	
	@Test
	public void testInstructCourse(){
		Course course=new Course();
		course.setId(2);
		course=(Course) new CourseBiz().fillEntity(course);
		professorBiz=new ProfessorBiz();
		professorBiz.Login("2121", "123");
		professorBiz.instructCourse(course);
	}
	
	@Test
	public void testTeachClass(){
		professorBiz=new ProfessorBiz();
		professorBiz.Login("2121", "123");
		Professor professor=(Professor) professorBiz.getEntity();
		List<Instruct> instructList=professorBiz.getInstructList();
		for(Instruct i:instructList){
			System.out.println(professor.getName()+" 教  "+i.getCourse().getName());
		}
		System.out.println(professor.getName()+"负责的班级有");
		List<TeachClass> teachList=professorBiz.getTeachClassesList();
		for(TeachClass t:teachList){
			System.out.println(t.getSchoolclass().getInfo());
		}
		
		
		Course course=instructList.get(0).getCourse();
		CourseBiz courseBiz=new CourseBiz(course);
		List<Schoolclass> classList=courseBiz.getClassList();
		System.out.println("班级列表");
		for(Schoolclass s:classList){
			System.out.println(s.getInfo());
		}
		
		Schoolclass toTeach=classList.get(0);
		professorBiz.teachClass(toTeach);
		
		System.out.println(professor.getName()+"负责的班级有");
		teachList=professorBiz.getTeachClassesList();
		for(TeachClass t:teachList){
			System.out.println(t.getSchoolclass().getInfo());
		}
		
//		professorBiz.declineClass(toTeach);
//		System.out.println(professor.getName()+"负责的班级有");
//		teachList=professorBiz.getTeachClassesList();
//		for(TeachClass t:teachList){
//			System.out.println(t.getSchoolclass().getInfo());
//		}
	}
	
	@Test
	public void testGiveGrade(){
		professorBiz=new ProfessorBiz();
		professorBiz.Login("2121", "123");
		Professor professor=(Professor) professorBiz.getEntity();
		List<Instruct> instructList=professorBiz.getInstructList();
		for(Instruct i:instructList){
			System.out.println(professor.getName()+" 教  "+i.getCourse().getName());
		}
		System.out.println(professor.getName()+"负责的班级有");
		List<TeachClass> teachList=professorBiz.getTeachClassesList();
		for(TeachClass t:teachList){
			System.out.println(t.getSchoolclass().getInfo());
		}
		Schoolclass schoolclass=teachList.get(0).getSchoolclass();
		List<Student> stulist=professorBiz.seeStudentList(schoolclass);
		System.out.println("选择了该课的有");
		for(Student s:stulist){
			System.out.println(s.getName());
		}
		Student student=stulist.get(0);
		professorBiz.gaveGrades(schoolclass.getCourse(), student, 100);
	}
}
