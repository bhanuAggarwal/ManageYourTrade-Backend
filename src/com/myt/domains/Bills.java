package com.myt.domains;

import java.util.List;

public class Bills {
	List<String> bills;

	@Override
	public String toString() {
		return "Bills [bills=" + bills + "]";
	}

	public Bills() {
		super();
	}

	public Bills(List<String> bills) {
		super();
		this.bills = bills;
	}

	public List<String> getBills() {
		return bills;
	}

	public void setBills(List<String> bills) {
		this.bills = bills;
	}
	
	
}
