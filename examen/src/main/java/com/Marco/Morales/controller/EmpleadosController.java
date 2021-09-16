package com.Marco.Morales.controller;

import java.beans.PropertyEditorSupport;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Marco.Morales.model.Empleado;
import com.Marco.Morales.service.IntEmpleadosService;




@Controller
@RequestMapping("/empleado")
public class EmpleadosController {
	@Autowired
	private IntEmpleadosService empleadosService;
	
	
	@GetMapping("/buscar")
	public String buscar(@RequestParam("id") int idEmpleado,Model model) {
		Empleado empleado = empleadosService.buscarPorId(idEmpleado);
		model.addAttribute("empleado", empleado);
		return "empleado/formEmpleado";
	}
	
	@PostMapping("/guardar")
	public String guardar(Empleado empleado,RedirectAttributes atributo) {
		//System.out.println(autor);
		if ( empleado.getId() == null) {
			empleado.setId(empleadosService.totalEmpleados()+1);
			empleadosService.guardar(empleado);
		}else {
			System.out.println("Registro Modificado");
			System.out.println(empleado);
		}
		atributo.addFlashAttribute("msg", "El autor se registro con exito!");
		return "redirect:/empleado/index";
	}
	
	@GetMapping("/crear")
	public String crear(Empleado empleado) {
		return "empleado/formEmpleado";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int idEmpleado,
			RedirectAttributes atributo) {
		empleadosService.eliminar(idEmpleado);
		atributo.addFlashAttribute("msg", "Empleado eliminado");
		return "redirect:/empleado/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Empleado> empleado = empleadosService.obtnerTodos();
		model.addAttribute("empleado", empleado);
		model.addAttribute("total", empleadosService.totalEmpleados());
		return "empleado/listaEmpleados";
	}
	
	@InitBinder
    protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) throws IllegalArgumentException{
          setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }

        @Override
        public String getAsText() throws IllegalArgumentException {
          return DateTimeFormatter.ofPattern("dd-MM-yyyy").format((LocalDate) getValue());
        }
      });
    }

}
