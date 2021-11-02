
package aluguel.repository;

import aluguel.dao.Conexao;
import aluguel.model.Os;
import aluguel.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class OsRepository {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     public boolean save(Os os){
        conexao = Conexao.conector();
        String sql = "INSERT INTO tb_os(id, tipo, situacao, equipamento, defeito, servico, tecnico, valor, data, id_cliente) VALUES (null,?,?,?,?,?,?,?,null,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, os.getTipo());
            pst.setString(2, os.getSituacao());
            pst.setString(3, os.getEquipamento());
            pst.setString(4, os.getDefeito());
            pst.setString(5, os.getServico());
            pst.setString(6, os.getTecnico());
            pst.setString(7, os.getValor());
            pst.setLong(8, os.getIdCliente());
            int i = pst.executeUpdate();
            if(i > 0){
                return true;
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e.getMessage());
           
        }
         return false;
    }
    
}
