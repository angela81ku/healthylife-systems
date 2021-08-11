package controller;

public class HouseChoresPointTableCol {
	int houseChoresID, point;
	String houseChoresName;


	public HouseChoresPointTableCol(int houseChoresID,  String houseChoresName,int point) {
		this.houseChoresID = houseChoresID;
		this.point = point;
		this.houseChoresName = houseChoresName;
	}
	// Do not delete getter and setter, this is how the mySQL connected to!!!

	/**
	 * return houseChoresID
	 * @return houseChoresID
	 */
	public int getHouseChoresID() {
		return houseChoresID;
	}

	public void setHouseChoresID(int houseChoresID) {
		this.houseChoresID = houseChoresID;
	}
	/**
	 * return point
	 * @return point
	 */
	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getHouseChoresName() {
		return houseChoresName;
	}

	public void setHouseChoresName(String houseChoresName) {
		this.houseChoresName = houseChoresName;
	}
}
