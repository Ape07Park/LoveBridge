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
public class UserFemale {
	private String fid;
	private String pwd;
	private String fName;
	private String fEmail;
	private LocalDate regDate;
	private int isDeleted;
	private String fProfile;
	private LocalDate loveDate;
	private String fStatusMessage;
	private String fSNS;
	private LocalDate fBirth;
	private String verifyCode;
}
