package teste2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    // Informações da sua conexão
    private static final String URL = "jdbc:postgresql://localhost:5432/java-testes";
    private static final String USUARIO = "-------";
    private static final String SENHA = "-------";

    public static void main(String[] args) {
        // Dados do novo produto
    	int idProduto = 2;
        String nmProduto = "Mouse";
        double preco = 200.00;

        // A instrução SQL para inserir
        String sql = "INSERT INTO produto (idProduto , nmProdut0, preco) VALUES (?, ?, ?)";

        try (
            // 1. Estabelece a conexão com o banco de dados
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            // 2. Cria o PreparedStatement com a instrução SQL
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            // 3. Define os valores para os placeholders (?)
            // O primeiro parâmetro (1) refere-se ao primeiro '?'
        	stmt.setInt(1, idProduto);
        	
            stmt.setString(2, nmProduto);
            // O segundo parâmetro (2) refere-se ao segundo '?'
            stmt.setDouble(3, preco);

            // 4. Executa a instrução SQL
            // executeUpdate() é usado para INSERT, UPDATE e DELETE
            int linhasAfetadas = stmt.executeUpdate();

            System.out.println(linhasAfetadas + " linha(s) inserida(s) com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir dados: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
