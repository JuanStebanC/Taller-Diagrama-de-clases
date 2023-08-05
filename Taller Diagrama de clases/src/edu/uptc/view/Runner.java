package edu.uptc.view;

import edu.uptc.model.*;
import edu.uptc.presenter.*;
import java.util.*;

public class Runner {

	public static void main(String[] args) {
		MainMenu();
	}
	public static void MainMenu() {
		Scanner sc = new Scanner(System.in);
		
		Product product = new Product(null, 0, 0, false, ETypeProduct.LICORES);
		Sale sale = new Sale(product, 0);
		ServiceSale serviceSale = new ServiceSale(sale, 0);
		Presenter presenter = new Presenter(serviceSale);
		
		int exit = 0;
		int option = 0;
		String name;
		double value = 0;
		int stock;
		boolean iva = false;
		String eTypeProduct;
		int cant;
		double totalSale = 0;
		int amount = 0;
		
		do {
			System.out.println("\n \n \n Ola q ahce"
					+ "\n 1. Agregar una nueva venta"
					+ "\n 2. Ver las ventas"
					+ "\n 3. Ver total acumulado"
					+ "\n 4. Salir");
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Ingrese el nombre del producto:");
				name = sc.next();
				while (true) {
		            try {
		                System.out.println("Ingrese el valor unitario del producto:");
		                value = sc.nextDouble();
		                break;
		            } catch (InputMismatchException e) {
		                System.out.println("El valor ingresado no es válido. Inténtalo de nuevo.");
		                sc.next();
		            }
		        }
				while (true) {
		            try {
		                System.out.println("Ingrese el stock disponible:");
		                stock = sc.nextInt();
		                break;
		            } catch (InputMismatchException e) {
		                System.out.println("El valor ingresado no es válido. Inténtalo de nuevo.");
		                sc.next();
		            }
		        }
				System.out.println("Ingrese el tipo de producto");
				sc.nextLine();
				eTypeProduct = sc.nextLine().toUpperCase();
				ETypeProduct typeProduct = ETypeProduct.valueOf(eTypeProduct);
				try {
		            typeProduct = ETypeProduct.valueOf(eTypeProduct);
		            if (typeProduct == ETypeProduct.MEDICINAS) {
		                iva = false;
		            } else if (typeProduct == ETypeProduct.LICORES || typeProduct == ETypeProduct.VIVERES
		                    || typeProduct == ETypeProduct.ASEO || typeProduct == ETypeProduct.RANCHO) {
		                iva = true;
		            }
		        } catch (IllegalArgumentException e) {
		            System.out.println("Has introducido un tipo de producto no válido. Inténtalo de nuevo.");
		            return;
		        }
				while (true) {
		            try {
		                System.out.println("Ingrese la cantidad de productos:");
		                cant = sc.nextInt();
		                sc.nextLine();
		                break;
		            } catch (InputMismatchException e) {
		                System.out.println("La cantidad ingresada no es válida. Inténtalo de nuevo.");
		                sc.nextLine();
		            }
		        }
						
				presenter.addSale(name, value, stock, iva, typeProduct, cant);
				System.out.println("La venta ha sido añadida");
				totalSale = totalSale + serviceSale.getSale().getTotalSale();
				amount ++;
				break;
			case 2:
				System.out.println(presenter.showSale());
				break;
			case 3:
				System.out.println("El total de la venta hasta ahora es: " + totalSale);
				break;
			case 4:
				System.out.println("¿Desea salir?"
						+ "\n 1. Si"
						+ "\n 2. No");
				option = sc.nextInt();
				if (option == 1) {
					exit++;
					System.out.println("***************SALIENDO***************");
				} else if (option != 1 && option != 2) {
					System.out.println("***************SELECCIONE UNA OPCIÓN VÁLIDA***************");
				}
				break;
			default:
				System.out.println("***************SELECCIONE UNA OPCIÓN VÁLIDA***************");
			}
		} while (exit==0);
		System.out.println("El total de las ventas es: " + totalSale);
		System.out.println("El promedio es: " + (totalSale / amount));
	}
}
