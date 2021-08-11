package controller;

public class HouseChoresLeadeBarChartCol {
	int point;
	String userName;


	public HouseChoresLeadeBarChartCol(String userName, int point) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "HouseChoresLeadeBarChartCol{" +
				"point=" + point +
				", userName='" + userName + '\'' +
				'}';
	}
}
