package model;

import java.sql.Date;
/**
 * ChoresAndExerciseRecordTableCol
 *
 * contains all the column used in the table in
 * chores and exercise system's record page.
 */
public class ChoresAndExerciseRecordTableCol {
	int recordID;
	String userName, ChoresAndExerciseName;
	Date date;

	/**
	 * constructed the ChoresAndExerciseRecordTableCol with specified information
	 * @param userName the user name who did the chores or exercise
	 * @param ChoresAndExerciseName ChoresAndExerciseName
	 * @param date the date of the chores and exercise the user did
	 * @param recordID recordID the unique ID that is autogenerated from database
	 */
	public ChoresAndExerciseRecordTableCol(String userName, String ChoresAndExerciseName, Date date, int recordID) {
		this.userName = userName;
		this.ChoresAndExerciseName = ChoresAndExerciseName;
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

	public String getChoresAndExerciseName() {
		return ChoresAndExerciseName;
	}

	public void setChoresAndExerciseName(String choresAndExerciseName) {
		ChoresAndExerciseName = choresAndExerciseName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ChoresAndExerciseRecordTableCol{" +
				"recordID=" + recordID +
				", userName='" + userName + '\'' +
				", ChoresAndExerciseName='" + ChoresAndExerciseName + '\'' +
				", date=" + date +
				'}';
	}
}
