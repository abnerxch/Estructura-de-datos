public class RepartoAsignado {
    public String nssEmpleado;
    public String empresa;

    public RepartoAsignado(String nssEmpleado, String empresa){
        this.nssEmpleado = nssEmpleado;
        this.empresa = empresa;
    }

    public void setNssEmpleado(String nssEmpleado){
        this.nssEmpleado = nssEmpleado;
    }

    public String getNssEmpleado(){
        return nssEmpleado;
    }

    public void setEmpresa(String empresa){
        this.empresa = empresa;
    }

    public String getEmpresa(){
        return empresa;
    }
}
