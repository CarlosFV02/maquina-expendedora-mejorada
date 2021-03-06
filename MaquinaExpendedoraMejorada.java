public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Total billetes vendidos
    private int billetesVendidos;
    // Indica si la m?quina est? premiada
    private boolean maquinaPremiada;
    // M?ximo biletes que se pueden vender
    private int maximoBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean estadoMaquina, int numeroMaximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        billetesVendidos = 0;
        maquinaPremiada = estadoMaquina;
        maximoBilletes = numeroMaximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
            return precioBillete;   
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            if (billetesVendidos < maximoBilletes) {        
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            
            else {
                System.out.println(" Ya has comprado el m?ximo de billetes posibles.");
                System.out.println();
            }
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (cantidadDeDineroQueFalta <= 0) {        
            if (billetesVendidos < maximoBilletes) {        
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();
            }
            if (maquinaPremiada == true){
                    if(billetesVendidos%3 == 0){
                    System.out.println("Descuento de " + precioBillete/10 + " euros en GADIS");
                    System.out.println();
                    }    
            }
            else{
                System.out.println("M?ximo n?mero de billetes comprados");
                System.out.println();
            }
            

            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            // Suma en uno los billetes vendidos
            billetesVendidos = billetesVendidos + 1;
        }
        
        else {
            System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");

        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
    
    /**
     * Vacia el dinero que haya acumulado en la m?quina
     */
    public int vaciarDineroDeLaMaquina() {
        int cantidadDeDineroVaciado;
        if (balanceClienteActual == 0) {        
            cantidadDeDineroVaciado = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        else {
            System.out.println("Se est? llevando a cabo una compra de billetes");
            System.out.println();   
            cantidadDeDineroVaciado = -1;
        }       
        return cantidadDeDineroVaciado;
    }
    
    /**
     * Devuelve el n?mero de billetes vendidos desde la creaci?n de la m?quina
     */
    public int getNumeroBilletesVendidos() {
        return billetesVendidos;
    }
    
    /**
     * Imprime por pantalla el n?mero de billetes vendidos desde la creaci?n 
     * de la m?quina
     */
    public void imprimeNumeroBilletesVendidos() {
        System.out.println("Se han vendido " + billetesVendidos + " billetes");
        System.out.println();
    }
}    
