
/**
 * Write a description of class SIMULADOR2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Simulador2 {
    public static void main(String[] args) {
        Banco objbanco = new Banco("progra2A");
        Cliente objcliente1 = new Cliente("Ana Guzman", "1001");

        CuentaBancaria objcuenta1 = new CuentaBancaria("MON-CTA-001", objcliente1, 150.00);
        Tarjeta objtarjeta1 = new Tarjeta("1234", "9999", objcuenta1);
        objbanco.registrarTarjeta(objtarjeta1);
        objbanco.registrarCuenta(objcuenta1);

        CajeroAutomatico cajerozonaportales = new CajeroAutomatico(objbanco);
        if (cajerozonaportales.autenticar("1234", "9999")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
            System.out.println(cajerozonaportales.retirar(100.0));
            System.out.println(cajerozonaportales.depositar(1005.0));
            mostrarHistorial(objcuenta1);
            System.out.println("Saldo final: " + cajerozonaportales.consultarSaldo());
        } else {
            System.out.println("No se pudo autenticar la tarjeta");
        }
    }
    private static void mostrarHistorial(CuentaBancaria cuenta) {
        System.out.println("Historial de la cuenta " + cuenta.getNumero() + ":");

        for (Transaccion transaccion : cuenta.getHistorial()) {
            System.out.println("- " + transaccion.getTipo()
                    + " por " + transaccion.getMonto()
                    + " el " + transaccion.getFecha());
        }
    }}
    

        
        
        
        
        
        
        