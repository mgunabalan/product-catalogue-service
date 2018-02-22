package com.pcs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "store")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long storeId;

	@NotNull
	@Column(unique = true)
	private String storeName;

	@NotNull
	@Column(unique = true)
	private String StoreCode;

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreCode() {
		return StoreCode;
	}

	public void setStoreCode(String storeCode) {
		StoreCode = storeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((StoreCode == null) ? 0 : StoreCode.hashCode());
		result = prime * result + (int) (storeId ^ (storeId >>> 32));
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
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
		Store other = (Store) obj;
		if (StoreCode == null) {
			if (other.StoreCode != null)
				return false;
		} else if (!StoreCode.equals(other.StoreCode))
			return false;
		if (storeId != other.storeId)
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
	}

	@Transient
	private int stock;

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getStock() {
		return stock;
	}
	
	

}
