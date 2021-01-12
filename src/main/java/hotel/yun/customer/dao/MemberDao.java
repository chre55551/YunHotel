package hotel.yun.customer.dao;

import java.util.List;

import hotel.yun.customer.model.Member;


public interface MemberDao {

	public Member insert(Member bBean);
	public Member query(int member_id);
	public List<Member> queryAll();
	public Member update(Member bBean);
	public boolean delete(int member_id);
}
