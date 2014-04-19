package data;

import java.io.Serializable;

public class Office implements Serializable {

	public static final long serialVersionUID = 340957856734873L;

	private String city;
	private String state;
	private int careCenterNumber;

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getCareCenterNumber() {
		return careCenterNumber;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public void setCareCenterNumber(final int careCenterNumber) {
		this.careCenterNumber = careCenterNumber;
	}
}