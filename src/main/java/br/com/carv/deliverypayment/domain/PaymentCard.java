package br.com.carv.deliverypayment.domain;

import javax.persistence.Entity;

@Entity
public class PaymentCard extends Payment {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numberInstallments;
	
	public PaymentCard() {
		
	}

	public PaymentCard(Long paymentId, PaymentStatus paymentStatus, Order order, Integer numberInstallments) {
		super(paymentId, paymentStatus, order);
		this.numberInstallments = numberInstallments;
	}



	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}
	
	

}
