package com.nes.test;

import com.nes.entidades.DetallePedido;
import com.nes.entidades.Genero;
import com.nes.entidades.Libro;
import com.nes.entidades.Pedido;
import com.nes.entidades.Stock;
import com.nes.entidades.Tienda;
import com.nes.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PruebaRegistro {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WebAppPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
  
    //Registrar un género
    Genero genero = new Genero();
    genero.setNombre("Drama");
    entityManager.persist(genero);
    
    //Registrar un Libro
    Libro libro = new Libro();
    libro.setNombre("Hamlet");
    libro.setPrecio(22.99f);
    libro.setGenero(genero);
    entityManager.persist(libro);
    
    //Registrar un Usuario
    Usuario usuario = new Usuario();
    usuario.setNombre("Fulano de Tal");
    usuario.setUsuario("usuario");
    usuario.setClave("1234");
    usuario.setAdministrador(false);
    entityManager.persist(usuario);
    
    //Registrar una tienda
    Tienda tienda = new Tienda();
    tienda.setNombre("Tienda #1");
    tienda.setDireccion("Av. Siempreviva 742");
    entityManager.persist(tienda);
    
    //Registrar Stock
    Stock stock = new Stock();
    stock.setLibro(libro);
    stock.setTienda(tienda);
    stock.setCantidad(12);
    entityManager.persist(stock);
    
    //Registrar un Pedido
    Pedido pedido = new Pedido();
    pedido.setTienda(tienda);
    pedido.setUsuario(usuario);
    entityManager.persist(pedido);
    
    //Registrar DetallePedido
    DetallePedido detallePedido = new DetallePedido();
    detallePedido.setPedido(pedido);
    detallePedido.setLibro(libro);
    detallePedido.setPrecioUnitario(libro.getPrecio());
    detallePedido.setCantidad(1);
    entityManager.persist(detallePedido);
    
    entityManager.getTransaction().commit();
    entityManager.close();
    entityManagerFactory.close();
  }
  
}
