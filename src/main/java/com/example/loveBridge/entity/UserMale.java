package com.example.LoveBridge.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserMale {
	private String mid;
	private String pwd;
	private String mName;
	private String mEmail;
	private LocalDate regDate;
	private int isDeleted;
	private String mProfile;
	private LocalDate loveDate;
	private String mStatusMessage;
	private String mSNS;
	private LocalDate mBirth;
	private String verifyCode;
}
