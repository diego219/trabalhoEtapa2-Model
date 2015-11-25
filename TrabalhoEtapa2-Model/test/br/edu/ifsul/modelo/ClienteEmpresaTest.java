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
public class ClienteEmpresaTest {

    EntityManagerFactory emf;
    EntityManager em;

    public ClienteEmpresaTest() {
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
            ClienteEmpresa ce = new ClienteEmpresa();
            ce.setCep("99999-999");
            ce.setCidade(em.find(Cidade.class, 1));
            ce.setEndereco("rua tal");
            ce.setAtivo(true);
            ce.setData_cadastro(Calendar.getInstance());
            ce.setNome("Empresa");
            ce.setTelefone("99999999");
            ce.setCelular_contato("99999999");
            ce.setCnpj("99999999");
            ce.setFundacao(Calendar.getInstance());
            ce.setRazao_social("Razao teste");
            ce.setNome_contato("Joãozinho");
            em.getTransaction().begin();
            em.persist(ce);
            em.getTransaction().commit();
        } catch (Exception e) {
            excecao = true;
            e.printStackTrace();
        }
        // Verificar resultado
        Assert.assertEquals(false, excecao);
    }

}
