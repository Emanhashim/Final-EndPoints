package com.bazra.usermanagement.response;

import java.math.BigDecimal;

public class TotalNumberResponse {

	private BigDecimal total;
	private String message;
	private int tot;
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public TotalNumberResponse( String message,BigDecimal total) {
		super();
		this.total = total;
		this.message = message;
	}
	
	public TotalNumberResponse( String message,int tot) {
		super();
		this.tot = tot;
		this.message = message;
	}
	
}
