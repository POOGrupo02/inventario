package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.Cliente;
import claseshijo.FormaPago;
import claseshijo.SalidaProducto;
import mysql.FormaPagoDAO;
import mysql.ProductoDAO;
import mysql.SalidasDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GuiSalida extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel wqe;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JLabel lblNewLabel = new JLabel("Carrito de compras");
	private final JLabel lblNewLabel_1 = new JLabel("Código de producto");
	private final JTextField txtCodProd = new JTextField();
	private final JLabel lblNewLabel_1_1 = new JLabel("Cliente");
	private final JButton btnAgregarProd = new JButton("Agregar al carrito");
	private final JLabel lblNewLabel_2 = new JLabel("DNI");
	private final JTextField txtDni = new JTextField();
	private final JLabel lblNewLabel_2_1 = new JLabel("Nombre");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblNewLabel_2_1_1 = new JLabel("Apellido");
	private final JTextField txtApellido = new JTextField();
	private final JLabel lblNewLabel_2_1_1_1 = new JLabel("Sexo");
	private final JComboBox cboSexo = new JComboBox();
	private final JLabel lblNewLabel_2_1_2 = new JLabel("celular");
	private final JTextField txtCelular = new JTextField();
	private final JLabel lblNewLabel_2_1_2_1 = new JLabel("(opcional)");
	private ProductoDAO pDAO = new ProductoDAO();
	private ArrayList<Producto> productosCarrito = new ArrayList<Producto>();
	private String[] columnasCarrito = { "CODIGO PRODUCTO", "NOMBRE", "PRECIO", "CANTIDAD" , "TOTAL"};
	private String[] columnasSalidas = { "ID", "CLIENTE", "CODIGO PRODUCTO", "PRODUCTO", "CANTIDAD",
			"MONTO", "FORMA DE PAGO", "CREATED_AT"};
	private final JButton btnPlus = new JButton("");
	private final JButton btnMinus = new JButton("");
	private final JTextField txtCantProd = new JTextField();
	private ArrayList<Integer> listCantProd = new ArrayList<Integer>();
	private int cantProd = 1;
	private Object[][] datosCarrito = null;
	private Object[][] datosSalida = null;
	private FormaPagoDAO fPgDAO = new FormaPagoDAO();
	private ArrayList<FormaPago> fPg = fPgDAO.readFormasPagos();
	private SalidasDAO sDAO = new SalidasDAO();
	private ArrayList<SalidaProducto> salidas = sDAO.readSalidas();
	ArrayList<Integer> formasPago = new ArrayList<>();
	private final JTextField txtCodProdElim = new JTextField();
	private final JLabel lblNewLabel_1_2 = new JLabel("Eliminar producto del carrito");
	private final JButton btnEliminarDelCarrito = new JButton("Eliminar del carrito");
	private final JButton btnRegistrarVenta = new JButton("Registrar venta");
	private final JLabel lblNewLabel_2_1_2_2 = new JLabel("Formas de pago");
	private final JComboBox<String> cboFormPag = new JComboBox<>();
	private final JButton btnAgregarFormPag = new JButton("Agregar forma de pago");
	private final JLabel lblFormPag = new JLabel("Formas de pago seleccionadas:");
	private final JComboBox<String> cboProducto = new JComboBox<>();
	private final JLabel lblNewLabel_1_3 = new JLabel("Buscar código");
	private final JButton btnBuscar = new JButton("Buscar");
	private ArrayList<Producto> productos = pDAO.readProds();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table1 = new JTable();
	private final JLabel lblNewLabel_1_4 = new JLabel("Salidas");
	private final JButton btnSalir = new JButton("SALIR");
	private JLabel lblNewLabel_3;
	private String formsPgsTxt = "";
	private final JButton btnGuardarLista = new JButton("Guardar Lista");
	private final JButton btnEliminarFormPg = new JButton("Eliminar");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSalida frame = new GuiSalida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiSalida() {
		txtCantProd.setEditable(false);
		txtCantProd.setBounds(378, 40, 39, 20);
		txtCantProd.setColumns(10);
		txtDni.setBounds(83, 101, 126, 20);
		txtDni.setColumns(10);
		txtCodProd.setBounds(154, 40, 86, 20);
		txtCodProd.setColumns(10);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 939, 754);
		wqe = new JPanel();
		wqe.setBackground(new Color(128, 255, 255));
		wqe.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(wqe);
		wqe.setLayout(null);
		{
			scrollPane.setBounds(566, 60, 347, 335);
			wqe.add(scrollPane);
			datosCarrito = new Object[productosCarrito.size()][columnasCarrito.length];

			table.setModel(new DefaultTableModel(datosCarrito, columnasCarrito));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			txtCantProd.setText(cantProd+"");
			
			
			showTableSalidas();
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(566, 35, 148, 14);
			wqe.add(lblNewLabel);
		}
		{
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 11, 140, 17);
			wqe.add(lblNewLabel_1);
		}
		{
			wqe.add(txtCodProd);
		}
		{
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(10, 79, 86, 14);
			wqe.add(lblNewLabel_1_1);
		}
		{
			btnAgregarProd.addActionListener(this);
			btnAgregarProd.setBounds(338, 65, 148, 23);
			wqe.add(btnAgregarProd);
		}
		{
			lblNewLabel_2.setBounds(10, 104, 46, 14);
			wqe.add(lblNewLabel_2);
		}
		{
			wqe.add(txtDni);
		}
		{
			lblNewLabel_2_1.setBounds(10, 145, 46, 14);
			wqe.add(lblNewLabel_2_1);
		}
		{
			txtNombre.setColumns(10);
			txtNombre.setBounds(83, 142, 126, 20);
			wqe.add(txtNombre);
		}
		{
			lblNewLabel_2_1_1.setBounds(10, 184, 46, 14);
			wqe.add(lblNewLabel_2_1_1);
		}
		{
			txtApellido.setColumns(10);
			txtApellido.setBounds(83, 181, 126, 20);
			wqe.add(txtApellido);
		}
		{
			lblNewLabel_2_1_1_1.setBounds(10, 223, 46, 14);
			wqe.add(lblNewLabel_2_1_1_1);
		}
		{
			cboSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Femenino", "Masculino"}));
			cboSexo.setBounds(83, 219, 126, 22);
			wqe.add(cboSexo);
		}
		{
			lblNewLabel_2_1_2.setBounds(10, 263, 46, 14);
			wqe.add(lblNewLabel_2_1_2);
		}
		{
			txtCelular.setColumns(10);
			txtCelular.setBounds(83, 260, 126, 20);
			wqe.add(txtCelular);
		}
		{
			lblNewLabel_2_1_2_1.setBounds(219, 263, 78, 14);
			wqe.add(lblNewLabel_2_1_2_1);
		}
		{
			btnPlus.addActionListener(this);
			btnPlus.setIcon(new ImageIcon(GuiSalida.class.getResource("/images/mas.png")));
			btnPlus.setBounds(427, 36, 24, 23);
			wqe.add(btnPlus);
		}
		{
			btnMinus.addActionListener(this);
			btnMinus.setIcon(new ImageIcon(GuiSalida.class.getResource("/images/menos.png")));
			btnMinus.setBounds(338, 37, 24, 23);
			wqe.add(btnMinus);
		}
		{
			wqe.add(txtCantProd);
		}
		{
			txtCodProdElim.setColumns(10);
			txtCodProdElim.setBounds(10, 392, 86, 20);
			wqe.add(txtCodProdElim);
		}
		{
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_2.setBounds(10, 366, 239, 14);
			wqe.add(lblNewLabel_1_2);
		}
		{
			btnEliminarDelCarrito.addActionListener(this);
			btnEliminarDelCarrito.setBounds(114, 391, 157, 23);
			wqe.add(btnEliminarDelCarrito);
		}
		{
			btnRegistrarVenta.addActionListener(this);
			btnRegistrarVenta.setBounds(566, 406, 157, 23);
			wqe.add(btnRegistrarVenta);
		}
		{
			lblNewLabel_2_1_2_2.setBounds(10, 301, 105, 14);
			wqe.add(lblNewLabel_2_1_2_2);
		}
		{
			cboFormPag.setBounds(114, 297, 126, 22);
			wqe.add(cboFormPag);
		}
		{
			btnAgregarFormPag.addActionListener(this);
			btnAgregarFormPag.setBounds(250, 297, 167, 23);
			wqe.add(btnAgregarFormPag);
		}
		{
			lblFormPag.setBounds(10, 337, 504, 14);
			wqe.add(lblFormPag);
		}
		{
			cboProducto.setBounds(10, 39, 126, 22);
			wqe.add(cboProducto);
		}
		{
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_3.setBounds(154, 13, 97, 16);
			wqe.add(lblNewLabel_1_3);
		}
		{
			btnBuscar.addActionListener(this);
			btnBuscar.setBounds(250, 39, 78, 23);
			wqe.add(btnBuscar);
		}
		{
			scrollPane_1.setBounds(10, 478, 722, 212);
			wqe.add(scrollPane_1);
		}
		{
			scrollPane_1.setViewportView(table1);
		}
		{
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1_4.setBounds(10, 453, 140, 14);
			wqe.add(lblNewLabel_1_4);
		}
		{
			btnSalir.addActionListener(this);
			btnSalir.setBounds(338, 391, 148, 23);
			wqe.add(btnSalir);
		}
		{
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon(GuiSalida.class.getResource("/images/venta.png")));
			lblNewLabel_3.setBounds(307, 108, 217, 167);
			wqe.add(lblNewLabel_3);
		}
		{
			btnGuardarLista.addActionListener(this);
			btnGuardarLista.setBounds(742, 667, 119, 23);
			wqe.add(btnGuardarLista);
		}
		{
			btnEliminarFormPg.addActionListener(this);
			btnEliminarFormPg.setBounds(427, 297, 97, 23);
			wqe.add(btnEliminarFormPg);
		}
		cboProducto.addItem("");
		cboFormPag.addItem("");
		
		for (int i = 0; i < fPg.size(); i++) {
			cboFormPag.addItem(fPg.get(i).getNombre());
		}
		
		for (int i = 0; i < productos.size(); i++) {
			cboProducto.addItem(productos.get(i).getCodigoProducto());
		}
	}
	
	private void showTxtFormPg() {
		formsPgsTxt = "";
		for (int i = 0; i < formasPago.size(); i++) {
			for (int k = 0; k < fPg.size(); k++) {
				if(formasPago.get(i) == fPg.get(k).getId()) {
					formsPgsTxt += i > 0 ? (", "+fPg.get(k).getNombre()) : fPg.get(k).getNombre();
				}
			}
		}
		
		lblFormPag.setText("Formas de pago seleccionadas: "+formsPgsTxt);
	}
	
	private void showTableSalidas() {
		datosSalida = new Object[salidas.size()][8];

		for (int i = 0; i < salidas.size(); i++) {
			SalidaProducto sP = salidas.get(i);
			datosSalida[i][0] = sP.getId();
			datosSalida[i][1] = sP.getCliente();
			datosSalida[i][2] = sP.getCodProd();
			datosSalida[i][3] = sP.getProducto();
			datosSalida[i][4] = sP.getCantidad();
			datosSalida[i][5] = sP.getMonto();
			datosSalida[i][6] = sP.getFormaPago();
			datosSalida[i][7] = sP.getCreatedAt();
		}

		table1.setModel(new DefaultTableModel(datosSalida, columnasSalidas));
	}
	
	private void showTableCarrito() {
		datosCarrito = new Object[productosCarrito.size()][columnasCarrito.length];
		for(int i = 0; i < productosCarrito.size(); i++) {
			Producto p = productosCarrito.get(i);
			datosCarrito[i][0] = p.getCodigoProducto();
			datosCarrito[i][1] = p.getProd();
			datosCarrito[i][2] = p.getCostoBase() + p.getCostoBase() * (p.getPorcentMargen()/100);
			datosCarrito[i][3] = listCantProd.get(i);
			datosCarrito[i][4] = (p.getCostoBase() + p.getCostoBase() * (p.getPorcentMargen()/100)) * listCantProd.get(i);
		}
		table.setModel(new DefaultTableModel(datosCarrito, columnasCarrito));
	}
	
	private int getIdFormPag() {
		String formPag = cboFormPag.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < fPg.size(); i++) {
			if (fPg.get(i).getNombre().equals(formPag)) {
				id = fPg.get(i).getId();
			}
		}
		return id;
	}
	
	private void guardarListVentasCsv() {
		File archivo = new File("lista_ventas.csv");
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
				PrintWriter pw = new PrintWriter(writer)) {

			writer.write('\uFEFF');
			
			pw.println("ID;CLIENTE;CODIGO_PRODUCTO;PRODUCTO;CANTIDAD;MONTO;FORMA DE PAGO; CREATED_AT");

			for (int i = 0; i < salidas.size(); i++) {
				
				SalidaProducto sP = salidas.get(i);
				
				pw.println(sP.getId() + ";" + sP.getCliente() + ";" + sP.getCodProd() + ";" + sP.getProducto() + ";" + sP.getCantidad() + ";" +
						sP.getMonto() + ";" + sP.getFormaPago() + ";" + sP.getCreatedAt());

			}
			JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}
	}
	
	private void guardarVentaCsv() {
		File archivo = new File("venta.csv");
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
				PrintWriter pw = new PrintWriter(writer)) {

			writer.write('\uFEFF');

			pw.println(String.join(";", columnasCarrito));
			
			double montoTotal = 0.0;

			for (int i = 0; i < productosCarrito.size(); i++) {
				
				String codigo = datosCarrito[i][0].toString();
				String nombre = datosCarrito[i][1].toString();
				String precio = datosCarrito[i][2].toString();
				String cantidad = datosCarrito[i][3].toString();
				String total = datosCarrito[i][4].toString();
				
				try {
					montoTotal += Double.parseDouble(total);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error al obtener el monto total.");
				}
				
				pw.println(codigo + ";" + nombre + ";" + precio + ";" + cantidad + ";" + total);
			}
			
			pw.println();

			pw.println("MONTO TOTAL;;;;" + String.format("%.2f", montoTotal));
			
			pw.println();
			
			pw.println("FORMAS DE PAGO;;;;" + formsPgsTxt);

			JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}
	}
	
	private void limpiarGui() {
		productosCarrito.clear();
		listCantProd.clear();
		formasPago.clear();
		txtCodProd.setText("");
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		cboSexo.setSelectedIndex(0);
		txtCelular.setText("");
		cboFormPag.setSelectedIndex(0);
		cboProducto.setSelectedIndex(0);
		lblFormPag.setText("Formas de pago seleccionadas:");
		showTableCarrito();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminarFormPg) {
			do_btnEliminarFormPg_actionPerformed(e);
		}
		if (e.getSource() == btnGuardarLista) {
			do_btnGuardarLista_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnBuscar) {
			do_btnBuscar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarFormPag) {
			do_btnAgregarFormPag_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrarVenta) {
			do_btnRegistrarVenta_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarDelCarrito) {
			do_btnEliminarDelCarrito_actionPerformed(e);
		}
		if (e.getSource() == btnMinus) {
			do_btnMinus_actionPerformed(e);
		}
		if (e.getSource() == btnPlus) {
			do_btnPlus_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarProd) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			
			if(cboProducto.getSelectedIndex()== 0) {
				JOptionPane.showMessageDialog(this, "Seleccione un producto.");
				return;
			}
			
			boolean isAgregado = false;
			for (int i = 0; i < productosCarrito.size(); i++) {
				if(productosCarrito.get(i).getCodigoProducto().equals(cboProducto.getSelectedItem().toString())) {
					isAgregado = true;
				}
			}
			
			if(isAgregado) {
				JOptionPane.showMessageDialog(this, "El producto ya está agregado en el carrito.");
				return;
			}
			
			Producto producto = pDAO.readProdByCod(cboProducto.getSelectedItem().toString());
			
			if(producto.getStock() < cantProd) {
				int sobrePasa = cantProd - producto.getStock();
				JOptionPane.showMessageDialog(this, "La cantidad requerida para este producto sobrepasa en "+sobrePasa);
				return;
			}
			
			productosCarrito.add(producto);
			listCantProd.add(cantProd);
			showTableCarrito();
			cantProd = 1;
			txtCantProd.setText(cantProd+"");
			txtCodProd.setText("");
			cboProducto.setSelectedIndex(0);
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Error al registrar producto."+e1);
		}
	}
	protected void do_btnPlus_actionPerformed(ActionEvent e) {
		cantProd++;
		txtCantProd.setText(cantProd+"");
	}
	protected void do_btnMinus_actionPerformed(ActionEvent e) {
		if(cantProd==1) {
			return;
		}else {
			cantProd--;
			txtCantProd.setText(cantProd+"");
		}
	}
	protected void do_btnEliminarDelCarrito_actionPerformed(ActionEvent e) {
		if(txtCodProdElim.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "El campo de código producto está vacío.");
			return;
		}
		
		String prodElim = txtCodProdElim.getText().trim();
		
		boolean isDeleted = false;
		for (int i = 0; i < productosCarrito.size(); i++) {
			if(productosCarrito.get(i).getCodigoProducto().equalsIgnoreCase(prodElim)) {
				productosCarrito.remove(i);
				listCantProd.remove(i);
				isDeleted = true;
			}
		}
		
		if(isDeleted) {
			txtCodProdElim.setText("");
			showTableCarrito();
		}else {
			JOptionPane.showMessageDialog(this, "El producto no está agregado en el carrito.");
			return;
		}
	}
	protected void do_btnRegistrarVenta_actionPerformed(ActionEvent e) {
		ArrayList<SalidaProducto> listSalida = new ArrayList<>();
		if(productosCarrito.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No se encuentra ningún producto en el carrito.");
			return;
		}
		if(formasPago.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No se ha seleccionada por lo menos una forma de pago.");
			return;
		}
		
		if(txtDni.getText().isBlank() || txtNombre.getText().isBlank() || txtApellido.getText().isBlank() || cboSexo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Los campos obligatorios para cliente no pueden estar.");
			return;
		}
		
		if(txtDni.getText().length()!=8) {
			JOptionPane.showMessageDialog(this, "La cantidad de números en un DNI solo es de 8.");
			return;
		}
		
		for (int i = 0; i < productosCarrito.size(); i++) {
			SalidaProducto sP = new SalidaProducto();
			sP.setProducto(String.valueOf(productosCarrito.get(i).getIdProducto()));
			sP.setCantidad(Integer.parseInt(datosCarrito[i][3].toString()));
			sP.setMonto(Double.parseDouble(datosCarrito[i][4].toString()));
			listSalida.add(sP);
		}
		Cliente cliente = new Cliente();
		cliente.setDni(txtDni.getText());
		cliente.setNombre(txtNombre.getText());
		cliente.setApellido(txtApellido.getText());
		cliente.setSexo(cboSexo.getSelectedItem().toString());
		cliente.setCelular(txtCelular.getText());
		
		 if (sDAO.createSalidas(listSalida, formasPago, cliente)) {
			 JOptionPane.showMessageDialog(this, "Venta registrada con éxito. Puede visualizarlo en el archivo .csv generado.");
			 guardarVentaCsv();
			 limpiarGui();
			 salidas = sDAO.readSalidas();
			 showTableSalidas();
		 }else {
			 JOptionPane.showMessageDialog(this, "Hubo un error al momento de registrar le venta.");
		 }
	}
	protected void do_btnAgregarFormPag_actionPerformed(ActionEvent e) {
		if(cboFormPag.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(this, "Elija la forma de pago.");
			return;
		}
		
		for (int i = 0; i < formasPago.size(); i++) {
			if(formasPago.get(i) == getIdFormPag()) {
				JOptionPane.showMessageDialog(this, "Ya está registrada esta forma de pago.");
				return;
			}
		}
		
		formasPago.add(getIdFormPag());
		
		showTxtFormPg();
		
		cboFormPag.setSelectedIndex(0);
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent e) {
		
		if(txtCodProd.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "El campo de código producto está vacío.");
			return;
		}
		
		for (int i = 0; i < productos.size(); i++) {
			if(productos.get(i).getCodigoProducto().equalsIgnoreCase(txtCodProd.getText())) {
				cboProducto.setSelectedItem(productos.get(i).getCodigoProducto());
				txtCodProd.setText("");
				return;
			}
		}
		
		JOptionPane.showMessageDialog(this, "No se encontró el código.");
		
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnGuardarLista_actionPerformed(ActionEvent e) {
		guardarListVentasCsv();
	}
	protected void do_btnEliminarFormPg_actionPerformed(ActionEvent e) {
		
		if(formasPago.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay ninguna forma de pago para eliminar.");
			return;
		}
		
		if(cboFormPag.getSelectedIndex()==0) {
			JOptionPane.showMessageDialog(this, "Elija la forma de pago que quiere eliminar.");
			return;
		}
		
		Boolean isDeleted = false;
		for (int i = 0; i < formasPago.size(); i++) {
			if(formasPago.get(i) == getIdFormPag()) {
				formasPago.remove(i);
				isDeleted = true;
			}
		}
		
		if(!isDeleted) {
			JOptionPane.showMessageDialog(this, "La forma de pago que quiere eliminar no se encuentra registrada.");
			return;
		}
		
		showTxtFormPg();
		
		cboFormPag.setSelectedIndex(0);
		
	}
}
