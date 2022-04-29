package memberList.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import memberList.member.vo.MemberVO;

@Repository("memberDAO")//id가 memberDAO인 bean을 생성
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired //id가 sqlSession인 빈을 주입 받음
	private SqlSession sqlSession;
	

	@Override
	public List selectAllMemberList() throws DataAccessException {
		List<MemberVO> memberList = null;
		memberList = sqlSession.selectList("mapper.member.selectAllMemberList");
		
		return memberList;
	}

	@Override
	public int insertMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		
		return result;
	}

	@Override
	public int deleteMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

}
