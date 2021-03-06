//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M3LPBD

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Guilherme Sabino de Freitas Gouveia
package projetofinal_institutofederal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ListaProjetosJFrame extends javax.swing.JFrame {

    /**
     * Creates new form ListaProjetosJFrame
     */
    public ListaProjetosJFrame() {
        initComponents();
        //Carrega a lista 
        carregaLista();
    }
    
    private void carregaLista() {
        try {
            //instancia do DB
            Connection conn = ConexaoDB.getInstance().getConnection();
            //Comando SQL SELECT
            String cmdSelect = "select * from disciplinas";
            //Comando executeQuery tem retorno. Objeti ResultSet
            ResultSet result = conn.createStatement().executeQuery(cmdSelect);
            //Percorre pelo result
            while(result.next()){
                //"Parse" Data Base Key values
                int idDB        = result.getInt("idDisciplina");
                String nomeDB   = result.getString("nome");
                int numeroDB    = result.getInt("carga");
                String cursoDB  = result.getString("cursoPertence");
                int vagasDB     = result.getInt("vagas");
                String periodoDB= result.getString("cursoPertence");
                
                
                //Inicia o vector, (para cada linha)
                Vector vector = new Vector();
                vector.add(idDB);
                vector.add(nomeDB);
                vector.add(numeroDB);
                vector.add(cursoDB);
                vector.add(vagasDB);
                vector.add(periodoDB);
                
                //Cast para DefaultComboBoxModel e insere o elemento da pesquisa
                //A tabela pede um vetor para preencher a linha (row)
                ((DefaultTableModel)jTable1.getModel()).addRow(vector);
                //Retorno do dB
                System.out.println(vector);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo_Software = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Titulo_Software.setFont(new java.awt.Font("Trajan Pro", 1, 24)); // NOI18N
        Titulo_Software.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo_Software.setText("Lista de Disciplinas");
        Titulo_Software.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTable1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título do Curso", "Carga Horária", "Curso ", "Número de Vagas", "Período"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButtonSair.setFont(new java.awt.Font("Trajan Pro", 0, 11)); // NOI18N
        jButtonSair.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(Titulo_Software)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonSair)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo_Software)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaProjetosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProjetosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProjetosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProjetosJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProjetosJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo_Software;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
