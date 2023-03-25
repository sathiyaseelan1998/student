package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.bo.LoginBo;
import com.student.bo.StudentBo;
import com.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	StudentBo studentBo=new StudentBo();
	
	@RequestMapping(value="/singIn",method=RequestMethod.GET)
	public String index(Model model){
		
		model.addAttribute("studentBo", studentBo);
		return "signIn";
		
	}
	
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public String signIn(@Valid @ModelAttribute("studentBo")StudentBo studentBo,BindingResult br,Model model){
		
		if(br.hasErrors()){
			
			return "signIn"; 
		}
		
		if(!(studentBo.getPassword().equals(studentBo.getConfirmPassword()))){
			model.addAttribute("msg", "password doesn't match");
			return "signIn";
		}
		if(studentService.isEmailExists(studentBo.getEmail())){
			model.addAttribute("msg", "email already exists");
			return "signIn";
		}
		int id=studentService.signIn(studentBo);
		if(id>0){
			model.addAttribute("msg", "student data save successfully");
			model.addAttribute("loginBo", new LoginBo());
			return "login";
		}
		else{
			model.addAttribute("msg", "student data doesn't save");
		}
		return "signIn";
		
	}
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(Model model,HttpServletRequest req){
		List<StudentBo> list=new ArrayList<StudentBo>();
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		String role=(String) session.getAttribute("role");
		list=studentService.view(email,role);
		model.addAttribute("list", list);
		model.addAttribute("view", "view");
		model.addAttribute("studentBo", new StudentBo());
		return "view";
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@RequestParam("id")int id,Model model){
		
		studentBo=studentService.edit(id);
		model.addAttribute("studentBo", studentBo);
		return "edit";
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("studentBo")StudentBo studentBo,BindingResult br,Model model){
		
		if(br.hasErrors()){
			return "edit"; 
		}
		if(!(studentBo.getPassword().equals(studentBo.getConfirmPassword()))){
			model.addAttribute("msg", "password doesn't match");
			return "edit";
		}
		
		int id=studentService.Update(studentBo);
		if(id>0){
			model.addAttribute("msg", "student record update successfully");
		}
		else{
			model.addAttribute("msg", "student record doesn't update");
		}
		
		return "edit";
		
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("id")int id,Model model){
		
		id=studentService.delete(id);
		return "redirect:/view";
		
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(Model model){
		model.addAttribute("loginBo", new LoginBo());
		model.addAttribute("studentBo", studentBo);

		return "login";
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginCheck(@Valid @ModelAttribute("loginBo")LoginBo loginBo,HttpServletRequest req,BindingResult br,Model model){
		if(br.hasErrors()){
			return "login"; 
		}
		loginBo=studentService.loginCheck(loginBo.getEmail(),loginBo.getPassword());
		if(null!=loginBo && loginBo.getLoginId()>0){
			HttpSession session=req.getSession();
			session.setAttribute("email", loginBo.getEmail());
			session.setAttribute("password", loginBo.getPassword());
			session.setAttribute("role", loginBo.getRole());
			model.addAttribute("msg", "login successful");
			model.addAttribute("studentBo", studentBo);

			return "redirect:/view";
		}
		else{
			model.addAttribute("msg", "invalid login");
		}
		return "login";
		
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String create(Model model,HttpServletRequest req)
	{
		
		HttpSession session=req.getSession();
		
		String email=(String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		String role=(String) session.getAttribute("role");
		
		model.addAttribute("role", role);
		session.invalidate();
		return "index";
		
	}
	@RequestMapping(value="/search")
	public String search(@ModelAttribute("studentBo")StudentBo studentBo,Model model){
		List<StudentBo> list=new ArrayList<StudentBo>();
		list=studentService.search(studentBo);
		if(null!=list && list.size()>0)
		{
			model.addAttribute("studentBo", new StudentBo());
			model.addAttribute("list", list);
			return "view";
		}
		else {
			model.addAttribute("msg", "record not found... ");
			return "view";
		}
		
	}
	@RequestMapping(value="/forget",method=RequestMethod.GET)
	public String forgetting(Model model){
		
		model.addAttribute("studentBo", studentBo);
		return "forget";
		
	}
	@RequestMapping("/forget")
	public String forget(@ModelAttribute("studentBo")StudentBo studentBo,Model model){
		if(!(studentBo.getPassword().equals(studentBo.getConfirmPassword()))){
			model.addAttribute("msg", "password doesn't match");
			return "forget";
		}
		if(!(studentService.isEmailExists(studentBo.getEmail()))){
			model.addAttribute("msg", "your not register");
			return "forget";
		}
		int id=studentService.forget(studentBo);
		if(0<id){
			model.addAttribute("loginBo", new LoginBo());
			model.addAttribute("msg", "Password changed");
		}
		return "login";
		
	}
}
