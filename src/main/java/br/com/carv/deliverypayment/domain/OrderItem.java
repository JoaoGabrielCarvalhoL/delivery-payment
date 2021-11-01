package br.com.carv.deliverypayment.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK idOrderItem = new OrderItemPK();
	
	private BigDecimal discount;
	
	private Integer amount; 
	
	private BigDecimal unitPrice;
	
	public OrderItem() {
		
	}
	
	public OrderItem(Order order, Product product, BigDecimal discount, Integer amount, BigDecimal unitPrice) {
		idOrderItem.setOrder(order);
		idOrderItem.setProduct(product);
		this.discount = discount; 
		this.amount = amount; 
		this.unitPrice = unitPrice;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "OrderItem [discount=" + discount + ", amount=" + amount + ", unitPrice=" + unitPrice + "]";
	}

	public OrderItemPK getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(OrderItemPK idOrderItem) {
		this.idOrderItem = idOrderItem;
	}
	
	public Order getOrder() {
		return idOrderItem.getOrder();
	}
	
	public Product getProduct() {
		return idOrderItem.getProduct();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOrderItem == null) ? 0 : idOrderItem.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (idOrderItem == null) {
			if (other.idOrderItem != null)
				return false;
		} else if (!idOrderItem.equals(other.idOrderItem))
			return false;
		return true;
	}

	
	

}
