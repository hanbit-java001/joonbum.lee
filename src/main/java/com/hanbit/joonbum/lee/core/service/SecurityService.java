package com.hanbit.joonbum.lee.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hanbit.joonbum.lee.core.dao.MemberDAO;
import com.hanbit.joonbum.lee.core.vo.MemberVO;

@Service
public class SecurityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityService.class);

	private static PasswordEncoder encoder = new StandardPasswordEncoder();

	@Autowired
	private MemberDAO memberDAO;

	public String encryptPassword(String password) {
		return encoder.encode(password);
	}

	public boolean matchPassword(String rawPassword, String encryptedPassword){
		return encoder.matches(rawPassword, encryptedPassword);
	}

	public MemberVO getValidMember(String email, String password) {
		MemberVO member = null;

		try {
			member = memberDAO.selectMember(email);

		} catch (Exception e) {
			throw new RuntimeException("가입되지 않은 이메일 입니다.");
		}

		String encryptedPassword = member.getPassword();

		if(matchPassword(password, encryptedPassword)){
			throw new RuntimeException("패스워드가 일치하지 않습니다.");
		}

		return member;
	}

}
