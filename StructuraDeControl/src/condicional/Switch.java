package condicional;

public class Switch {
    public static void ejecutarSwitch() {
        String mes = "Junio";

        /*switch(mes) {
            case "Enero":
                System.out.println("El mes de enero tiene 31 dias");
                break;
            case "Febrero":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Marzo":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Abril":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Mayo":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Juio":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Julio":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Agosto":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Septimebre":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Octubre":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Noviembre":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            case "Diciembre":
                System.out.println("El mes de febrero  tiene 28 dias");
                break;
            default:
                System.out.println("Mes no valido");
        }*/

        int numeroDeLetrasDelMes = switch (mes) {
            case "Enero", "Marzo", "Mayo", "Julio", "Agosto", "Octubre", "Diciembre" -> 31;
            case "Abril", "Junio", "Septiembre", "Noviembre" -> 30;
            case "Febrero" -> 28;
            default -> 0;
        };

        System.out.println("El mes de " + mes + " tine " + numeroDeLetrasDelMes + " días");
    }
}
