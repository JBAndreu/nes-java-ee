package com.nes.controladores;

import com.nes.entidades.Genero;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
public class ControladorGenero {
  private Genero genero = new Genero();
  
  public void registrarGenero() {
    //Obtener una instancia de EntityManagerFactory
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("WebAppPU");
    //Obtener una instancia de EntityManager
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    //Como vamos a persistir datos, abrimos una transacción
    entityManager.getTransaction().begin();
    //Persistimos la información
    entityManager.persist(genero);
    //Ejecutamos la transacción
    entityManager.getTransaction().commit();
    //Cerramos la instancia de EntityManager
    entityManager.close();
    //Cerramos la instancia de EntityManagerFactory
    entityManagerFactory.close();
  }
  
  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }
}
