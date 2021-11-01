package br.com.carv.deliverypayment.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PaymentBillet extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Date dueDate; 
	
	private Date paymentDate;
	
	public PaymentBillet() {
		
	}

	public PaymentBillet(Long paymentId, PaymentStatus paymentStatus, Order order, Date dueDate, Date paymentDate) {
		super(paymentId, paymentStatus, order);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
		
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
	

}
