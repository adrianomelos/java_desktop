package aluguel.view;

import aluguel.dao.Conexao;
import aluguel.model.Produto;
import aluguel.repository.ProdutoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class TelaProdutos extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public TelaProdutos() {
        initComponents();
        pesquisarProdutos();
        btnEditar.setEnabled(false);
        btnCadastrarProdtuto1.setEnabled(false);
    }
    
     private void pesquisarProdutos(){
        conexao = Conexao.conector();
        String sql = "select * from tb_produto";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            tabelaProdutos.setModel(DbUtils.resultSetToTableModel(rs));
            //tabelaProdutos.removeColumn(tabelaProdutos.getColumnModel().getColumn(3));
          
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    
     private void limparCampos() {
        txtDescricaoProduto.setText(null);
        txtNomeProduto.setText(null);
        txtPrecoProduto.setText(null);
        txtQtdProduto.setText(null);
        txtCodigo.setText(null);
        btnEditar.setEnabled(false);
        btnCadastrarProdtuto1.setEnabled(false);
        
    }
     
      private boolean verficarCamposVazios() {
        
        String nome = txtNomeProduto.getText();
        String descricao = txtDescricaoProduto.getText();
        String preco = txtPrecoProduto.getText();
        String qtd = txtQtdProduto.getText();
        
        if(!nome.equals("")){
            if(!descricao.equals("")){
                if(!preco.equals("")){
                    if(!qtd.equals("")){
                        return true;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "O campo quantidade do produto não pode ser vazio");
                    return false;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "O campo preço não pode ser vazio");
                    return false;
                }
            }else{
                JOptionPane.showMessageDialog(null, "O campo descrição não pode ser vazio");
                return false;
            }         
        }else{
            JOptionPane.showMessageDialog(null, "O campo nome não pode ser vazio");
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        txtQtdProduto = new javax.swing.JTextField();
        txtDescricaoProduto = new javax.swing.JTextField();
        txtPrecoProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        btnCadastrarProdtuto = new javax.swing.JButton();
        btnCadastrarProdtuto1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCadastrarProdtuto3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPesquisarProduto = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Produtos");

        jLabel1.setText("Nome:");

        jLabel2.setText("Descrição:");

        jLabel3.setText("Qtd:");

        jLabel4.setText("Preço:");

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProdutos);

        btnCadastrarProdtuto.setText("Cadastrar");
        btnCadastrarProdtuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdtutoActionPerformed(evt);
            }
        });

        btnCadastrarProdtuto1.setText("Remover");
        btnCadastrarProdtuto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdtuto1ActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnCadastrarProdtuto3.setText("Cancelar");
        btnCadastrarProdtuto3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdtuto3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Código");

        txtCodigo.setEditable(false);

        jLabel6.setText("Pesquisar produto");

        txtPesquisarProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarProdutoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrecoProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(txtQtdProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(txtNomeProduto))
                            .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(182, 182, 182))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrarProdtuto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrarProdtuto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrarProdtuto3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarProdtuto)
                    .addComponent(btnCadastrarProdtuto1)
                    .addComponent(btnEditar)
                    .addComponent(btnCadastrarProdtuto3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarProdtutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdtutoActionPerformed
        
        ProdutoRepository repository = new ProdutoRepository();
         if(verficarCamposVazios()){
             Produto p = new Produto();
             p.setNome(txtNomeProduto.getText());
             p.setDescricao(txtDescricaoProduto.getText());
             p.setPreco(Double.parseDouble(txtPrecoProduto.getText()));
             p.setQtd(Integer.parseInt(txtQtdProduto.getText()));
             
              boolean a = repository.save(p);
                    if(a){
                         JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
                         limparCampos();
                         pesquisarProdutos();
                    }  
         }
        
    }//GEN-LAST:event_btnCadastrarProdtutoActionPerformed

    private void btnCadastrarProdtuto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdtuto1ActionPerformed
        // TODO add your handling code here:
        if(txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "É necessário selecionar um produto!");
        }
        else
        {
           ProdutoRepository repository = new ProdutoRepository();
           int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o produto?","Atenção",JOptionPane.YES_NO_OPTION);
            if(sair == JOptionPane.YES_OPTION){
                if(verficarCamposVazios()){
                    Produto produto = new Produto();
                    Long id = Long.valueOf(txtCodigo.getText());
                    produto.setId(id);
                    boolean a = repository.delete(produto);
                    if(a){
                        JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
                        limparCampos();
                        btnCadastrarProdtuto.setEnabled(true);
                        pesquisarProdutos();
                    } 
                };
            
            }
        }
    }//GEN-LAST:event_btnCadastrarProdtuto1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        ProdutoRepository repository = new ProdutoRepository();
        if(!txtCodigo.getText().equals("")){
          if(verficarCamposVazios()){
             Produto produto = new Produto();
                    Long id = Long.valueOf(txtCodigo.getText());
                    produto.setId(id);
                    produto.setNome(txtNomeProduto.getText());
                    produto.setDescricao(txtDescricaoProduto.getText());
                    produto.setNome(txtNomeProduto.getText());
                    produto.setPreco(Double.parseDouble(txtPrecoProduto.getText()));
                    produto.setQtd(Integer.parseInt(txtQtdProduto.getText()));
        
                    boolean a = repository.update(produto);
                    if(a){
                         JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
                         limparCampos();
                         txtCodigo.setText(null);
                         pesquisarProdutos();
                         btnCadastrarProdtuto.setEnabled(true);
                    }else{
                    JOptionPane.showMessageDialog(null, "Algo deu errado procure o administrador do sistema");
                    } 
                    
          }
        }else{
             JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCadastrarProdtuto3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdtuto3ActionPerformed
        // TODO add your handling code here:
        limparCampos();
        btnCadastrarProdtuto.setEnabled(true);
    }//GEN-LAST:event_btnCadastrarProdtuto3ActionPerformed

    private void tabelaProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutosMouseClicked
        // TODO add your handling code here:
        pegarLinhaSelecionada();
        btnEditar.setEnabled(true);
        btnCadastrarProdtuto1.setEnabled(true);
    }//GEN-LAST:event_tabelaProdutosMouseClicked

    private void txtPesquisarProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarProdutoKeyReleased
        // TODO add your handling code here:
        pesquisarProdutoPorNome();
    }//GEN-LAST:event_txtPesquisarProdutoKeyReleased

    private void pesquisarProdutoPorNome(){
        conexao = Conexao.conector();
        String sql = "select * from tb_produto where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesquisarProduto.getText() + "%");
            rs = pst.executeQuery();
            tabelaProdutos.setModel(DbUtils.resultSetToTableModel(rs));
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
     public void pegarLinhaSelecionada(){
         
        btnCadastrarProdtuto.setEnabled(false);
        
        int linha = tabelaProdutos.getSelectedRow();
        String id = tabelaProdutos.getModel().getValueAt(linha, 0).toString();
        ProdutoRepository repository = new ProdutoRepository();
        
              Produto produto = new Produto();
              produto.setId(Long.parseLong(id));
              Produto b = repository.findById(produto);
              
        txtDescricaoProduto.setText(b.getDescricao());
        txtNomeProduto.setText(b.getNome());
        txtPrecoProduto.setText(b.getPreco().toString());
        txtQtdProduto.setText(b.getQtd().toString());
        txtCodigo.setText(b.getId().toString());
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarProdtuto;
    private javax.swing.JButton btnCadastrarProdtuto1;
    private javax.swing.JButton btnCadastrarProdtuto3;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricaoProduto;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPesquisarProduto;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtQtdProduto;
    // End of variables declaration//GEN-END:variables
}
