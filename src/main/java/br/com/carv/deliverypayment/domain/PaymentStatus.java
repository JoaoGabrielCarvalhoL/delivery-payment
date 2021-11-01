package br.com.carv.deliverypayment.domain;

public enum PaymentStatus {
	
	PENDING(1, "Pending"), 
	PAIDOUT(2, "Paid Out"), 
	CALLEDOFF(3, "Called off");
	
	private Integer id; 
	private String description;
	
	private PaymentStatus(Integer id, String description ) {
		this.id = id;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer id) {
		
		if (id == null) {
			return null;
		}
		
		for (PaymentStatus pay : PaymentStatus.values()) {
			if (id.equals(pay.getId())) {
				return pay;
			}
		}
		
		throw new IllegalArgumentException();
	}

}
