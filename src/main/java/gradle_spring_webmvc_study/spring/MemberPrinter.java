package gradle_spring_webmvc_study.spring;

import org.springframework.stereotype.Component;

import gradle_spring_webmvc_study.dto.Member;

@Component
public class MemberPrinter {
	public void print(Member member) {
		System.out.printf("ȸ������:���̵�=%d,�̸���=%s,�̸�=%s,�����=%tF\n", member.getId(), member.getEmail(), member.getName(),
				member.getRegisterDateTime());
	}
}
