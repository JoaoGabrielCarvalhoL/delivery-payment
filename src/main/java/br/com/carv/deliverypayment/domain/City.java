package br.com.carv.deliverypayment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cityId; 
	
	@Column(nullable = false, length = 50)
	private String cityName;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn
	private State state;
	
	public City() {
		
	}
	
	public City(Long cityId, String cityName) {
		this.cityId = cityId;
		this.cityName = cityName;
	}
	
	public Long getCityId() {
		return cityId;
	}
	
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
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
		City other = (City) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City cityId=" + cityId + ", cityName=" + cityName + " State: " + state;
	}
	
	
	
	

}
