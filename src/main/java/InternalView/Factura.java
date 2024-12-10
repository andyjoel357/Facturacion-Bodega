package InternalView;

import conexion.conexion;
import controlador.RegistrarFactura;
import controlador.venta;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.DetalleVenta;
import modelo.cliente;

/**
 *
 * @author joelj
 */
public class Factura extends javax.swing.JFrame {

    private DefaultTableModel modeloDatosProductos;
    ArrayList<DetalleVenta> listarproductos = new ArrayList<>();
    private DetalleVenta producto;

    //Detalle de la venta de productos
    //BASE DE DATOS
    private int id_producto = 0;
    private String nombre = "";
    private int stock = 0; //stock en la db
    private double precio_unitario = 0.0;
    private int porcentajeiva = 0;

    //DETLLE VENTA
    private int cantidad = 0; //productos a comprar
    private double subtotal = 0.0; // cantidad por precio
    private double descuento = 0.0;
    private double iva = 0.0;
    private double total = 0.0;

    //Total
    private double subtotalGeneral = 0.0;
    private double totalGeneral = 0.0;
    // Nª detalle

    private int auxIdDetalle = 1;
    private int idDatos = 0;
    // constructor

    public Factura() {
        initComponents();
        this.setSize(new Dimension(1000, 550));
        this.setTitle("SISTEMA DE FACTURACION");
        //CArgar productos en el COMBO BOX
        this.iniTablaProductos();
        //Numero NotaVenta
        this.idDetalleVenta();
        num_factura.setText(String.valueOf(idDatos + 1));
    }

    private void iniTablaProductos() {
        modeloDatosProductos = new DefaultTableModel();

        //añadir columnbas
        modeloDatosProductos.addColumn("N");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("P. Unitario");
        modeloDatosProductos.addColumn("V. Total");

        //agregar los datos del mdoelo a la tabla
        this.visor.setModel(modeloDatosProductos);
    }

    public void listaTabla() {
        this.modeloDatosProductos.setRowCount(listarproductos.size());
        for (int i = 0; i < listarproductos.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listarproductos.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listarproductos.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listarproductos.get(i).getPrecio_unitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listarproductos.get(i).getTotal(), i, 4);
        }
        //AÑADIR AL JTABLE
        visor.setModel(modeloDatosProductos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numero = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cliente_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cliente_ci = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cliente_direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cliente_telf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cliente_correo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        num_factura = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        nombre_Cliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CI_cliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        direccion_cliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        telf_cliente = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        correo_cliente = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        apellido_cliente = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        visor = new javax.swing.JTable();
        eliminar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        bsc_codigo = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        bsc_nombre = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        unidades = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        clc_iva = new javax.swing.JTextField();
        cobrar = new javax.swing.JButton();
        cobrar1 = new javax.swing.JButton();

        numero.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Factura Numero:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Cliente"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        cliente_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_nombreKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Direccion:");

        cliente_ci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_ciKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("RUC/CI:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Telefono:");

