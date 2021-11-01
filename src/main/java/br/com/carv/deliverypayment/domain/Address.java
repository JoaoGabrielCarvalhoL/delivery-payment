package br.com.carv.deliverypayment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressId; 
	
	@Column(nullable = false, length = 50)
	private String street; 
	
	@Column(nullable = false, length = 10)
	private String numberHouse; 
	
	@Column(nullable = false, length =  20)
	private String complement; 
	
	@Column(nullable = false, length = 30)
	private String district; 
	
	@Column(nullable = false, length = 10)
	private String cep;
	
	@ManyToOne
	@JoinColumn
	private City city;
	

	@ManyToOne
	@JoinColumn
	private Client client;
	
	public Address() {
		
	}

	public Address(Long addressId, String street, String numberHouse, String complement, String district, String cep, City city) {
		super();
		this.addressId = addressId;
		this.street = street;
		this.numberHouse = numberHouse;
		this.complement = complement;
		this.district = district;
		this.cep = cep;
		this.city = city;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumberHouse() {
		return numberHouse;
	}

	public void setNumberHouse(String numberHouse) {
		this.numberHouse = numberHouse;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", numberHouse=" + numberHouse
				+ ", complement=" + complement + ", district=" + district + ", cep=" + cep + ", city=" + city + "]";
	}
	
	
	
	
	
	

}
