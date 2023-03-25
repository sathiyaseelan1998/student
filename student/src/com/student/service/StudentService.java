package com.student.service;

import java.util.List;

import com.student.bo.LoginBo;
import com.student.bo.StudentBo;

public interface StudentService {

	int signIn(StudentBo studentBo);

	List<StudentBo> view(String email, String role);

	StudentBo edit(int id);

	int Update(StudentBo studentBo);

	int delete(int id);

	boolean isEmailExists(String email);

	LoginBo loginCheck(String email, String password);

	List<StudentBo> search(StudentBo studentBo);

	int forget(StudentBo studentBo);

}
