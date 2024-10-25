package Sesion07.src.Actividades.Actividad06;

public class Alumno extends Persona {
    private Fecha fechaIngreso;

    public Alumno(String nombre, int edad, Fecha fechaIngreso) {
        super(nombre, edad);
        this.fechaIngreso = fechaIngreso;
    }

    public Fecha getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fecha de Ingreso: " + fechaIngreso;
    }
}
