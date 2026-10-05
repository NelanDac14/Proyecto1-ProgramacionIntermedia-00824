package cr.uned.programacionintermedia.nelsonacuna.proyecto1;

import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;

/**
 * Clase principal del proyecto
 *
 * @author Nelson Andrés Acuña Cambronero
 * @version 1.0
 */
public class NelsonAcuna_Proyecto1 {

    public static void main(String[] args) {

        // Variables
        int opcMenu = 0;
        boolean continuar;

        /**
         * Configura la salida estándar de la aplicación utilizando la
         * codificación UTF-8, con el propósito de representar correctamente
         * caracteres como tildes y la letra ñ.
         *
         * Basado en la documentación oficial de Java para las clases
         * PrintStream y StandardCharsets
         *
         * Fuente: Oracle, Java SE Documentation - PrintStream:
         * https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/io/PrintStream.html
         *
         * Oracle, Java SE Documentation - StandardCharsets:
         * https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/nio/charset/StandardCharsets.html
         */
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner scannerEntrada = new Scanner(System.in);

        // Menú principal.
        do {
            continuar = true;
            // Mostramos el menú principal
            menuPrincipal();
            //Try-Catch para validar la entrada de la opción del menú
            try {
                // Recibe la opción elegida del usuario
                opcMenu = scannerEntrada.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida, inténtelo de nuevo.");
                // Descartamos el buffer de entrada erróneo.
                scannerEntrada.nextLine();
                //Saltamos el switch para repetir el menú
                continue;
            }

            // switch menú principal.
            switch (opcMenu) {
                case 1: // Gestión de Superhéroes.
                    // Submenú Gestión de Superhéroes.
                    do {
                        continuar = true;
                        // Mostramos el submenú de gestión de superhéroes
                        menuGestionSuperheroes();

                        //Try-Catch para validar la entrada de la opción del submenú
                        try {
                            // Recibe la opción elegida del usuario
                            opcMenu = scannerEntrada.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opción inválida, inténtelo de nuevo.");
                            // Descartamos el buffer de entrada erróneo.
                            scannerEntrada.nextLine();
                            //Saltamos el switch para repetir el menú
                            continue;
                        }// Fin try-catch

                        // switch submenú gestión de superhéroes.
                        switch (opcMenu) {
                            case 1: // Agregar superhéroe
                                //Variables
                                String nombHeroico = "";
                                String nombReal = "";
                                String poderPrincipal = "";
                                String nivel = "";
                                String estado = "";
                                double salarioMensual = 0.0;
                                
                                agregarSuperHeroe(scannerEntrada, nombHeroico, nombReal, poderPrincipal, nivel, estado, salarioMensual, continuar);
                                
                                break;
                            case 2: // Actualizar datos de un superhéroe
                                break;
                            case 3: // Cambiar estado de un superhéroe
                                break;
                            case 4: // Eliminar un superhéroe
                                break;
                            case 5: // Regresar al menú principal
                                continuar = false;
                                break;
                            default: // Opción por default
                                System.out.println("Opción inválida, inténtelo de nuevo. (Rango de opciones 1 al 5)");
                                break;
                        }
                    } while (continuar);

                    // volvemos a ver el menú principal
                    continuar = true;

                    break;
                case 2: //Gestión de Equipos de Rescate.
                    // Submenú Gestión de Equipos de Rescate.
                    do {
                        continuar = true;
                        // Mostramos el submenú de Gestión de Equipos de Rescate
                        menuGestionEquiposRescate();

                        //Try-Catch para validar la entrada de la opción del submenú
                        try {
                            // Recibe la opción elegida del usuario
                            opcMenu = scannerEntrada.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opción inválida, inténtelo de nuevo.");
                            // Descartamos el buffer de entrada erróneo.
                            scannerEntrada.nextLine();
                            //Saltamos el switch para repetir el menú
                            continue;
                        }// Fin try-catch

                        // switch submenú Gestión de Equipos de Rescate.
                        switch (opcMenu) {
                            case 1: // Agregar equipo
                                break;
                            case 2: // Actualizar equipo
                                break;
                            case 3: // Eliminar equipo
                                break;
                            case 4: // Regresar al menú principal
                                continuar = false;
                                break;
                            default: // Opción por default
                                System.out.println("Opción inválida, inténtelo de nuevo. (Rango de opciones 1 al 4)");
                                break;
                        }
                    } while (continuar);

                    // volvemos a ver el menú principal
                    continuar = true;

                    break;
                case 3: // Módulo de Reportes.
                    // Módulo de Reportes.
                    do {
                        continuar = true;
                        // Mostramos el submenú Módulo de Reportes
                        menuModuloReportes();

                        //Try-Catch para validar la entrada de la opción del submenú
                        try {
                            // Recibe la opción elegida del usuario
                            opcMenu = scannerEntrada.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Opción inválida, inténtelo de nuevo.");
                            // Descartamos el buffer de entrada erróneo.
                            scannerEntrada.nextLine();
                            //Saltamos el switch para repetir el menú
                            continue;
                        }// Fin try-catch

                        // switch submenú Módulo de Reportes.
                        switch (opcMenu) {
                            case 1: // Mostrar todos los superhéroes
                                break;
                            case 2: // Buscar superhéroes por ID
                                break;
                            case 3: // Mostrar todos los equipos de rescate
                                break;
                            case 4: // Mostrar el equipo con mayor costo operativo
                                break;
                            case 5: // Buscar equipos por tipo de emergencia
                                break;
                            case 6: // Mostrar superhéroes con nivel Élite
                                break;
                            case 7: // Mostrar cantidad de héroes según su estado
                                break;
                            case 8: // Regresar al menú principal
                                continuar = false;
                                break;
                            default: // Opción por default
                                System.out.println("Opción inválida, inténtelo de nuevo. (Rango de opciones 1 al 8)");
                                break;
                        }
                    } while (continuar);

                    // volvemos a ver el menú principal
                    continuar = true;

                    break;
                case 4: // Salir.
                    System.out.println("¡Gracias por utilizar nuestro programa!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo. (Rango de opciones 1 al 4)");

            }

        } while (continuar);
    }

