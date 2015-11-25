package br.edu.ifsul.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author diego
 */
public class ReferenciaTest {

    EntityManagerFactory emf;
    EntityManager em;

    public ReferenciaTest() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoEtapa2-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean excecao = false;
        try {
            Referencia ref = new Referencia();
            ref.setCliente_comum(em.find(ClienteComum.class, 1)); //Alterar para uma ID que exista para que possa ser testado
            ref.setNome("Junior");
            ref.setTelefone("99999999");
            ref.setCelular("8828828");
            ref.setParentesco("Primo");
            em.getTransaction().begin();
            em.persist(ref);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
