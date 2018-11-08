
package soft.java.interfaces;

import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import soft.java.conection.MySQLConnection;
import soft.java.login.Login;

public class Pending extends javax.swing.JFrame {
    
    int x, y;
    int priceToPay = 0;
    String currentHours = "";
    String statedFalse = "No disponible";
    String StatedTrue = "Disponible";
    
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
    
    
    public Pending() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Pendientes");
        setIconImage(new ImageIcon(getClass().getResource("/soft/java/files/car_icon_100px.png")).getImage());
        this.setLocationRelativeTo(null);
        bloquear();
        ShowTable();
        
    }

    // metodo para mostrar la tabla de la Base Datos 
    void ShowTable(){
        
        
        DefaultTableModel modelo = new DefaultTableModel();   
            modelo.addColumn("ID Vehículo");
            modelo.addColumn("Placa");
            modelo.addColumn("Tipo Vehículo");
            modelo.addColumn("Fecha Entrada");
            modelo.addColumn("Hora Entrada");
            modelo.addColumn("Fecha Salida");
            modelo.addColumn("Hora Salida");
            modelo.addColumn("Tipo Tarifa");
            modelo.addColumn("Valor");
            modelo.addColumn("Estado");
                table_pending.setModel(modelo);
            String sql = "SELECT id_vehiculo ,placa, tipo_vehiculo, fecha_entrada, hora_entrada, fecha_salida, hora_salida, tipo_tarifa, valor, estado FROM vehiculo INNER JOIN tarifa ON vehiculo.id_tarifa1 = tarifa.id_tarifa WHERE estado = 'Disponible' ORDER BY id_vehiculo ASC;";
            String datos[] = new String[10];
            Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    datos[0] = rs.getString(1); /*Id vehiculo*/
                    datos[1] = rs.getString(2); /*Placa*/
                    datos[2] = rs.getString(3); /*Tipo vehiculo*/
                    datos[3] = rs.getString(4); /*Fecha entrada*/
                    datos[4] = rs.getString(5); /*Hora entrada*/
                    datos[5] = rs.getString(6); /*Fecha salida*/
                    datos[6] = rs.getString(7); /*Hora salida*/
                    datos[7] = rs.getString(8); /*Tipo tarifa*/
                    datos[8] = rs.getString(9); /*Valor*/
                    datos[9] = rs.getString(10); /*Estado*/

                        modelo.addRow(datos);
                }
                 table_pending.setModel(modelo);  
                 TableColumnModel columnModel = table_pending.getColumnModel();
                    columnModel.getColumn(0).setPreferredWidth(20);
                    columnModel.getColumn(3).setPreferredWidth(50);
                    columnModel.getColumn(4).setPreferredWidth(50);
                    columnModel.getColumn(5).setPreferredWidth(50);
        } catch (SQLException ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void bloquear(){
        txt_fecha_Salida.setEditable(false);
        txt_hora_salida.setEditable(false);
            btn_dar_salida.setEnabled(false);
            btn_disable.setEnabled(false);
            btn_add.setEnabled(false);
            btn_modified.setEnabled(false);
            btn_update.setEnabled(false);
    }
    
    void desbloquear(){
        btn_disable.setEnabled(true);
        btn_add.setEnabled(true);
        btn_modified.setEnabled(true);
        btn_update.setEnabled(true);
        btn_dar_salida.setEnabled(true);
    }
    
    void limpiar(){
        txt_fecha_Salida.setText("");
        txt_hora_salida.setText("");
        txt_id.setText("");
    }
    
    // Metodo para obtener la fecha del sistema
    void getFecha(){
       Date currentDate = new Date();
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            txt_fecha_Salida.setText(String.format(format.format(currentDate), format));
    }
    
    // Metodo para obtener la hora del sistema
    void getHours(){
        Date getHours = new Date();
        String hourFormat = "hh:mm:ss a";
        SimpleDateFormat format = new SimpleDateFormat(hourFormat);
        Calendar calendar = Calendar.getInstance(); 
            txt_hora_salida.setText(String.format(format.format(getHours), calendar));
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            currentHours = dateFormat.format(date);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pending = new javax.swing.JTable();
        btn_dar_salida = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_generate_salida = new javax.swing.JButton();
        txt_fecha_Salida = new javax.swing.JTextField();
        txt_hora_salida = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_disable = new javax.swing.JButton();
        btn_modified = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();

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

        jPanel1.setBackground(new java.awt.Color(49, 56, 62));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(3, 146, 222));
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 242));
        jLabel1.setText("Vehículos pendientes por liquidar");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soft/java/files/Minus Math _30px.png"))); // NOI18N
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(274, 274, 274)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 70));

        jPanel2.setBackground(new java.awt.Color(240, 240, 242));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        table_pending.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        table_pending.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table_pending);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_dar_salida.setBackground(new java.awt.Color(255, 255, 255));
        btn_dar_salida.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_dar_salida.setForeground(new java.awt.Color(49, 56, 62));
        btn_dar_salida.setText("Dar salida");
        btn_dar_salida.setBorder(null);
        btn_dar_salida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dar_salida.setFocusPainted(false);
        btn_dar_salida.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_dar_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dar_salidaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 56, 62));
        jLabel6.setText("Fecha salida");

        txt_id.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txt_id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_id.setEnabled(false);
        txt_id.setFocusable(false);

        btn_generate_salida.setBackground(new java.awt.Color(255, 255, 255));
        btn_generate_salida.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        btn_generate_salida.setForeground(new java.awt.Color(49, 56, 62));
        btn_generate_salida.setText("Generar salida");
        btn_generate_salida.setBorder(null);
        btn_generate_salida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generate_salida.setFocusPainted(false);
        btn_generate_salida.setPreferredSize(new java.awt.Dimension(170, 46));
        btn_generate_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generate_salidaActionPerformed(evt);
            }
        });

        txt_fecha_Salida.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_fecha_Salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_SalidaActionPerformed(evt);
            }
        });
        txt_fecha_Salida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fecha_SalidaKeyTyped(evt);
            }
        });

        txt_hora_salida.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_hora_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_salidaActionPerformed(evt);
            }
        });
        txt_hora_salida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hora_salidaKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel7.setText("ID");

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 56, 62));
        jLabel8.setText("Hora salida");

        btn_add.setBackground(new java.awt.Color(255, 255, 255));
        btn_add.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_add.setForeground(new java.awt.Color(49, 56, 62));
        btn_add.setText("Agregar");
        btn_add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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

        btn_modified.setBackground(new java.awt.Color(255, 255, 255));
        btn_modified.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_modified.setForeground(new java.awt.Color(49, 56, 62));
        btn_modified.setText("Modificar");
        btn_modified.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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

        btn_update.setBackground(new java.awt.Color(255, 255, 255));
        btn_update.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        btn_update.setForeground(new java.awt.Color(49, 56, 62));
        btn_update.setText("Actualizar");
        btn_update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_disable, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_modified, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_disable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modified, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btn_generate_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_fecha_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_dar_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_dar_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_generate_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_hora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fecha_Salida, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea cerrar esta ventana?", "Cerrar" ,dialog);
        if (result == 0){
            this.dispose();
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Mouse Pressed
         x = evt.getX();
         y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
    }//GEN-LAST:event_formKeyPressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Mouse Dragged
       Point p = MouseInfo.getPointerInfo().getLocation();
       this.setLocation(p.x-x, p.y-y);
    }//GEN-LAST:event_formMouseDragged

    private void txt_fecha_SalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_SalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_SalidaActionPerformed

    private void txt_hora_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_salidaActionPerformed

    private void btn_generate_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate_salidaActionPerformed
        
        double payment = 0.0;
        
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar cal  = Calendar.getInstance();
        Date date = cal.getTime();
        
        int fila = table_pending.getSelectedRow();
        if(fila>=0){
            try {
                txt_id.setText(table_pending.getValueAt(fila, 0).toString());
                int idSelected = Integer.parseInt(txt_id.getText());
                getFecha();
                getHours();
                // Consulta en la BD
                Statement stat = con.createStatement();
                ResultSet rs = stat.executeQuery("SELECT fecha_entrada, tipo_vehiculo, valor FROM vehiculo INNER JOIN tarifa ON vehiculo.id_tarifa1 = tarifa.id_tarifa WHERE id_vehiculo = "+idSelected+" AND estado = 'Disponible'");
                rs.first();
                // Selecciona los atributos deacuerdo a la posicion de la consulta sql
                String fecha_entrada = rs.getString(1);
                Date fecha_Entrada = dateFormat.parse(fecha_entrada);
                String tipo_vehiculo = rs.getString(2);
                String valor_tarifa = rs.getString(3);
                // Convierte el valor traido de la BD de String a double
                double valorTarifa = Double.parseDouble(valor_tarifa);
                // Calcula el tiempo transcurrido entre la fecha de entrada y la fecha actual (de salida)
                int ratePay = (int) (date.getTime() - fecha_Entrada.getTime()) / 60000;
                // Determina el valor a pagar con base al tiempo transcurrido y calculado en hora-minuto
                payment = (valorTarifa / 60) * ratePay;
                // Parsea el resultado a pagar de double a Entero
                int payMent = (int) payment;
                priceToPay = payMent;
                desbloquear();
                btn_generate_salida.setEnabled(false);
                btn_dar_salida.setEnabled(true);
                btn_update.setEnabled(false);
            } catch (SQLException ex) {
                Logger.getLogger(Pending.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Pending.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    }//GEN-LAST:event_btn_generate_salidaActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // Boton Agregar
        try {                                                                   
            PreparedStatement pps = con.prepareStatement("UPDATE vehiculo SET fecha_salida='"+txt_fecha_Salida.getText()+"',hora_salida='"+currentHours+"' WHERE id_vehiculo ='"+txt_id.getText()+"'");
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            bloquear();
            ShowTable();
            btn_generate_salida.setEnabled(true);
            btn_dar_salida.setEnabled(true);
            txt_fecha_Salida.setText("");
            txt_hora_salida.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_disableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_disableActionPerformed
        limpiar();
        bloquear();
        btn_generate_salida.setEnabled(true);
    }//GEN-LAST:event_btn_disableActionPerformed

    private void btn_modifiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifiedActionPerformed
        // Boton Modificar
        limpiar();
        int fila = table_pending.getSelectedRow();
        if(fila>=0){
            txt_id.setText(table_pending.getValueAt(fila, 0).toString());
            txt_fecha_Salida.setText(table_pending.getValueAt(fila, 5).toString());
            txt_hora_salida.setText(table_pending.getValueAt(fila, 6).toString());

            bloquear();
            txt_fecha_Salida.setEditable(true);
            txt_hora_salida.setEditable(true);
            btn_modified.setEnabled(false);
            btn_update.setEnabled(true);
            btn_disable.setEnabled(true);
        }else{
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }//GEN-LAST:event_btn_modifiedActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Boton Actualizar
        try {                                                                   
            PreparedStatement pps = con.prepareStatement("UPDATE vehiculo SET fecha_salida='"+txt_fecha_Salida.getText()+"',hora_salida='"+txt_hora_salida.getText()+"',estado='"+StatedTrue+"' WHERE id_vehiculo ='"+txt_id.getText()+"'");
            pps.executeUpdate();
            pps.close();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            desbloquear();
            bloquear();
            btn_generate_salida.setEnabled(true);

            limpiar();
            ShowTable();
        } catch (SQLException ex) {
            Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_dar_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dar_salidaActionPerformed
       // Boton dar salida
        Registry registry = new Registry();
        Home home = new Home();
                
        int fila = table_pending.getSelectedRow();
        int dialog = JOptionPane.YES_NO_OPTION;
        int idSelected = Integer.parseInt(txt_id.getText());
        
        String emptyId = "";
        String tiempoTranscurrido = "";
        String enteroString = Integer.toString(priceToPay);
        
        int mesesTranscurrido = 0;
        int diasTranscurrido = 0;
        int horasTranscurrido = 0;
        int minutosTranscurrido = 0;

        if (!txt_id.getText().equals(emptyId)){  
            if (idSelected >= 0){
                int result = JOptionPane.showConfirmDialog(null, "¿Desea cálcular la salida del vehículo?", "Cierre" ,dialog);  
                    if (result == 0){
                        try {
                            // Enviar datos a la interfaz Registro 
                            Registry.txt_placa.setText(table_pending.getValueAt(fila, 1).toString());
                            Registry.txt_fecha_entrada.setText(table_pending.getValueAt(fila, 3).toString());
                            Registry.txt_hora_entrada.setText(table_pending.getValueAt(fila, 4).toString());
                            Registry.txt_fecha_salida.setText(table_pending.getValueAt(fila, 5).toString());
                            Registry.txt_hora_salida.setText(table_pending.getValueAt(fila, 6).toString());
                            Registry.txt_tipo.setText(table_pending.getValueAt(fila, 7).toString());
                            Registry.txt_tarifa.setText(table_pending.getValueAt(fila, 8).toString());
                            Registry.txt_pago.setText(enteroString);
                            
                            PreparedStatement pps;
                            
                            // Consulta en la BD
                            Statement stat = con.createStatement();
                            ResultSet rs = stat.executeQuery("SELECT fecha_entrada, fecha_salida, hora_entrada, hora_salida FROM vehiculo WHERE id_vehiculo = '"+idSelected+"' AND estado = 'Disponible'");
                            rs.first();
                            // Selecciona los atributos deacuerdo a la posicion de la consulta sql
                            String fecha_entrada = rs.getString(1);
                            String fecha_salida = rs.getString(2);
                            String hora_entrada = rs.getString(3);
                            String hora_salida = rs.getString(4);
                            // Convierte los registro de fecha de String a un Array.
                            String[] entradaFecha = fecha_entrada.split("-");
                                int diaEntrada = Integer.parseInt(entradaFecha[0]);
                                int mesEntrada = Integer.parseInt(entradaFecha[1]);
                                
                            String[] salidaFecha = fecha_salida.split("-");
                                int diaSalida = Integer.parseInt(salidaFecha[0]);
                                int mesSalida = Integer.parseInt(salidaFecha[1]);
                                
                            String[] entradaHora = hora_entrada.split(":");
                                int horaEntrada = Integer.parseInt(entradaHora[0]);
                                int minutoEntrada = Integer.parseInt(entradaHora[1]);

                            String[] salidaHora = hora_salida.split(":");
                                int horaSalida = Integer.parseInt(salidaHora[0]);
                                int minutoSalida = Integer.parseInt(salidaHora[1]);

                            mesesTranscurrido = mesEntrada - mesSalida;
                            diasTranscurrido = diaEntrada - diaSalida;
                            horasTranscurrido = horaEntrada - horaSalida;
                            minutosTranscurrido = minutoEntrada - minutoSalida;
                            
                            if( (mesesTranscurrido == 0) && diasTranscurrido == 0){
                                tiempoTranscurrido = Math.abs(horasTranscurrido)+" hora(s) "+Math.abs(minutosTranscurrido)+" minuto(s)";
                                Registry.txt_tiempo.setText(tiempoTranscurrido);
                            }else if (Math.abs(diasTranscurrido) > 0){
                                tiempoTranscurrido = Math.abs(diasTranscurrido)+" dia(s) "+Math.abs(horasTranscurrido)+" hora(s) "+Math.abs(minutosTranscurrido)+" minuto(s)";
                                Registry.txt_tiempo.setText(tiempoTranscurrido);
                            }else {
                                tiempoTranscurrido = Math.abs(mesesTranscurrido)+" mes(es) "+Math.abs(diasTranscurrido)+" dia(s) "+Math.abs(horasTranscurrido)+" hora(s) "+Math.abs(minutosTranscurrido)+" minuto(s)";
                                Registry.txt_tiempo.setText(tiempoTranscurrido);
                            }
                            
                            pps = con.prepareStatement("UPDATE vehiculo SET estado='"+statedFalse+"' WHERE id_vehiculo ='"+txt_id.getText()+"'");                                                                         
                            pps.executeUpdate();
                            pps.close();
 
                            Registry.btn_liquidacion.setEnabled(true);
                            Registry.txt_efectivo.setEditable(true);
                            
                            home.dispose();
                            registry.setVisible(true);
                            this.dispose();
                          
                        } catch (SQLException ex) {
                            Logger.getLogger(Pending.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            }
            
        }else{
           JOptionPane.showMessageDialog(null, "Ningun vehículo ha sido seleccionado"); 
        }

    }//GEN-LAST:event_btn_dar_salidaActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void txt_fecha_SalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fecha_SalidaKeyTyped
        int characterLimit = 10;
        if (txt_fecha_Salida.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_fecha_SalidaKeyTyped

    private void txt_hora_salidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hora_salidaKeyTyped
       int characterLimit = 10;
        if (txt_hora_salida.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_hora_salidaKeyTyped


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
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pending().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_dar_salida;
    private javax.swing.JButton btn_disable;
    private javax.swing.JButton btn_generate_salida;
    private javax.swing.JButton btn_modified;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_pending;
    private javax.swing.JTextField txt_fecha_Salida;
    private javax.swing.JTextField txt_hora_salida;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
