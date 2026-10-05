package cr.uned.programacionintermedia.nelsonacuna.proyecto1;

/**
 * Representa un Superhéroe dentro del proyecto
 *
 * @author Nelson Andrés Acuña Cambronero
 * @version 1.0
 */
public class Superheroe {

    private static int contadorId;
    private String idHeroe;
    private String nombreHeroico;
    private String nombreReal;
    private String poder;
    private String experiencia;
    private String estado;
    private double salarioMensual;

    /**
     * Crea un Superhéroe dentro del sistema
     *
     * @param nombreHeroico Nombre del Superhéroe: debe tener mínimo 3
     * caracteres y debe ser ingresado por usuario.
     *
     * @param nombreReal Nombre real del superhéroe: debe tener mínimo 3
     * caracteres y debe ser ingresado por usuario.
     *
     * @param poder Selección única del usuario entre las siguientes opciones
     * (Fuerza, Velocidad, Tecnología, Magia o Telepatía)
     *
     * @param experiencia Selección única del usuario entre las siguientes
     * opciones (Novato, Intermedio o Élite)
     *
     * @param estado Selección única del usuario entre las siguientes opciones
     * (Disponible, En misión o Recuperación)
     *
     * @param salarioMensual Salario mensual del Superhéroe, dato ingresado por
     * el usuario
     *
     */
    public Superheroe(String nombreHeroico, String nombreReal, String poder, String experiencia, String estado, double salarioMensual) {
        this.nombreHeroico = nombreHeroico;
        this.nombreReal = nombreReal;
        this.poder = poder;
        this.experiencia = experiencia;
        this.estado = estado;
        this.salarioMensual = salarioMensual;
    }
    
    public Superheroe() {
        this.nombreHeroico = "";
        this.nombreReal = "";
        this.poder = "";
        this.experiencia = "";
        this.estado = "";
        this.salarioMensual = 0.0;
    }
    

    public String getIdHeroe() {
        return idHeroe;
    }

    public void setIdHeroe(String idHeroe) {
        this.idHeroe = idHeroe;
    }

    public String getNombreHeroico() {
        return nombreHeroico;
    }

    public void setNombreHeroico(String nombreHeroico) {

        // Validación del nombre heroico
        if (nombreHeroico.length() >= 3) {
            this.nombreHeroico = nombreHeroico;
        } else {
            System.out.println("Nombre inválido, el nombre heroico debe tener al menos 3 caracteres");
        }
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        // Validación del nombre real
        if (nombreReal.length() >= 3) {
            this.nombreReal = nombreReal;
        } else {
            System.out.println("Nombre inválido, el nombre real debe tener al menos 3 caracteres");
        }
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    //Métodos adicionales
    public void generadorIdHeroe() {

        //Creamos el nuevo id para el superhéroe
        contadorId++; // Aumentamos el contador de héroes

        if (String.valueOf(contadorId).length() >= 2) {
            this.idHeroe = "HER-" + contadorId;
        } else {
            this.idHeroe = "HER-0" + contadorId;
        }
    }
}
