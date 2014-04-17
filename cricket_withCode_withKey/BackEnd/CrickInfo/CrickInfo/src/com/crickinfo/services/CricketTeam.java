package com.crickinfo.services;

public class CricketTeam {
	
	String teamId;
	String teamName;
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public CricketTeam(String teamId, String teamName) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}
	
	
	
	

}
