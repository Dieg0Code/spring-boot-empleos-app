package dieg0code.empleos.controller;

import dieg0code.empleos.model.Vacante;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = getVacantes();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }

    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) {
        Vacante vacante = new Vacante();
        vacante.setNombre("Ingeniero de comunicaciones");
        vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
        vacante.setFecha(new Date());
        vacante.setSalario(9700.0);
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping("/listado")
    public String mostrarListado(Model model) {
        List<String> lista = new LinkedList<String>();
        lista.add("Ingeniero de Software");
        lista.add("Auxiliar de Contabilidad");
        lista.add("Vendedor");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);

        return "listado";
    }

    @GetMapping("/")
    public String mostrarHome(Model model) {
        /*
        model.addAttribute("mensaje", "Bienvenido a Empleos App");
        model.addAttribute("fecha", new Date());
        */
        String nombre = "Auxiliar de Contabilidad";
        Date fechaPub = new Date();
        double salario = 9000.0;
        boolean vigente = true;

        model.addAttribute("nombre", nombre);
        model.addAttribute("fecha", fechaPub);
        model.addAttribute("salario", salario);
        model.addAttribute("vigente", vigente);

        return "home";
    }

    /**
     * Método que regresa una lista de objetos de tipo Vacante
     *
     * @return List<Vacante>
     */
    private List<Vacante> getVacantes() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Vacante> lista = new LinkedList<Vacante>();

        try {
            // Creamos la oferta de trabajo 1
            Vacante vacante1 = new Vacante();
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Solicitamos Ing. Civil para diseñar puente peatonal");
            vacante1.setFecha(sdf.parse("05-03-2022"));
            vacante1.setSalario(8500.0);
            vacante1.setDestacado(1);
            vacante1.setImagen("empresa1.png");

            // Oferta de trabajo 2
            Vacante vacante2 = new Vacante();
            vacante2.setId(2);
            vacante2.setNombre("Contador Publico");
            vacante2.setDescripcion("Empresa importante solicita contador con 5 años de experiencia");
            vacante2.setFecha(sdf.parse("05-03-2022"));
            vacante2.setSalario(12000.0);
            vacante2.setDestacado(0);
            vacante2.setImagen("empresa2.png");

            // Oferta de trabajo 3
            Vacante vacante3 = new Vacante();
            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Eléctrico");
            vacante3.setDescripcion("Empresa internacional solicita Ingeniero mecánico para mantenimiento de la instalación eléctrica");
            vacante3.setFecha(sdf.parse("05-03-2022"));
            vacante3.setSalario(10500.0);
            vacante3.setDestacado(0);


            // Oferta de trabajo 4
            Vacante vacante4 = new Vacante();
            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico");
            vacante4.setDescripcion("Solicitamos Diseña Gráfico para diseñar publicidad de la empresa");
            vacante4.setFecha(sdf.parse("05-03-2022"));
            vacante4.setSalario(7500.0);
            vacante4.setDestacado(1);
            vacante4.setImagen("empresa3.png");

            // Agregamos las ofertas a la lista
            lista.add(vacante1);
            lista.add(vacante2);
            lista.add(vacante3);
            lista.add(vacante4);

        } catch (ParseException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lista;
    }

}