        cliente_telf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cliente_telfKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Correo /E-mail:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cliente_ci, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliente_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cliente_telf, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addGap(18, 18, 18)
                .addComponent(cliente_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cliente_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cliente_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cliente_ci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cliente_telf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(cliente_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("MENU");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Telefono: ----------");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("VENTA AL POR MAYOR Y MENOR DE VIVERES");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nombre Bodega");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel12)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        num_factura.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        num_factura.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Factura Numero:");

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Black", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre:");

        nombre_Cliente.setBackground(new java.awt.Color(153, 153, 255));
        nombre_Cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombre_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        nombre_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_ClienteKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Direccion:");

        CI_cliente.setBackground(new java.awt.Color(153, 153, 255));
        CI_cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CI_cliente.setForeground(new java.awt.Color(0, 0, 0));
        CI_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CI_clienteKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("RUC/CI:");

        direccion_cliente.setBackground(new java.awt.Color(153, 153, 255));
        direccion_cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        direccion_cliente.setForeground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Telefono:");

        telf_cliente.setBackground(new java.awt.Color(153, 153, 255));
        telf_cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        telf_cliente.setForeground(new java.awt.Color(0, 0, 0));
        telf_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telf_clienteKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Correo /E-mail:");

        correo_cliente.setBackground(new java.awt.Color(153, 153, 255));
        correo_cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        correo_cliente.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Apellido:");

        apellido_cliente.setBackground(new java.awt.Color(153, 153, 255));
        apellido_cliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        apellido_cliente.setForeground(new java.awt.Color(0, 0, 0));
        apellido_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellido_clienteActionPerformed(evt);
            }
        });
        apellido_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellido_clienteKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CI_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(correo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nombre_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apellido_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(direccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombre_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(direccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20)
                        .addComponent(apellido_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CI_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(telf_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(correo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos adquiridos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto Black", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        visor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        visor.setForeground(new java.awt.Color(0, 0, 0));
        visor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Unidades", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        visor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(visor);

        eliminar.setBackground(new java.awt.Color(0, 204, 0));
        eliminar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("ELIMINAR");
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Codigo:");

        bsc_codigo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Producto:");

        bsc_nombre.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        buscar.setBackground(new java.awt.Color(51, 51, 255));
        buscar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 255, 255));
        buscar.setText("Buscar");
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        agregar.setBackground(new java.awt.Color(102, 204, 255));
        agregar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        agregar.setForeground(new java.awt.Color(255, 255, 255));
        agregar.setText("Añadir Producto");
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Unidades:");

        unidades.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(145, 145, 145)
                                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(agregar))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(9, 9, 9)
                                        .addComponent(bsc_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bsc_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(15, 15, 15)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(bsc_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(bsc_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(unidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Impuestos"));

        jLabel17.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Subtotal:");

        txt_subtotal.setBackground(new java.awt.Color(153, 153, 255));
        txt_subtotal.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Desc. %:");

        txt_total.setBackground(new java.awt.Color(153, 153, 255));
        txt_total.setForeground(new java.awt.Color(0, 0, 0));

        jLabel19.setBackground(new java.awt.Color(255, 51, 51));
        jLabel19.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Total:");

        clc_iva.setBackground(new java.awt.Color(153, 153, 255));
        clc_iva.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        clc_iva.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19))
                    .addComponent(jLabel17))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(clc_iva, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_subtotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(clc_iva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cobrar.setBackground(new java.awt.Color(0, 153, 153));
        cobrar.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        cobrar.setForeground(new java.awt.Color(255, 255, 255));
        cobrar.setText("FACTURAR");
        cobrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cobrarActionPerformed(evt);
            }
        });

        cobrar1.setBackground(new java.awt.Color(0, 153, 153));
        cobrar1.setFont(new java.awt.Font("Roboto Black", 1, 18)); // NOI18N
        cobrar1.setForeground(new java.awt.Color(255, 255, 255));
        cobrar1.setText("NOTA DE VENTA");
        cobrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cobrar1)
                                            .addComponent(cobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(num_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cobrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cliente_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_nombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c < 'z') && (c < 'A' || c < 'Z'))
            evt.consume();
    }//GEN-LAST:event_cliente_nombreKeyTyped

    private void cliente_ciKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_ciKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_cliente_ciKeyTyped

    private void cliente_telfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cliente_telfKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_cliente_telfKeyTyped

    private void nombre_ClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_ClienteKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c < 'z') && (c < 'A' || c < 'Z'))
            evt.consume();
    }//GEN-LAST:event_nombre_ClienteKeyTyped

    private void CI_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CI_clienteKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_CI_clienteKeyTyped

    private void telf_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telf_clienteKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
    }//GEN-LAST:event_telf_clienteKeyTyped

    private void apellido_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido_clienteKeyTyped
        char c = evt.getKeyChar();
        if ((c < 'a' || c < 'z') && (c < 'A' || c < 'Z'))
            evt.consume();
    }//GEN-LAST:event_apellido_clienteKeyTyped

    private void apellido_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellido_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellido_clienteActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String pBuscarCodigo = bsc_codigo.getText().trim();
        String pBuscarNombre = bsc_nombre.getText().trim();
        createFilteredTableModel(visor, pBuscarNombre, pBuscarCodigo);
    }//GEN-LAST:event_buscarActionPerformed

    private void createFilteredTableModel(JTable table, String nombreFilter, String codigoFilter) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Codigo de Barra");
        model.addColumn("Nombre");
        model.addColumn("Descripcion");
        model.addColumn("Precio Unitario");
        model.addColumn("Stock");
        model.addColumn("Categoria");
        model.addColumn("Fecha");

        StringBuilder sql = new StringBuilder("SELECT * FROM productos WHERE 1=1");

        if (!nombreFilter.isEmpty()) {
            sql.append(" AND nombre LIKE '%").append(nombreFilter).append("%'");
        }
        if (!codigoFilter.isEmpty()) {
            sql.append(" AND codigo_barra LIKE '%").append(codigoFilter).append("%'");
        }

        try (Connection cn = conexion.conectar(); Statement st = cn.createStatement(); ResultSet rs = st.executeQuery(sql.toString())) {

            while (rs.next()) {
                Object[] row = new Object[8];
                for (int i = 0; i < 8; i++) {
                    row[i] = rs.getObject(i + 1);
                }
                model.addRow(row);
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e);
        }

        table.setModel(model);
    }
    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed

        if (!unidades.getText().isEmpty() && unidades.getText().matches("\\d+")) {
            cantidad = Integer.parseInt(unidades.getText());

            // Get product data
            this.DatosDelProducto();

            // Check stock availability
            if (cantidad <= stock) {
                subtotal = precio_unitario * cantidad;
                subtotal = (double) Math.round(subtotal * 100) / 100;
                total += subtotal; // Update total

                // Create a new product entry
                producto = new DetalleVenta(
                        auxIdDetalle,
                        id_producto,
                        nombre,
                        cantidad,
                        precio_unitario,
                        subtotal,
                        iva,
                        subtotal
                );

                // Add to the product list
                listarproductos.add(producto);
                JOptionPane.showMessageDialog(null, "Producto Agregado");
                auxIdDetalle++;

                // Update stock
                stock -= cantidad;

                // Clear input fields
                unidades.setText("");
                bsc_codigo.setText("");

                // Recalculate totals
                this.calcularTotal();
                clc_iva.setText("");
                bsc_nombre.setText("");

                // Update subtotal and total fields
                txt_subtotal.setText(String.valueOf(total));
                double ivaCalculado = total * (iva / 100);
                double totalConIva = total + ivaCalculado;
                txt_total.setText(String.valueOf(totalConIva));

            } else {
                JOptionPane.showMessageDialog(null, "La cantidad supera Stock Actual: " + stock);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene el campo Cantidad");
        }

        // Update the table
        this.listaTabla();

    }//GEN-LAST:event_agregarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        this.Eliminar();
    }//GEN-LAST:event_eliminarActionPerformed

    private void visorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visorMouseClicked
        int selectedRowIndex = visor.getSelectedRow();
        int idArray = (int) visor.getValueAt(selectedRowIndex, 0);
        int ca = listarproductos.get(idArray - 1).getCantidad();
        String nombre = listarproductos.get(idArray - 1).getNombre();
        unidades.setText(String.valueOf(ca));
    }//GEN-LAST:event_visorMouseClicked

    private void cobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cobrarActionPerformed
        cliente Cliente = new cliente();
        DetalleVenta detalleVenta = new DetalleVenta();
        venta Venta = new venta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

         // Validaciones de campos
        if (nombre_Cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo Nombre");
        } else if (apellido_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo Apellido");
        } else if (direccion_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo Dirección");
        } else if (CI_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo Ruc / CI");
        } else if (CI_cliente.getText().length() > 13) {
            JOptionPane.showMessageDialog(null, "El campo Ruc / CI debe tener 13 dígitos");
        } else if (!CI_cliente.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El campo Ruc / CI solo acepta números");
        } else if (telf_cliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo Teléfono");
        } else if (telf_cliente.getText().length() > 10) {
            JOptionPane.showMessageDialog(null, "El campo Teléfono debe tener 10 dígitos");
        } else if (!telf_cliente.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "El campo Teléfono solo acepta números");
        } else if (listarproductos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Agregue al menos un Producto");
        } else if (txt_subtotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo Subtotal");
        } else if (!txt_subtotal.getText().matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(null, "El campo Subtotal debe ser un número válido");
        } else if (clc_iva.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Llene el campo IVA");
        } else if (!clc_iva.getText().matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(null, "El campo IVA debe ser un número válido");
        } else {
            // REGISTRAR cabecera
            Cliente.setId_cliente(0);
            Cliente.setNombre(nombre_Cliente.getText());
            Cliente.setApellido(apellido_cliente.getText());
            Cliente.setCorreo(correo_cliente.getText());
            Cliente.setCi(CI_cliente.getText());
            Cliente.setTelefono(telf_cliente.getText());
            Cliente.setDirecion(direccion_cliente.getText());

            if (Venta.guardarCabezera(Cliente)) {
                // Obtener id del dato guardado
                this.idDetalleVenta();
                JOptionPane.showMessageDialog(null, "Venta Registrada");
                calcularTotal();
                // Generar PDF
                RegistrarFactura pdf = new RegistrarFactura();
                pdf.Datos(idDatos);
                pdf.generarPDF();

                // GUARDAR DETALLE
                 for (DetalleVenta elemento : listarproductos) {
                    detalleVenta.setId_factura(idDatos);
                    detalleVenta.setId_producto(elemento.getId_producto());
                    detalleVenta.setNombre(elemento.getNombre());
                    detalleVenta.setCantidad(elemento.getCantidad());
                    detalleVenta.setPrecio_unitario(elemento.getPrecio_unitario());
                    detalleVenta.setSubtotal(elemento.getSubtotal());

                    if (Venta.guardarDetalle(detalleVenta)) {
                        // RESETEAR CAMPOS
                        nombre_Cliente.setText("");
                        apellido_cliente.setText("");
                        direccion_cliente.setText("");
                        CI_cliente.setText("");
                        telf_cliente.setText("");
                        correo_cliente.setText("");
                        txt_subtotal.setText("");
                        clc_iva.setText("");
                        txt_total.setText("");

                        // RESTAR STOCK
                        this.RestarStock(elemento.getId_producto(), elemento.getCantidad());
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar detalle");
                    }
                }

                // LIMPIAR LISTA
                listarproductos.clear();
                listaTabla();

            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar cabecera");
            }
        }

    }//GEN-LAST:event_cobrarActionPerformed

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
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Factura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Factura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CI_cliente;
    private javax.swing.JButton agregar;
    private javax.swing.JTextField apellido_cliente;
    private javax.swing.JTextField bsc_codigo;
    private javax.swing.JTextField bsc_nombre;
    private javax.swing.JButton buscar;
    public static javax.swing.JTextField clc_iva;
    private javax.swing.JTextField cliente_ci;
    private javax.swing.JTextField cliente_correo;
    private javax.swing.JTextField cliente_direccion;
    private javax.swing.JTextField cliente_nombre;
    private javax.swing.JTextField cliente_telf;
    private javax.swing.JButton cobrar;
    private javax.swing.JButton cobrar1;
    private javax.swing.JTextField correo_cliente;
    private javax.swing.JTextField direccion_cliente;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre_Cliente;
    private javax.swing.JLabel num_factura;
    private javax.swing.JLabel numero;
    private javax.swing.JTextField telf_cliente;
    public static javax.swing.JTextField txt_subtotal;
    public static javax.swing.JTextField txt_total;
    private javax.swing.JTextField unidades;
    public static javax.swing.JTable visor;
    // End of variables declaration//GEN-END:variables

    private void DatosDelProducto() {
        try {
            String sql = "SELECT * FROM productos WHERE codigo_barra = '" + this.bsc_codigo.getText() + "'";
            Connection cn = conexion.conectar();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) { // Check if a result is returned
                id_producto = rs.getInt("id_producto");
                nombre = rs.getString("nombre");
                stock = rs.getInt("stock");
                precio_unitario = rs.getDouble("precio_unitario");
                System.out.println("Producto encontrado: " + nombre + ", Precio Unitario: " + precio_unitario); // Debugging line
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto: " + e);
        }
    }

    private void idDetalleVenta() {

        try {
            Connection cn = conexion.conectar();
            String sql = "SELECT * FROM clientes ORDER BY id_cliente DESC LIMIT 1";
            Statement st;
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idDatos = rs.getInt("id_cliente");
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar Id" + e);
        }
    }

    public void calcularTotal() {
    subtotalGeneral = 0;
    double ivaPorcentaje = 0; // Inicializar el porcentaje de IVA
    double ivaTotal = 0;

    try {
        // Obtener el porcentaje de IVA desde el campo clc_iva
        String ivaInput = clc_iva.getText().trim();
        if (!ivaInput.isEmpty() && ivaInput.matches("\\d+")) {
            int ivaEntero = Integer.parseInt(ivaInput);
            ivaPorcentaje = ivaEntero / 100.0; // Convertir a decimal
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un porcentaje de IVA válido.");
            return; // Salir del método si el IVA no es válido
        }

        // Solo calcular el subtotal
        for (DetalleVenta elemento : listarproductos) {
            double subtotalElemento = elemento.getPrecio_unitario() * elemento.getCantidad();
            elemento.setSubtotal(subtotalElemento);
            subtotalGeneral += subtotalElemento;
        }

        // Redondear el subtotal
        subtotalGeneral = (double) Math.round(subtotalGeneral * 100) / 100;

        // Calcular el IVA
        ivaTotal = subtotalGeneral * ivaPorcentaje;
        ivaTotal = (double) Math.round(ivaTotal * 100) / 100;

        // Calcular el total
        double totalGeneral = subtotalGeneral + ivaTotal;
        totalGeneral = (double) Math.round(totalGeneral * 100) / 100;

        // Actualizar la interfaz
        txt_subtotal.setText(String.valueOf(subtotalGeneral));
        txt_total.setText(String.valueOf(totalGeneral)); // Actualizar el total con IVA

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al calcular el total.");
    }
}

    private void Eliminar() {
        int idArray = 0;
        int selectedRowIndex = visor.getSelectedRow();

        // If a row is selected
        if (selectedRowIndex != -1) {
            idArray = (int) modeloDatosProductos.getValueAt(selectedRowIndex, 0);
            int option = JOptionPane.showConfirmDialog(null, "Esta Seguro de Eliminar este producto?", "!ADVERTENCIA!", JOptionPane.YES_NO_OPTION);

            switch (option) {
                case 0://Si
                    listarproductos.remove(idArray - 1);
                    modeloDatosProductos.removeRow(selectedRowIndex);
                    this.calcularTotal();
                    //limpiar campos
                    unidades.setText("");
                    break;
                case 1://No 
                    visor.clearSelection();
                    //limpiar campos
                    unidades.setText("");
                    break;
                default:
                    visor.clearSelection();
                    //limpiar campos
                    unidades.setText("");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Item");
        }

    }

    private void RestarStock(int id, int cantidad) {
        int stockActual = 0;

        // Retrieve current stock
        try (Connection cn = conexion.conectar()) {
            String sql = "SELECT stock FROM productos WHERE id_producto = ?";
            PreparedStatement st = cn.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                stockActual = rs.getInt("stock");
            } else {
                System.out.println("Producto no encontrado con ID: " + id);
                return; // Exit if product is not found
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener stock: " + e.getMessage());
            return; // Exit on error
        }

        // Update stock
        int nuevoStock = stockActual - cantidad;
        if (nuevoStock < 0) {
            System.out.println("No hay suficiente stock para restar. Stock actual: " + stockActual + ", cantidad a restar: " + cantidad);
            return; // Exit if not enough stock
        }

        try (Connection cn = conexion.conectar()) {
            String sql = "UPDATE productos SET stock = ? WHERE id_producto = ?";
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setInt(1, nuevoStock);
            consulta.setInt(2, id);

            int filasActualizadas = consulta.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Stock actualizado correctamente. Nuevo stock: " + nuevoStock);
            } else {
                System.out.println("Error al actualizar el stock. ID del producto: " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error al restar stock: " + e.getMessage());
        }
    }

}
