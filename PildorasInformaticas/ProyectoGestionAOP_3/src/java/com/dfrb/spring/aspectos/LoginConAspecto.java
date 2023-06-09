package com.dfrb.spring.aspectos;

import com.dfrb.spring.aop.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author dfrb@ne
 */

@Aspect
@Component
@Order(2)
public class LoginConAspecto {
    // Ejecuta tareas antes y después de llamarse a un metodo específico.
    @Around("execution(* com.dfrb.spring.servicios.*.getServicio(..))")
    public Object ejecutarServicio(ProceedingJoinPoint point) throws Throwable {
        System.out.println("--- Comienzo de tareas antes de ejecutarse el método ---");
        long inicio = System.currentTimeMillis();
        Object resultado = point.proceed(); // point apunta al método destino, aqui es cuando se ejecuta.
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;
        System.out.println("El método tadó "+ duracion/1000 +" segundos.");
        System.out.println("--- Comienzo de tareas después de ejecutado el método ---");
        return resultado;
    }
    
    // Pointcut para el metodo getClientesList()
    @Pointcut("execution(* com.dfrb.spring.dao.ClienteDAOImplement.getClientesList(..))")
    public void paraGetClientesList() {
        
    }
    
    // Se realizan tareas de forma automatica despues de la ejecucion de metodo
    @AfterReturning(pointcut = "paraGetClientesList()", returning = "listaClientes")
    public void processAfterGetClientesList(List<Cliente> listaClientes) {
        List<Cliente> nuevaListaClientes = new ArrayList<>();
        for (Cliente c : listaClientes) {
            if ("V.I.P.".equalsIgnoreCase(c.getTipo())) {
                nuevaListaClientes.add(c);
            }
        }
        System.out.println("Clientes V.I.P:");
        for (Cliente c : nuevaListaClientes) {
            System.out.println(c.getNombre());
        }
    }
    
    @After("paraGetClientesList()")
    public void processAlwaysAfterGetClientesList(JoinPoint point) {
        System.out.println("Ejecutanto las tareas programadas siempre...");
    }
    
    // Se ejecutan tareas automaticas despues de lanzarse una Excepcion en el metodo getClientesList()
    @AfterThrowing(pointcut = "paraGetClientesList()", throwing = "Excepcion")
    public void processAfterExceptionGetClientesList(Throwable Excepcion) {
        System.out.println("Aqui se ejecutarían las tareas de forma automática después de lanzada la Excepción");
    }
    
    @Pointcut("execution(* com.dfrb.spring.dao.*.*(..))") // Aplicando un Pointcut expression (*) al inicio y al final del nombre del metodo
    public void paraClientes() {
    }
    
    @Before("paraClientes()")
    // Se crea un JoinPont para poder acceder a los parametros del metodo especificado en el Pointcut si el metodo contiene alguno
    public void antesInsertarCliente(JoinPoint point) {
        System.out.println("El usuario esta logueado correctamente");
        System.out.println("El perfil del usuario para Insertar Cliente es correcto");
        Object[] parametros = point.getArgs();
        for (Object p : parametros) {
            if (p instanceof Cliente) {
                Cliente cliente = (Cliente) p;
                System.out.println("El nombre del Cliente es: "+ cliente.getNombre());
                System.out.println("El tipo de Cliente es: "+ cliente.getTipo());
            }
        }
        
    }
}
