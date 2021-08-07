module healthSystem {

//	requires rt;
//	requires jfxrt;

	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
//	requires javafx.sql;
	requires mysql.connector.java;

	opens login;
}