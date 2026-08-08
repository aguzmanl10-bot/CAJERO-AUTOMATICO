
/**
 * Write a description of class SIMULADOR3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SIMULADOR3
{
     public static void main(String[] args) {
        Banco objbanco = new Banco("Banco Universitario");
        Cliente objcliente1 = new Cliente("Ana Lopez", "1001");
        Cliente objcliente2 = new Cliente("Carlos Perez", "1002");
        Cliente objcliente3 = new Cliente("Maria Gomez", "1003");
           
        CuentaBancaria objcuenta1 = new CuentaBancaria("CTA-1001", objcliente1, 2000.0);
        CuentaBancaria objcuenta2 = new CuentaBancaria("CTA-1002", objcliente2, 1200.0);
        CuentaBancaria objcuenta3 = new CuentaBancaria("CTA-1003", objcliente3, 500.0);   
           
        Tarjeta objtarjeta1 = new Tarjeta("TAR-001", "1234", objcuenta1);
        Tarjeta objtarjeta2 = new Tarjeta("TAR-002", "2345", objcuenta2);
        Tarjeta objtarjeta3 = new Tarjeta("TAR-003", "3456", objcuenta3);
        
        objbanco.registrarTarjeta(objtarjeta1);
        objbanco.registrarTarjeta(objtarjeta2);
        objbanco.registrarTarjeta(objtarjeta3);
        objbanco.registrarCuenta(objcuenta1);
        objbanco.registrarCuenta(objcuenta2);
        objbanco.registrarCuenta(objcuenta3);

        CajeroAutomatico cajerozonaportales = new CajeroAutomatico(objbanco);
        if (cajerozonaportales.autenticar("TAR-001", "1234")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
            System.out.println(cajerozonaportales.depositar(300.0));
            mostrarHistorial(objcuenta1);
            System.out.println("Saldo final: " + cajerozonaportales.consultarSaldo());
        } else {
            System.out.println("No se pudo autenticar la tarjeta");
        }
        if (cajerozonaportales.autenticar("TAR-002", "2345")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
            System.out.println(cajerozonaportales.retirar(400.0));
            mostrarHistorial(objcuenta2);
            System.out.println("Saldo final: " + cajerozonaportales.consultarSaldo());
        } else {
            System.out.println("No se pudo autenticar la tarjeta");
        }
        if (cajerozonaportales.autenticar("TAR-001", "1234")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
            System.out.println(cajerozonaportales.transferir("CTA-1003", 700.0));
            mostrarHistorial(objcuenta1);
            System.out.println("Saldo final: " + cajerozonaportales.consultarSaldo());
        } else {
            System.out.println("No se pudo autenticar la tarjeta");
        }
        if (cajerozonaportales.autenticar("TAR-003", "3456")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
            System.out.println(cajerozonaportales.retirar(1500.0));
            mostrarHistorial(objcuenta3);
            System.out.println("Saldo final: " + cajerozonaportales.consultarSaldo());
        } else {
            System.out.println("No se pudo autenticar la tarjeta");
        }
        if (cajerozonaportales.autenticar("TAR-002", "2345")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
        
            System.out.println(cajerozonaportales.transferir("CTA-1001", 250.0));
            mostrarHistorial(objcuenta2);
            System.out.println("Saldo final: " + cajerozonaportales.consultarSaldo());
        } else {
            System.out.println("No se pudo autenticar la tarjeta");
        }
        if (cajerozonaportales.autenticar("TAR-002", "235")) {
            System.out.println("Saldo inicial: " + cajerozonaportales.consultarSaldo());
            System.out.println(cajerozonaportales.retirar(1000.0));
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

    

        

        