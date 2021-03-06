
package soft.java.interfaces;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Paragraph;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import soft.java.conection.MySQLConnection;
import soft.java.login.Login;


public class Registry extends javax.swing.JFrame {

    int x, y;
    String currentHours = "";
    
    // conector a la Base de datos
    MySQLConnection conex = new MySQLConnection();
    Connection con = conex.getConnectionBD();
        
    public Registry() {
        this.setUndecorated(true);
        initComponents();
        setTitle("Registro vehículo");
        setIconImage(new ImageIcon(getClass().getResource("/soft/java/files/car_icon_100px.png")).getImage());
        this.setLocationRelativeTo(null);
        // Ejecuta la hora del sistema
        Timer time = new Timer(1000, new Registry.currentHour());
        time.start();
        getVehiculo();
        bloquear();
    }
    
      // Clase para obtener la hora del sistema
    class currentHour implements ActionListener{
      
        public void actionPerformed(ActionEvent e){
            Date getHours = new Date();
            String hourFormat = "hh:mm a";
            SimpleDateFormat format = new SimpleDateFormat(hourFormat);
            Calendar calendar = Calendar.getInstance(); 
                jbl_hours.setText(String.format(format.format(getHours), calendar));    
                 
        }
        
    }
    

    // Metodo para desbloquear campos de texto y botones
    void desbloquear(){
        txt_placa.setEditable(true);
        jcb_vehiculo.setEditable(true);
        txt_fecha_entrada.setEditable(false);
        txt_hora_entrada.setEditable(false);        
        txt_fecha_salida.setEditable(false);        
        txt_hora_salida.setEditable(false);
        txt_pago.setEditable(false);
        txt_efectivo.setEditable(false);
        txt_cambio.setEditable(false);
        txt_tiempo.setEditable(false);
            btn_nuevo_ingreso.setEnabled(false);
            jcb_vehiculo.setEnabled(true);
            jcb_vehiculo.setEditable(false);
            btn_ingreso.setEnabled(false);
            btn_cancelar.setEnabled(true);
            btn_pendiente.setEnabled(true);
            btn_liquidacion.setEnabled(false);   
    }
    
    // Metodo para bloquear campos de texto y botones
    void bloquear(){
        txt_placa.setEditable(false);
        jcb_vehiculo.setEditable(false);
        txt_tarifa.setEditable(false);
        txt_tipo.setEditable(false);
        txt_fecha_entrada.setEditable(false);
        txt_hora_entrada.setEditable(false);        
        txt_fecha_salida.setEditable(false);        
        txt_hora_salida.setEditable(false);
        txt_pago.setEditable(false);
        txt_efectivo.setEditable(false);
        txt_cambio.setEditable(false);
        txt_tiempo.setEditable(false);
            btn_nuevo_ingreso.setEnabled(true);
            jcb_vehiculo.setEnabled(false);
            btn_ingreso.setEnabled(false);
            btn_cancelar.setEnabled(false);
            btn_pendiente.setEnabled(false);
            btn_liquidacion.setEnabled(false);   
    }
    
    // Metodo para limpiar campos de texto
    void limpiar(){
        txt_placa.setText("");
        txt_tarifa.setText("");
        txt_tipo.setText("");
        txt_fecha_entrada.setText("");
        txt_fecha_entrada.setText("");
        txt_hora_entrada.setText("");
        txt_fecha_salida.setText("");
        txt_hora_salida.setText("");
        txt_pago.setText("");
        txt_efectivo.setText("");
        txt_cambio.setText("");
        txt_tiempo.setText("");
    }
    
    // Metodo para obtener la fecha del sistema
    void getFecha(){
       Date currentDate = new Date();
        String dateFormat = "dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            txt_fecha_entrada.setText(String.format(format.format(currentDate), format));
    }
    
    // Metodo para obtener la hora del sistema
    void getHours(){
        Date getHours = new Date();
        String hourFormat = "hh:mm:ss a";
        SimpleDateFormat format = new SimpleDateFormat(hourFormat);
        Calendar calendar = Calendar.getInstance(); 
            txt_hora_entrada.setText(String.format(format.format(getHours), calendar));

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            currentHours = dateFormat.format(date);
    }
    
