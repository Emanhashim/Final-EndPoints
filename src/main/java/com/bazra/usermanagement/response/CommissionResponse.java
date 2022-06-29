package com.bazra.usermanagement.response;

import java.math.BigDecimal;

public class CommissionResponse {

    private BigDecimal commission;
    private String message;
    private String username;
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BigDecimal getAmount() {
        return commission;
    }
    public void setAmount(BigDecimal amount) {
        this.commission = amount;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public CommissionResponse( BigDecimal commission, String message, String username) {
        
        this.username=username;
        this.commission = commission;
        this.message= message;
       }
    public CommissionResponse(String message) {
        this.message=message;
    }
}
