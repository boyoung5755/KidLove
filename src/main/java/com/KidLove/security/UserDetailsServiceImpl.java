package com.KidLove.security;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.KidLove.auth.dao.AuthDAO;
import com.KidLove.auth.vo.LoginVO;
import com.KidLove.mber.vo.MberVO;
import com.fasterxml.jackson.annotation.JacksonInject;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @packageName	: com.KidLove.auth.vo
 * @since		: 2024.08.19
 * @author		: Boyoung
 * @description	: 
 * ================================================
 * DATE 			AUTHOR			NOTE
 * ------------------------------------------------
 * 2024.08.19		Boyoung			최초생성
 */


@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements  UserDetailsService {
	
	@Inject
	private AuthDAO authDao;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		log.info("################## UserDetailsService ##################");
        log.info("################## loadUserByUsername ##################");
        log.info("username = {}", username);
        
        MberVO member = authDao.findOneWithAuthoritiesByUserId(username);
        
        if(Objects.isNull(member)) {
        	throw new UsernameNotFoundException("존재하지 않는 사용자입니다.");
        }
        
        log.info("member = {}", member);
        log.info("member's role = {}", List.of(member.getMberRole()));
        
        return new LoginVO(member.getMberId(), member.getMberPw(), List.of(member.getMberRole()));
        
	}

}
