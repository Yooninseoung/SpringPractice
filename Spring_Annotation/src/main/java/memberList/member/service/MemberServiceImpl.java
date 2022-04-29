package memberList.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import memberList.member.dao.MemberDAO;
import memberList.member.vo.MemberVO;


@Service("memberService") //id가 memberService인 bean을 생성
@Transactional(propagation = Propagation.REQUIRED) //트랜잭션을 모든 메소드에 적용
public class MemberServiceImpl implements MemberService {
	@Autowired //id가 memberDAO인 빈을 주입 받음
	private MemberDAO memberDAO;
	

	@Override
	public List listMembers() throws DataAccessException {
		List<MemberVO> memberList = null;
		memberList = memberDAO.selectAllMemberList();
		
		return memberList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		
		return memberDAO.insertMember(memberVO);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		
		return memberDAO.deleteMember(id);
	}

}
