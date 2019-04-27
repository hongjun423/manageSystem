package com.manage.app.member.dao;

import com.manage.app.member.Member;

public interface IMemberDao {
	void memberInsert(Member member);
	Member memberSelect(String memId, String memPw);
	void memberUpdate();
	void memberDelete();
}
