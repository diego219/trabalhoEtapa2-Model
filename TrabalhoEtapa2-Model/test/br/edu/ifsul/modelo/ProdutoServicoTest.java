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
public class ProdutoServicoTest {

    EntityManagerFactory emf;
    EntityManager em;

    public ProdutoServicoTest() {
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
            ProdutoServico ps = new ProdutoServico();
            ps.setData_cadastro(Calendar.getInstance());
            ps.setDescricao("Produto Teste");
            ps.setUnidade("UN");
            ps.setValor_custo(12.00);
            ps.setValor_unitario(30.00);
            em.getTransaction().begin();
            em.persist(ps);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
