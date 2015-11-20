package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Diego Oliveira
 */
public class TesteInserirCidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("TrabalhoEtapa2-ModelPU");
            em = emf.createEntityManager();
            Cidade c = new Cidade();
            c.setNome("Passo Fundo");
            c.setUf("RS");
            c.setCodigo_estado_ibge("43");
            c.setCodigo_municipio_ibge("4314100");
            
            // criando o objeto para validar as anotações da bean validation API
            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Cidade>> erros = validador.validate(c);
            if (erros.size() > 0) {
                for (ConstraintViolation<Cidade> erro : erros){
                    System.out.println("Erro: "+erro.getMessage());
                }
            } else {
                em.getTransaction().begin();
                em.persist(c);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }

}
