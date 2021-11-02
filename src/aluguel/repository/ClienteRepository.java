package aluguel.repository;

import aluguel.dao.Conexao;
import aluguel.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ClienteRepository {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     public boolean save(Client client){
        conexao = Conexao.conector();
        String sql = "INSERT INTO tb_client(id, nome, email, endereco, telefone) VALUES (null,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, client.getNome());
            pst.setString(2, client.getEmail());
            pst.setString(3, client.getEndereco());
            pst.setString(4, client.getTelefone());
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

    public boolean delete(Client user) {
        conexao = Conexao.conector();
        String sql = "DELETE FROM tb_client WHERE id = ?";
        try {
            pst = conexao.prepareStatement(sql);       
            pst.setLong(1, user.getId());
              int i = pst.executeUpdate();
            if(i > 0){
                return true;
            }
            conexao.close();
        } catch (Exception e) {
            return false;
        }
        return true;
   
    }

    public boolean update(Client user) {
        conexao = Conexao.conector();
        String sql = "UPDATE tb_client SET nome= ?, email= ?, endereco = ?, telefone = ? WHERE id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user.getNome());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getEndereco());
            pst.setString(4, user.getTelefone());
            pst.setLong(5, user.getId());
            
            int i = pst.executeUpdate();
            if(i > 0){
                return true;
            }
            conexao.close();
        } catch (Exception e) {
        }
        return false;
    }
    
}
