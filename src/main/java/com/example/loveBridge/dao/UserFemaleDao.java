package com.example.LoveBridge.dao;


	import org.apache.ibatis.annotations.Insert; 
	import org.apache.ibatis.annotations.Mapper;
	import org.apache.ibatis.annotations.Select;
	import org.apache.ibatis.annotations.Update;

	import com.example.LoveBridge.entity.UserFemale;

	@Mapper
	public interface UserFemaleDao {
		@Select("select * from userfemale where fid=#{fid}")
		UserFemale getUser(String fid);
		
		@Insert("insert into userfemale values(#{fid}, #{pwd}, #{fName}, #{fEmail}, default, default"
				+ "#{fProfile},#{loveDate},#{fStatusMessage}, #{fSNS}, #{fBirth}, #{verifyCode})")
		void insertFemale(UserFemale Fuser);
		
		@Update("update userfemale set pwd=#{pwd}, fName=#{fName}, fEmail=#{fEmail}, fProfile=#{fProfile}," 
				+ "loveDate=#{loveDate}, fStatusMessage=#{fStatusMessage}, "
				+ "fSNS=#{fSNS} fBirth=#{fBirth} where fid=#{fid}")
		void updateFuser(UserFemale Fuser);
		
		@Update("update userfemale set isDeleted=1 where fid=#{fid}")
		void deleteFuser(String fid);
	}

