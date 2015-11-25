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
public class OrdemServicoTest {

    EntityManagerFactory emf;
    EntityManager em;

    public OrdemServicoTest() {
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
            OrdemServico os = new OrdemServico();
            os.setCliente(em.find(Cliente.class, 1));
            os.setData_emissao(Calendar.getInstance());
            os.setData_entrega(Calendar.getInstance());
            os.setData_prevista(Calendar.getInstance());
            os.setObservacoes("Teste O.S.");
            os.setValor_total(0.00);
            em.getTransaction().begin();
            em.persist(os);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
