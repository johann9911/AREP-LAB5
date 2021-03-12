package co.escuelaing.edu.model;

import java.util.Date;

public class Message {

	private String description;
	private Date date;

	public Message(String description) {
		this.description=description;
		this.date= new Date();
	}
	public Message(String description, Date date) {
		this.description=description;
		this.date= date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
