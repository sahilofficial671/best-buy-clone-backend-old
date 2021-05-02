package com.bestbuy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "Please add valid product name.")
	@Size(max = 150)
	private String name;
	
	@Size(max = 255)
	private String description;
	
	@NotNull(message = "Please add valid product quantity.")
	@Column(name = "quantity")
	private Integer quantity;
	
	@NotNull(message = "Please add valid product price.")
	@Column(name = "price")
	private Double price;
	
	@NotNull(message = "Please add valid product special price.")
	@Column(name = "special_price")
	private Double specialPrice;
	
    @NotNull(message = "Please add select valid product category.")
    @Column(name = "category_id")
	private Integer categoryId;

    @NotNull(message = "Please add select valid product slug.")
    @Column(name = "slug")
	private String slug;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    
	@Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    
    private Date updatedAt;
	
	public Product() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(Double specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", price=" + price + ", specialPrice=" + specialPrice + ", categoryId=" + categoryId + ", slug="
				+ slug + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}