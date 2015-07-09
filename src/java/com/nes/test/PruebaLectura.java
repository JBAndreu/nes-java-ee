package com.nes.test;

import com.nes.entidades.DetallePedido;
import com.nes.entidades.Genero;
import com.nes.entidades.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PruebaLectura {
  
  public static void main(String[] args) {
    //Obtener una instancia de EntityManagerFactory
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WebAppPU");
    //Obtener una instancia de EntityManager
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    //Obtener una instancia de Query
    Query query = entityManager.createQuery("SELECT p FROM Pedido p where p.id = 1");
    //Instruir a la instancia de Query que ejecute la consulta
    Pedido pedido = (Pedido) query.getSingleResult();
    //Procesar los datos devueltos
    System.out.println("Información de Pedido: ");
    System.out.println("ID: " + pedido.getId());
    System.out.println("Tienda: " + pedido.getTienda().getNombre());
    System.out.println("Usuario: " + pedido.getUsuario().getNombre());
    System.out.println("Detalle del pedido");
    for(DetallePedido detalle : pedido.getDetalle()){
      System.out.println("- Libro: " + detalle.getLibro().getNombre() +
        " Cantidad: " + detalle.getCantidad() +
        " Precio Unitario: " + detalle.getPrecioUnitario());
    }
    
    //Cerrar la instancia de EntityManager
    entityManager.clear();
    //Cerrar la instancia de EntityManagerFactory
    entityManagerFactory.close();
    
    //Obtener una instancia de EntityManagerFactory
    EntityManagerFactory entityManagerFactory1 = Persistence.createEntityManagerFactory("WebAppPU");
    //Obtener una instancia de EntityManager
    EntityManager entityManager1 = entityManagerFactory1.createEntityManager();
    
    //Obtener una instancia de Query
    Query query1 = entityManager1.createQuery("SELECT g FROM Genero g");
    //Instruir a la instancia de Query que ejecute la consulta
    List<Genero> listaGeneros = (List<Genero>) query1.getResultList();
    //Procesar los datos devueltos
    System.out.println();
    System.out.println("Lista de Generos");
    for(Genero g : listaGeneros) {
      System.out.println("ID: " + g.getId() + " Nombre: " + g.getNombre());
    }
    
    //Cerrar la instancia de EntityManager
    entityManager1.clear();
    //Cerrar la instancia de EntityManagerFactory
    entityManagerFactory1.close();
  }
  
}
