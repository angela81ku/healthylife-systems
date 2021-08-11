package login;

import java.sql.Date;

public class HouseChoresLeaderTableCol {
	int point;
	String userName, houseChoresName;
	Date date;

	public HouseChoresLeaderTableCol(String userName,  Date date, String houseChoresName,int point) {
		this.userName = userName;
		this.houseChoresName = houseChoresName;
		this.date = date;
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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
		return "HouseChoresLeaderTableCol{" +
				"point=" + point +
				", userName='" + userName + '\'' +
				", houseChoresName='" + houseChoresName + '\'' +
				", date=" + date +
				'}';
	}
}
