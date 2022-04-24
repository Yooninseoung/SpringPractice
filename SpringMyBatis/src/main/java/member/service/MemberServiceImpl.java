package member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import member.dao.MemberDAO;
import member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

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
