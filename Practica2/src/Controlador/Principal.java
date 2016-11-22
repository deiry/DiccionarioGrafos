
package Controlador;


import Modelo.CargaArchivo;
import Vista.FormularioPrincipal;
import Vista.VistaPrincipal;


public class Principal {
    
    public static void main(String[] args) {
        
     
     /*FormularioPrincipal view=new  FormularioPrincipal();
      
       CargaArchivo model=new  CargaArchivo();
       controlador controller=new controlador(view, model);
       controller.cargarAtributos();
       controller.mostrar();*/
     
        VistaPrincipal view = new VistaPrincipal();
        CargaArchivo model = new CargaArchivo();
        Controller controller = new Controller(view, model);
        controller.initAtributos();
        controller.mostrar();
       
       
       
 
        
     
               
    }
    
}
