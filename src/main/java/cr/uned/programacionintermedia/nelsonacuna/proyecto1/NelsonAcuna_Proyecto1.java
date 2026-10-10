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
                //Eliminamos el buffer residual
                scannerEntrada.nextLine();
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
     * Solicita datos de un superhéroe
     *
     * Solicita al usuario datos de un superhéro, ya se para agregar o
     * actualizar un superhéroe
     *
     * @param entrada Entrada de datos
     * @param superHeroe objeto de la clase SuperHeroe
     */
    public static void solicitarDatosSuperHeroe(Scanner entrada, Superheroe superHeroe) {
        // Variable
        String nombHeroico;
        String nombReal;
        String poderPrincipal;
        String nivel;
        String estado;
        double salarioMensual;

        // Se solicita el nombre heroico
        do {
            System.out.print("Nombre heroico: ");
            nombHeroico = entrada.nextLine();
            // Validamos que el nombre tenga más de 3 caracteres
            if (nombHeroico.length() >= 3) {
                break;
            } else {
                System.out.println("\nNombre inválido, el nombre heroico debe tener al menos 3 caracteres\n");
            }
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setNombreHeroico(nombHeroico);

        // Se solicita el nombre real
        do {
            System.out.print("Nombre real: ");
            nombReal = entrada.nextLine();
            // Validamos que el nombre tenga más de 3 caracteres
            if (nombReal.length() >= 3) {
                break;
            } else {
                System.out.println("\nNombre inválido, el nombre real debe tener al menos 3 caracteres\n");
            }
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setNombreReal(nombReal);

        //Se solicita el poder principal
        do {
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
                    // Salimos del switch ya que valida la opción válida
                    break;
                default:
                    System.out.println("\n¡Poder inválido! Intentalo de nuevo\n");
                    // Repetimos el bucle do/while 
                    continue;
            }
            // Salimos del bucle una vez validada la opción elegida del usuario
            break;
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setPoder(poderPrincipal);

        // Se solicita el nivel de experiencia
        do {
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
                    // Salimos del switch ya que valida la opción válida
                    break;
                default:
                    System.out.println("\n¡Nivel inválido! Intentalo de nuevo.\n");
                    // Repetimos el bucle do/while 
                    continue;
            }
            // Salimos del bucle una vez validada la opción elegida del usuario            
            break;
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setExperiencia(nivel);

        // Se solicita el estado
        do {
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
                    // Salimos del switch ya que valida la opción válida
                    break;
                default:
                    System.out.println("\n¡Estado inválido! Intentalo de nuevo.\n");
                    // Repetimos el bucle do/while 
                    continue;
            }
            // Salimos del bucle una vez validada la opción elegida del usuario            
            break;
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setEstado(estado);

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
            }
        } while (true);

        // Asignamos el dato al superhéroe
        superHeroe.setSalarioMensual(salarioMensual);

        // Limpiamos el buffer residual
        entrada.nextLine();
    }

    /**
     * Buscador por ID de superhéroes
     *
     * Busca un superhéroe por su ID, digitado por el usuario
     *
     * @param entrada Entrada de datos por teclado
     * @param superHeroes lista de superhéroes actual
     * @param idSuperHeroe id suministrado por el usuario
     * @param encontrado notifica al usuario si encontró o no el ID
     *
     * @return retorna la posición del superhéroe dentro de la lista
     */
    public static int buscadorIdHeroes(Scanner entrada, ArrayList<Superheroe> superHeroes, String idSuperHeroe) {
        do {
            System.out.print("Ingrese el ID del Superhéroe: ");
            idSuperHeroe = entrada.nextLine();

            // Visualizamos que el usuario no haya ingresado dato en blanco
            if (!idSuperHeroe.isEmpty()) {

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
            } else {
                System.out.println("Debes ingresar un ID válido para continuar");
            }
        } while (true);
    }

    //Métodos del módulo de Gestión de Superhéroes
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

            //Muesta el nuevo ID del superhéroe a registrar
            System.out.println("ID generado: " + superHeroe.getIdHeroe());

            // Solicitamos la información del superhéroe
            solicitarDatosSuperHeroe(entrada, superHeroe);

            // Agregamos el superheroe a la lista de superheroes
            superHeroes.add(superHeroe);

            // Notificamos al usuario que se registró correctamente
            System.out.println("\n¡Superhéroe registrado correctamente!");

            String pregunta = "Deseas agregar otro superhéroe";
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
     * @param entrada
     * @param superHeroes
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

            String idSuperHeroe = "";
            int posIndexSuperHeroe = 0;
            // Creamos un nuevo superhéroe
            Superheroe superHeroe = new Superheroe();
            // Encabezado
            System.out.println("\n" + "-".repeat(10) + " ACTUALIZAR DATOS DE UN SUPERHÉROE " + "-".repeat(10) + "\n");

            // Buscamos al superhéroe que deseamos actualizar
            posIndexSuperHeroe = buscadorIdHeroes(entrada, superHeroes, idSuperHeroe);

            // Validamos que se encontró el ID del superhéro buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el superhéroe solicitado! Intentelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información correspondiente del superhéroe solicitado
            superHeroe = superHeroes.get(posIndexSuperHeroe);

            // Solicitamos los datos actualizados del superhéroe
            solicitarDatosSuperHeroe(entrada, superHeroe);

            // Actualizamos el superhéroe
            superHeroes.set(posIndexSuperHeroe, superHeroe);

            String pregunta = "Deseas actualizar a otro superhéroe";

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
            String idSuperHeroe = "";
            String estado = "";
            int posIndexSuperHeroe;

            // Creamos un nuevo superhéroe
            Superheroe superHeroe = new Superheroe();

            System.out.println("\n" + "-".repeat(11) + " CAMBIO DE ESTADO DE SUPERHÉROE " + "-".repeat(12) + "\n");

            // Busca el ID del héroe dentro de la lista de héroes actual
            posIndexSuperHeroe = buscadorIdHeroes(entrada, superHeroes, idSuperHeroe);

            // Validamos que se encontró el ID del superhéro buscado
            if (posIndexSuperHeroe == -1) {
                System.out.println("\n¡No se encontró el superhéroe solicitado! Intentelo de nuevo\n");
                // Repetimos el proceso de buscar un ID
                continue;
            }

            // Se agrega la información correspondiente del superhéroe solicitado
            superHeroe = superHeroes.get(posIndexSuperHeroe);

            //Se muestra al usuario el estado actual del superhéroe
            System.out.println("\nEl superhéroe " + superHeroe.getNombreHeroico() + " cuenta con el estado actual: " + superHeroe.getEstado() + "\n");

            // Se solicita el nuevo estado del superhéroe
            do {
                System.out.print("\nIngrese el nuevo estado (Disponible, En misión, Recuperación): ");
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
                        // Salimos del switch ya que valida la opción válida
                        break;
                    // Opción inválida
                    default:
                        System.out.println("\n¡Estado inválido! Intentalo de nuevo.\n");
                        // Repetimos el bucle do/while 
                        continue;
                }
                // Salimos del bucle una vez validada la opción elegida del usuario            
                break;
            } while (true);

            // Asignamos el nuevo estado al superHéroe correspondiente
            superHeroe.setEstado(estado);

            System.out.println("\nEstado actualizado correctamente!\n");

            String pregunta = "Deseas actualizar el estado a otro superhéroe";

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
     * @param entrada
     * @param superHeroes
     */
    public static void eliminarSuperHeroe(Scanner entrada, ArrayList<Superheroe> superHeroes) {
        // Variables
        String idSuperHeroe;
        String pregunta;
        boolean encontrado;
        int posSuperHeroe = 0;

        // Se repite mientras el usuario no regrese al menú principal o que no exista supehéroes
        do {
            //Validamos que la lista de superhéroes no esté vacia
            if (superHeroes.isEmpty()) {
                System.out.println("\n¡Lista vacía! Agrega un superhéroe para continuar\n");
                //Regresamos al menú
                return;
            }

            // Se inicializa en falso dentro del bucle do/while
            encontrado = false;
            // Eliminamos el buffer de entrada
            //entrada.nextLine();
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
                    System.out.println("\nEl superhéroe con el ID: " + idSuperHeroe + " no se encuentra registrado\n");
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
                        + " | " + superHeroes.get(posSuperHeroe).getNombreHeroico();

                // Validamos respuesta de usuario
                if (respuestaSiNo(entrada, pregunta)) {
                    // Se elimina el superhéroe
                    superHeroes.remove(posSuperHeroe);
                    System.out.println("\nEl superhéroe fue eliminado correctamente\n");

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

        //Validamos que la lista de superhéroes no esté vacia
        if (superHeroes.isEmpty()) {
            System.out.println("\n¡Lista vacía! Agrega un superhéroe para continuar\n");
            //Regresamos al menú
            return;
        }

        System.out.println("\n" + "-".repeat(31) + " LISTADO DE SUPERHÉROES " + "-".repeat(31) + "\n");

        // Encabezado de la lista de superHéroes
        System.out.printf("%-6s   %-14s   %-17s   %-10s   %-12s   %-9s   \n", "ID", "Nombre Heroico", "Poder", "Nivel", "Estado", "Salario");
        System.out.println("=".repeat(86));

        // Recorremos la lista de superheroes para mostrarlo al usuario
        for (Superheroe superHeroe : superHeroes) {
            // Imprime cada superhéroe de la lista con el formato ya indicado
            System.out.printf("%-6s   %-14s  %-17s   %-10s   %-12s   %-9s  \n", superHeroe.getIdHeroe(), superHeroe.getNombreHeroico(),
                    superHeroe.getPoder(), superHeroe.getExperiencia(), superHeroe.getEstado(), formatoMonetario(superHeroe.getSalarioMensual()));
            System.out.println("-".repeat(86));
        }

        //Mensaje que indica la cantidad de superhéroes registados a la actualidad 
        System.out.print("\nTotal de superhéroes registrados: " + superHeroes.size() + "\n");
    }
}
