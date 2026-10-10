package cr.uned.programacionintermedia.nelsonacuna.proyecto1;

/**
 * Representa un Equipo de Rescate dentro del proyecto
 *
 * @author Nelson Andrés Acuña Cambronero
 * @version 1.0
 */

import java.util.ArrayList;

/**
 * Representa un Equipo de rescate dentro del proyecto
 * 
 * @author Nelson Andrés Acuña Cambronero
 * @version 1.0
 */

public class EquipoRescate {    

//Atributos de la clase
    private static int contadorId;
    private String idEquipo;
    private String nombreEquipo;
    private String tipoEmergencia;
    private String nivelAmenaza;
    private String ciudadAsignada;
    private String usoTecnologiaEspecial;
    private ArrayList<Superheroe> listaSuperheroes;
    private double costoOperativo;
    
    /**
     * Crea un equipo de rescate dentro del sistema
     * 
     * @param nombreEquipo Nombre que recibirá el equipo de superhéroes, debe
     * tener al menos 3 caracteres
     * 
     * @param tipoEmergencia Tipo de emergencia para el cual el equipo es 
     * creado, dato que elige el usuario de las siguientes opciones: Desastres
     * naturales, Invasión alienígena, Amenaza nuclear o Villano de alto riesgo
     * 
     * @param nivelAmenaza Nivel de amenaza con el que 
     * @param ciudadAsignada 
     * @param usoTecnologiaEspecial 
     * @param listaSuperheroes 
     * @param costoOperativo 
     */

    
    
    public EquipoRescate(String nombreEquipo, String tipoEmergencia, String nivelAmenaza, 
            String ciudadAsignada, String usoTecnologiaEspecial, ArrayList<Superheroe> listaSuperheroes, 
            double costoOperativo) {
        this.nombreEquipo = nombreEquipo;
        this.tipoEmergencia = tipoEmergencia;
        this.nivelAmenaza = nivelAmenaza;
        this.ciudadAsignada = ciudadAsignada;
        this.usoTecnologiaEspecial = usoTecnologiaEspecial;
        this.listaSuperheroes = listaSuperheroes;
        this.costoOperativo = costoOperativo;
    }

    public EquipoRescate() {
        this.nombreEquipo = "";
        this.tipoEmergencia = "";
        this.nivelAmenaza = "";
        this.ciudadAsignada = "";
        this.usoTecnologiaEspecial = "";
        this.listaSuperheroes = new ArrayList<>();
        this.costoOperativo = 0.0;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        EquipoRescate.contadorId = contadorId;
    }
    
    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getTipoEmergencia() {
        return tipoEmergencia;
    }

    public void setTipoEmergencia(String tipoEmergencia) {
        this.tipoEmergencia = tipoEmergencia;
    }

    public String getNivelAmenaza() {
        return nivelAmenaza;
    }

    public void setNivelAmenaza(String nivelAmenaza) {
        this.nivelAmenaza = nivelAmenaza;
    }

    public String getCiudadAsignada() {
        return ciudadAsignada;
    }

    public void setCiudadAsignada(String ciudadAsignada) {
        this.ciudadAsignada = ciudadAsignada;
    }

    public String getUsoTecnologiaEspecial() {
        return usoTecnologiaEspecial;
    }

    public void setUsoTecnologiaEspecial(String usoTecnologiaEspecial) {
        this.usoTecnologiaEspecial = usoTecnologiaEspecial;
    }

    public ArrayList<Superheroe> getListaSuperheroes() {
        return listaSuperheroes;
    }

    public void setListaSuperheroes(ArrayList<Superheroe> listaSuperheroes) {
        this.listaSuperheroes = listaSuperheroes;
    }
    
    public double getCostoOperativo() {
        return costoOperativo;
    }

    public void setCostoOperativo(double costoOperativo) {
        this.costoOperativo = costoOperativo;
    }
    
    // Métodos adicionales
    
    /**
     * Genera el ID del equipo
     * 
     * Genera automáticamente el ID del equipo cada vez que sea
     * necesario, en casos de agregar nuevos equipos de rescate
     */
    public void generadorIdEquipo() {
        // Aumentamos el contador de héroes
        contadorId++;

        if (String.valueOf(contadorId).length() >= 2) {
            // En caso de que la numeración del contadorId sea mayor a 9
            this.idEquipo = "EQU-" + contadorId;
        } else {
            // En caso de que la numeración del contadorId sea menor a 9
            this.idEquipo = "EQU-0" + contadorId;
        }
    }
    
    /**
     * Calcula el costo operativo del equipo de rescate
     * 
     * En base a la lista de superhéroes asignada, toma los 
     * salarios mensuales de estos, sumandolos obteniendo de 
     * esta manera el costo operativo del equipo.
     */
    public void calcularCostoOperativo(){
        for(Superheroe superHeroe : listaSuperheroes){
            costoOperativo += superHeroe.getSalarioMensual();
        }
    }
    
}
