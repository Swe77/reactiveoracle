package org.acme.audit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.jboss.logging.Logger;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Table(name = "AUDIT_TRACKING")
public class Audit extends PanacheEntity{

	private static final Logger LOG = Logger.getLogger(Audit.class);
	
	@Column(name = "TRANSACTION_NAME")
	private String transactionName;
	
	@Column(name = "TRANSACTION_URL")
	private String transactionUrl;

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getTransactionUrl() {
		return transactionUrl;
	}

	public void setTransactionUrl(String transactionUrl) {
		this.transactionUrl = transactionUrl;
	}
}
