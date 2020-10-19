package gradle_spring_webmvc_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gradle_spring_webmvc_study.dto.Member;

@Component
public class MemberInfoPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;

	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("������ ����\n");
			return;
		}
		printer.print(member);
		System.out.println();
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	@Autowired
	public void setPrinter(MemberPrinter memberPrinter) {
		this.printer = memberPrinter;
	}

}
