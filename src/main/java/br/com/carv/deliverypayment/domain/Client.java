package br.com.carv.deliverypayment.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientId; 
	
	@Column(nullable = false, length = 60)
	private String clientName; 
	
	@Column(nullable = false, length = 50)
	private String clientEmail; 
	
	@Column(nullable = false, length = 15) 
	private String cpfOrCnpj; 
	
	@Column(nullable = false)
	private Integer typeCliente;
	
	@Column(nullable = false, length = 16) 
	private String cellphone;
	
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<Order>();
	
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<Address>();
	
	public Client() {
		
	}

	public Client(Long clientId, String clientName, String clientEmail, String cpfOrCnpj, TypeClient typeCliente,
			String cellphone) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.cpfOrCnpj = cpfOrCnpj;
		this.typeCliente = typeCliente.getId();
		this.cellphone = cellphone;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public TypeClient getTypeCliente() {
		return TypeClient.toEnum(typeCliente);
	}

	public void setTypeCliente(TypeClient typeCliente) {
		this.typeCliente = typeCliente.getId();
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientEmail=" + clientEmail
				+ ", cpfOrCnpj=" + cpfOrCnpj + ", typeCliente=" + typeCliente + ", cellphone=" + cellphone
				+ ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
		Client other = (Client) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		return true;
	}
	
	
	

}
