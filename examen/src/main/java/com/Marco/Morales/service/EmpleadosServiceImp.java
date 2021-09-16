package com.Marco.Morales.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Marco.Morales.model.Empleado;



@Service
public class EmpleadosServiceImp implements IntEmpleadosService {
	private List<Empleado> lista;
	private List<Empleado> total;
	public EmpleadosServiceImp() {
		
		lista = new LinkedList<Empleado>();
		total = new LinkedList<Empleado>();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		try {
			Empleado a1 = new Empleado();
			a1.setId(5);
			a1.setNombre("software");
			a1.setGenero('M');
			a1.setEmail("armando@gmail.com");
			a1.setSalario(23000.00);
			a1.setFoto("");
			a1.setFechaNacimiento(LocalDate.now());
			
			Empleado a2 = new Empleado();
			a2.setId(4);
			a2.setNombre("computadoras");
			a2.setGenero('M');
			a2.setEmail("julian@gmail.com");
			a2.setSalario(19000.00);
			a2.setFoto("");
			a2.setFechaNacimiento(LocalDate.now());
			
			Empleado a3 = new Empleado();
			a3.setId(3);
			a3.setNombre("telefonos");
			a3.setGenero('F');
			a3.setEmail("natalia@gmail.com");
			a3.setSalario(26000.00);
			a3.setFoto("");
			a3.setFechaNacimiento(LocalDate.now());
			
			Empleado a4 = new Empleado();
			a4.setId(2);
			a4.setNombre("tablets");
			a4.setGenero('F');
			a4.setEmail("alejandra@gmail.com");
			a4.setSalario(30000.00);
			a4.setFoto("");
			a4.setFechaNacimiento(LocalDate.now());
			
			Empleado a5 = new Empleado();
			a5.setId(1);
			a5.setNombre("airpots");
			a5.setGenero('M');
			a5.setEmail("luis@gmail.com");
			a5.setSalario(14000.00);
			a5.setFoto("");
			a5.setFechaNacimiento(LocalDate.now());
			
			
			Empleado a6 = new Empleado();
			
			
			a6.setSalario(14000.00+30000.00+23000.00+19000.00+26000.00);
			
			
			total.add(a6);
			lista.add(a1);
			lista.add(a2);
			lista.add(a3);
			lista.add(a4);
			lista.add(a5);
			total.add(a6);
			
		}catch(DateTimeParseException ex) {
					System.out.println("Error: " + 	ex.getMessage());
		}
	}
	@Override
	public List<Empleado> obtnerTodos() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public void guardar(Empleado empleado) {
		// TODO Auto-generated method stub
		lista.add(empleado);

	}

	@Override
	public void eliminar(Integer idEmpleado) {
		// TODO Auto-generated method stub
		lista.remove(buscarPorId(idEmpleado));

	}

	@Override
	public Empleado buscarPorId(Integer idEmpleado) {
		// TODO Auto-generated method stub
		for(Empleado a : lista) {
			if ( a.getId() == idEmpleado) {
				return a;
			}
		}
		return null;
	}
	

	@Override
	public Integer totalEmpleados() {
		// TODO Auto-generated method stub
		
		return lista.size();
	}
	@Override
	public Integer totalDeVenta() {
		// TODO Auto-generated method stub
		
		return total.size();
	}


}
