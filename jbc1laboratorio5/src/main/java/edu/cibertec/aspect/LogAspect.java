package edu.cibertec.aspect;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.weaver.ast.Instanceof;
import org.springframework.stereotype.Component;

import edu.cibertec.entity.ProductoEntity;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* edu.cibertec.service.*.registrarProducto(..))")
    public void pointcuts(){}

    @Before("pointcuts()") //Se ejecuta antes de la ejecucion del metodo segun patron del pointcut
    public void logBefore(JoinPoint jp){
        //Si quiero ver los argumentos
        //" con los argumentos "+ ((ProductoEntity) jp.getArgs()[0]).toString()+
        if( jp.getArgs().length>0){
            System.out.println("Iniciando el método  " + jp.getSignature().getName()+" del servicio "+ jp.getSignature().getDeclaringTypeName().split("\\.")[3]+" con los argumentos "+ java.util.Arrays.toString(jp.getArgs())+" a las "+ LocalDateTime.now());
  
        }else{
            System.out.println("Iniciando el método  " + jp.getSignature().getName()+" del servicio "+ jp.getSignature().getDeclaringTypeName().split("\\.")[3]+" sin argumentos a las "+ LocalDateTime.now());
        }
    }

    @After("pointcuts()")//Se ejecuta despues de la ejecucion del metodo segun patron del pointcut
    public void logAfter(JoinPoint jp){
        System.out.println("Finalizando el método  " + jp.getSignature().getName()+" del servicio "+ jp.getSignature().getDeclaringTypeName().split("\\.")[3]+" a las "+ LocalDateTime.now());
    }

    @AfterReturning(pointcut = "pointcuts()", returning = "resultado")//Se ejecuta despues de la ejecucion del metodo segun patron del pointcut y e devuelve el resultado si no existe error
    public void logAfter(JoinPoint jp, Object resultado) {
        System.out.println("El método retornó");
        if (resultado instanceof List<?>) {
            List<?> lista = (List<?>) resultado;
            for (Object obj : lista) {
                if (obj instanceof ProductoEntity producto) {
                    System.out.println("Producto: " + producto);
                }
            }
        } else if (resultado instanceof ProductoEntity producto) {
            System.out.println("Producto: " + producto);
        }

        System.out.println(
            "Finalizando el método " +
            jp.getSignature().getName() +
            " del servicio " +
            jp.getSignature().getDeclaringTypeName() +
            " a las " +
            LocalDateTime.now()
        );
    }

    @Around("pointcuts()")//Se ejecuta antes y despues de la ejecucion del metodo segun patron del pointcut (Puede controlar la ejecucion del metodo)
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Auditoria Around Before " + pjp.getSignature().getName());
        Object obj = null;
        //if(pjp.getSignature().getName().equals("imprimir")){
            obj = pjp.proceed();
        //}        
        System.out.println("Auditoria Around After " + pjp.getSignature().getName());
        return obj;
    }

    @AfterThrowing(pointcut = "pointcuts()", throwing = "error")//Se ejecuta despues de la ejecucion del metodo segun patron del pointcut si existe una excepcion
    public void logAfterThrowing(JoinPoint jp, Throwable error) {
        System.out.println("Exception in " + jp.getSignature().getName() + " with message: " + error.getMessage());
    }
}
