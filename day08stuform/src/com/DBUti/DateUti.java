package com.DBUti;

import java.util.*;

public class DateUti {

	public static java.sql.Date getCurrentDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}
}
