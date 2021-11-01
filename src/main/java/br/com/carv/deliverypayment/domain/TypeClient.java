package br.com.carv.deliverypayment.domain;

public enum TypeClient {
	
	PHYSICALPERSON(1,"PHYSICAL PERSON"),
	LEGALPERSON(2, "LEGAL PERSON");
	
	private Integer id; 
	private String description;
	
	private TypeClient (Integer id, String description) {
		this.id = id; 
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static TypeClient toEnum(Integer id) {
		
		if (id == null) {
			return null;
		}
		
		for (TypeClient client : TypeClient.values()) {
			if (id.equals(client.getId())) {
				return client;
			}
		}
		
		throw new IllegalArgumentException();
		
	}

}
