package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import dao.Dao;
import model.Aluno;

public class Service {
    public static void InserirAluno(Aluno a) throws SQLException {  
    	String query = "select max(id) as id from tb_aluno";
    	int id = 0;
    	ResultSet rs = Dao.SelectCommand(query);
    	while(rs.next()){
        	id = rs.getInt("id");
        }
        	id ++;
    	
    	
        query = String.format("insert into tb_aluno (id,nome,ra,curso) values(%s,'%s','%s','%s')",id, a.getNome(), a.getRa(), a.getCurso());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void AtualizarAluno(Aluno a) {
        String query = String.format("update tb_aluno set nome = '%s', ra = '%s', curso = '%s' where id = %s", a.getNome(), a.getRa(), a.getCurso(),a.getId());
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExcluirAluno(int id) {
        String query = String.format("delete from tb_aluno where id = %s", id);
        Dao.InsertUpdateDeleteCommand(query);
    }
   
    public static void ExibirAlunos() {
        String query= "select * from tb_aluno order by id";
       
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
                System.out.println("ID: "+rs.getString("id"));
                System.out.println("NOME: "+rs.getString("nome"));
                System.out.println("RA: "+rs.getString("ra"));
                System.out.println("CURSO: "+rs.getString("curso") + "\n");
            }
        }
        catch (Exception e){
                System.out.println(e);
        }  
    }
   
    public static void ExibirAluno(int id) {
        String query = String.format("select * from tb_usuario where id = %s", id);
        ResultSet rs = Dao.SelectCommand(query);
       
        try {
            while(rs.next()){
            	 System.out.println(rs.getString("id"));
                 System.out.println(rs.getString("nome"));
                 System.out.println(rs.getString("ra"));
                 System.out.println(rs.getString("curso"));
            }
        }
        catch (Exception e){
                System.out.println(e);
        }
    }
 
}
