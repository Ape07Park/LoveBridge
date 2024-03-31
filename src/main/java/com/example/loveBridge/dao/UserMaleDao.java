package com.example.LoveBridge.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.LoveBridge.entity.UserMale;

@Mapper
public interface UserMaleDao {
	@Select("select * from usermale where mid=#{mid}")
	UserMale getUser(String mid);
	
	@Insert("insert into usermale values(#{mid}, #{pwd}, #{mName}, #{mEmail}, default, default"
			+ "#{mProfile},#{loveDate},#{mStatusMessage}, #{mSNS}, #{mBirth}, #{verifyCode})")
	void insertMale(UserMale Muser);
	
	@Update("update usermale set pwd=#{pwd}, mName=#{mName}, mEmail=#{mEmail}, mProfile=#{mProfile}," 
			+ "loveDate=#{loveDate}, mStatusMessage=#{mStatusMessage}, "
			+ "mSNS=#{mSNS} mBirth=#{mBirth} where mid=#{mid}")
	void updateMuser(UserMale Muser);
	
	@Update("update usermale set isDeleted=1 where mid=#{mid}")
	void deleteMuser(String mid);
	
}