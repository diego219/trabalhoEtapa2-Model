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
public class ItemOrdemServicoTest {

    EntityManagerFactory emf;
    EntityManager em;

    public ItemOrdemServicoTest() {
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
            ItemOrdemServico ios = new ItemOrdemServico();
            ios.setOrdem_servico(em.find(OrdemServico.class, 2));
            ios.setProduto_servico(em.find(ProdutoServico.class, 1));
            ios.setAcrescimo(0.00);
            ios.setDesconto(0.00);
            ios.setUnitario(25.00);
            ios.setQuantidade(1);
            em.getTransaction().begin();
            em.persist(ios);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
