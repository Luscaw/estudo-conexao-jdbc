package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o código: ");
		int codigo = sc.nextInt();

		Connection conexao = FabricaConexao.getConexao();
		String sql = "DELETE FROM pessoas WHERE codigo >= ?";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);

		int cont = stmt.executeUpdate();

		if (cont > 0) {
			System.out.println("Pessoa excluída com sucesso!");
		} else {
			System.out.println("Sem alterações!");
		}

		System.out.println("Linhas afestadas: " + cont);

		sc.close();
		conexao.close();
	}
}
