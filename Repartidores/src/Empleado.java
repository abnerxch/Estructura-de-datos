public class Empleado {

    private String nss;
    private String nombre;
    private int numDiasTrabajados;

    /*public Empleado(String nss){
        this.Empleado(nss, " ", 0);
    }*/

    public Empleado(String nss, String nombre, int numDiasTrabajados){
        this.nss = nss;
        this.nombre = nombre;
        this.numDiasTrabajados = numDiasTrabajados;
    }

    public void setNss(String nss){this.nss = nss;}

    public String getNss(){
        return nss;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre (){ return nombre;}

    public void setNumDiasTrabajados(int numDiasTrabajados){ this.numDiasTrabajados = numDiasTrabajados;}

    public int getNumDiasTrabajados(){ return numDiasTrabajados;}

    public boolean equals(Object obj){
        if ((obj != null) && (obj instanceof Empleado)) {
            Empleado emp = (Empleado) obj;
            return this.nss.equals(emp.nss);
        }
        else return false;
    }

    public void incrementarDiaTrabajado(){
        this.numDiasTrabajados++;
    }
}

