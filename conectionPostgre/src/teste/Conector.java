package teste;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {

	static final String URL = "jdbc:postgresql://localhost:5432/java-testes"; //incica o caminho do banco de dados
	static final String USER = "------"; // aqui vai o nome usuario que vc quer acessar
	static final String PASS = "------"; // aqui a senha do seu banco

	public static Connection criarConexao() throws ClassNotFoundException, SQLException{
	Class.forName("org.postgresql.Driver");
	Connection conecta = DriverManager.getConnection(URL, USER, PASS);
	if (conecta != null){
	System.out.print("Conexão efetuada com sucesso...");
	return conecta;
	}
	return null;
	}
	
}

