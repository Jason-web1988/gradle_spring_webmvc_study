package gradle_spring_webmvc_study.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gradle_spring_webmvc_study.dto.Code;
import gradle_spring_webmvc_study.dto.Login;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String form(/* Model model, */ Login login){
		/*
		 * List<String> loginTypes = new ArrayList<>(); loginTypes.add("일반회원");
		 * loginTypes.add("기업회원"); loginTypes.add("헤드헌터회원");
		 * 
		 * model.addAttribute("loginTypes", loginTypes);
		 */
		
		return "login/form";
		/*
		 * ModelAndView mav = new ModelAndView("login/form", )\ return mav;
		 */
	}
	
	
	@PostMapping("/result")
	public String result(@ModelAttribute("login") Login login) {
		return "login/result";
	}
	
	@ModelAttribute("loginTypes")
	public List<String> getLoginTypes() {
		List<String> loginTypes = new ArrayList<>();
		loginTypes.add("일반회원");
		loginTypes.add("기업회원");
		loginTypes.add("헤드헌터회원");
		return loginTypes;
	}
	
	@ModelAttribute("jobCodes")
	public List<Code> getJobCodes() {
		List<Code> jobCodes = new ArrayList<>();
		jobCodes.add(new Code("A", "일반회원"));
		jobCodes.add(new Code("B", "기업회원"));
		jobCodes.add(new Code("C", "헤드헌터회원"));
		return jobCodes;
	}
	
	@ModelAttribute("tools")
	public List<String> getTools() {
		List<String> tools = new ArrayList<>();
		tools.add("Eclipse");
		tools.add("intelliJ");
		tools.add("VSCODE");
		return tools;
	}
	
	@ModelAttribute("favoriteOsNames")
	public List<String> getFavoriteOsNames(){
		List<String> favoriteOs = new ArrayList<>();
		favoriteOs.add("윈도우10");
		favoriteOs.add("리눅스");
		favoriteOs.add("유닉스");
		favoriteOs.add("칼리리눅스");
		favoriteOs.add("우분투");
		return favoriteOs;
	}
	
	@ModelAttribute("likeOs")
	public List<Code> getLikeOs(){
		List<Code> likeOs = new ArrayList<>();
		likeOs.add(new Code("O1", "윈도우10"));
		likeOs.add(new Code("O2", "리눅스"));
		likeOs.add(new Code("O3", "유닉스"));
		likeOs.add(new Code("O4", "칼리리눅스"));
		likeOs.add(new Code("O5", "우분투"));
		return likeOs;
	}
	
	@ModelAttribute("subjects")
	public List<Code> getSubjects(){
		List<Code> subjects = new ArrayList<>();
		subjects.add(new Code("S1", "윈도우10"));
		subjects.add(new Code("S2", "리눅스"));
		subjects.add(new Code("S3", "유닉스"));
		subjects.add(new Code("S4", "칼리리눅스"));
		subjects.add(new Code("S5", "우분투"));
		return subjects;
	}
	
	@GetMapping("/login1")
	public String form1(Login login){
		return "login/form";
	}

	@GetMapping("/login2")
    public String form2(Login login){
       login.setLoginType("기업회원");
       login.setJobCode("B");
       login.setTool("VSCODE");
       List<String> favoriteOs = Arrays.asList("리눅스","칼리리눅스");
       login.setFavoriteOs(favoriteOs);
       List<String> likeOs = Arrays.asList("O1","O5");
       login.setLikeOs(likeOs);
       
        return "login/form";
    }
	
}
