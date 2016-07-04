/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testexml;

import com.br.lp3.model.entities.Aluno;
import java.io.File;
import java.util.List;

/**
 *
 * @author Everson
 */
public class TesteXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        XMLManager xmlm = new XMLManager(new File("alunos.xml"));
        List<Aluno> lista = xmlm.parseAlunos();
        for(Aluno aluno : lista){
            System.out.println(aluno);
        }
    }
    
}
