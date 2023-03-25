package com.student.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.bo.LoginBo;
import com.student.bo.StudentBo;
import com.student.vo.LoginVo;
import com.student.vo.StudentVo;

@Repository
public class StudentDaoImpl implements StudentDao {
	@Autowired
	SessionFactory sf;
	@Override
	public int signIn(StudentVo studentVo) {
		// TODO Auto-generated method stub
		int id=0;
		try {
			Session session=sf.getCurrentSession();
			id=(int) session.save(studentVo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return id;
	}
	@Override
	public List<StudentVo> view(String email,String role) {
		// TODO Auto-generated method stub
		List<StudentVo> listVo=new ArrayList<StudentVo>();
		StudentVo studentVo=new StudentVo();

		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(StudentVo.class);
			if(role.equals("admin")){
		
			listVo=cr.list();
			}
			else{
				cr.add(Restrictions.eq("email", email));
				studentVo=(StudentVo) cr.uniqueResult();
				listVo.add(studentVo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return listVo;
	}
	@Override
	public StudentVo edit(int id) {
		// TODO Auto-generated method stub
		StudentVo studentVo=new StudentVo();
		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(StudentVo.class);
			cr.add(Restrictions.eq("id", id));
			studentVo=(StudentVo) cr.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return studentVo;
	}
	@Override
	public int update(StudentVo studentVo) {
		// TODO Auto-generated method stub
		int id=0;
		try {
			Session session=sf.getCurrentSession();
			session.update(studentVo);
			if(null!=studentVo){
				id=studentVo.getId();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return id;
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		StudentVo studentVo=new StudentVo();
		studentVo.setId(id);
		try {
			Session session=sf.getCurrentSession();
			/*Query query=(Query) session.createQuery("delete from LoginVo where id=:n ");
			query.setParameter("n", id);
			query.executeUpdate();*/
			session.delete(studentVo);
			if(null!=studentVo){
				id=studentVo.getId();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return id;
	}
	@Override
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		StudentVo studentVo=new StudentVo();
		boolean isExists=false;
		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(StudentVo.class);
			cr.add(Restrictions.eq("email", email));
			studentVo=(StudentVo) cr.uniqueResult();
			if(null!=studentVo){
				isExists=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return isExists;
	}
	@Override
	public int loginSave(LoginVo loginVo) {
		// TODO Auto-generated method stub
		int loginId=0;
		try {
			Session session=sf.getCurrentSession();
			loginId=(int) session.save(loginVo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return loginId;
	}
	@Override
	public LoginVo loginCheck(String email, String password) {
		// TODO Auto-generated method stub
		
		LoginVo loginVo=new LoginVo();
		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(LoginVo.class);
			cr.add(Restrictions.eq("email", email));
			cr.add(Restrictions.eq("password", password));
			loginVo=(LoginVo) cr.uniqueResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return loginVo;
	}
	@Override
	public LoginVo getLoginId(LoginVo loginVo) {
		// TODO Auto-generated method stub
		//LoginVo loginVo=new LoginVo();
		//int loginId=0;
		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(LoginVo.class);
			cr.add(Restrictions.eq("studentVo", loginVo.getStudentVo()));
			loginVo=(LoginVo) cr.uniqueResult();
			
			/*if(null!=loginVo && loginVo.getLoginId()>0){
				loginId=loginVo.getLoginId();
			}*/
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return loginVo;
	}
	@Override
	public void updateLogin(LoginVo loginVo) {
		// TODO Auto-generated method stub
		try {
			Session session=sf.getCurrentSession();
			session.update(loginVo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	@Override
	public void deleteLogin(LoginVo loginVo) {
		// TODO Auto-generated method stub
		
		try {
			Session session=sf.getCurrentSession();
			session.delete(loginVo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	@Override
	public List<StudentVo> search(StudentBo studentBo) {
		// TODO Auto-generated method stub
		List<StudentVo> list=new ArrayList<StudentVo>();

		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(StudentVo.class);
			if(null!=studentBo.getName()){
				cr.add(Restrictions.ilike("name", studentBo.getName(), MatchMode.ANYWHERE));
			}
			list=cr.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	@Override
	public StudentVo getInfo(String email) {
		// TODO Auto-generated method stub
		
		StudentVo studentVo=new StudentVo();
		try {
			Session session=sf.getCurrentSession();
			Criteria cr=session.createCriteria(StudentVo.class);
			cr.add(Restrictions.eq("email", email));
			studentVo=(StudentVo) cr.uniqueResult();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return studentVo;
	}

}
