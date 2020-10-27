package gradle_spring_webmvc_study.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gradle_spring_webmvc_study.dto.ErrorResponse;
import gradle_spring_webmvc_study.dto.Member;
import gradle_spring_webmvc_study.dto.RegisterRequest;
import gradle_spring_webmvc_study.exception.DuplicateMemberException;
import gradle_spring_webmvc_study.exception.MemberNotFoundException;
import gradle_spring_webmvc_study.service.MemberRegisterService;
import gradle_spring_webmvc_study.spring.MemberDao;

@RestController
public class RestMemberController {
	@Autowired
	private MemberDao memberDao;
	
	
	@Autowired
	private MemberRegisterService registerService;

	/*
	 * @GetMapping("memberList") public ModelAndView memberList(){ List<Member>
	 * member = memberDao.selectAll(); ModelAndView mav = new ModelAndView();
	 * mav.addObject("member", member); mav.setViewName("rest/list"); return mav; }
	 */
	
	
	@GetMapping("/api/members")
	public List<Member> members(){
		return memberDao.selectAll();
	}
	
	/*
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = memberDao.selectById(id);
		if(member == null) {
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member"));
			throw new MemberNotFoundException();
		}
//		return ResponseEntity.status(HttpStatus.OK).body(member);
		return member;
	}
	*/
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id) {
		Member member = memberDao.selectById(id);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		return member;
	}

	
	@PostMapping("/api/members")	//JSON형식으로 전송된 요청 데이터를 커맨드 객체로 전달받는 방법, 커맨드 객체에 @RequestBody 애노테이션을 붙이면 된다.
	public ResponseEntity<Object> newMember(@RequestBody @Valid RegisterRequest regReq, Errors errors, HttpServletResponse response) throws IOException {
		try {
			if(errors.hasErrors()) {
				return ResponseEntity.badRequest().build();
//				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//				return;
			}
			Long newMemberId = registerService.regist(regReq);
//			response.setHeader("Location", "/api/members/" + newMemberId);
//			response.setStatus(HttpServletResponse.SC_CREATED);
			URI uri = URI.create("/api/members/" + newMemberId);
			return ResponseEntity.created(uri).build();
		} catch (DuplicateMemberException e) {
//			response.sendError(HttpServletResponse.SC_CONFLICT);
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
