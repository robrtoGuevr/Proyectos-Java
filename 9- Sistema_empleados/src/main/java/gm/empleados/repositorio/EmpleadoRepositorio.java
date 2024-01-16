package gm.empleados.repositorio;

import gm.empleados.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
