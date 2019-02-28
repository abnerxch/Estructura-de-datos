import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Empresa {
    LinkedList empleadosPorNss;
    LinkedListInter itrEmpleadosPorNss;

    public void RepartosAsignados(){

        Queue quAsignados = new LinkedList();


        RepartoAsignado a1 = new RepartoAsignado("0123", "Empresa1");
        RepartoAsignado a2 = new RepartoAsignado ("0789", "Empresa1");
        RepartoAsignado a3 = new RepartoAsignado ("0456", "Empresa2");
        RepartoAsignado a4 = new RepartoAsignado ("9871", "Empresa3");
        quAsignados.add(a1);
        quAsignados.add(a2);
        quAsignados.add(a3);
        quAsignados.add(a4);
        //return quAsignados;
    }

    public void actualizar(Queue quAsignados){
        Scanner read = new Scanner(System.in);
        Empleado emp;
        while (!quAsignados.isEmpty()) {
            RepartoAsignado reparto = (RepartoAsignado) quAsignados.remove();
            emp = new Empleado(reparto.getNssEmpleado()); //Línea con error
            if (itrEmpleadosPorNss.find(emp)) {  //Línea con error
                emp = (Empleado) itrEmpleadosPorNss.getCurrent(); //Línea con error
            }
            else {
                String nombre = read.next();
                emp.setNombre(nombre);
                insertarOrdenado(emp);
            }
            emp.incrementarDiaTrabajado();
        }
    }


    public void insertarOrdenado(Empleado nuevo){
        Empleado empAnt = null;
        boolean enc = false;
        Empleado emp = null;
        //buscar posición en la lista por nss sin que se repita
        itrEmpleadosPorNss.goFirst();
        while ( (itrEmpleadosPorNss.isOnList()) && !enc ) { //Línea con error
            emp = (Empleado) itrEmpleadosPorNss.getCurrent(); //Línea con error
            if (emp.getNss().compareTo(nuevo.getNss())<0) {
                empAnt = emp;
                itrEmpleadosPorNss.advance();
            }
            else enc = true;
        }
        if ((enc) && (emp.getNss().compareTo(nuevo.getNss())==0))
            System.out.println("Error,el empleado con el NSS "+ emp.getNss()+ " ya esta");
        else {

            if (empAnt == null)
                itrEmpleadosPorNss.insertAtStart(Empleado nuevo); //Línea con error
            else {
                itrEmpleadosPorNss.find(Empleado empAnt); //Línea con error
                itrEmpleadosPorNss.insert(nuevo); //Línea con error
            }
        }
    }

}
