package br.com.carv.deliverypayment.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId; 
	
	@Column(nullable = false)
	private String productName;
	
	@Column(nullable = false)
	private BigDecimal productPrice;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable
	private List<Category> categories = new ArrayList<Category>();
	
	@OneToMany(mappedBy = "idOrderItem.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
		
	}
	
	public Product(Long productId, String productName, BigDecimal productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public BigDecimal getProductPrice() {
		return productPrice; 
	}
	
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	public List<Category> getCategory() {
		return categories;
	}
	
	public void setCategory(List<Category> categories) {
		this.categories = categories;
	}
	
	public Set<OrderItem> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	
	@Override 
	public String toString() {
		return "Product Id: " + getProductId() + " Product Name: " + getProductName() + 
				" Product Unit Price: " + getProductPrice();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<>();
		
		for (OrderItem order : items) {
			orders.add(order.getOrder());
		}
		
		return orders;
	}

	
	
	

}
