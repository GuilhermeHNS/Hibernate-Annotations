/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.annotations;
import Util.HibernateUtil;
import Model.Professor;
import Model.Disciplina;
import org.hibernate.Session;
/**
 *
 * @author guilh
 */
public class HibernateAnnotations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Professor prf = new Professor("Guilherme", "guilherme@gmail.com", 1000);
        Disciplina disc = new Disciplina("Disciplina de matemática", "60hrs");
        Professor prf02 = new Professor("Raphael", "raphael@gmail.com", 1200);
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
            session.save(prf);
            session.save(disc);
            session.save(prf02);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
        
        //ATUALIZANDO DADOS
        
        prf.setNome("Guilherme Novo");
        disc.setDescricao("Disciplina de calculos");
        
        session.beginTransaction();
            session.update(prf);
            session.update(disc);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
    
}
