package com.Marco.Morales.service;

import java.util.List;

import com.Marco.Morales.model.Empleado;



public interface IntEmpleadosService {
	public List<Empleado> obtnerTodos();
	public void guardar(Empleado empleado);
	public void eliminar(Integer idEmpleado);
	public Empleado buscarPorId(Integer idEmpleado);
	//otros metodo o metotos
	public Integer totalEmpleados();
	public Integer totalDeVenta();

}
