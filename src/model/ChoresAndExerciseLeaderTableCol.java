package model;

import java.sql.Date;

/**
 * ChoresAndExerciseLeaderTableCol  contains all the column used in the bar chart in
 * chores and exercise system's leader page.
 */
public class ChoresAndExerciseLeaderTableCol {
	int point;
	String userName, eventName;
	Date date;

	/**
	 * Construct the specified information in the ChoresAndExerciseLeaderTable
	 * @param userName username
	 * @param date date of the event date
	 * @param eventName chore
	 * @param point
	 */
	public ChoresAndExerciseLeaderTableCol(String userName, Date date, String eventName, int point) {
		this.userName = userName;
		this.eventName = eventName;
		this.date = date;
		this.point = point;
	}

	/**
	 * get the event point
	 * @return the event point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * set the event point
	 * @param point the event point
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
	 * @param userName the user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * get the event name
	 * @return the event name
	 */
	public String getEventName() {
		return eventName;
	}

	/**
	 * set teh house chores name
	 * @param eventName house chores name
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	/**
	 * get the recorded event date
	 * @return the recorded event date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * set the recorded event date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ChoresAndExerciseLeaderTableCol{" +
				"point=" + point +
				", userName='" + userName + '\'' +
				", eventName='" + eventName + '\'' +
				", date=" + date +
				'}';
	}
}