    // Metodo para obtener datos 'tipo vehiculo' de la base datos
    void getVehiculo(){  
        try {
            String sql = "SELECT DISTINCT type_vehiculo FROM tarifa";
            PreparedStatement pps = con.prepareStatement(sql);
            ResultSet rs = pps.executeQuery(sql);
                jcb_vehiculo.addItem("Seleccione vehículo");
            while(rs.next()){
                jcb_vehiculo.addItem(rs.getString("type_vehiculo"));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No hay resultado");
        } 
    }
   
/*
    void getTarifa(){
        String selectedVehiculo = jcb_vehiculo.getSelectedItem().toString();
        System.out.println(selectedVehiculo);
        try {
            String sql = "SELECT tipo_tarifa, valor FROM tarifa WHERE type_vehiculo = '"+selectedVehiculo+"'";
            PreparedStatement pps = con.prepareStatement(sql);
            ResultSet rs = pps.executeQuery(sql);
                jcb_tarifa.addItem("Seleccione tarifa");   
            while(rs.next()){
                jcb_tarifa.addItem(rs.getString("tipo_tarifa"));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No hay resultado");
        }         
    }
*/ 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jbl_hours = new javax.swing.JLabel();
        rs_calendar = new rojeru_san.componentes.RSCalendar();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_placa = new javax.swing.JTextField();
        jcb_vehiculo = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btn_ingreso = new javax.swing.JButton();
        txt_tarifa = new javax.swing.JTextField();
        txt_tipo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_nuevo_ingreso = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        btn_pendiente = new javax.swing.JButton();
        btn_liquidacion = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_fecha_entrada = new javax.swing.JTextField();
        txt_hora_entrada = new javax.swing.JTextField();
        txt_fecha_salida = new javax.swing.JTextField();
        txt_hora_salida = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tiempo = new javax.swing.JTextField();
        txt_pago = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_efectivo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_cambio = new javax.swing.JTextField();

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

        jPanel3.setBackground(new java.awt.Color(240, 240, 242));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(890, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 980, 70));

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
        jLabel20.setText("Registro Diario");

        jbl_hours.setFont(new java.awt.Font("Roboto", 0, 40)); // NOI18N
        jbl_hours.setForeground(new java.awt.Color(182, 182, 184));

