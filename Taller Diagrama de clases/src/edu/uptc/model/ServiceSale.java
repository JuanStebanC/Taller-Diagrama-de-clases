package edu.uptc.model;

public class ServiceSale {
	private Sale sale;

	public ServiceSale(Sale sale, int cant) {
		this.sale = sale;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
}