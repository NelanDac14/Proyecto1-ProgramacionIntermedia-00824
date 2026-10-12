package cr.uned.programacionintermedia.nelsonacuna.proyecto1;

import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;

/**
 * Clase principal del proyecto
 * 
 * Este proyecto es desarrollado para solucionar la necesidad de la Academia
 * Internacional de Superhéroes de gestionar sus equipos de rescate y sus 
 * superhéroes correspondientes
 * 
 * Permite funcionalidades como agregar, actualizar, leer y eliminar registros,
 * ya sea de superhéroes o de equipos de rescate. Cuenta con 2 clases que 
 * funcionan como objetos respectivos de sus nombre y que funcionan como tal dentro
 * del sistema.
 *
 * @author Nelson Andrés Acuña Cambronero
 * @version 1.0
 */
public class NelsonAcuna_Proyecto1 {

    public static void main(String[] args) {

        // Variables
        int opcMenu;
        boolean continuar;

        // Creamos un ArrayList de SuperHeroes y de Equipos de Rescate para almacenarlos
        ArrayList<Superheroe> superHeroes = new ArrayList<>();
        ArrayList<EquipoRescate> equiposRescate = new ArrayList<>();

        /**
         * Configura la salida estándar de la aplicación utilizando la
         * codificación UTF-8, con el propósito de representar correctamente
         * caracteres con tildes y la letra ñ.
         *
         * Basado en la documentación oficial de Java para las clases
         * PrintStream y StandardCharsets
         */
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));;

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
                //Eliminamos el buffer residual
                scannerEntrada.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("¡Opción inválida! Inténtelo de nuevo.");
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
                        //Variables
                        continuar = true;
                        // Mostramos el submenú de gestión de superhéroes
                        menuGestionSuperheroes();

                        //Try-Catch para validar la entrada de la opción del submenú
                        try {
                            // Recibe la opción elegida del usuario
                            opcMenu = scannerEntrada.nextInt();
                            //Eliminamos el buffer residual
                            scannerEntrada.nextLine();
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
                                // Solicitamos los datos del nuevo superhéroe
                                agregarSuperHeroe(scannerEntrada, superHeroes);
                                break;
                            case 2: // Actualizar datos de un superhéroe
                                actualizarDatosSuperHeroe(scannerEntrada, superHeroes);
                                break;
                            case 3: // Cambiar estado de un superhéroe
                                cambiarEstadoSuperHeroe(scannerEntrada, superHeroes);
                                break;
                            case 4: // Eliminar un superhéroe
                                eliminarSuperHeroe(scannerEntrada, superHeroes);
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

                        // Try-Catch para validar la entrada de la opción del submenú
                        try {
                            // Recibe la opción elegida del usuario
                            opcMenu = scannerEntrada.nextInt();
                            //Eliminamos el buffer residual
                            scannerEntrada.nextLine();
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
                                agregarEquipo(scannerEntrada, superHeroes, equiposRescate);
                                break;
                            case 2: // Actualizar equipo
                                actualizarEquipo(scannerEntrada, superHeroes, equiposRescate);
                                break;
                            case 3: // Eliminar equipo
                                eliminarEquipo(scannerEntrada, equiposRescate);
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
                            //Eliminamos el buffer residual
                            scannerEntrada.nextLine();
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
                                mostrarSuperHeroes(superHeroes);
                                break;
                            case 2: // Buscar superhéroes por ID
                                buscarSuperHeroe(scannerEntrada, superHeroes);
                                break;
                            case 3: // Mostrar todos los equipos de rescate
                                mostrarEquiposRescate(equiposRescate);
                                break;
                            case 4: // Mostrar el equipo con mayor costo operativo
                                equipoMayorCostoOperativo(equiposRescate);
                                break;
                            case 5: // Buscar equipos por tipo de emergencia
                                buscarEquipoTipoEmergencia(scannerEntrada, equiposRescate);
                                break;
                            case 6: // Mostrar superhéroes con nivel Élite
                                mostrarHeroeNivelElite(superHeroes);
                                break;
                            case 7: // Mostrar cantidad de héroes según su estado
                                mostrarCantHeroesPorEstado(superHeroes);
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

        System.out.println("\n" + "=".repeat(55));
        System.out.println("||" + " ".repeat(14) + "ACADEMIA DE SUPERHÉROES              ||");
        System.out.println("=".repeat(55));

        System.out.println("\nSistema de Gestión de Superhéroes y Equipos de Rescate\n");

        System.out.println("=".repeat(19) + " MENÚ PRINCIPAL " + "=".repeat(20) + "\n");

        System.out.println("1. Gestión de Superhéroes");
        System.out.println("2. Gestión de Equipos de Rescate");
        System.out.println("3. Módulo de Reportes");
        System.out.println("4. Salir");

        System.out.print("\nSeleccione una opción: ");

    }

    // Submenú de Gestión de Superhéroes.
    public static void menuGestionSuperheroes() {
        System.out.println("\n" + "-".repeat(15) + " GESTIÓN DE SUPERHÉROES " + "-".repeat(16) + "\n");
        System.out.println("1. Agregar superhéroe");
        System.out.println("2. Actualizar datos de un superhéroe");
        System.out.println("3. Cambiar estado de un superhéroe");
        System.out.println("4. Eliminar un superhéroe");
        System.out.println("5. Regresar al menú principal");

        System.out.print("\nSeleccione una opción: ");

    }

    // Submenú de Gestión de Equipos de Rescate.
    public static void menuGestionEquiposRescate() {
        System.out.println("\n" + "-".repeat(12) + " Gestión de Equipos de Rescate " + "-".repeat(12) + "\n");
        System.out.println("1. Agregar equipo");
        System.out.println("2. Actualizar equipo");
        System.out.println("3. Eliminar equipo");
        System.out.println("4. Regresar al menú principal");

        System.out.print("\nSeleccione una opción: ");
    }

    // Submenú del Módulo de reportes.
    public static void menuModuloReportes() {
        System.out.println("\n" + "-".repeat(17) + " MÓDULO DE REPORTES " + "-".repeat(18) + "\n");
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

    /**
     * Formateo para expreción monetaria o contable
     *
     * Establece el formato en estilo decimal con dos decimales para referir un
     * dato que demastrará una expresión monetaria en dólares.
     *
     * @param monto recibe un tipo de dato int, con la intención de convertirlo
     * en formato monetario
     *
     * @return Retorna el dato con el formato monetario establecido
     */
    public static String formatoMonetario(double monto) {
        // Se establece los símbolos decimales a utilizar
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.US);
        // Se establece la coma como seperador de grupos
        simbolos.setGroupingSeparator(',');
        // Se establece el punto con el separador de decimales
        simbolos.setDecimalSeparator('.');
        // Establece el formato decimal deseado al dato
        DecimalFormat formato_contable = new DecimalFormat("$#,##0.00", simbolos);
        // Retornamos el dato en string con el formato establecido
        return String.valueOf(formato_contable.format(monto));
    }

    /**
     * Validación de respuestas de Sí o No
     *
     * Valida las respuestas de los usuarios a pregunta de Sí o No
     *
     * @param entrada objeto que recibe la elección del usuario
     * @param pregunta la pregunta que se realizará al momento de esperar la
     * respuesta del usuario
     *
     * @return Retornará true si la respuesta es afirmativa y false para el caso
     * contrario
     */
    public static boolean respuestaSiNo(Scanner entrada, String pregunta) {
        // Variables
        String respuesta;
        // Realizamos la pregunta de respuesta Sí o No
        do {
            System.out.print("\n¿" + pregunta + "? (S/N): ");
            // Recibimos la respuesta del usuario
            respuesta = entrada.nextLine();

            // Pasamos la respuesta a mayúscula
            respuesta = respuesta.toUpperCase();

            // Validamos la respuesta del usuario
            switch (respuesta) {
                // Usuario contesta "Sí"
                case "S":
                    return true;
                // Usuario contasta "No"
                case "N":
                    return false;
                // cualquier otra respuesta del usuaio
                default:
                    System.out.println("¡Respuesta inválida! Ingrese (S/N)");
                    break;
            }
        } while (true);
    }

    /**
     * Solicitud y validación de nombre
     *
     * Solicita al usuario un nombre, ya se de superhéroe, nombre real, nombre
     * de equipo de rescate o nombre de ciudad asignada lo valida que tenga el
     * mínimo de caracteres correspondientes
     *
     * @param entrada entrada de datos
     *
     * @param mensaje mensaje del dato que va a solicitar
     *
     * @param tamMinNomb dato que representa la cantidad mínima para el nombre
     *
     * @return retorna un String con el nombre solicitado ya validado a que
     * tenga el mínimo de caracteres correspondientes
     */
    public static String solicitarNombre(Scanner entrada, String mensaje, int tamMinNomb) {
        // Se solicita el nombre heroico
        do {

            String nombSolicitado;
            System.out.print(mensaje + ": ");
            nombSolicitado = entrada.nextLine();
            // Validamos que el nombre tenga más de 3 caracteres
            if (nombSolicitado.length() >= tamMinNomb) {
                return nombSolicitado;
            } else {
                System.out.println("\n¡Nombre inválido! Debe contener al menos " + tamMinNomb + " caracteres.\n");
            }
        } while (true);
    }

    /**
     * Solicita y valida una opción seleccionada por el usuario.
     *
     * @param entrada entrada de datos
     * @param mensaje mensaje que se mostrará al usuario
     * @param opciones lista de opciones permitidas
     * @return opción válida seleccionada por el usuario
     */
    public static String solicitarOpcion(Scanner entrada, String mensaje, String... opciones) {

        do {
            System.out.print(mensaje + " ("
                    + String.join(", ", opciones) + "): ");

            String respuesta = entrada.nextLine().trim();

            for (String opcion : opciones) {
                if (respuesta.equalsIgnoreCase(opcion)) {
                    return opcion;
                }
            }

            System.out.println(
                    "\n¡Opción inválida! Seleccione una de las opciones indicadas.\n"
            );

        } while (true);
    }

    /**
     * Buscador por ID de superhéroes
     *
     * Busca un superhéroe por su ID, en caso de no encontrarlo devuelve -1
     *
     * @param superHeroes lista de superhéroes actual
     * @param idSuperHeroe id suministrado por el usuario
     *
     * @return retorna la posición del superhéroe dentro de la lista
     */
    public static int buscadorIdHeroes(ArrayList<Superheroe> superHeroes, String idSuperHeroe) {
        do {
            // Buscamos que el ID exista dentro
            for (Superheroe superHeroe : superHeroes) {

                // Comparamos el ID enviado del usuario con el de las lista hasta encontrárlo
                if (superHeroe.getIdHeroe().equals(idSuperHeroe)) {
                    // Obtenemos la poscición del superhéroe a eliminar dentro del ArrayList
                    return superHeroes.indexOf(superHeroe);

                }
            }
            // No se encontró el ID del superhéroe
            return -1;
        } while (true);
    }

    /**
     * Buscador de superhéroes
     *
     * Busca un superhéroe por un dato sumistrado por el usuario
     *
     * @param superHeroes Lista de superhéroes actual
     * @param buscarDato Dato que el usuario ingresa para buscar según el tipo
     * de búsqueda
     * @param tipoBusqueda Tipo de búsqueda que se desea raealizar por: 
     * 1- Busca por Poder 2- Busca por Nivel 3- Busca por Estado
     *
     * @return retorna las posiciones de los superhéroes dentro de la lista que
     * cumplan con el dato a buscar
     */
    public static ArrayList<Integer> buscadorHeroes(ArrayList<Superheroe> superHeroes, String buscarDato, int tipoBusqueda) {
        // Variables necesarias
        ArrayList<Integer> posHeroesEncontrados = new ArrayList<>();

        for (Superheroe superHeroe : superHeroes) {
            switch (tipoBusqueda) {
                case 1: // Busqueda por Poder 

                    // Buscamos que el Poder exista dentro de la lista de superhéroes */
                    // Comparamos el Poder enviado del usuario con el de las lista hasta encontrárlo
                    if (superHeroe.getPoder().equalsIgnoreCase(buscarDato.trim())) {
                        /* Obtenemos la poscición del superhéroe encontrado dentro de la lista de superhéroes
                            y lo añadimos a la lista de superhéroes encontrados*/
                        posHeroesEncontrados.add(superHeroes.indexOf(superHeroe));

                    }
                    // Continuamos con la siguiente evaluación de dato
                    break;
                case 2: // Busqueda por Nivel 

                    // Buscamos que el Nivel exista dentro de la lista de superhéroes */
                    // Comparamos el Nivel enviado del usuario con el de las lista hasta encontrárlo
                    if (superHeroe.getExperiencia().equalsIgnoreCase(buscarDato.trim())) {
                        /* Obtenemos la poscición del superhéroe encontrado dentro de la lista de superhéroes
                            y lo añadimos a la lista de superhéroes encontrados*/
                        posHeroesEncontrados.add(superHeroes.indexOf(superHeroe));

                    }
                    // Continuamos con la siguiente evaluación de dato
                    break;
                case 3: // Busqueda por Estado 

                    // Buscamos que el Estado exista dentro de la lista de superhéroes */
                    // Comparamos el Estado enviado del usuario con el de las lista hasta encontrárlo
                    if (superHeroe.getEstado().equalsIgnoreCase(buscarDato.trim())) {
                        /* Obtenemos la poscición del superhéroe encontrado dentro de la lista de superhéroes
                            y lo añadimos a la lista de superhéroes encontrados*/
                        posHeroesEncontrados.add(superHeroes.indexOf(superHeroe));

                    }
                    // Continuamos con la siguiente evaluación de dato
                    break;

                default:
                    // No se encontraron superhéroes
                    return posHeroesEncontrados;
            } // Fin del swift
        } // Fin del bucle for

        // Ya se recorrio toda la lista, retornamos lo encontrado
        return posHeroesEncontrados;
    }

    /**
     * Buscador de equipos de rescate
     *
     * Busca un equipo de rescate por un dato sumistrado por el usuario
     *
     * @param equiposRescate Lista de equipos de rescate actual
     * @param buscarDato Dato que el usuario ingresa para buscar según el tipo
     * de búsqueda
     * @param tipoBusqueda Tipo de búsqueda que se desea raealizar por ejemplo:
     * 1- Busca por Tipo de emergencia 2- Busca por Nivel de amenaza 3- Busca
     * por Uso de tecnología
     *
     * @return retorna las posiciones de los equipos de rescate dentro de la lista que
     * cumplan con el dato a buscar
     */
    public static ArrayList<Integer> buscadorEquiposRescate(ArrayList<EquipoRescate> equiposRescate, String buscarDato, int tipoBusqueda) {
        // Variables necesarias
        ArrayList<Integer> posEquiposEncontrados = new ArrayList<>();

        for (EquipoRescate equipoRescate : equiposRescate) {
            switch (tipoBusqueda) {
                case 1: // Busca por Tipo de emergencia 

                    // Comparamos el tipo de emergencia enviado del usuario con el de las lista hasta encontrárlo
                    if (equipoRescate.getTipoEmergencia().equalsIgnoreCase(buscarDato.trim())) {
                        /* Obtenemos la poscición del equipo de rescate encontrado dentro de la lista de 
                        equipos de rescates y lo añadimos a la lista de equipos de rescate encontrados*/
                        posEquiposEncontrados.add(equiposRescate.indexOf(equipoRescate));
                    }
                    // Continuamos con la siguiente evaluación de dato
                    break;
                case 2: // Busca por Nivel de amenaza  

                    // Comparamos el Nivel de amenaza enviado del usuario con el de las lista hasta encontrárlo
                    if (equipoRescate.getNivelAmenaza().equalsIgnoreCase(buscarDato.trim())) {
                        /* Obtenemos la poscición del equipo de rescate encontrado dentro de la lista de 
                        equipos de rescates y lo añadimos a la lista de equipos de rescate encontrados*/
                        posEquiposEncontrados.add(equiposRescate.indexOf(equipoRescate));
                    }
                    // Continuamos con la siguiente evaluación de dato
                    break;
                case 3: // Busca por Uso de tecnología 

                    // Comparamos el Busca por Uso de tecnología enviado del usuario con el de las lista hasta encontrárlo
                    if (equipoRescate.getUsoTecnologiaEspecial().equalsIgnoreCase(buscarDato.trim())) {
                        /* Obtenemos la poscición del equipo de rescate encontrado dentro de la lista de 
                        equipos de rescates y lo añadimos a la lista de equipos de rescate encontrados*/
                        posEquiposEncontrados.add(equiposRescate.indexOf(equipoRescate));
                    }
                    // Continuamos con la siguiente evaluación de dato
                    break;

                default:
                    // No se encontraron equipos de rescate
                    return posEquiposEncontrados;
            } // Fin del swift
        } // Fin del bucle for

        // Ya se recorrio toda la lista, retornamos lo encontrado
        return posEquiposEncontrados;
    }

    /**
     * Buscador por ID de equipos de rescate
     *
     * Busca un equipo de rescate por su ID, digitado por el usuario
     *
     * @param equiposRescate lista de equipos de rescate actual
     * @param idEquipoRescate id suministrado por el usuario
     *
     * @return retorna la posición del superhéroe dentro de la lista
     */
    public static int buscadorIdEquipoRescate(ArrayList<EquipoRescate> equiposRescate, String idEquipoRescate) {
        // Visualizamos que el usuario no haya ingresado dato en blanco           
        do {
            // Buscamos que el ID exista dentro
            for (EquipoRescate equipoRescate : equiposRescate) {
                // Comparamos el ID enviado del usuario con el de las lista hasta encontrárlo
                if (equipoRescate.getIdEquipo().equals(idEquipoRescate)) {
                    // Obtenemos la posición del equipo de rescate a retornar dentro del ArrayList
                    return equiposRescate.indexOf(equipoRescate);
                }
            }
            // No se encontró el ID del superhéroe
            return -1;
        } while (true);
    }

    /**
     * Imprime una lista de superhéroes
     *
     * Su función es imprimir la cantidad de superhéroes existentes dentro del
     * ArrayList, se 1 o varios
     *
     * @param superHeroes Lista que recibe para imprimir
     */
    public static void imprimirSuperHeroes(ArrayList<Superheroe> superHeroes) {
        // Encabezado de la lista de superHéroes
        System.out.printf("%-6s   %-14s   %-17s   %-10s   %-12s   %-9s   \n", "ID", "Nombre Heroico", "Poder", "Nivel", "Estado", "Salario");
        System.out.println("=".repeat(86));

        // Recorremos la lista de superheroes para mostrarlo al usuario
        for (Superheroe superHeroe : superHeroes) {
            // Imprime cada superhéroe de la lista con el formato ya indicado
            System.out.printf("%-6s   %-14s   %-17s   %-10s   %-12s   %-9s  \n", superHeroe.getIdHeroe(), superHeroe.getNombreHeroico(),
                    superHeroe.getPoder(), superHeroe.getExperiencia(), superHeroe.getEstado(), formatoMonetario(superHeroe.getSalarioMensual()));
            System.out.println("-".repeat(86));
        }

    }

    /**
     * Imprime una lista de equipos de rescate
     *
     * Muestra en pantalla todos los equipos de rescate existentes dentro de la
     * lista equiposRescate, además los superhéroes que lo integran y su
     * respectivo Salario por superhéroe y costo operativo del equipo
     *
     * @param equiposRescate Lista de equipos de rescate que desea imprimir
     */
    public static void imprimirEquiposRescate(ArrayList<EquipoRescate> equiposRescate) {
        for (EquipoRescate equipoRescate : equiposRescate) {
            // Mostramos datos del equipo
            System.out.printf("%-27s     %-10s     \n", "Equipo: " + equipoRescate.getNombreEquipo(), "ID: " + equipoRescate.getIdEquipo());
            System.out.println("Tipo de emergencia: " + equipoRescate.getTipoEmergencia());
            System.out.println("Nivel de amenaza: " + equipoRescate.getNivelAmenaza());
            System.out.println("Ciudad asignada: " + equipoRescate.getCiudadAsignada());
            System.out.println("¿Usa tecnología especial?: " + equipoRescate.getUsoTecnologiaEspecial());
            System.out.println("Superhéroes del equipo:");
            //Mostramos los superhéroes del equipo
            for (Superheroe superheroe : equipoRescate.getListaSuperheroes()) {
                System.out.printf("%-1s %-6s   %-20s   (%-10s)\n", "-", superheroe.getIdHeroe(), superheroe.getNombreHeroico(), formatoMonetario(superheroe.getSalarioMensual()));
            }
            System.out.println("-".repeat(55));
            System.out.println("COSTO OPERATIVO TOTAL: " + formatoMonetario(equipoRescate.getCostoOperativo()));
            System.out.println("-".repeat(55));
        }

    }

    /**
     * Solicita datos de un superhéroe
     *
     * Solicita al usuario datos de un superhéroe, ya se para agregar o
     * actualizar un superhéroe
     *
     * @param entrada Entrada de datos
     * @param superHeroe objeto de la clase SuperHeroe
     */
    public static void solicitarDatosSuperHeroe(Scanner entrada, Superheroe superHeroe) {
        // Variable
        double salarioMensual;

        String mensaje;

        // Se solicita el nombre heroico
        mensaje = "Nombre heroico";
        // Asignamos el dato al superhéroe
        superHeroe.setNombreHeroico(solicitarNombre(entrada, mensaje, 3));

        // Se solicita el nombre real
        mensaje = "Nombre real";
        // Asignamos el dato al superhéroe
        superHeroe.setNombreReal(solicitarNombre(entrada, mensaje, 3));

        // Se solicita el poder principal
        mensaje = "Poder principal";
        // Asignamos el dato al superhéroe        
        superHeroe.setPoder(solicitarOpcion(entrada, mensaje, "Fuerza", "Velocidad", "Tecnología", "Magia", "Telepatía"));

        // Se solicita el nivel de experiencia
        mensaje = "Nivel";
        // Asignamos el dato al superhéroe
        superHeroe.setExperiencia(solicitarOpcion(entrada, mensaje, "Novato", "Intermedio", "Élite"));

        // Se solicita el estado
        mensaje = "Estado";
        // Asignamos el dato al superhéroe
        superHeroe.setEstado(solicitarOpcion(entrada, mensaje, "Disponible", "En misión", "Recuperación"));

        // Se solicita el salario mensual
        do {
            System.out.print("Salario mensual ($): ");
            // Try-Catch para validar que el dato ingresado sea el esperado
            try {
                // Recibimos el salario mensual que establece el usuario
                salarioMensual = entrada.nextDouble();

                // Validamos que el monto ingresado sea mayor a cero
                if (salarioMensual > 0.0) {
                    break;
                } else {
                    System.out.println("¡Salario Inválido! Ingrese un monto mayor a cero");
                }
            } catch (Exception e) {
                System.out.println("\n¡Salario Inválido! Intente de nuevo\n");
                // Descartamos el buffer de entrada erróneo.
                entrada.nextLine();
            }
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setSalarioMensual(salarioMensual);

        // Limpiamos el buffer residual
        entrada.nextLine();
    }

    /**
     * Solicita datos de un equipo de rescate
     *
     * Solicita y valida datos correspondientes a un equipo de rescate para luego 
     * agregar un equipo o actualizarlo
     *
     * @param entrada entrada de datos
     * @param equipoRescate objeto de la clase EquipoRescate
     * @param superHeroes arreglo de superhéroes que contiene la lista de los
     * superhéroes actuales
     */
    public static void solicitarDatosEquipoRescate(Scanner entrada, EquipoRescate equipoRescate, ArrayList<Superheroe> superHeroes) {
        // Variable
        String mensaje;
        String idHeroesEquipo;
        String[] heroesEquipo;
        ArrayList<Superheroe> superHeroesEquipo = new ArrayList<>();

        // Se solicita el nombre del equipo        
        mensaje = "Nombre del equipo";
        equipoRescate.setNombreEquipo(solicitarNombre(entrada, mensaje, 3));

        //Se solicita el tipo de emergencia
        mensaje = "Tipo de emergencia";
        // Asignamos el dato al EquipoRescate  
        equipoRescate.setTipoEmergencia(solicitarOpcion(entrada, mensaje, "Desastres naturales", "Invasión alienígena", "Amenaza nuclear", "Villano de alto riesgo"));

        //Se solicita el nivel de amenaza
        mensaje = "Nivel de amenaza";
        // Asignamos el dato al EquipoRescate  
        equipoRescate.setNivelAmenaza(solicitarOpcion(entrada, mensaje, "Bajo", "Medio", "Alto"));

        //Se solicita la ciudad a designar el equipo
        mensaje = "Ciudad asignada";
        // Asignamos el dato al EquipoRescate  
        equipoRescate.setCiudadAsignada(solicitarNombre(entrada, mensaje, 3));

        //Se solicita validar el uso de tecnología
        mensaje = "Usa tecnología especial";
        // Asignamos el dato al EquipoRescate  
        if (respuestaSiNo(entrada, mensaje)) {
            equipoRescate.setUsoTecnologiaEspecial("Sí");
        } else {
            equipoRescate.setUsoTecnologiaEspecial("No");
        }

        System.out.println("-".repeat(6) + " SELECCIONE LOS SUPERHÉROES PARA EL EQUIPO " + "-".repeat(6));
        System.out.println("(Ingrese los ID separados por coma)");
        System.out.print("ID de superhéroes: ");
        // Recibimos lo héroes que formarán parte del equipo
        idHeroesEquipo = entrada.nextLine().trim();
        // Separamos los ID ingresados a un arreglo String
        heroesEquipo = idHeroesEquipo.split(",");

        // Recorremo el arreglo heroesEquipo para agregarlo al arreglo de superhéroes del equipo
        for (String idHeroe : heroesEquipo) {
            // Contiene la posición del superhéroe dentro de la lista de superhéroes
            int posIndexSuperHeroe;

            //Buscamos el ID de superhéroe dentro de la lista de superhéroes
            posIndexSuperHeroe = buscadorIdHeroes(superHeroes, idHeroe.trim().toUpperCase());

            // Validamos que se encontró el ID del superhéro buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el ID: " + idHeroe + "!\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Validamos que el superhéro a agregar no se duplique dentro de la lista del equipo
            if (buscadorIdHeroes(superHeroesEquipo, idHeroe.trim().toUpperCase()) != -1) {
                // El superhéroe ya está registrado dentro del equipo
                System.out.println("\nEl superhéroe con el ID: " + idHeroe + " ya se encuentra en el equipo");
                continue;
            }

            // Agregamos el superhéroe al equipo 
            superHeroesEquipo.add(superHeroes.get(posIndexSuperHeroe));
        } // Fin del for

        // Imprimimos la cantidad de superhéroes que se añadieron al equipo
        System.out.println("Superhéroes agregados: " + superHeroesEquipo.size());

        //Añadimos el equipo de superhéroes al equipo correspondiente
        equipoRescate.setListaSuperheroes(superHeroesEquipo);

        //Se calcula el costo operativo del equipo de rescate
        equipoRescate.calcularCostoOperativo();
        // Se muestra el costo operativo del equipo de rescate
        System.out.println("Costo operativo calculado: " + formatoMonetario(equipoRescate.getCostoOperativo()));

    }

    //Métodos del Módulo de Gestión de Superhéroes
    /**
     * Agrega un nuevo superhéroe o actualiza su información
     *
     * Este métodos solicita la información necesaria para agregar un nuevo
     * superhéroe o actualizar un superhéroe ya existente y lo guarda en el
     * ArrayList superHeroes
     *
     * @param entrada Entrada de datos
     * @param superHeroes Lista de superhéroes
     */
    public static void agregarSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {
        do {
            // Creamos un nuevo superhéroe
            Superheroe superHeroe = new Superheroe();
            // Encabezado
            System.out.println("\n" + "-".repeat(17) + " AGREGAR SUPERHÉROE " + "-".repeat(18) + "\n");

            // Se genera el ID del superhéroe 
            superHeroe.generadorIdHeroe();

            //Muestra el nuevo ID del superhéroe a registrar
            System.out.println("ID generado: " + superHeroe.getIdHeroe());

            // Solicitamos la información del superhéroe
            solicitarDatosSuperHeroe(entrada, superHeroe);

            // Agregamos el superheroe a la lista de superheroes
            superHeroes.add(superHeroe);

            // Notificamos al usuario que se registró correctamente
            System.out.println("\n¡Superhéroe registrado correctamente!");

            String pregunta = "Desea agregar otro superhéroe";
            if (!respuestaSiNo(entrada, pregunta)) {
                break;
            }
        } while (true);
    }

    /**
     * Atualiza datos de un superhéroe
     *
     * Su funcionalidad es la actualización de datos de los superhéroes para
     * mantener actualizados estos o por si algún error de digitación
     *
     * @param entrada entrada de datos
     * @param superHeroes lista de superhéroes actuales
     */
    public static void actualizarDatosSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {
        //Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un superhéroe para continuar\n");
            //Regresamos al menú
            return;
        }

        do {
            // Variables

            String idSuperHeroe;
            int posIndexSuperHeroe;
            // Creamos un nuevo superhéroe
            Superheroe superHeroe;
            // Encabezado
            System.out.println("\n" + "-".repeat(10) + " ACTUALIZAR DATOS DE UN SUPERHÉROE " + "-".repeat(10) + "\n");

            // Solicitamos el ID del superhéroe
            System.out.print("Ingrese el ID del Superhéroe: ");
            idSuperHeroe = entrada.nextLine();
            // Buscamos al superhéroe que deseamos actualizar
            posIndexSuperHeroe = buscadorIdHeroes(superHeroes, idSuperHeroe);

            // Validamos que se encontró el ID del superhéro buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el superhéroe solicitado! Inténtelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información correspondiente del superhéroe solicitado
            superHeroe = superHeroes.get(posIndexSuperHeroe);

            // Solicitamos los datos actualizados del superhéroe
            solicitarDatosSuperHeroe(entrada, superHeroe);

            // Actualizamos el superhéroe
            superHeroes.set(posIndexSuperHeroe, superHeroe);

            String pregunta = "Desea actualizar a otro superhéroe";

            // Si responde que no, sale al menú de Gestión de superhéroes
            if (!respuestaSiNo(entrada, pregunta)) {
                // Salimos del do/while
                break;
            }

        } while (true);
    }

    /**
     * Cambia el estado del superhéroe según si ID
     *
     * Permite al usuario cambiar el estado del superhéros (Disponible, En
     * misión o Recuperación) esto con la intención de valorar que superhéroe se
     * encuentra disponible durante un evento de emergencia
     *
     * @param entrada recibe datos del usuario, para este caso el ID del
     * superhéroe
     * @param superHeroes lista actual de superhéroes en sistema
     */
    public static void cambiarEstadoSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {

        //Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("¡Lista vacía! Agrega un superhéroe para continuar");
            //Regresamos al menú
            return;
        }

        do {
            // Variables
            String idSuperHeroe;
            String mensaje;
            int posIndexSuperHeroe;

            // Creamos un nuevo superhéroe
            Superheroe superHeroe;

            System.out.println("\n" + "-".repeat(11) + " CAMBIO DE ESTADO DE SUPERHÉROE " + "-".repeat(12) + "\n");

            // Solicitamos el ID del superhéroe
            System.out.print("Ingrese el ID del Superhéroe: ");
            idSuperHeroe = entrada.nextLine();

            // Busca el ID del héroe dentro de la lista de héroes actual
            posIndexSuperHeroe = buscadorIdHeroes(superHeroes, idSuperHeroe);

            // Validamos que se encontró el ID del superhéro buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el superhéroe solicitado! Inténtelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información correspondiente del superhéroe solicitado
            superHeroe = superHeroes.get(posIndexSuperHeroe);

            //Se muestra al usuario el estado actual del superhéroe
            System.out.println("\nEl superhéroe " + superHeroe.getNombreHeroico() + " cuenta con el estado actual: " + superHeroe.getEstado() + "\n");

            // Se solicita el nuevo estado del superhéroe
            mensaje = "Ingrese el nuevo estado";
            // Asignamos el dato al superhéroe        
            superHeroe.setEstado(solicitarOpcion(entrada, mensaje, "Disponible", "En misión", "Recuperación"));

            System.out.println("\nEstado actualizado correctamente!\n");

            String pregunta = "Desea actualizar el estado a otro superhéroe";

            // Si responde que no, sale al menú de Gestión de superhéroes
            if (!respuestaSiNo(entrada, pregunta)) {
                // Salimos del do/while
                break;
            }

        } while (true);
    }

    /**
     * Elimina un superhéroe del sistema
     *
     * Su funcionalidad es eliminar a un superhéroe, el cual es buscado por su
     * ID y luego eliminado de la lista
     *
     * @param entrada entrada de datos
     * @param superHeroes lista de superhéroes actuales
     */
    public static void eliminarSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {
        do {
            //Validamos que la lista de superhéroes no esté vacia
            if (superHeroes.isEmpty()) {
                System.out.println("¡Lista vacía! Agrega un superhéroe para continuar");
                //Regresamos al menú
                return;
            }

            // Variables
            String idSuperHeroe;
            String pregunta;
            int posIndexSuperHeroe;

            // Creamos un nuevo superhéroe
            Superheroe superHeroe;

            System.out.println("\n" + "-".repeat(17) + " ELIMINAR SUPERHÉROE " + "-".repeat(17) + "\n");

            // Solicitamos el ID del superhéroe
            System.out.print("Ingrese el ID del Superhéroe: ");
            idSuperHeroe = entrada.nextLine();

            // Busca el ID del héroe dentro de la lista de héroes actual
            posIndexSuperHeroe = buscadorIdHeroes(superHeroes, idSuperHeroe);

            // Validamos que se encontró el ID del superhéro buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el superhéroe solicitado! Inténtelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información correspondiente del superhéroe solicitado
            superHeroe = superHeroes.get(posIndexSuperHeroe);

            // Reafirmamos la decisión de eliminar al superhéroe solicitado o velvemos a preguntar
            pregunta = "Deseas eliminar a: " + superHeroe.getIdHeroe()
                    + " | " + superHeroe.getNombreHeroico();

            // Validamos respuesta de usuario
            if (respuestaSiNo(entrada, pregunta)) {
                // Se elimina el superhéroe
                superHeroes.remove(posIndexSuperHeroe);
                System.out.println("\nEl superhéroe fue eliminado correctamente\n");

                //Preguntamos si desea eliminar a otro superhéroe
                pregunta = "Deseas eliminar a otro superhéroe";
                if (!respuestaSiNo(entrada, pregunta)) {
                    // Regresamos al menú anterior
                    return;
                }

            }

        } while (true);
    }

    //Métodos del Módulo de Gestión de Equipos de Rescate
    /**
     * Agregar nuevo equipo
     *
     * Agrega un nuevo equipo de rescate a la lista con la información
     * correspondiente y los superhéroes que conforman el equipo
     *
     * @param entrada Entrada de datos
     * @param superHeroes Lista de superhéroes actualizada
     * @param equiposRescate Lista de equipos de rescate actualizada
     */
    public static void agregarEquipo(Scanner entrada, ArrayList<Superheroe> superHeroes, ArrayList<EquipoRescate> equiposRescate) {

        //Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un superhéroe para continuar\n");
            //Regresamos al menú
            return;
        }

        do {
            // Creamos un nuevo equipo de rescate
            EquipoRescate equipoRescate = new EquipoRescate();

            // Encabezado
            System.out.println("-".repeat(14) + " AGREGAR EQUIPO DE RESCATE " + "-".repeat(14));

            // Se genera el ID del equipo
            equipoRescate.generadorIdEquipo();

            //Muesta el nuevo ID del equipo de rescate a registrar
            System.out.println("ID generado: " + equipoRescate.getIdEquipo());

            // Solicitamos la información del equipo de rescate
            solicitarDatosEquipoRescate(entrada, equipoRescate, superHeroes);

            // Agregamos el equipo de rescate a la lista de equipos de rescate
            equiposRescate.add(equipoRescate);

            // Notificamos al usuario que se registró correctamente
            System.out.println("\n¡Equipo registrado correctamente!");

            String pregunta = "Desea agregar otro equipo de rescate";
            if (!respuestaSiNo(entrada, pregunta)) {
                break;
            }
        } while (true);
    }

    /**
     * Actualizar equipo de rescate
     *
     * Actualiza un equipo de rescate mediante el ID del equipo.
     *
     * @param entrada Entrada de datos
     * @param superHeroes Lista actualizada de superhéroes
     * @param equiposRescate Lista actualizada de equipos de rescate
     */
    public static void actualizarEquipo(Scanner entrada, ArrayList<Superheroe> superHeroes, ArrayList<EquipoRescate> equiposRescate) {
        //Validamos que la lista de equipos de rescate no esté vacia
        if (equiposRescate.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un equipo de rescate para continuar\n");
            //Regresamos al menú
            return;
        }

        do {
            // Variables
            String idEquipoRescate;
            int posIndexEquipoRescate;
            //Creamos un equipo de rescate
            EquipoRescate equipoRescate;

            //Encabezado
            System.out.println("-".repeat(6) + " ACTUALIZAR DATOS DE UN EQUIPO DE RESCATE " + "-".repeat(7));

            // Solicitamos el ID del equipo de rescate
            System.out.print("Ingrese el ID del equipo de rescate: ");
            idEquipoRescate = entrada.nextLine();

            // Buscamos el equipo de rescate que se desea actualizar
            posIndexEquipoRescate = buscadorIdEquipoRescate(equiposRescate, idEquipoRescate);

            // Validamos que se encontró el ID del equipo de rescate
            if (posIndexEquipoRescate == -1) {
                System.out.println("\n¡No se encontró el equipo de rescate solicitado! Inténtelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información del correspondiente al equipo de rescate solicitado
            equipoRescate = equiposRescate.get(posIndexEquipoRescate);

            // Solicitamos los datos actualizados del equipo de rescate
            solicitarDatosEquipoRescate(entrada, equipoRescate, superHeroes);

            // Actualizamos el equipo de rescate
            equiposRescate.set(posIndexEquipoRescate, equipoRescate);

            String pregunta = "Desea actualizar a otro equipo de rescate";

            // Si responde que no, sale al menú de Gestión de equipos de rescate
            if (!respuestaSiNo(entrada, pregunta)) {
                // Salimos del do/while
                break;
            }
        } while (true);
    }

    /**
     * Elimina un equipo de rescate
     *
     * Elimina un equipo de rescate de la lista actual de equipos de rescate que
     * existen, por medio de un ID de equipo que recibe del usuario para
     * encontrarlo dentro de la lista de equipos de rescate
     *
     * @param entrada Entrada de datos
     * @param equiposRescate Lista de equipos de rescate existentes
     */
    public static void eliminarEquipo(Scanner entrada, ArrayList<EquipoRescate> equiposRescate) {
        do {
            // Validamos que la lista de equipos de rescate no esté vacía
            if (equiposRescate.isEmpty()) {
                System.out.println("¡Lista vacía! Agrega un equipo de rescate para continuar");
                // Regresamos al menú
                return;
            }

            // Variables
            String idEquipoRescate;
            String pregunta;
            int posIndexEquipoRescate;

            // Creamos un nuevo equipo de rescate
            EquipoRescate equipoRescate;

            // Encabezado
            System.out.println("-".repeat(13) + " ELIMINAR EQUIPO DE RESCATE " + "-".repeat(14));

            // Solicitamos el ID del equipo de rescate
            System.out.print("Ingrese el ID del equipo de rescate: ");
            idEquipoRescate = entrada.nextLine();

            // Busca el ID del equipo de rescate dentro de la lista actual de equipos
            posIndexEquipoRescate = buscadorIdEquipoRescate(equiposRescate, idEquipoRescate);

            // Validamos que se encontró el ID del equipo de rescate buscado
            if (posIndexEquipoRescate == -1) {
                System.out.println("\n¡No se encontró el equipo de rescate solicitado! Inténtelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información correspondiente del equipo de rescate solicitado
            equipoRescate = equiposRescate.get(posIndexEquipoRescate);

            // Preguntamos al usuario si realmente desea eliminarlo
            pregunta = "Deseas eliminar al equipo: " + equipoRescate.getIdEquipo() + " | " + equipoRescate.getNombreEquipo();
            // Validamos la respuesta del usuario
            if (respuestaSiNo(entrada, pregunta)) {
                // Se elimina el equipo de rescate
                equiposRescate.remove(posIndexEquipoRescate);
                System.out.println("\nEl equipo de rescate fue eliminado correctamente\n");

                //Preguntamos si desea elimiar otro equipo de rescate
                pregunta = "Deseas eliminar otro equipo de rescate";
                if (!respuestaSiNo(entrada, pregunta)) {
                    // Regresamos al menú anterior
                    return;
                }
            }
        } while (true);
    }

    //Métodos del Módulo de Reportes
    /**
     * Muestra todos los superhéroes registrados
     *
     * Muestra en pantalla la lista de superhéroes actual con el objetivo de que
     * el usuario pueda observarlos
     *
     * @param superHeroes esta es la lista de superhéroes que existen hasta el
     * momento, registrado por el usuari
     */
    public static void mostrarSuperHeroes(ArrayList<Superheroe> superHeroes) {

        //Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un superhéroe para continuar\n");
            //Regresamos al menú
            return;
        }

        System.out.println("\n" + "-".repeat(31) + " LISTADO DE SUPERHÉROES " + "-".repeat(31) + "\n");

        imprimirSuperHeroes(superHeroes);

        //Mensaje que indica la cantidad de superhéroes registrados a la actualidad 
        System.out.print("\nTotal de superhéroes registrados: " + superHeroes.size() + "\n");
    }

    /**
     * Busca un superhéroe para mostrarlo en pantalla
     *
     * Busca dentro de la lista de superhéroes un superhéroe en específico el
     * cual es buscado por su ID correspondiente y mostrado al usuario en
     * pantalla
     *
     * @param entrada Entrada de datos
     * @param superHeroes Lista actualizada de superhéroes
     */
    public static void buscarSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {
        // Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("¡Lista vacía! Agrega un superhéroe para continuar");
            // Regresamos al menú
            return;
        }
        do {
            // Variables
            String idSuperHeroe;
            String pregunta;
            int posIndexSuperHeroe;
            ArrayList<Superheroe> superHeroesEncontrados = new ArrayList<>();

            // Título
            System.out.println("\n" + "-".repeat(15) + " BUSCADOR DE SUPERHÉROES " + "-".repeat(15));

            // Solicitamos el ID del superhéroe
            System.out.print("\nIngrese el ID del Superhéroe: ");
            idSuperHeroe = entrada.nextLine();

            // Busca el ID del héroe dentro de la lista de héroes actual
            posIndexSuperHeroe = buscadorIdHeroes(superHeroes, idSuperHeroe);

            // Validamos que se encontró el ID del superhéroe buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el superhéroe solicitado! Inténtelo de nuevo\n");
                // Repetimos el proceso de buscar un ID 
                continue;
            }

            // Agregamos el superhéroe encontrado a la lista de encontrados para imprimir
            superHeroesEncontrados.add(superHeroes.get(posIndexSuperHeroe));

            System.out.println("\n" + "-".repeat(86));
            // Imprimimos el superhéroe encontrado
            imprimirSuperHeroes(superHeroesEncontrados);

            // Preguntamos si desea buscar otro superhéroe
            pregunta = "Deseas buscar otro superhéroe";
            if (!respuestaSiNo(entrada, pregunta)) {
                // Salimos al menú anterior del módulo de reportes
                return;
            }

        } while (true);

    }

    /**
     * Muestra todos los equipos de rescate registrados
     *
     * Muestra en pantalla todos los equipos de rescate existentes al momento de
     * ser llamado el método
     *
     * @param equiposRescate Arreglo de Equipos de rescate
     */
    public static void mostrarEquiposRescate(ArrayList<EquipoRescate> equiposRescate) {

        // Validamos que la lista de equipos de rescate no esté vacia
        if (equiposRescate.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un equipo de rescate para continuar\n");
            // Regresamos al menú
            return;
        }

        // Encabezado
        System.out.println("\n" + "-".repeat(12) + " LISTADO DE EQUIPOS DE RESCATE " + "-".repeat(12) + "\n");

        System.out.println("=".repeat(55));
        imprimirEquiposRescate(equiposRescate);
        System.out.println("=".repeat(55));

        // Mensaje que indica la cantidad de equipos de rescate registrados a la actualidad 
        System.out.print("\nTotal de equipos registrados: " + equiposRescate.size() + "\n");

    }

    /**
     * Muestra el equipo con mayor costo operativo
     *
     * Recibe la lista de equipos de rescate actual y con base en sus costos
     * operativos individuales, los compara y extrae el equipo que tiene menor
     * costo operativo.
     *
     * @param equiposRescate Lista de equipos de rescate
     */
    public static void equipoMayorCostoOperativo(ArrayList<EquipoRescate> equiposRescate) {
        // Validamos que la lista de equipos de rescate no esté vacia
        if (equiposRescate.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un equipo de rescate para continuar\n");
            // Regresamos al menú
            return;
        }
        // Variables
        // Inicializo la variable con el costo operativo del primer equipo de rescate de la lista
        double costoOperativoMayor = equiposRescate.get(0).getCostoOperativo();

        EquipoRescate equipoMayorCosto = equiposRescate.get(0);
        ArrayList<EquipoRescate> equiposMayorCosto = new ArrayList<>();

        // Encabezado
        System.out.println("\n" + "-".repeat(10) + " EQUIPO CON MAYOR COSTO OPERATIVO " + "-".repeat(11) + "\n");

        // Bucle que recorre los equipos de rescate para evaluar su costo operativo 
        for (EquipoRescate equipoRescate : equiposRescate) {
            if (equipoRescate.getCostoOperativo() > costoOperativoMayor) {
                // Asignamos el nuevo valor mayor al costo operativo mayor que ocupamos
                costoOperativoMayor = equipoRescate.getCostoOperativo();
                // Asignamos el nuevo equipo con el mayor costo operativo
                equipoMayorCosto = equipoRescate;
            }
        }

        // Agregamos el equipo resultante de mayor costo al arreglo de equiposMayorCosto
        equiposMayorCosto.add(equipoMayorCosto);

        // Imprimimos los datos en pantalla
        System.out.println("=".repeat(55));
        // Pasamos el arreglo de equiposMayorCosto y lo imprimimos
        imprimirEquiposRescate(equiposMayorCosto);
        System.out.println("\n" + "=".repeat(55));
    }

    /**
     * Busca equipos de rescate por tipo de emergencia
     *
     * Permite buscar equipos de rescate según el tipo de emergencia que el
     * usuario requiera de momento y los imprime en pantalla
     *
     * @param entrada Entrada de datos
     * @param equiposRescate Lista de equipos de rescate que reciba para buscar
     */
    public static void buscarEquipoTipoEmergencia(Scanner entrada, ArrayList<EquipoRescate> equiposRescate) {
        //Validamos que la lista de equipos de rescate no esté vacia
        if (equiposRescate.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un equipo de rescate para continuar\n");
            //Regresamos al menú
            return;
        }

        // Variable
        String mensaje;
        String tipoEmergencia;

        ArrayList<Integer> posEquiposEncontrados;
        ArrayList<EquipoRescate> equiposEncontrados = new ArrayList<>();

        // Encabezado
        System.out.println("\n" + "-".repeat(6) + " EQUIPOS DE RESCATE POR TIPO DE EMERGENCIA " + "-".repeat(6) + "\n");

        //Se solicita el tipo de emergencia
        mensaje = "Tipo de emergencia";
        // Asignamos el dato a buscar 
        tipoEmergencia = solicitarOpcion(entrada, mensaje, "Desastres naturales", "Invasión alienígena", "Amenaza nuclear", "Villano de alto riesgo");

        // Extraemos las posiciones de los equipos que cumplen con lo solicitado
        posEquiposEncontrados = buscadorEquiposRescate(equiposRescate, tipoEmergencia, 1);

        // Recorremos las posiciones y asignamos lo valores correspondiente a los equipos encontrados
        for (int posEquipo : posEquiposEncontrados) {
            // Agregamos el resultado al arreglo de equipos encontrados
            equiposEncontrados.add(equiposRescate.get(posEquipo));
        }

        // Imprimimos los datos en pantalla
        System.out.println("\n" + "=".repeat(55));
        imprimirEquiposRescate(equiposEncontrados);
        System.out.println("\nTotal de equipos encontrados: " + equiposEncontrados.size() + " para " + tipoEmergencia);
        System.out.println("\n" + "=".repeat(55));

    }

    /**
     * Mostrar superhéroes de nivel élite
     *
     * Muestra en pantalla los superhéroes que tienen el nivel de experiencia
     * élite.
     *
     * @param superHeroes Lista de superhéroes actuales
     */
    public static void mostrarHeroeNivelElite(ArrayList<Superheroe> superHeroes) {
        // Validamos que la lista de equipos de rescate no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un superhéroe para continuar\n");
            // Regresamos al menú
            return;
        }

        ArrayList<Integer> posHeroesEncontrados;
        ArrayList<Superheroe> heroesEncontrados = new ArrayList<>();

        // Encabezado
        System.out.println("\n" + "-".repeat(13) + " SUPERHÉROES DE NIVEL ÉLITE " + "-".repeat(14) + "\n");
        // Asignamos el dato a buscar 
        String nivelExperiencia = "Élite";

        //Recibimos el arreglo de posisiones encontradas
        posHeroesEncontrados = buscadorHeroes(superHeroes, nivelExperiencia, 2);

        // Recorremos las posiciones encontradas
        for (int posHeroe : posHeroesEncontrados) {
            // Agregamos el resultado al arreglo de equipos encontrados
            heroesEncontrados.add(superHeroes.get(posHeroe));
        }

        // Imprimimos los datos en pantalla
        System.out.println("=".repeat(86));
        imprimirSuperHeroes(heroesEncontrados);
        System.out.println("Total de héroes de nivel élite: " + heroesEncontrados.size());
        System.out.println("=".repeat(86));
    }

        /**
     * Mostrar la cantidad de superhéroes por estado
     *
     * Muestra la cantidad de héroes que existe por estado y el detalle de cada
     * uno de ellos
     *
     * @param superHeroes Recibe la lista de superhéroes actuales
     */
    public static void mostrarCantHeroesPorEstado(ArrayList<Superheroe> superHeroes) {
        // Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("¡Lista vacía! Agrega un superhéroe para continuar");
            // Regresamos al menú
            return;
        }
        
        // Variables
        String estado;
        int cantHeroesEstado;
        ArrayList<Integer> posHeroesEncontrados;
        ArrayList<Superheroe> heroesEncontrados = new ArrayList<>();

        // Encabezado
        System.out.println("\n" + "-".repeat(25) + " CANTIDAD DE SUPERHÉROES POR ESTADO " + "-".repeat(25) + "\n");

        // Estado Disponible
        estado = "Disponible";
        // Obtenemos la lista de posiciones encontradas con el estado indicado
        posHeroesEncontrados = buscadorHeroes(superHeroes, estado, 3);
        // Obtenemos la cantidad que hay
        cantHeroesEstado = posHeroesEncontrados.size();
        // Recorremos la lista añadiendo cada héroe en su posición para añadirlo en héroes encontrados
        for (int posHeroe : posHeroesEncontrados) {
            heroesEncontrados.add(superHeroes.get(posHeroe));
        }

        System.out.println("=".repeat(86));
        System.out.println(estado + ": " + cantHeroesEstado);
        System.out.println("=".repeat(86));
        // Imprimimos la lista de héroes encontrados
        imprimirSuperHeroes(heroesEncontrados);
        System.out.println("=".repeat(86));

        // Limpiamos el arreglo para reutilizarlo con el siguiente estado
        heroesEncontrados.clear();

        // Estado En misión
        estado = "En misión";
        // Obtenemos la lista de posiciones encontradas con el estado indicado
        posHeroesEncontrados = buscadorHeroes(superHeroes, estado, 3);
        // Obtenemos la cantidad que hay
        cantHeroesEstado = posHeroesEncontrados.size();
        // Recorremos la lista añadiendo cada héroe en su posición para añadirlo en héroes encontrados
        for (int posHeroe : posHeroesEncontrados) {
            heroesEncontrados.add(superHeroes.get(posHeroe));
        }

        System.out.println("=".repeat(86));
        System.out.println(estado + ": " + cantHeroesEstado);
        System.out.println("=".repeat(86));
        // Imprimimos la lista de héroes encontrados
        imprimirSuperHeroes(heroesEncontrados);
        System.out.println("=".repeat(86));

        // Limpiamos el arreglo para reutilizarlo con el siguiente estado
        heroesEncontrados.clear();

        // Estado Recuperación
        estado = "Recuperación";
        // Obtenemos la lista de posiciones encontradas con el estado indicado
        posHeroesEncontrados = buscadorHeroes(superHeroes, estado, 3);
        // Obtenemos la cantidad que hay
        cantHeroesEstado = posHeroesEncontrados.size();
        // Recorremos la lista añadiendo cada héroe en su posición para añadirlo en héroes encontrados
        for (int posHeroe : posHeroesEncontrados) {
            heroesEncontrados.add(superHeroes.get(posHeroe));
        }

        System.out.println("=".repeat(86));
        System.out.println(estado + ": " + cantHeroesEstado);
        System.out.println("=".repeat(86));
        // Imprimimos la lista de héroes encontrados
        imprimirSuperHeroes(heroesEncontrados);
        System.out.println("=".repeat(86));
    }
}
