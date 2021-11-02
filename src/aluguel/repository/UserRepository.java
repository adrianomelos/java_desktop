package aluguel.repository;

import aluguel.dao.Conexao;
import aluguel.model.User;
import aluguel.view.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserRepository {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public boolean save(User user){
        conexao = Conexao.conector();
        String sql = "INSERT INTO tb_user(id, nome, email, password, profile) VALUES (null,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getProfile());
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
     
    public boolean login(User user){
    
        conexao = Conexao.conector();
        String sql = "select * from tb_user where email = ? and password = ?";
        try {
            
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user.getEmail());
            pst.setString(2, user.getPassword());
            
            rs = pst.executeQuery();
            if (rs.next()){
                Principal principal = new Principal();
                String perfil = rs.getString(5);
               
                if(perfil.equals("ADMIN")){
                   
                    Principal.menuCadUsuario.setEnabled(true);
                    Principal.menuRelatorio.setEnabled(true);
                }
                Principal.lblUsuario.setText(rs.getString(2));
                principal.setVisible(true);
               
            }else{
                return false;
            }
             conexao.close();
             return true;
        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "" + e.getMessage());
          return false;
        }
       
    }

    public User findById(User user) {
        conexao = Conexao.conector();
        String sql = "select * from tb_user where id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setLong(1, user.getId());
            rs = pst.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setEmail(rs.getString(3));
                u.setName(rs.getString(2));
                u.setPassword(rs.getString(4));
                u.setProfile(rs.getString(5));
                return u;
            }
            conexao.close();
        } catch (Exception e) {
        }
        return null;
    }

    public boolean update(User user) {
        conexao = Conexao.conector();
        String sql = "UPDATE tb_user SET nome= ?, email= ?, password = ?, profile = ? WHERE id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getProfile());
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

    public boolean delete(User user) {
        conexao = Conexao.conector();
        String sql = "DELETE FROM tb_user WHERE id = ?";
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
    
}
