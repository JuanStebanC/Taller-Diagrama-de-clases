package edu.uptc.presenter;

import edu.uptc.model.ETypeProduct;
import edu.uptc.model.ServiceSale;

public class Presenter {
	private ServiceSale serviceSale;

	public Presenter(ServiceSale serviceSale) {
		this.serviceSale = serviceSale;
	}
	public double addSale(String name, double value, int stock, boolean iva, ETypeProduct typeProduct, int cant) {
		serviceSale.getSale().getProduct().setName(name);
		serviceSale.getSale().getProduct().setValue(value);
		serviceSale.getSale().getProduct().setStock(stock);
		serviceSale.getSale().getProduct().setTypeProduct(typeProduct);
		serviceSale.getSale().setCant(cant);
		return serviceSale.getSale().getTotalSale();
	}
	public String showSale() {
		String show = "Producto: "
				+ "\n" + serviceSale.getSale().getProduct().getName()
				+ "\n Valor Unitario:"
				+ "\n" + serviceSale.getSale().getProduct().getValue()
				+ "\n Iva:"
				+ "\n" + serviceSale.getSale().calcIva()
				+ "\n Tipo de producto:"
				+ "\n" + serviceSale.getSale().getProduct().getTypeProduct()
				+ "\n Descuento:"
				+ "\n" + serviceSale.getSale().calcDiscount()
				+ "\n Cantidad:"
				+ "\n" + serviceSale.getSale().getCant()
				+ "\n \n Precio Total:"
				+ "\n" + serviceSale.getSale().getTotalSale();
		return show;
	}
}
