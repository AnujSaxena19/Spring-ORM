package com.GL.SpringORM.dao;


import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.GL.SpringORM.entities.Student;

public class StudentDao {
	
	
	private HibernateTemplate hibernateTemplate;
	//save student
	@Transactional
	public int insert(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}
	
	//get the single data (object)
	public Student getStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//get all the data
	public List<Student> getAllStudents(){
		List<Student> students = hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//delete the data
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = hibernateTemplate.get(Student.class, studentId);
		hibernateTemplate.delete(student);
	}
	
	//updating data
	@Transactional
	public void updateStudent(Student student) {
		hibernateTemplate.update(student);
	}
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
}