        rs_calendar.setBackground(new java.awt.Color(49, 56, 62));
        rs_calendar.setBorder(null);
        rs_calendar.setForeground(new java.awt.Color(255, 255, 255));
        rs_calendar.setAltoFilas(20);
        rs_calendar.setAltoHead(35);
        rs_calendar.setColorDiaActual(new java.awt.Color(240, 92, 44));
        rs_calendar.setEnabled(false);
        rs_calendar.setFocusable(false);
        rs_calendar.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        rs_calendar.setFuenteFilas(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rs_calendar.setFuenteHead(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rs_calendar.setPreferredSize(new java.awt.Dimension(300, 322));
        rs_calendar.setTextMayusculas(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbl_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(rs_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel20)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel20)
                .addGap(51, 51, 51)
                .addComponent(rs_calendar, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbl_hours, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 300, 630));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 215));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(49, 56, 62));
        jLabel2.setText("Digite la placa");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(49, 56, 62));
        jLabel3.setText("Tipo de vehículo");

        txt_placa.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_placa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_placaActionPerformed(evt);
            }
        });
        txt_placa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_placaKeyTyped(evt);
            }
        });

        jcb_vehiculo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jcb_vehiculo.setPreferredSize(new java.awt.Dimension(33, 35));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcb_vehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_placa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcb_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(324, 70));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(49, 56, 62));
        jLabel4.setText("Tarifa");

        btn_ingreso.setBackground(new java.awt.Color(255, 255, 255));
        btn_ingreso.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btn_ingreso.setForeground(new java.awt.Color(112, 112, 112));
        btn_ingreso.setText("Dar ingreso");
        btn_ingreso.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(112, 112, 112), null));
        btn_ingreso.setBorderPainted(false);
        btn_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ingreso.setFocusPainted(false);
        btn_ingreso.setPreferredSize(new java.awt.Dimension(170, 28));
        btn_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresoActionPerformed(evt);
            }
        });

        txt_tarifa.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        txt_tarifa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tarifaActionPerformed(evt);
            }
        });

        txt_tipo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txt_tipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(49, 56, 62));
        jLabel14.setText("Tipo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btn_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel7.setPreferredSize(new java.awt.Dimension(100, 70));

        btn_nuevo_ingreso.setBackground(new java.awt.Color(255, 255, 255));
        btn_nuevo_ingreso.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_nuevo_ingreso.setForeground(new java.awt.Color(49, 56, 62));
        btn_nuevo_ingreso.setText("Nuevo ingreso");
        btn_nuevo_ingreso.setBorderPainted(false);
        btn_nuevo_ingreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nuevo_ingreso.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_nuevo_ingreso.setRequestFocusEnabled(false);
        btn_nuevo_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevo_ingresoActionPerformed(evt);
            }
        });

        btn_cancelar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(49, 56, 62));
        btn_cancelar.setText("Cancelar");
        btn_cancelar.setToolTipText("");
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_cancelar.setRequestFocusEnabled(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_pendiente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_pendiente.setForeground(new java.awt.Color(49, 56, 62));
        btn_pendiente.setText("Pendiente");
        btn_pendiente.setBorderPainted(false);
        btn_pendiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_pendiente.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_pendiente.setRequestFocusEnabled(false);
        btn_pendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pendienteActionPerformed(evt);
            }
        });

        btn_liquidacion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btn_liquidacion.setForeground(new java.awt.Color(49, 56, 62));
        btn_liquidacion.setText("Generar liquidación");
        btn_liquidacion.setBorder(null);
        btn_liquidacion.setBorderPainted(false);
        btn_liquidacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_liquidacion.setPreferredSize(new java.awt.Dimension(189, 50));
        btn_liquidacion.setRequestFocusEnabled(false);
        btn_liquidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_liquidacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btn_nuevo_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_pendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_liquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_liquidacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_nuevo_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_pendiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setPreferredSize(new java.awt.Dimension(324, 70));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(49, 56, 62));
        jLabel6.setText("Fecha entrada");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(49, 56, 62));
        jLabel7.setText("Hora entrada");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(49, 56, 62));
        jLabel8.setText("Fecha salida");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(49, 56, 62));
        jLabel9.setText("Hora salida");

        txt_fecha_entrada.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_fecha_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_entradaActionPerformed(evt);
            }
        });

        txt_hora_entrada.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_hora_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_entradaActionPerformed(evt);
            }
        });

        txt_fecha_salida.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_fecha_salida.setForeground(new java.awt.Color(240, 92, 44));
        txt_fecha_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_salidaActionPerformed(evt);
            }
        });

        txt_hora_salida.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_hora_salida.setForeground(new java.awt.Color(240, 92, 44));
        txt_hora_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_salidaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(49, 56, 62));
        jLabel10.setText("Tiempo transcurrido");

        txt_tiempo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_tiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tiempo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_tiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tiempoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(53, 53, 53)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_hora_salida, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                    .addComponent(txt_fecha_salida)
                    .addComponent(txt_hora_entrada)
                    .addComponent(txt_fecha_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(txt_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(127, 127, 127))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_fecha_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_hora_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(2, 2, 2))
                    .addComponent(txt_fecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_hora_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_pago.setColumns(5);
        txt_pago.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_pago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pagoActionPerformed(evt);
            }
        });
        txt_pago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pagoKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(49, 56, 62));
        jLabel11.setText("Valor a pagar");

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(49, 56, 62));
        jLabel12.setText("Efectivo");

        txt_efectivo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        txt_efectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_efectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_efectivoActionPerformed(evt);
            }
        });
        txt_efectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_efectivoKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(49, 56, 62));
        jLabel13.setText("Cambio");

        txt_cambio.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_cambio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_cambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cambioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(58, 58, 58)
                                .addComponent(txt_cambio))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(58, 58, 58)
                                .addComponent(txt_efectivo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(62, 62, 62)
                                .addComponent(txt_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_pago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 980, 630));

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

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Mouse Dragged
       Point p = MouseInfo.getPointerInfo().getLocation();
       this.setLocation(p.x-x, p.y-y);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
       // Mouse Pressed
         x = evt.getX();
         y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void txt_placaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_placaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_placaActionPerformed
    private void txt_fecha_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_entradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_entradaActionPerformed
    private void txt_hora_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_entradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_entradaActionPerformed
    private void txt_fecha_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_salidaActionPerformed
    private void txt_hora_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_salidaActionPerformed
    private void txt_tiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tiempoActionPerformed
    private void txt_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pagoActionPerformed
    private void txt_efectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_efectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_efectivoActionPerformed
    private void txt_cambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cambioActionPerformed
    
     // Evento, teclado, - Campo Efectivo
    private void txt_efectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyTyped
        char inputText = evt.getKeyChar();
        int characterLimit = 10;
        if (inputText<'0' || inputText>'9') evt.consume();
        if (txt_efectivo.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_efectivoKeyTyped

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // Boton volver
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void btn_nuevo_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevo_ingresoActionPerformed
       // Boton nuevo ingreso
       desbloquear();
       btn_ingreso.setEnabled(true);
       // Captura la fecha
       getFecha();
       // Captura la hora
       getHours();
       // Enfoque campo texto placa
       txt_placa.grabFocus();
    }//GEN-LAST:event_btn_nuevo_ingresoActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // Boton nuevo cancelar
        bloquear();
        limpiar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresoActionPerformed
       // Boton Dar ingreso
       int selectedVehiculoId = jcb_vehiculo.getSelectedIndex();
       String selectedVehiculo = jcb_vehiculo.getSelectedItem().toString(); 
       String StatedTrue = "Disponible";
       String emptyPlaca = "";
    
      
       if (!txt_placa.getText().equals(emptyPlaca)){
           
            if (selectedVehiculo.equals("Seleccione vehículo")) {
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de vehículo");
            }else{ 
                try {
                     
                     PreparedStatement pps = con.prepareStatement("INSERT INTO vehiculo (placa, tipo_vehiculo, fecha_entrada, hora_entrada, estado, id_tarifa1) VALUES (?,?,?,?,?,?)");
                     pps.setString(1, txt_placa.getText());
                     pps.setString(2, selectedVehiculo);
                     pps.setString(3, txt_fecha_entrada.getText());
                     pps.setString(4, currentHours);
                     pps.setString(5, StatedTrue);
                     pps.setInt(6, selectedVehiculoId);
                     pps.executeUpdate();
                     pps.close();
                     JOptionPane.showMessageDialog(null, "Datos Almacenados");
                     limpiar();
                     bloquear();
                } catch (SQLException ex) {
                    Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
       }else{
          JOptionPane.showMessageDialog(null, "Debe agregar Placa");
          txt_placa.grabFocus();
       }
    }//GEN-LAST:event_btn_ingresoActionPerformed

    private void btn_pendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pendienteActionPerformed
        Pending pending = new Pending();
        pending.setVisible(true);
        bloquear();
        limpiar();
        this.dispose();
    }//GEN-LAST:event_btn_pendienteActionPerformed

    private void btn_liquidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_liquidacionActionPerformed
    // Boton - Generar liquidacion
        String emptyId = "";
        int dialog = JOptionPane.YES_NO_OPTION;
        int payMayor = Integer.parseInt(txt_pago.getText());
        
        if (!txt_efectivo.getText().equals(emptyId)){
            int payMenor = Integer.parseInt(txt_efectivo.getText());
            if(payMenor >= payMayor){
                int result = JOptionPane.showConfirmDialog(null, "¿Generar reporte de salida del vehículo?", "Cierre" ,dialog);  
                if (result == 0){
                    try {        
                        PreparedStatement pps = con.prepareStatement("UPDATE vehiculo SET valor_pagado = '"+txt_pago.getText()
                                +"' WHERE placa = '"+txt_placa.getText()+"'");
                        pps.executeUpdate();
                        pps.close();
                        JOptionPane.showMessageDialog(null, "Vehículo dado de salida.");
                   } catch (SQLException ex) {
                       Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
                   }
                    // Generar reporte de salida vehiculo
                    try {
                        // Reemplazar esta ruta al hacer el ejecutable
                        //  File url = new File("..\\src\\soft\\java\\reporting\\recibo-parkingExpress.pdf");
                    File urldest = new File("src\\soft\\java\\reporting\\recibo-parkingExpress.pdf");
                    String dest = urldest.toString(); 
                        System.out.println(dest); 
      
                        // REPORTE
                        PdfWriter writer = new PdfWriter(dest);
                        PdfDocument pdfDoc = new PdfDocument(writer);
                        Document document = new Document(pdfDoc, PageSize.A5);
                        pdfDoc.addNewPage(); 
                        
                        Paragraph paragraph = new Paragraph ("| Recibo | - ParkingExpress"); 
                        paragraph.setBorder(Border.NO_BORDER);
                        paragraph.setBold();
                        
                        Paragraph para1 = new Paragraph ("Placa vehiculo: "+txt_placa.getText()); 
                        Paragraph para2 = new Paragraph ("Fecha de ingreso: "+txt_fecha_entrada.getText()); 
                        Paragraph para3 = new Paragraph ("Hora de ingreso: "+txt_hora_entrada.getText());
                        Paragraph para4 = new Paragraph ("Fecha de salida: "+txt_fecha_salida.getText());
                        Paragraph para5 = new Paragraph ("Hora de salida: "+txt_hora_salida.getText());
                        Paragraph para6 = new Paragraph ("-----------------------");
                        Paragraph para7 = new Paragraph ("Pago por aparcamiento: "+txt_pago.getText());
                        Paragraph para8 = new Paragraph ("Pago en efectivo: "+txt_efectivo.getText());
                        Paragraph para9 = new Paragraph ("Total cambio: "+txt_cambio.getText());
                        Paragraph para10 = new Paragraph ("-----------------------");
                        
                        document.add(paragraph); 
                        document.add(para1); 
                        document.add(para2); 
                        document.add(para3);
                        document.add(para4); 
                        document.add(para5); 
                        document.add(para6);
                        document.add(para7);
                        document.add(para8); 
                        document.add(para9);
                        document.add(para10);
                        document.close();
                        
                        System.out.println("PDF Created");
                        // Abre el REPORTE
                        int result2 = JOptionPane.showConfirmDialog(null, "¿Desea abrir el reporte de salida del vehículo, para imprimir?", "Imprimir" ,dialog);  
                        if(result2 == 0){
                            try {
                                if(urldest.exists()){
                                    Process processOpen = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+dest);
                                    processOpen.waitFor();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Es posible que aun no se haya generado ningun reporte, por favor verifique.");
                                }
                            } catch (Exception ex) {
                               ex.printStackTrace();  
                            }
                        }
                        limpiar();
                        bloquear();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Registry.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Registry.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }else if(result == 1){
                    try {        
                        PreparedStatement pps = con.prepareStatement("UPDATE vehiculo SET valor_pagado = '"+txt_pago.getText()
                                +"' WHERE placa = '"+txt_placa.getText()+"'");
                        pps.executeUpdate();
                        pps.close();
                        JOptionPane.showMessageDialog(null, "Vehículo dado de salida.");
                        limpiar();
                        bloquear();
                   } catch (SQLException ex) {
                       Logger.getLogger(Rate.class.getName()).log(Level.SEVERE, null, ex);
                   }
                }
            }else{
                JOptionPane.showMessageDialog(null, "El pago ingresado no correspode a la cantidad a pagar, Por favor verifique.");
            }            
        }else{
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad de efectivo al pago que debe realizar"); 
        }  
    }//GEN-LAST:event_btn_liquidacionActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void txt_tarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tarifaActionPerformed

    private void txt_pagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pagoKeyReleased
       
    }//GEN-LAST:event_txt_pagoKeyReleased

    private void txt_efectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_efectivoKeyReleased
       
        if (!txt_efectivo.getText().equals("")) {
             String payValued = txt_pago.getText();
             String payCash = txt_efectivo.getText();

             Integer cashPay = Integer.parseInt(payCash);
             Integer changePay = Integer.parseInt(payValued);
             
             int valor_pagado = cashPay - changePay;
             
             String enteroString = Integer.toString(valor_pagado);
             txt_cambio.setText(enteroString); 
        }else{
         txt_cambio.setText("");
        }     
       
    }//GEN-LAST:event_txt_efectivoKeyReleased

    private void txt_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipoActionPerformed

    private void txt_placaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_placaKeyTyped
        // Limite caracteres placa
        int characterLimit = 15;
        if (txt_placa.getText().length() >= characterLimit){
            evt.consume();
        }
    }//GEN-LAST:event_txt_placaKeyTyped

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
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_ingreso;
    public static javax.swing.JButton btn_liquidacion;
    private javax.swing.JButton btn_nuevo_ingreso;
    private javax.swing.JButton btn_pendiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jbl_hours;
    private javax.swing.JComboBox<String> jcb_vehiculo;
    private rojeru_san.componentes.RSCalendar rs_calendar;
    private javax.swing.JTextField txt_cambio;
    public static javax.swing.JTextField txt_efectivo;
    public static javax.swing.JTextField txt_fecha_entrada;
    public static javax.swing.JTextField txt_fecha_salida;
    public static javax.swing.JTextField txt_hora_entrada;
    public static javax.swing.JTextField txt_hora_salida;
    public static javax.swing.JTextField txt_pago;
    public static javax.swing.JTextField txt_placa;
    public static javax.swing.JTextField txt_tarifa;
    public static javax.swing.JTextField txt_tiempo;
    public static javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
