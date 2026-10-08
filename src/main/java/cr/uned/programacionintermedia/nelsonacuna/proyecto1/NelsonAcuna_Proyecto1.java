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
 * @author Nelson Andrés Acuña Cambronero
 * @version 1.0
 */
public class NelsonAcuna_Proyecto1 {

    public static void main(String[] args) {

        // Variables
        int opcMenu = 0;
        boolean continuar;

        // Creamos un ArrayList de SuperHeroes para almacenarlos
        ArrayList<Superheroe> superHeroes = new ArrayList<>();

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
                        //Variables
                        String nombHeroico = "";
                        String nombReal = "";
                        String poderPrincipal = "";
                        String nivel = "";
                        String estado = "";
                        double salarioMensual = 0.0;
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
                                // Solicitamos los datos del nuevo superhéroe
                                agregarSuperHeroe(scannerEntrada, nombHeroico, nombReal, poderPrincipal, nivel, estado, salarioMensual, continuar, superHeroes);
                                break;
                            case 2: // Actualizar datos de un superhéroe
                                break;
                            case 3: // Cambiar estado de un superhéroe
                                cambiarEstadoSuperHeroe(scannerEntrada, superHeroes, continuar);
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
                                mostrarSuperHeroes(superHeroes);
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

        System.out.println("=".repeat(55));
        System.out.println("||" + " ".repeat(14) + "ACADEMIA DE SUPERHÉROES              ||");
        System.out.println("=".repeat(55));

        System.out.println("Sistema de Gestión de Superhéroes y Equipos de Rescate\n");

        System.out.println("=".repeat(19) + " MENÚ PRINCIPAL " + "=".repeat(20));
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

    //Métodos del módulo de Gestión de Superhéroes
    /**
     * Agrega un nuevo superhéroe
     *
     * Este métodos solicita la información necesaria para agregar un nuevo
     * superhéroe y la guarda en el ArrayList superHeroes
     *
     * @param entrada
     * @param nombHeroico
     * @param nombReal
     * @param poderPrincipal
     * @param nivel
     * @param estado
     * @param salarioMensual
     * @param continuar
     * @param superHeroes
     */
    public static void agregarSuperHeroe(Scanner entrada, String nombHeroico, String nombReal, String poderPrincipal,
            String nivel, String estado, double salarioMensual, boolean continuar, ArrayList<Superheroe> superHeroes) {
        // Limpiamos el buffer residual
        entrada.nextLine();
        // Se crea un nuevo héroe
        Superheroe superHeroe = new Superheroe();
        // Se genera el IdHeroe 
        superHeroe.generadorIdHeroe();
        System.out.println("\n" + "-".repeat(17) + " AGREGAR SUPERHÉROE " + "-".repeat(18) + "\n");
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
        // Asignamos el dato al superhéroe
        superHeroe.setNombreHeroico(nombHeroico);

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
        // Asignamos el dato al superhéroe
        superHeroe.setNombreReal(nombReal);

        //Se solicita el poder principal
        do {
            continuar = true;
            System.out.print("Poder principal (Fuerza, Velocidad, Tecnología, Magia, Control elemental): ");
            // Recibimos el poder elegido por el usuario
            poderPrincipal = entrada.nextLine();
            // Se establece en minúscula el poder digitado por el usuario para validar
            poderPrincipal = poderPrincipal.toLowerCase();
            // Validamos que el poder ingresado por el usuario sea válido
            switch (poderPrincipal) {
                // Opciones válidas
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
        } while (continuar);
        // Asignamos el dato al superhéroe
        superHeroe.setPoder(poderPrincipal);

        // Se solicita el nivel de experiencia
        do {
            continuar = true;
            System.out.print("Nivel (Novato, Intermedio, Élite): ");
            // Recibimos el nivel elegido por el usuario
            nivel = entrada.nextLine();
            // Se establece en minúscula el poder digitado por el usuario para validar
            nivel = nivel.toLowerCase();
            // Validamos que el nivel elegido por el usuario sea válido
            switch (nivel) {
                // Opciones válidas
                case "novato":
                case "intermedio":
                case "élite":
                    continuar = false;
                    break;
                default:
                    System.out.println("¡Nivel inválido! Intentalo de nuevo.\nNiveles a elegir: Novato, Intermedio, Élite");
                    break;
            }
        } while (continuar);
        // Asignamos el dato al superhéroe
        superHeroe.setExperiencia(nivel);

        // Se solicita el estado
        do {
            continuar = true;
            System.out.print("Estado (Disponible, En misión, Recuperación): ");
            // Recibimos el estado elegido por el usuario
            estado = entrada.nextLine();
            // Se establece en minúscula el estado digitado por el usuario para validar
            estado = estado.toLowerCase();
            // Validamos que el estado ingresado por el usuario sea válido
            switch (estado) {
                // Opciones válidas
                case "disponible":
                case "en misión":
                case "recuperación":
                    continuar = false;
                    break;
                default:
                    System.out.println("¡Estado inválido! Intentalo de nuevo.\nEstados a elegir: Disponible, En misión, Recuperación");
                    break;
            }
        } while (continuar);
        // Asignamos el dato al superhéroe
        superHeroe.setEstado(estado);

        // Se solicita el salario mensual
        do {
            continuar = true;
            System.out.print("Salario mensual ($): ");
            // Try-Catch para validar que el dato ingresado sea el esperado
            try {
                // Recibimos el salario mensual que establece el usuario
                salarioMensual = entrada.nextDouble();
                if (salarioMensual > 0.0) {
                    continuar = false;
                } else {
                    System.out.println("¡Salario Inválido! Ingrese un monto mayor a cero");
                }
            } catch (Exception e) {
                System.out.println("¡Salario Inválido! Intente de nuevo");
            }
        } while (continuar);
        // Asignamos el dato al superhéroe
        superHeroe.setSalarioMensual(salarioMensual);

        // Agregamos el superheroe a la lista de superheroes
        superHeroes.add(superHeroe);
        // Notificamos al usuario que se registró correctamente
        System.out.println("¡Superhéroe registrado correctamente!");
    }

    /**
     * Atualiza datos de un superhéroe
     *
     * Su funcionalidad es la actualización de datos de los superhéroes para
     * mantener actualizados estos o por si algún error de digitación
     *
     * @param entrada
     * @param superHeroes
     * @param continuar
     */
    public static void actualizarDatosSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes, boolean continuar) {

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
     * @param continuar
     */
    public static void cambiarEstadoSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes, boolean continuar) {
        if (!(superHeroes.isEmpty())) {
            // Variables
            String idSuperHeroe;
            String estado;

            // Limpiarmos buffer residual
            entrada.nextLine();

            System.out.println("\n" + "-".repeat(11) + " CAMBIO DE ESTADO DE SUPERHÉROE " + "-".repeat(12) + "\n");
            // Solicitamos el dato necesario para cambiar el estado del superhéroe
            System.out.print("Ingrese el ID del Superhéroe: ");
            // Recibimos el ID del superhéro a cambiar de estado
            idSuperHeroe = entrada.nextLine();

            // Busca el ID del héroe dentro de la lista de héroes actual
            for (Superheroe superheroe : superHeroes) {
                // Compara el ID ingresado por el ID de la lista
                if (superheroe.getIdHeroe().equals(idSuperHeroe)) {
                    System.out.println("\nEl superhéroe " + superheroe.getNombreHeroico() + " cuenta con el estado actual: " + superheroe.getEstado() + "\n");
                    // Se solicita el nuevo estado del superhéroe
                    do {
                        continuar = true;
                        System.out.print("\nIngrese el nuevo estado (Disponible, En misión, Recuperación)");
                        // Recibimos el estado elegido por el usuario
                        estado = entrada.nextLine();
                        // Se establece en minúscula el estado digitado por el usuario para validar
                        estado = estado.toLowerCase();
                        // Validamos que el estado ingresado por el usuario sea válido
                        switch (estado) {
                            // Opciones válidas
                            case "disponible":
                            case "en misión":
                            case "recuperación":
                                continuar = false;
                                break;
                            // Opción inválida
                            default:
                                System.out.println("¡Estado inválido! Intentalo de nuevo.\nEstados a elegir: Disponible, En misión, Recuperación");
                                break;
                        }
                    } while (continuar);

                    // Asignamos el nuevo estado al superHéroe correspondiente
                    superheroe.setEstado(estado);
                    System.out.println("¡Cambio de estado realizado correctamente!\n" + superheroe.getIdHeroe() + "  " + superheroe.getNombreHeroico() + ": " + superheroe.getEstado());
                    break;
                }// Fin del if comparativo
            }// Fin del bucle for
        } else {
            System.out.println("Primero debe agregar algún Superhéroe");
        }
    }

    /**
     * Elimina un superhéroe del sistema
     *
     * Su funcionalidad es eliminar a un superhéroe, el cual es buscado por su
     * ID y luego eliminado de la lista
     *
     * @param entrada
     * @param superHeroes
     */
    public static void eliminarSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {
        // Variables
        String idSuperHeroe;
        String pregunta;
        boolean encontrado;
        int posSuperHeroe = 0;

        //Validamos que ya haya héroes registrados
        do {
            // Validamos que haya héroes registrados
            if (superHeroes.isEmpty()) {
                System.out.println("¡Debes agregar superhéroes primero para continuar!");
                return;
            }
            encontrado = false;
            // Eliminamos el buffer de entrada
            entrada.nextLine();
            // Solicitamos el Id del héroe a eliminar
            System.out.println("\n" + "-".repeat(17) + " ELIMINAR SUPERHÉROE " + "-".repeat(17) + "\n");
            System.out.print("Ingrese el ID del Superhéroe: ");
            idSuperHeroe = entrada.nextLine();

            // Visualizamos que el usuario no haya ingresado dato en blanco
            if (!idSuperHeroe.isEmpty()) {
                // Buscamos que el ID exista dentro
                for (Superheroe superHeroe : superHeroes) {

                    // Comparamos el ID enviado del usuario con el de las lista hasta encontrárlo
                    if (superHeroe.getIdHeroe().equals(idSuperHeroe)) {
                        // Obtenemos la poscición del superhéroe a eliminar dentro del ArrayList
                        posSuperHeroe = superHeroes.indexOf(superHeroe);
                        // Héroe encontrado
                        encontrado = true;
                        // Salimos del bucle
                        break;

                    }
                }

                // Si no se encontrara el superhéro dentro de la lista, notificamos al usuario
                if (!encontrado) {
                    System.out.println("El superhéroe con el ID: " + idSuperHeroe + " no se encuentra registrado");
                    pregunta = "Desea regresar al menú principal";
                    // Validamos la respuesta del usuario
                    if (respuestaSiNo(entrada, pregunta)) {
                        return;
                    } else {
                        //Repetimos eliminar superhéroe
                        continue;
                    }
                }

                // Reafirmamos la descisión de eliminar al superhéroe solicitado o velvemos a preguntar
                pregunta = "Deseas eliminar a: " + superHeroes.get(posSuperHeroe).getIdHeroe()
                        + " | " + superHeroes.get(posSuperHeroe).getNombreHeroico() + "(S/N)";

                // Validamos respuesta de usuario
                if (respuestaSiNo(entrada, pregunta)) {
                    // Se elimina el superhéroe
                    superHeroes.remove(posSuperHeroe);
                    System.out.println("El superhéroe fue eliminado correctamente");

                    //Preguntamos si desea eliminar a otro superhéroe
                    pregunta = "Deseas regresar al menú principal";
                    if (respuestaSiNo(entrada, pregunta)) {
                        // Regresamos al menú principal
                        return;
                    }
                }

            } else {
                System.out.println("Debes ingresar un ID válido para continuar");
            }
        } while (true);
    }

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
        System.out.println("\n" + "-".repeat(26) + " LISTADO DE SUPERHÉROES " + "-".repeat(27) + "\n");
        // Se valida que la lista no esté vacía<
        if (!superHeroes.isEmpty()) {
            // Encabezado de la lista de superHéroes
            System.out.printf("%-8s  %-15s  %-10s  %-10s  %-12s  %-10s  \n", "ID", "Nombre Heroico", "Poder", "Nivel", "Estado", "Salario");
            System.out.println("=".repeat(77));
            // Recorremos la lista de superheroes para mostrarlo al usuario
            for (Superheroe superHeroe : superHeroes) {
                // Imprime cada superhéroe de la lista con el formato ya indicado
                System.out.printf("%-8s  %-15s  %-10s  %-10s  %-12s  %-10s  \n", superHeroe.getIdHeroe(), superHeroe.getNombreHeroico(),
                        superHeroe.getPoder(), superHeroe.getExperiencia(), superHeroe.getEstado(), formatoMonetario(superHeroe.getSalarioMensual()));
                System.out.println("-".repeat(77));
            }
            //Mensaje que indica la cantidad de superhéroes registados a la actualidad 
            System.out.print("\nTotal de superhéroes registrados: " + superHeroes.size());
        } else {
            System.out.println("¡Lista vacía! Agrega un superhéroe para continuar");
        }
    }
}
