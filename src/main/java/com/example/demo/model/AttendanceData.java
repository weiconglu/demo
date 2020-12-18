package com.example.demo.model;

/**
 * @author founder3829
 *
 */
public class AttendanceData {

	private Integer id;
	private String loginName;
	private String fullName;
	private String status;
	private String startAt;
	private String endAt;
	private String deskName;
	private String siteName;
	private String floorName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartAt() {
		return startAt;
	}

	public void setStartAt(String startAt) {
		this.startAt = startAt;
	}

	public String getEndAt() {
		return endAt;
	}

	public void setEndAt(String endAt) {
		this.endAt = endAt;
	}

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	@Override
	public String toString() {
		return "AttendanceData [id=" + id + ", loginName=" + loginName + ", fullName=" + fullName + ", status=" + status
				+ ", startAt=" + startAt + ", endAt=" + endAt + ", deskName=" + deskName + ", siteName=" + siteName
				+ ", floorName=" + floorName + "]";
	}

}
