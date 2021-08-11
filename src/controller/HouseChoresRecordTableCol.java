package controller;

import java.sql.Date;

public class HouseChoresRecordTableCol {
	int recordID;
	String userName, houseChoresName;
	Date date;

	public HouseChoresRecordTableCol(String userName, String houseChoresName, Date date, int recordID) {
		this.userName = userName;
		this.houseChoresName = houseChoresName;
		this.date = date;
		this.recordID = recordID;
	}

	public int getRecordID() {
		return recordID;
	}

	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHouseChoresName() {
		return houseChoresName;
	}

	public void setHouseChoresName(String houseChoresName) {
		this.houseChoresName = houseChoresName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "HouseChoresRecordTableCol{" +
				"recordID=" + recordID +
				", userName='" + userName + '\'' +
				", houseChoresName='" + houseChoresName + '\'' +
				", date=" + date +
				'}';
	}
}
