package com.student.dao;

import java.util.List;

import com.student.bo.LoginBo;
import com.student.bo.StudentBo;
import com.student.vo.LoginVo;
import com.student.vo.StudentVo;

public interface StudentDao {

	int signIn(StudentVo studentVo);

	List<StudentVo> view(String email, String role);

	StudentVo edit(int id);

	int update(StudentVo studentVo);

	int delete(int id);

	boolean isEmailExists(String email);

	int loginSave(LoginVo loginVo);

	LoginVo loginCheck(String email, String password);

	LoginVo getLoginId(LoginVo loginVo);

	void updateLogin(LoginVo loginVo);

	void deleteLogin(LoginVo loginVo);

	List<StudentVo> search(StudentBo studentBo);

	StudentVo getInfo(String email);

}
