package login;

public class HouseChoresPoint {
	int houseChoresID, point;
	String houseChoresName;

	public HouseChoresPoint(int houseChoresID, int point, String houseChoresName) {
		this.houseChoresID = houseChoresID;
		this.point = point;
		this.houseChoresName = houseChoresName;
	}

	public int getHouseChoresID() {
		return houseChoresID;
	}

	public void setHouseChoresID(int houseChoresID) {
		this.houseChoresID = houseChoresID;
	}

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
