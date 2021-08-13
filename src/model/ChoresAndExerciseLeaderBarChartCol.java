package model;

/**
 * ChoresAndExerciseLeaderBarChartCol  contains all the column used in the bar chart in
 * chores and exercise system's leader page.
 */
public class ChoresAndExerciseLeaderBarChartCol {
	int point;
	String userName;

	/**
	 * Construct the object with specified information
	 * @param userName the user name
	 * @param point the point that user get in certain period
	 */
	public ChoresAndExerciseLeaderBarChartCol(String userName, int point) {
		this.userName = userName;
		this.point = point;
	}

	/**
	 * get the user's point summary in certain period
	 * @return the summary point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * set the user's point summary in certain period
	 * user's point summary in certian period
	 *
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * get the user name
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * set the user name
	 * @param userName the username
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "ChoresAndExerciseLeaderBarChartCol{" +
				"point=" + point +
				", userName='" + userName + '\'' +
				'}';
	}
}
