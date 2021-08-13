package model;
/**
 * ChoresAndExercisePointTableCol
 *
 * contains all the column used in the bar chart in
 * chores and exercise system's leader page.
 */
public class ChoresAndExercisePointTableCol {
	int houseChoresID, point;
	String houseChoresName;

	/**
	 * Constructed object with specified information
	 * @param houseChoresID houseChoresID
	 * @param houseChoresName houseChoresName
	 * @param point the correspondent point assigned to each houseChoresID
	 */
	public ChoresAndExercisePointTableCol(int houseChoresID, String houseChoresName, int point) {
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

	/**
	 * set houseChoresId
	 * @param houseChoresID houseChoresID
	 */
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
	/**
	 * return the correspondent point assigned to each houseChoresID
	 * @return the correspondent point assigned to each houseChoresID
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * get the houseChoresName
	 * @return the houseChoresName
	 */
	public String getHouseChoresName() {
		return houseChoresName;
	}
	/**
	 * set the houseChoresName
	 */
	public void setHouseChoresName(String houseChoresName) {
		this.houseChoresName = houseChoresName;
	}

	@Override
	public String toString() {
		return "ChoresAndExercisePointTableCol{" +
				"houseChoresID=" + houseChoresID +
				", point=" + point +
				", houseChoresName='" + houseChoresName + '\'' +
				'}';
	}
}
