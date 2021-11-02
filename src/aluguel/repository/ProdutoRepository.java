
package aluguel.repository;

import aluguel.dao.Conexao;
import aluguel.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ProdutoRepository {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     public boolean save(Produto produto){
        conexao = Conexao.conector();
        String sql = "INSERT INTO tb_produto(id, nome, descricao, preco, qtd) VALUES (null,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setString(3, produto.getPreco().toString());
            pst.setString(4, produto.getQtd().toString());
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
     
      public Produto findById(Produto produto) {
        conexao = Conexao.conector();
        String sql = "select * from tb_produto where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setLong(1, produto.getId());
            rs = pst.executeQuery();
            if(rs.next()){
                Produto u = new Produto();
                u.setDescricao(rs.getString(3));
                u.setId(rs.getLong(1));
                u.setNome(rs.getString(2));
                u.setPreco(rs.getDouble(4));
                u.setQtd(rs.getInt(5));
                return u;
            }
            conexao.close();
        } catch (Exception e) {
        }
        return null;
    }
      
        public boolean delete(Produto produto) {
        conexao = Conexao.conector();
        String sql = "DELETE FROM tb_produto WHERE id = ?";
        try {
            pst = conexao.prepareStatement(sql);       
            pst.setLong(1, produto.getId());
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
        
         public boolean update(Produto produto) {
        conexao = Conexao.conector();
        String sql = "UPDATE tb_produto SET nome = ?, descricao = ?, preco = ?, qtd = ? WHERE id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, produto.getNome());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPreco());
            pst.setInt(4, produto.getQtd());
            pst.setLong(5, produto.getId());
            
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
