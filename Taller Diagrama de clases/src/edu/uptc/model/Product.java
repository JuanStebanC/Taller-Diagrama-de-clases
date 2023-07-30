package edu.uptc.model;

public class Product {
	private String name;
	private double value;
	private int stock;
	private boolean iva;
	final int STOCK_MIN = 10;
	private ETypeProduct typeProduct;
	
	public Product(String name, double value, int stock, boolean iva, ETypeProduct typeProduct) {
		super();
		this.name = name;
		this.value = value;
		this.stock = stock;
		this.iva = iva;
		this.typeProduct = typeProduct;
	}
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	private void setValue(double value) {
		this.value = value;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isIva() {
		return iva;
	}
	public void setIva(boolean iva) {
		this.iva = iva;
	}
	public ETypeProduct getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(ETypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", value=" + value + ", stock=" + stock + ", iva=" + iva + ", STOCK_MIN="
				+ STOCK_MIN + ", typeProduct=" + typeProduct + "]";
	}
	
	
}
