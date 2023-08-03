package edu.uptc.model;

public class Sale {
	private int cant;
	private Product product;
	public Sale(int cant, Product product) {
		super();
		this.cant = cant;
		this.product = product;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double calcDiscount() {
		double discount = 0;
		/*- Cantidad entre 5 y 10 5%
		- Entre 11 y 20 10%
		- Entre 21 y 50 20%
		- Mayor a 50 30%*/
		if (this.getCant() >= 5 && this.getCant() <= 10) {
			discount = 0.05;
		} else if (this.getCant() >= 11 && this.getCant() <= 20) {
			discount = 0.1;
		} else if (this.getCant() >= 21 && this.getCant() <= 50) {
			discount = 0.2;
		} else if (this.getCant() > 50) {
			discount = 0.3;
		}
		return discount;
	}
	public double getTotalSale() {
		double total = (product.getValue())-(calcDiscount())+(calcIva());
		return total;
				
	}
	public double calcIva() {
		double iva = 0;
		switch (product.getTypeProduct().toString()) {
		case "LICORES":
			iva=(product.getValue())*0.19;
			break;
		case "VIVERES":
			iva=(product.getValue())*0.08;
			break;
		case "ASEO":
			iva=(product.getValue())*0.14;
			break;
		case "RANCHO":
			iva=(product.getValue())*0.19;
			break;
		case "MEDICINAS":
			break;
		default:
		}
		return iva;
	}
}