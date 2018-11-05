
package soft.java.interfaces;

import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import soft.java.conection.MySQLConnection;
import soft.java.login.Login;


public class Rate extends javax.swing.JFrame {

        int x, y;
  
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
        
        
    public Rate() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Tarifas");
        this.setLocationRelativeTo(null);
        ShowTable();
        bloquear();
    }

  // metodo para mostrar la tabla de la Base Datos 
    void ShowTable(){
        DefaultTableModel modelo = new DefaultTableModel();       
            modelo.addColumn("ID Tarifa");
            modelo.addColumn("Tipo vehículo");
            modelo.addColumn("Tipo Tarifa");
            modelo.addColumn("Valor");
                table_tarifa.setModel(modelo);         
            String sql = "SELECT * FROM tarifa";
            String datos[] = new String[4];
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    datos[0] = rs.getString(1); /*ID Tarifa*/
                    datos[1] = rs.getString(2); /*Tipo vehiculo*/
                    datos[2] = rs.getString(3); /*Tipo Tarifa*/
                    datos[3] = rs.getString(4); /*Valor*/
                        modelo.addRow(datos);
                }
                 table_tarifa.setModel(modelo);  
                
        } catch (SQLException ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
    
    void limpiar(){
        txt_vehiculo.setText("");
        txt_tarifa.setText("");
        txt_valor.setText("");
        txt_buscar.setText("");
    }
    
    void bloquear(){
        txt_vehiculo.setEditable(false);
        txt_tarifa.setEditable(false);
        txt_valor.setEditable(false);
            btn_enable.setEnabled(true);
            btn_disable.setEnabled(false);
            btn_add.setEnabled(false);
            btn_modified.setEnabled(false);
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
    }
    
    void desbloquear(){
        txt_vehiculo.setEditable(true);
        txt_tarifa.setEditable(true);
        txt_valor.setEditable(true);
            btn_enable.setEnabled(false);
            btn_disable.setEnabled(true);
            btn_add.setEnabled(true);
            btn_modified.setEnabled(true);
            btn_update.setEnabled(true);
            btn_delete.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        txt_tarifa = new javax.swing.JTextField();
        txt_vehiculo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_modified = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_enable = new javax.swing.JButton();
        btn_disable = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_tarifa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(34, 39, 42));
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 70));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 242));
        jLabel1.setText("Parking Express");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel1)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(49, 56, 62));

        jLabel19.setBackground(new java.awt.Color(49, 56, 62));
        jLabel19.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(240, 92, 44));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Volver");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(240, 92, 44), null));
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.setFocusCycleRoot(true);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel19.setPreferredSize(new java.awt.Dimension(189, 50));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Ubuntu", 0, 26)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 242));
        jLabel20.setText("Tarifas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel20)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(267, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(261, 261, 261)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 300, 630));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(3, 146, 222));
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soft/java/files/Minus Math _30px.png"))); // NOI18N
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(890, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 980, 70));

        jPanel3.setBackground(new java.awt.Color(240, 240, 242));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(49, 56, 62));
        jLabel3.setText("Tipo de tarifa");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 56, 62));
        jLabel4.setText("Valor");

        txt_valor.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_valor.setPreferredSize(new java.awt.Dimension(14, 35));
        txt_valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_valorActionPerformed(evt);
            }
        });
        txt_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valorKeyTyped(evt);
            }
        });

        txt_tarifa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_tarifa.setPreferredSize(new java.awt.Dimension(14, 35));
        txt_tarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarifaActionPerformed(evt);
            }
        });

        txt_vehiculo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_vehiculo.setPreferredSize(new java.awt.Dimension(14, 35));
        txt_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_vehiculoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 56, 62));
        jLabel7.setText("Tipo de vehículo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valor, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(txt_vehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tarifa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(520, 520, 520))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 980, 230));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_add.setBackground(new java.awt.Color(255, 255, 255));
        btn_add.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(49, 56, 62));
        btn_add.setText("Agregar");
        btn_add.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_add.setBorderPainted(false);
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.setFocusable(false);
        btn_add.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_add.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel5.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        btn_modified.setBackground(new java.awt.Color(255, 255, 255));
        btn_modified.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_modified.setForeground(new java.awt.Color(49, 56, 62));
        btn_modified.setText("Modificar");
        btn_modified.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_modified.setBorderPainted(false);
        btn_modified.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modified.setFocusable(false);
        btn_modified.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_modified.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_modified.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifiedActionPerformed(evt);
            }
        });
        jPanel5.add(btn_modified, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, -1, -1));

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_update.setForeground(new java.awt.Color(49, 56, 62));
        btn_update.setText("Actualizar");
        btn_update.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btn_update.setBorderPainted(false);
        btn_update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_update.setFocusable(false);
        btn_update.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_update.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel5.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        btn_delete.setBackground(new java.awt.Color(255, 255, 255));
        btn_delete.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(49, 56, 62));
        btn_delete.setText("Eliminar");
        btn_delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_delete.setBorderPainted(false);
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.setFocusable(false);
        btn_delete.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_delete.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel5.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, -1, -1));

        txt_buscar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txt_buscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_buscar.setEnabled(false);
        txt_buscar.setFocusable(false);
        jPanel5.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 50, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("ID");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 24, 26, -1));

        btn_enable.setBackground(new java.awt.Color(255, 255, 255));
        btn_enable.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_enable.setForeground(new java.awt.Color(49, 56, 62));
        btn_enable.setText("Habilitar");
        btn_enable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_enable.setBorderPainted(false);
        btn_enable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_enable.setFocusable(false);
        btn_enable.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_enable.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_enable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enableActionPerformed(evt);
            }
        });

        btn_disable.setBackground(new java.awt.Color(255, 255, 255));
        btn_disable.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_disable.setForeground(new java.awt.Color(49, 56, 62));
        btn_disable.setText("Cancelar");
        btn_disable.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        btn_disable.setBorderPainted(false);
        btn_disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_disable.setFocusable(false);
        btn_disable.setMargin(new java.awt.Insets(48, 16, 16, 48));
        btn_disable.setPreferredSize(new java.awt.Dimension(160, 40));
        btn_disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_disableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_enable, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_disable, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_enable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_disable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 980, 80));

        jPanel6.setBackground(new java.awt.Color(240, 240, 242));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        table_tarifa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        table_tarifa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_tarifa.setGridColor(new java.awt.Color(255, 255, 255));
        table_tarifa.setRowHeight(25);
        jScrollPane1.setViewportView(table_tarifa);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 980, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del sistema?", "Salir" ,dialog);
        if (result == 0){
            conex.getDisconnectBD();
            Login login = new Login();
            login.setVisible(true);
                this.dispose();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txt_valorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_valorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_valorActionPerformed
    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
       // Boton Guardar
        try {
            PreparedStatement pps = con.prepareStatement("INSERT INTO tarifa (type_vehiculo, tipo_tarifa,valor) VALUES (?,?,?)");
            pps.setString(1, txt_vehiculo.getText());
            pps.setString(2, txt_tarifa.getText());
            pps.setString(3, txt_valor.getText());
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Almacenados");
            ShowTable();
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed
    private void btn_modifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifiedActionPerformed
        // Boton Modificar
        int fila = table_tarifa.getSelectedRow();
        if(fila>=0){
            txt_buscar.setText(table_tarifa.getValueAt(fila, 0).toString());
            txt_vehiculo.setText(table_tarifa.getValueAt(fila, 1).toString());
            txt_tarifa.setText(table_tarifa.getValueAt(fila, 2).toString());
            txt_valor.setText(table_tarifa.getValueAt(fila, 3).toString());
            btn_add.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_modified.setEnabled(false);
        }else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }//GEN-LAST:event_btn_modifiedActionPerformed
    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
       // Boton Actualizar
        try {                                                                   
            PreparedStatement pps = con.prepareStatement("UPDATE tarifa SET type_vehiculo='"+txt_vehiculo.getText()+"',tipo_tarifa='"+txt_tarifa.getText()
                +"',valor='"+txt_valor.getText()+"' WHERE id_tarifa ='"+txt_buscar.getText()+"'");
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            limpiar();
            btn_add.setEnabled(true);
            btn_delete.setEnabled(true);
            btn_modified.setEnabled(true);
            ShowTable();
        } catch (SQLException ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // Boton Eliminar
        int fila = table_tarifa.getSelectedRow();
        String valor = table_tarifa.getValueAt(fila, 0).toString();
        if(fila>=0){
            try {
                PreparedStatement pps = con.prepareStatement("DELETE FROM tarifa WHERE id_tarifa='"+valor+"'");
                pps.executeUpdate();
                pps.close();
                JOptionPane.showMessageDialog(null, "Dato Eliminado");
                ShowTable();
            } catch (SQLException ex) {
                Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
      
    }//GEN-LAST:event_formKeyPressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Mouse Pressed
         x = evt.getX();
         y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
       // Mouse Dragged
       Point p = MouseInfo.getPointerInfo().getLocation();
       this.setLocation(p.x-x, p.y-y);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void txt_tarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tarifaActionPerformed

    private void txt_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyTyped
        char inputText = evt.getKeyChar();
        if (inputText<'0' || inputText>'9') evt.consume();
    }//GEN-LAST:event_txt_valorKeyTyped

    private void btn_enableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enableActionPerformed
        desbloquear();
    }//GEN-LAST:event_btn_enableActionPerformed

    private void btn_disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disableActionPerformed
        bloquear();
        limpiar();
    }//GEN-LAST:event_btn_disableActionPerformed

    private void txt_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_vehiculoActionPerformed

    }//GEN-LAST:event_txt_vehiculoActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel21MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_disable;
    private javax.swing.JButton btn_enable;
    private javax.swing.JButton btn_modified;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_tarifa;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_tarifa;
    private javax.swing.JTextField txt_valor;
    private javax.swing.JTextField txt_vehiculo;
    // End of variables declaration//GEN-END:variables
}
