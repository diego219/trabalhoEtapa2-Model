package br.edu.ifsul.modelo;

import java.util.Calendar;
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
public class OrdemServicoTestRemove {

    EntityManagerFactory emf;
    EntityManager em;

    public OrdemServicoTestRemove() {
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
            OrdemServico os = em.find(OrdemServico.class, 2);
            em.getTransaction().begin();
            em.remove(os);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
