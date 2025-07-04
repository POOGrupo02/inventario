package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.Cliente;
import claseshijo.EntradaProducto;
import claseshijo.Proveedor;
import claseshijo.SalidaProducto;
import mysql.EntradasDAO;
import mysql.ProductoDAO;
import mysql.ProveedorDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiEntrada extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("RUC de proveedor");
	private final JComboBox<String> cboProveedor = new JComboBox<>();
	private final JLabel lblNewLabel_1 = new JLabel("Código de producto");
	private final JComboBox<String> cboProducto = new JComboBox<String>();
	private final JButton btnMinus = new JButton("");
	private final JTextField txtCantProd = new JTextField();
	private final JButton btnPlus = new JButton("");
	private final JButton btnAgregarProd = new JButton("Agregar a entradas");
	private final JLabel lblNewLabel_1_2 = new JLabel("Eliminar producto del carrito");
	private final JTextField txtCodProdElim = new JTextField();
	private final JButton btnEliminarDeEntrada = new JButton("Eliminar de las entradas");
	private final JLabel lblNewLabel_1_1 = new JLabel("Productos añadidos");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JButton btnNewButton = new JButton("Registrar entrada");
	private EntradasDAO eDAO = new EntradasDAO();
	private ArrayList<EntradaProducto> entradas = eDAO.readEntradas();
	private ProductoDAO pDAO = new ProductoDAO();
	private ProveedorDAO provDAO = new ProveedorDAO();
	private ArrayList<Proveedor> proveedores = new ArrayList<>();
	private ArrayList<Producto> productos = pDAO.readProds();
	private ArrayList<Integer> listCantProd = new ArrayList<Integer>();
	private ArrayList<Producto> productosEntrada = new ArrayList<Producto>();
	private String[] columnasRegisEntr = { "CODIGO PRODUCTO", "NOMBRE", "PRECIO", "CANTIDAD", "TOTAL" };
	private String[] columnasEntrada = { "ID", "CODIGO PRODUCTO", "PRODUCTO", "CANTIDAD",
			"MONTO", "PROVEEDOR", "CREATED_AT"};
	private Object[][] datosRegisEntr = null;
	private Object[][] datosEntrada = null;
	private int cantProd = 1;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table1 = new JTable();
	private final JLabel lblNewLabel_1_4 = new JLabel("Entradas");
	private JButton btnSalir;
	private final JLabel lblNewLabel_2 = new JLabel("New label");
	private final JButton btnGuardarLista = new JButton("Guardar Lista");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiEntrada frame = new GuiEntrada();
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
	public GuiEntrada() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1003, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 83, 129, 14);
			contentPane.add(lblNewLabel);
			
			datosRegisEntr = new Object[productosEntrada.size()][columnasRegisEntr.length];
			table.setModel(new DefaultTableModel(datosRegisEntr, columnasRegisEntr));
			
			showTableEntradas();
		}
		{
			cboProveedor.setBounds(10, 110, 119, 22);
			contentPane.add(cboProveedor);
		}
		{
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(10, 11, 140, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			cboProducto.addActionListener(this);
			cboProducto.setBounds(10, 39, 126, 22);
			contentPane.add(cboProducto);
		}
		{
			btnMinus.addActionListener(this);
			btnMinus.setIcon(new ImageIcon(GuiEntrada.class.getResource("/images/menos.png")));
			btnMinus.setBounds(338, 37, 24, 23);
			contentPane.add(btnMinus);
		}
		{
			txtCantProd.setText("1");
			txtCantProd.setEditable(false);
			txtCantProd.setColumns(10);
			txtCantProd.setBounds(378, 40, 39, 20);
			contentPane.add(txtCantProd);
		}
		{
			btnPlus.addActionListener(this);
			btnPlus.setIcon(new ImageIcon(GuiEntrada.class.getResource("/images/mas.png")));
			btnPlus.setBounds(427, 36, 24, 23);
			contentPane.add(btnPlus);
		}
		{
			btnAgregarProd.addActionListener(this);
			btnAgregarProd.setBounds(338, 88, 148, 23);
			contentPane.add(btnAgregarProd);
		}
		{
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_2.setBounds(10, 152, 239, 14);
			contentPane.add(lblNewLabel_1_2);
		}
		{
			txtCodProdElim.setColumns(10);
			txtCodProdElim.setBounds(10, 178, 86, 20);
			contentPane.add(txtCodProdElim);
		}
		{
			btnEliminarDeEntrada.addActionListener(this);
			btnEliminarDeEntrada.setBounds(114, 177, 184, 23);
			contentPane.add(btnEliminarDeEntrada);
		}
		{
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(547, 11, 140, 14);
			contentPane.add(lblNewLabel_1_1);
		}
		{
			scrollPane.setBounds(546, 37, 431, 212);
			contentPane.add(scrollPane);
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(547, 272, 140, 23);
			contentPane.add(btnNewButton);
		}
		{
			scrollPane_1.setBounds(10, 396, 694, 295);
			contentPane.add(scrollPane_1);
		}
		{
			scrollPane_1.setViewportView(table1);
		}
		{
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1_4.setBounds(10, 361, 140, 14);
			contentPane.add(lblNewLabel_1_4);
		}
		
		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(735, 399, 148, 23);
		contentPane.add(btnSalir);
		{
			lblNewLabel_2.setIcon(new ImageIcon(GuiEntrada.class.getResource("/images/Stock.jpg")));
			lblNewLabel_2.setBounds(10, 209, 200, 133);
			contentPane.add(lblNewLabel_2);
		}
		{
			btnGuardarLista.addActionListener(this);
			btnGuardarLista.setBounds(714, 668, 119, 23);
			contentPane.add(btnGuardarLista);
		}
		
		cboProducto.addItem("");
		
		for (int i = 0; i < productos.size(); i++) {
			cboProducto.addItem(productos.get(i).getCodigoProducto());
		}
	}
	
	private void guardarListEntradasCsv() {
		File archivo = new File("lista_entradas.csv");
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
				PrintWriter pw = new PrintWriter(writer)) {

			writer.write('\uFEFF');
			
			pw.println(String.join(";", columnasEntrada));

			for (int i = 0; i < entradas.size(); i++) {
				
				EntradaProducto sP = entradas.get(i);
				
				pw.println(sP.getId() + ";" + sP.getCodProd() + ";" + sP.getProducto() + ";" + sP.getCantidad() + ";" +
						sP.getMonto() + ";" + sP.getProveedor() + ";" + sP.getCreatedAt());

			}
			JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo"+e1);
		}
	}
	
	private void guardarEntradaCsv() {
		File archivo = new File("entrada.csv");
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
				PrintWriter pw = new PrintWriter(writer)) {

			writer.write('\uFEFF');

			pw.println(String.join(";", columnasRegisEntr));
			
			double montoTotal = 0.0;

			for (int i = 0; i < productosEntrada.size(); i++) {
				
				String codigo = datosRegisEntr[i][0].toString();
				String nombre = datosRegisEntr[i][1].toString();
				String precio = datosRegisEntr[i][2].toString();
				String cantidad = datosRegisEntr[i][3].toString();
				String total = datosRegisEntr[i][4].toString();
				
				try {
					montoTotal += Double.parseDouble(total);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error al obtener el monto total.");
				}
				
				pw.println(codigo + ";" + nombre + ";" + precio + ";" + cantidad + ";" + total);
			}
			
			pw.println();

			pw.println("MONTO TOTAL;;;;" + String.format("%.2f", montoTotal));

			JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}
	}
	
	private int getIdProdFilt() {
		String product = cboProducto.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < productos.size(); i++) {
			if (productos.get(i).getCodigoProducto().equals(product)) {
				id = productos.get(i).getIdProducto();
			}
		}
		return id;
	}
	
	private void limpiarGui() {
		productosEntrada.clear();
		listCantProd.clear();
		cboProveedor.setSelectedIndex(0);
		cboProducto.setSelectedIndex(0);
		showTableRegiEnt();
	}
	
	private void showTableEntradas() {
		datosEntrada = new Object[entradas.size()][7];

		for (int i = 0; i < entradas.size(); i++) {
			EntradaProducto sP = entradas.get(i);
			datosEntrada[i][0] = sP.getId();
			datosEntrada[i][1] = sP.getCodProd();
			datosEntrada[i][2] = sP.getProducto();
			datosEntrada[i][3] = sP.getCantidad();
			datosEntrada[i][4] = sP.getMonto();
			datosEntrada[i][5] = sP.getProveedor();
			datosEntrada[i][6] = sP.getCreatedAt();
		}

		table1.setModel(new DefaultTableModel(datosEntrada, columnasEntrada));
	}
	
	private void showTableRegiEnt() {
		datosRegisEntr = new Object[productosEntrada.size()][columnasRegisEntr.length];
		for(int i = 0; i < productosEntrada.size(); i++) {
			Producto p = productosEntrada.get(i);
			datosRegisEntr[i][0] = p.getCodigoProducto();
			datosRegisEntr[i][1] = p.getProd();
			datosRegisEntr[i][2] = p.getCostoBase();
			datosRegisEntr[i][3] = listCantProd.get(i);
			datosRegisEntr[i][4] = p.getCostoBase() * listCantProd.get(i);
		}
		table.setModel(new DefaultTableModel(datosRegisEntr, columnasRegisEntr));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboProducto) {
			do_cboProducto_actionPerformed(e);
		}
		if (e.getSource() == btnGuardarLista) {
			do_btnGuardarLista_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		if (e.getSource() == btnMinus) {
			do_btnMinus_actionPerformed(e);
		}
		if (e.getSource() == btnPlus) {
			do_btnPlus_actionPerformed(e);
		}
		if (e.getSource() == btnEliminarDeEntrada) {
			do_btnEliminarDeEntrada_actionPerformed(e);
		}
		if (e.getSource() == btnAgregarProd) {
			do_btnAgregarProd_actionPerformed(e);
		}
	}

	protected void do_btnAgregarProd_actionPerformed(ActionEvent e) {
		try {

			if (cboProducto.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "Seleccione un producto.");
				return;
			}

			boolean isAgregado = false;
			for (int i = 0; i < productosEntrada.size(); i++) {
				if (productosEntrada.get(i).getCodigoProducto().equals(cboProducto.getSelectedItem().toString())) {
					isAgregado = true;
				}
			}

			if (isAgregado) {
				JOptionPane.showMessageDialog(this, "El producto ya está agregado en el carrito.");
				return;
			}

			Producto producto = pDAO.readProdByCod(cboProducto.getSelectedItem().toString());

			productosEntrada.add(producto);
			listCantProd.add(cantProd);
			showTableRegiEnt();
			cantProd = 1;
			txtCantProd.setText(cantProd + "");
			cboProducto.setSelectedIndex(0);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Error al registrar producto." + e1);
		}
	}

	protected void do_btnEliminarDeEntrada_actionPerformed(ActionEvent e) {
		if(txtCodProdElim.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "El campo de código producto está vacío.");
			return;
		}
		
		String prodElim = txtCodProdElim.getText().trim();
		
		boolean isDeleted = false;
		for (int i = 0; i < productosEntrada.size(); i++) {
			if(productosEntrada.get(i).getCodigoProducto().equalsIgnoreCase(prodElim)) {
				productosEntrada.remove(i);
				listCantProd.remove(i);
				isDeleted = true;
			}
		}
		
		if(isDeleted) {
			txtCodProdElim.setText("");
			showTableRegiEnt();
		}else {
			JOptionPane.showMessageDialog(this, "El producto no está agregado en el carrito.");
			return;
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
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			ArrayList<EntradaProducto> listEntrada = new ArrayList<>();
			if(productosEntrada.isEmpty()) {
				JOptionPane.showMessageDialog(this, "No se encuentra ningún producto en el carrito.");
				return;
			}
			
			if(cboProveedor.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(this, "No se ha seleccionado a ningún proveedor.");
				return;
			}
			
			for (int i = 0; i < productosEntrada.size(); i++) {
				EntradaProducto sP = new EntradaProducto();
				sP.setProducto(String.valueOf(productosEntrada.get(i).getIdProducto()));
				sP.setCantidad(Integer.parseInt(datosRegisEntr[i][3].toString()));
				sP.setMonto(Double.parseDouble(datosRegisEntr[i][4].toString()));
				listEntrada.add(sP);
			}
			
			int idCliente = -1;
			for (int i = 0; i < proveedores.size(); i++) {
				if(proveedores.get(i).getRuc().equals(cboProveedor.getSelectedItem().toString())) {
					idCliente = proveedores.get(i).getId();
				}
			}
			
			 if (eDAO.createEntradas(listEntrada, idCliente)) {
				 JOptionPane.showMessageDialog(this, "Entrada registrada con éxito. Puede visualizarlo en el archivo .csv generado.");
				 guardarEntradaCsv();
				 limpiarGui();
				 entradas = eDAO.readEntradas();
				 showTableEntradas();
			 }else {
				 JOptionPane.showMessageDialog(this, "Hubo un error al momento de registrar le venta.");
			 }
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Hubo un error al momento de registrar le venta.");
		}
		
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
	protected void do_btnGuardarLista_actionPerformed(ActionEvent e) {
		guardarListEntradasCsv();
	}
	protected void do_cboProducto_actionPerformed(ActionEvent e) {
		cboProveedor.removeAllItems();
		cboProveedor.addItem("");
		proveedores = eDAO.readProvsByIdProd(getIdProdFilt());
		for (int i = 0; i < proveedores.size(); i++) {
			cboProveedor.addItem(proveedores.get(i).getRuc());
		}
	}
}
