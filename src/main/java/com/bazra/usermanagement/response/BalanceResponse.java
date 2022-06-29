package com.bazra.usermanagement.response;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceResponse {
    private BigDecimal balance;
    private String message;
    private String username;
    
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public BigDecimal getAmount() {
        return balance;
    }
    public void setAmount(BigDecimal balance) {
        this.balance = balance;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public BalanceResponse( BigDecimal balance, String message, String username) {
        
        this.username=username;
        this.balance = balance;
        this.message= message;
       }
    public BalanceResponse(String message) {
        this.message=message;
    }
}
