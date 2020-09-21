package com.entity;

import java.security.Timestamp;

public class Log {
	private int log_id;
	private String action;
	private String table;
	private Timestamp datetime;

	public int getLogID() {
		return log_id;
	}

	public void setLogID(int log_id) {
		this.log_id = log_id;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Timestamp getDatetime() {
		return datetime;
	}

	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
}