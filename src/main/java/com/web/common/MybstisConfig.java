package com.web.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.web.vo.UserInfoVO;

public class MybstisConfig {

	private static SqlSessionFactory SSF;
	private final static String CONFIG_PATH = "config/mybatis-config.xml";

	static {
		try {
			InputStream is = Resources.getResourceAsStream(CONFIG_PATH);
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SSF = ssfb.build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return SSF;
	}

	public static void main(String[] args) {
		try (SqlSession session = getSqlSessionFactory().openSession(true)){
			List<UserInfoVO> list = session.selectList("com.web.mapper.UserInfoMapper.selectUserInfoList");
			for (UserInfoVO userList : list) {
				System.out.println(userList);
			}
			int uiNum = 17;
			UserInfoVO user = session.selectOne("com.web.mapper.UserInfoMapper.selectUserInfo",uiNum);
//			System.out.println("user : "+ user);
			
//			int result = 0;
//			UserInfoVO userInfo = new UserInfoVO();
//			userInfo.setUiName("dlqkqd");
//			userInfo.setUiId("123bnm1234");
//			userInfo.setUiPwd("123hfgdhd");
//			userInfo.setUiDesc("qrqrer3나나나");
//			userInfo.setUiBirth("000000");
//			result = session.insert("com.web.mapper.UserInfoMapper.insertUserInfo",userInfo );
//			System.out.println(result);
			
//			int result = 0;
//			UserInfoVO userInfo = new UserInfoVO();
//			userInfo.setUiName("dlqkqd");
//			userInfo.setUiId("123bnm1234");
//			userInfo.setUiPwd("123hfgdhd");
//			userInfo.setUiDesc("qrqrer3나나나");
//			userInfo.setUiBirth("000000");
//			userInfo.setUiNum(22);
//			result = session.update("com.web.mapper.UserInfoMapper.updateUserInfo",userInfo);
//			System.out.println(result);
			
//			int result = 0;
//			result = session.delete("com.web.mapper.UserInfoMapper.deleteUserInfo",uiNum);
//			System.out.println(result);
		} catch (Exception e) {
	
		}
	}
}
