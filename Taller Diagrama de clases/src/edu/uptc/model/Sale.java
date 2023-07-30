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
		switch (product.getTypeProduct().toString()) {
		case "LICORES":
			discount=(product.getValue())*0.19;
			break;
		case "VIVERES":
			discount=(product.getValue())*0.08;
			break;
		case "ASEO":
			discount=(product.getValue())*0.14;
			break;
		case "RANCHO":
			discount=(product.getValue())*0.19;
			break;
		case "MEDICINAS":
			break;
		default:
		}
		return discount;
	}
	public double getTotalSale() {
		double total = (product.getValue())-(calcDiscount());
		return total;
				
	}
	public double calcIva() {
		double iva = (product.getValue()) * 0.19;
		return iva;
	}
}
