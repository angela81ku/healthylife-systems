package model;

/**
 * UserTableCol, this is to retrieve the user table in database.
 * Thus, this object contains all the column in the user table.
 */
public class UserTableCol {
	int account_id;
	String firstname,lastname,username,password;

	/**
	 * Construct the UserTableCol with the user table in database
	 * @param account_id the user account ID
	 * @param firstname the user first name
	 * @param lastname the user last name
	 * @param username the username (this should be unique)
	 * @param password the user password
	 */
	public UserTableCol(int account_id, String firstname, String lastname, String username, String password) {
		this.account_id = account_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}

	/**
	 * get the account_id
	 * @return account_id
	 */
	public int getAccount_id() {
		return account_id;
	}

	/**
	 * set the account_id
	 * @param account_id account_id
	 */
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	/**
	 * get the first name
	 * @return user first name
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * set the first name
	 * @param firstname user first name
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * get the last name
	 * @return user last name
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * set the last name
	 * @param lastname user last name
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * get the user name
	 * @return the user name
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * set the username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * get the password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * set the password
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
