package modelo;

import java.util.Scanner;

public class Efectivo {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Pedimos los datos necesarios al usuario
        System.out.print("Ingrese el monto total a pagar: ");
        double montoTotal = sc.nextDouble();
        System.out.print("Ingrese la tasa de interés anual: ");
        double tasaInteresAnual = sc.nextDouble();
        System.out.print("Ingrese la cantidad de meses para pagar: ");
        int cantidadMeses = sc.nextInt();
        
        // Calculamos la tasa de interés mensual
        double tasaInteresMensual = tasaInteresAnual / 12;
        
        // Calculamos la cuota mensual a pagar
        double cuotaMensual = (montoTotal * tasaInteresMensual) / (1 - Math.pow(1 + tasaInteresMensual, -cantidadMeses));
        
        // Imprimimos el cronograma de pagos
        double saldoPendiente = montoTotal;
        System.out.println("Cronograma de pagos:");
        System.out.println("Mes\tCuota\tInterés\tAmortización\tSaldo Pendiente");
        for (int i = 1; i <= cantidadMeses; i++) {
            double interes = saldoPendiente * tasaInteresMensual;
            double amortizacion = cuotaMensual - interes;
            saldoPendiente -= amortizacion;
            System.out.printf("%d\t%.2f\t%.2f\t%.2f\t\t%.2f\n", i, cuotaMensual, interes, amortizacion, saldoPendiente);
        }
	}
}