    // Menú principal del proyecto.
    public static void menuPrincipal() {

        System.out.println("\n=======================================================");
        System.out.println("||              ACADEMIA DE SUPERHÉROES              ||");
        System.out.println("=======================================================\n");

        System.out.println("Sistema de Gestión de Superhéroes y Equipos de Rescate\n");

        System.out.println("================== MENÚ PRINCIPAL =====================");
        System.out.println("1. Gestión de Superhéroes");
        System.out.println("2. Gestión de Equipos de Rescate");
        System.out.println("3. Módulo de Reportes");
        System.out.println("4. Salir");

        System.out.print("\nSeleccione una opción: ");

    }

    // Submenú de Gestión de Superhéroes.
    public static void menuGestionSuperheroes() {
        System.out.println("\n------ GESTIÓN DE SUPERHÉROES ------\n");
        System.out.println("1. Agregar superhéroe");
        System.out.println("2. Actualizar datos de un superhéroe");
        System.out.println("3. Cambiar estado de un superhéroe");
        System.out.println("4. Eliminar un superhéroe");
        System.out.println("5. Regresar al menú principal");

        System.out.print("\nSeleccione una opción: ");

    }

    // Submenú de Gestión de Equipos de Rescate.
    public static void menuGestionEquiposRescate() {
        System.out.println("\n---- Gestión de Equipos de Rescate ----");
        System.out.println("1. Agregar equipo");
        System.out.println("2. Actualizar equipo");
        System.out.println("3. Eliminar equipo");
        System.out.println("4. Regresar al menú principal");

        System.out.print("\nSeleccione una opción: ");
    }

    // Submenú del Módulo de reportes.
    public static void menuModuloReportes() {
        System.out.println("\n===== MÓDULO DE REPORTES ====\n");
        System.out.println("1. Mostrar todos los superhéroes");
        System.out.println("2. Buscar superhéroes por ID");
        System.out.println("3. Mostrar todos los equipos de rescate");
        System.out.println("4. Mostrar el equipo con mayor costo operativo");
        System.out.println("5. Buscar equipos por tipo de emergencia");
        System.out.println("6. Mostrar superhéroes con nivel Élite");
        System.out.println("7. Mostrar cantidad de héroes según su estado");
        System.out.println("8. Regresar al menú principal");

        System.out.print("\nSeleccione una opción: ");
    }

    public static void agregarSuperHeroe(Scanner entrada, String nombHeroico, String nombReal, String poderPrincipal,
            String nivel, String estado, double salarioMensual, boolean continuar) {
        // Se crea un nuevo héroe
        Superheroe superHeroe = new Superheroe();
        // Se genera el IdHeroe 
        superHeroe.generadorIdHeroe();
        System.out.println("--- AGREGAR SUPERHPEROE ---\n");
        System.out.println("ID generado: " + superHeroe.getIdHeroe());

        // Se solicita el nombre heroico
        do {
            continuar = true;
            System.out.print("Nombre heroico: ");
            nombHeroico = entrada.nextLine();
            // Validamos que el nombre tenga más de 3 caracteres
            if (nombHeroico.length() >= 3) {
                continuar = false;
            } else {
                System.out.println("Nombre inválido, el nombre heroico debe tener al menos 3 caracteres");
            }
        } while (continuar);

        // Se solicita el nombre real
        do {
            continuar = true;
            System.out.print("Nombre real: ");
            nombReal = entrada.nextLine();
            // Validamos que el nombre tenga más de 3 caracteres
            if (nombReal.length() >= 3) {
                continuar = false;
            } else {
                System.out.println("Nombre inválido, el nombre real debe tener al menos 3 caracteres");
            }
        } while (continuar);
        
        //Se solicita el poder principal
        do{
            continuar = true;
            System.out.println("Poder principal (Fuerza, Velocidad, Tecnología, Magia, Control elemental): ");
            poderPrincipal = entrada.nextLine();
            //Se establece en minúscula el poder digitado por el usuario para validar
            poderPrincipal = poderPrincipal.toLowerCase();
            // Validamos que el poder ingresado por el usuario sea valido
            switch (poderPrincipal) {
                case "fuerza":
                case "velocidad":
                case "tecnología":
                case "magia":
                case "control elemental":
                    continuar = false;
                    break;
                default:
                    System.out.println("¡Poder inválido! Intentalo de nuevo.\nPoderes a elegir: Fuerza, Velocidad, Tecnología, Magia, Control elemental");
                    break;
            }
        }while(continuar);
    }
}
