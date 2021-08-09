package login;

public class HouseChoresPoint {
	int houseChoresID, point;
	String houseChoresName;

	public HouseChoresPoint(int houseChoresID, String houseChoresName, int point ) {
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

	@Override
	public String toString() {
		return "HouseChoresPoint{" +
				"houseChoresID=" + houseChoresID +
				", houseChoresName='" + houseChoresName +
				", point=" + point +'\'' +
				'}';
	}
}
