package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.bo.LoginBo;
import com.student.bo.StudentBo;
import com.student.dao.StudentDao;
import com.student.vo.LoginVo;
import com.student.vo.StudentVo;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;
	
	StudentBo studentBo=new StudentBo();
	StudentVo studentVo=new StudentVo();
	@Override
	public int signIn(StudentBo studentBo) {
		// TODO Auto-generated method stub
		studentVo.setName(studentBo.getName());
		studentVo.setEmail(studentBo.getEmail());
		studentVo.setPassword(studentBo.getPassword());
		studentVo.setConfirmPassword(studentBo.getConfirmPassword());
		studentVo.setRole(studentBo.getRole());
		studentVo.setAddress(studentBo.getAddress());
		
		int id=studentDao.signIn(studentVo);
		
		if(id>0){
			LoginVo loginVo=new LoginVo();
			loginVo.setEmail(studentBo.getEmail());
			loginVo.setPassword(studentBo.getPassword());
			loginVo.setConfirmPassword(studentBo.getConfirmPassword());
			loginVo.setRole(studentBo.getRole());
			
			studentVo.setId(id);
			loginVo.setStudentVo(studentVo);
			
			int loginId=studentDao.loginSave(loginVo);
		}
		
		return id;
	}
	@Override
	public List<StudentBo> view(String email,String role) {
		// TODO Auto-generated method stub
		List<StudentBo> listBo=new ArrayList<StudentBo>();
		List<StudentVo> listVo=new ArrayList<StudentVo>();
		listVo=studentDao.view(email,role);
		for(StudentVo vo:listVo){
			StudentBo bo=new StudentBo();
			bo.setId(vo.getId());
			bo.setName(vo.getName());
			bo.setEmail(vo.getEmail());
			bo.setPassword(vo.getPassword());
			bo.setConfirmPassword(vo.getConfirmPassword());
			bo.setRole(vo.getRole());
			bo.setAddress(vo.getAddress());
			listBo.add(bo);
		}
		return listBo;
	}
	@Override
	public StudentBo edit(int id) {
		// TODO Auto-generated method stub
		studentVo=studentDao.edit(id);
		if(null!=studentVo){
			studentBo.setId(studentVo.getId());
			studentBo.setName(studentVo.getName());
			studentBo.setEmail(studentVo.getEmail());
			studentBo.setPassword(studentVo.getPassword());
			studentBo.setConfirmPassword(studentVo.getConfirmPassword());
			studentBo.setRole(studentVo.getRole());
			studentBo.setAddress(studentVo.getAddress());
		}
		return studentBo;
	}
	@Override
	public int Update(StudentBo studentBo) {
		// TODO Auto-generated method stub
		studentVo.setId(studentBo.getId());
		studentVo.setName(studentBo.getName());
		studentVo.setEmail(studentBo.getEmail());
		studentVo.setPassword(studentBo.getPassword());
		studentVo.setConfirmPassword(studentBo.getConfirmPassword());
		studentVo.setRole(studentBo.getRole());
		studentVo.setAddress(studentBo.getAddress());
		int id=studentDao.update(studentVo);
		if(id>0){
			LoginVo loginVo=new LoginVo();
			StudentVo studentVo=new StudentVo();
			studentVo.setId(id);
			loginVo.setStudentVo(studentVo);
			loginVo=studentDao.getLoginId(loginVo);
			if(null!=loginVo){
				
				loginVo.setLoginId(loginVo.getLoginId());
				loginVo.setEmail(studentBo.getEmail());
				loginVo.setPassword(studentBo.getPassword());
				loginVo.setConfirmPassword(studentBo.getConfirmPassword());
				loginVo.setRole(studentBo.getRole());
				studentDao.updateLogin(loginVo);
			}
		}
		return id;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		id=studentDao.delete(id);
		if(id>0){
		LoginVo loginVo=new LoginVo();
		StudentVo studentVo=new StudentVo();
		studentVo.setId(id);
		loginVo.setStudentVo(studentVo);
		loginVo=studentDao.getLoginId(loginVo);
			if(null!=loginVo){
				studentDao.deleteLogin(loginVo);
			}
		}
		return id;
	}
	@Override
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		boolean isExists=studentDao.isEmailExists(email);
		return isExists;
	}
	@Override
	public LoginBo loginCheck(String email, String password) {
		// TODO Auto-generated method stub
		LoginBo loginBo=new LoginBo();
		LoginVo loginVo=new LoginVo();
		loginVo=studentDao.loginCheck(email,password);
		if(null!=loginVo){
			loginBo.setLoginId(loginVo.getLoginId());
			loginBo.setEmail(loginVo.getEmail());
			loginBo.setPassword(loginVo.getPassword());
			loginBo.setConfirmPassword(loginVo.getConfirmPassword());
			loginBo.setRole(loginVo.getRole());
		}

		return loginBo;
	}
	@Override
	public List<StudentBo> search(StudentBo studentBo) {
		// TODO Auto-generated method stub
		List<StudentBo> listBo=new ArrayList<StudentBo>();
		List<StudentVo> listVo=new ArrayList<StudentVo>();
		listVo=studentDao.search(studentBo);
		for(StudentVo vo:listVo){
			StudentBo bo=new StudentBo();
			bo.setId(vo.getId());
			bo.setName(vo.getName());
			bo.setEmail(vo.getEmail());
			bo.setPassword(vo.getPassword());
			bo.setConfirmPassword(vo.getConfirmPassword());
			bo.setRole(vo.getRole());
			bo.setAddress(vo.getAddress());
			listBo.add(bo);
		}
		return listBo;
	}
	@Override
	public int forget(StudentBo studentBo) {
		// TODO Auto-generated method stub
		studentVo=studentDao.getInfo(studentBo.getEmail());
		studentVo.setId(studentVo.getId());
		studentVo.setName(studentVo.getName());
		studentVo.setEmail(studentBo.getEmail());
		studentVo.setPassword(studentBo.getPassword());
		studentVo.setConfirmPassword(studentBo.getConfirmPassword());
		studentVo.setRole(studentVo.getRole());
		studentVo.setAddress(studentVo.getAddress());
		int id=studentDao.update(studentVo);
		if(id>0){
			LoginVo loginVo=new LoginVo();
			//StudentVo studentVo=new StudentVo();
			studentVo.setId(id);
			loginVo.setStudentVo(studentVo);
			loginVo=studentDao.getLoginId(loginVo);
			if(null!=loginVo){
				
				loginVo.setLoginId(loginVo.getLoginId());
				loginVo.setEmail(studentBo.getEmail());
				loginVo.setPassword(studentBo.getPassword());
				loginVo.setConfirmPassword(studentBo.getConfirmPassword());
				loginVo.setRole(studentVo.getRole());
				studentDao.updateLogin(loginVo);
			}
		}
		return id;
	}

}
