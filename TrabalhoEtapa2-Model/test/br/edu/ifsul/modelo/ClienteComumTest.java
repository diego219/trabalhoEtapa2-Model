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
public class ClienteComumTest {

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteComumTest() {
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
            ClienteComum cc = new ClienteComum();
            cc.setCep("99999-999");
            cc.setCidade(em.find(Cidade.class, 1));
            cc.setCpf("009.060.710-46");
            cc.setEndereco("rua tal");
            cc.setAtivo(true);
            cc.setData_cadastro(Calendar.getInstance());
            cc.setNascimento(Calendar.getInstance());
            cc.setSpc(true);
            cc.setNome("Diego");
            cc.setTelefone("99999999");
            em.getTransaction().begin();
            em.persist(cc);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
