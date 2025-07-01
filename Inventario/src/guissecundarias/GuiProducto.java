package guissecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;

import clasepadre.Producto;
import claseshijo.Marca;
import claseshijo.Presentacion;
import claseshijo.ProductoGeneral;
import claseshijo.UnidadMedida;
import mysql.MarcaDAO;
import mysql.PresentacionDAO;
import mysql.ProductoDAO;
import mysql.ProductoGeneralDAO;
import mysql.UnidadMedidaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import java.awt.Color;

public class GuiProducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCod;
	private JTextField txtStock;
	private JButton btnAgregar;
	private ProductoDAO pDAO = new ProductoDAO();
	private ProductoGeneralDAO pgDAO = new ProductoGeneralDAO();
	private PresentacionDAO prDAO = new PresentacionDAO();
	private UnidadMedidaDAO uDAO = new UnidadMedidaDAO();
	private MarcaDAO mDAO = new MarcaDAO();
	private ArrayList<Producto> productos = pDAO.readProds();
	private ArrayList<ProductoGeneral> pg = pgDAO.readProductosGenerales();
	private ArrayList<Marca> m = mDAO.readMarcas();
	private ArrayList<Presentacion> pr = prDAO.readPresentaciones();
	private ArrayList<UnidadMedida> u = uDAO.readUnidadesMedidas();
	private JDateChooser dateChooserFeVenc = new JDateChooser();
	private String[] columnas = { "CÓDIGO_PRODUCTO", "NOMBRE", "MARCA", "PRESENTACIÓN", "UNIDAD DE MEDIDA",
			"CANTIDAD_MEDIDA", "STOCK", "STOCK_MIN", "COSTO_BASE", "PORCENT_MARGEN", "FECHA_FABRICACION",
			"FECHA_VENCIMIENTO", "CREATED_AT", "UPDATED_AT" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiProducto dialog = new GuiProducto();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiProducto() {
		setModal(true);
		setTitle("Producto");
		setBounds(100, 100, 1087, 614);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			showTable();
		}

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(25, 17, 89, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Stock:");
		lblNewLabel_2.setBounds(25, 240, 63, 14);
		contentPanel.add(lblNewLabel_2);

		txtCod = new JTextField();
		txtCod.setBounds(187, 17, 86, 20);
		contentPanel.add(txtCod);
		txtCod.setColumns(10);

		txtStock = new JTextField();
		txtStock.setBounds(187, 237, 86, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);

		btnAgregar = new JButton("Registrar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(25, 514, 89, 23);
		contentPanel.add(btnAgregar);

		lblNewLabel_4 = new JLabel("Stock mínimo:");
		lblNewLabel_4.setBounds(25, 283, 81, 14);
		contentPanel.add(lblNewLabel_4);
		{
			txtStockMin.setColumns(10);
			txtStockMin.setBounds(187, 280, 86, 20);
			contentPanel.add(txtStockMin);
		}

		lblNewLabel_5 = new JLabel("Fecha de fabricación");
		lblNewLabel_5.setBounds(25, 393, 152, 14);
		contentPanel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Fecha de vencimiento");
		lblNewLabel_6.setBounds(25, 440, 152, 14);
		contentPanel.add(lblNewLabel_6);
		lblNombre.setBounds(25, 51, 89, 14);

		contentPanel.add(lblNombre);
		lblPresentacin.setBounds(25, 84, 116, 14);

		contentPanel.add(lblPresentacin);
		{
			cboProd.setBounds(186, 50, 129, 22);
			contentPanel.add(cboProd);
		}
		{
			cboMarca.setBounds(187, 83, 86, 22);
			contentPanel.add(cboMarca);
		}
		{
			lblUnidadDeMedida.setBounds(25, 121, 116, 14);
			contentPanel.add(lblUnidadDeMedida);
		}
		{
			cboPresen.setBounds(187, 120, 86, 22);
			contentPanel.add(cboPresen);
		}
		{
			cboUniMedi.setBounds(187, 156, 86, 22);
			contentPanel.add(cboUniMedi);
		}
		{
			lblUnidadDeMedida_2.setBounds(25, 160, 128, 14);
			contentPanel.add(lblUnidadDeMedida_2);
		}
		{
			lblUnidadDeMedida_2_1.setBounds(25, 200, 152, 14);
			contentPanel.add(lblUnidadDeMedida_2_1);
		}
		{
			txtCantMedi.setColumns(10);
			txtCantMedi.setBounds(187, 197, 86, 20);
			contentPanel.add(txtCantMedi);
		}
		{
			txtCostBas.setColumns(10);
			txtCostBas.setBounds(187, 320, 86, 20);
			contentPanel.add(txtCostBas);
		}
		{
			lblNewLabel_4_1.setBounds(25, 323, 89, 14);
			contentPanel.add(lblNewLabel_4_1);
		}
		{
			lblNewLabel_4_1_1.setBounds(25, 358, 156, 14);
			contentPanel.add(lblNewLabel_4_1_1);
		}
		{
			txtPorceMarg.setColumns(10);
			txtPorceMarg.setBounds(187, 355, 86, 20);
			contentPanel.add(txtPorceMarg);
		}
		{
			scrollPane.setBounds(405, 97, 631, 357);
			contentPanel.add(scrollPane);
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			lblNewLabel_1.setBounds(405, 17, 140, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtCodFilt.setColumns(10);
			txtCodFilt.setBounds(553, 17, 86, 20);
			contentPanel.add(txtCodFilt);
		}
		{
			btnBuscarxCod.addActionListener(this);
			btnBuscarxCod.setBounds(405, 47, 153, 23);
			contentPanel.add(btnBuscarxCod);
		}
		{
			lblNewLabel_1_1.setBounds(649, 20, 119, 14);
			contentPanel.add(lblNewLabel_1_1);
		}
		{
			cboProdFilt.addActionListener(this);
			cboProdFilt.setBounds(774, 17, 119, 22);
			contentPanel.add(cboProdFilt);
		}
		{
			btnGuardarLista.addActionListener(this);
			btnGuardarLista.setBounds(917, 16, 119, 23);
			contentPanel.add(btnGuardarLista);
		}
		{
			dateChooserFeVenc.setBounds(187,435,200,30);
			contentPanel.add(dateChooserFeVenc);
		}
		{
			dateChooserFeFab.setBounds(187, 393, 200, 30);
			contentPanel.add(dateChooserFeFab);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(130, 514, 89, 23);
			contentPanel.add(btnModificar);
		}
		{
			btnEliminar.addActionListener(this);
			btnEliminar.setBounds(229, 514, 89, 23);
			contentPanel.add(btnEliminar);
		}
		{
			btnSalir.addActionListener(this);
			btnSalir.setBounds(332, 514, 153, 23);
			contentPanel.add(btnSalir);
		}

		cboProd.addItem("");
		cboMarca.addItem("");
		cboPresen.addItem("");
		cboUniMedi.addItem("");
		cboProdFilt.addItem("");

		for (int i = 0; i < pg.size(); i++) {
			cboProd.addItem(pg.get(i).getName());
			cboProdFilt.addItem(pg.get(i).getName());
		}
		for (int i = 0; i < m.size(); i++) {
			cboMarca.addItem(m.get(i).getName());
		}
		for (int i = 0; i < m.size(); i++) {
			cboPresen.addItem(pr.get(i).getName());
		}
		for (int i = 0; i < u.size(); i++) {
			cboUniMedi.addItem(u.get(i).getName());
		}
	}
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnGuardarLista) {
			do_btnGuardarLista_actionPerformed(e);
		}
		if (e.getSource() == cboProdFilt) {
			do_cboProdFilt_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarxCod) {
			do_btnBuscarxCod_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}

	private JLabel lblNewLabel_4;
	private final JTextField txtStockMin = new JTextField();
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private final JLabel lblNombre = new JLabel("Producto:");
	private final JLabel lblPresentacin = new JLabel("Marca:");
	private final JComboBox<String> cboProd = new JComboBox<>();
	private final JComboBox<String> cboMarca = new JComboBox<>();
	private final JLabel lblUnidadDeMedida = new JLabel("Presentación:");
	private final JComboBox<String> cboPresen = new JComboBox<>();
	private final JComboBox<String> cboUniMedi = new JComboBox<>();
	private final JLabel lblUnidadDeMedida_2 = new JLabel("Unidad de medida:");
	private final JLabel lblUnidadDeMedida_2_1 = new JLabel("Cantidad de medida:");
	private final JTextField txtCantMedi = new JTextField();
	private final JTextField txtCostBas = new JTextField();
	private final JLabel lblNewLabel_4_1 = new JLabel("Costo base:");
	private final JLabel lblNewLabel_4_1_1 = new JLabel("Porcentaje de margen:");
	private final JTextField txtPorceMarg = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JLabel lblNewLabel_1 = new JLabel("Código de producto:");
	private final JTextField txtCodFilt = new JTextField();
	private final JButton btnBuscarxCod = new JButton("Buscar por código");
	private final JLabel lblNewLabel_1_1 = new JLabel("Filtrar por nombre:");
	private final JComboBox<String> cboProdFilt = new JComboBox<String>();
	private final JButton btnGuardarLista = new JButton("Guardar Lista");
	private final JDateChooser dateChooserFeFab = new JDateChooser();
	private final JButton btnModificar = new JButton("Modificar");
	private final JButton btnEliminar = new JButton("Eliminar");
	private final JButton btnSalir = new JButton("SALIR");
	
	private void showTable() {
		Object[][] datos = new Object[productos.size()][14];

		for (int i = 0; i < productos.size(); i++) {
			Producto p = productos.get(i);
			datos[i][0] = p.getCodigoProducto();
			datos[i][1] = p.getProd();
			datos[i][2] = p.getMarca();
			datos[i][3] = p.getPresentacion();
			datos[i][4] = p.getUnidadMedida();
			datos[i][5] = String.valueOf(p.getCantidadMedida());
			datos[i][6] = String.valueOf(p.getStock());
			datos[i][7] = String.valueOf(p.getStockMin());
			datos[i][8] = String.valueOf(p.getCostoBase());
			datos[i][9] = String.valueOf(p.getPorcentMargen());
			datos[i][10] = p.getFechaFabricacion() != null ? p.getFechaFabricacion().toString() : "";
			datos[i][11] = p.getFechaVencimiento() != null ? p.getFechaVencimiento().toString() : "";
			datos[i][12] = p.getCreatedAt();
			datos[i][13] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	private String getCod() {
		return txtCod.getText().trim();
	}

	private String getProd() {
		return String.valueOf(getIdProd());
	}

	private String getMarca() {
		return String.valueOf(getIdMarca());
	}

	private String getPresen() {
		return String.valueOf(getIdPresen());
	}

	private String getUniMedi() {
		return String.valueOf(getIdUniMedi());
	}

	private double getCantMedi() {
		return Double.parseDouble(txtCantMedi.getText());
	}

	private int getStock() {
		return Integer.parseInt(txtStock.getText());
	}

	private int getStockMin() {
		return Integer.parseInt(txtStockMin.getText());
	}

	private double getCostBas() {
		return Double.parseDouble(txtCostBas.getText());
	}

	private double getPorceMarg() {
		return Double.parseDouble(txtPorceMarg.getText());
	}

	

	private int getIdProd() {
		String product = cboProd.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < pg.size(); i++) {
			if (pg.get(i).getName().equals(product)) {
				id = pg.get(i).getId();
			}
		}
		return id;
	}

	private int getIdMarca() {
		String marca = cboMarca.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).getName().equals(marca)) {
				id = m.get(i).getId();
			}
		}
		return id;
	}

	private int getIdPresen() {
		String presen = cboPresen.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < pr.size(); i++) {
			if (pr.get(i).getName().equals(presen)) {
				id = pr.get(i).getId();
			}
		}
		return id;
	}

	private int getIdUniMedi() {
		String uni = cboUniMedi.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < u.size(); i++) {
			if (u.get(i).getName().equals(uni)) {
				id = u.get(i).getId();
			}
		}
		return id;
	}
	
	private int getIdProdFilt() {
		String product = cboProdFilt.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < pg.size(); i++) {
			if (pg.get(i).getName().equals(product)) {
				id = pg.get(i).getId();
			}
		}
		return id;
	}
	
	private void guardarCsv() {
		File archivo = new File("productos.csv");
		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
				PrintWriter pw = new PrintWriter(writer)) {

			writer.write('\uFEFF');

			pw.println(
					"CÓDIGO_PRODUCTO;NOMBRE;MARCA;PRESENTACIÓN;UNIDAD DE MEDIDA;CANTIDAD_MEDIDA;STOCK;STOCK_MIN;COSTO_BASE;PORCENT_MARGEN;FECHA_FABRICACION;FECHA_VENCIMIENTO;CREATED_AT;UPDATED_AT");

			for (int i = 0; i < productos.size(); i++) {
				Producto p = productos.get(i);
				pw.println(p.getCodigoProducto() + ";" + p.getProd() + ";" + p.getMarca() + ";" + p.getPresentacion()
						+ ";" + p.getUnidadMedida() + ";" + p.getCantidadMedida() + ";" + p.getStock() + ";"
						+ p.getStockMin() + ";" + p.getCostoBase() + ";" + p.getPorcentMargen() + ";"
						+ p.getFechaFabricacion() + ";" + p.getFechaVencimiento() + ";" + p.getCreatedAt() + ";"
						+ p.getUpdatedAt());

			}

			JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
		}
	}
	
	private Boolean validarProd() {
		Date fechaFab = dateChooserFeFab.getDate();
		Date fechaVenc = dateChooserFeVenc.getDate();
		
		if (getCod().isBlank() || getIdProd() < 0 || getIdMarca() < 0 || getIdPresen() < 0 || getIdUniMedi() < 0
				|| txtCantMedi.getText().isBlank() || txtStock.getText().isBlank()
				|| txtStockMin.getText().isBlank() || txtCostBas.getText().isBlank()
				|| txtPorceMarg.getText().isBlank() || fechaFab==null
				|| fechaVenc==null) {
			JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
			return false;
		}
		else if (getCantMedi() < 0 || getStock() < 0 || getStockMin() < 0 || getCostBas() < 0
				|| getPorceMarg() < 0) {
			JOptionPane.showMessageDialog(this, "No se pueden registrar números negativos.");
			return false;
		}
		
		else if(fechaVenc.before(fechaFab)) {
			JOptionPane.showMessageDialog(this, "La fecha de fabricación debe ser anterior a la fecha de vencimiento.");
			return false;
		} else return true;
		
	}

	private void limpiarCampos() {
		// Limpiar los JTextField
		txtCod.setText("");
		txtCantMedi.setText("");
		txtStock.setText("");
		txtStockMin.setText("");
		txtCostBas.setText("");
		txtPorceMarg.setText("");
		dateChooserFeFab.setDate(null);
		dateChooserFeVenc.setDate(null);
		// Reiniciar JComboBox al primer ítem
		cboProd.setSelectedIndex(0);
		cboMarca.setSelectedIndex(0);
		cboPresen.setSelectedIndex(0);
		cboUniMedi.setSelectedIndex(0);
	}

	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			
			if(!validarProd()) return;
			
			if (pDAO.readProdByCod(getCod()) != null) {
				JOptionPane.showMessageDialog(this, "El código del producto ya existe.");
				return;
			}
			
			Producto p = new Producto();
			p.setCodigoProducto(getCod());
			p.setProd(getProd());
			p.setMarca(getMarca());
			p.setPresentacion(getPresen());
			p.setUnidadMedida(getUniMedi());
			p.setCantidadMedida(getCantMedi());
			p.setStock(getStock());
			p.setStockMin(getStockMin());
			p.setCostoBase(getCostBas());
			p.setPorcentMargen(getPorceMarg());
			p.setFechaFabricacion(dateChooserFeFab.getDate());
			p.setFechaVencimiento(dateChooserFeVenc.getDate());
			

			Boolean isCreated = pDAO.createProd(p);
			if (isCreated) {
				JOptionPane.showMessageDialog(this, "El producto fue registrado con éxito.");
				limpiarCampos();
				productos = pDAO.readProds();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar el producto.");
		} catch (Exception e2) {
			System.out.println(e2);
			JOptionPane.showMessageDialog(this, "Error al registrar el producto, verifique los datos ingresados");
			// TODO: handle exception
		}
	}
	protected void do_btnBuscarxCod_actionPerformed(ActionEvent e) {
		try {
			if (txtCodFilt.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo está vacío.");
				return;
			}
			Producto p = pDAO.readProdByCod(txtCodFilt.getText());
			if (p != null) {
				JOptionPane.showMessageDialog(this, "Producto encontrado");
				table.setModel(new DefaultTableModel());
				Object[][] datos = new Object[1][14];
				datos[0][0] = p.getCodigoProducto();
				datos[0][1] = p.getProd();
				datos[0][2] = p.getMarca();
				datos[0][3] = p.getPresentacion();
				datos[0][4] = p.getUnidadMedida();
				datos[0][5] = String.valueOf(p.getCantidadMedida());
				datos[0][6] = String.valueOf(p.getStock());
				datos[0][7] = String.valueOf(p.getStockMin());
				datos[0][8] = String.valueOf(p.getCostoBase());
				datos[0][9] = String.valueOf(p.getPorcentMargen());
				datos[0][10] = p.getFechaFabricacion() != null ? p.getFechaFabricacion().toString() : "";
				datos[0][11] = p.getFechaVencimiento() != null ? p.getFechaVencimiento().toString() : "";
				datos[0][12] = p.getCreatedAt();
				datos[0][13] = p.getUpdatedAt();

				table.setModel(new DefaultTableModel(datos, columnas));
			} else {
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
				return;
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Ingrese un código válido");
		}
	}
	
	protected void do_cboProdFilt_actionPerformed(ActionEvent e) {
		try {
			productos = pDAO.readProdsByProd(getIdProdFilt());

			Object[][] datos = new Object[productos.size()][14];

			for (int i = 0; i < productos.size(); i++) {
				Producto p = productos.get(i);
				datos[i][0] = p.getCodigoProducto();
				datos[i][1] = p.getProd();
				datos[i][2] = p.getMarca();
				datos[i][3] = p.getPresentacion();
				datos[i][4] = p.getUnidadMedida();
				datos[i][5] = String.valueOf(p.getCantidadMedida());
				datos[i][6] = String.valueOf(p.getStock());
				datos[i][7] = String.valueOf(p.getStockMin());
				datos[i][8] = String.valueOf(p.getCostoBase());
				datos[i][9] = String.valueOf(p.getPorcentMargen());
				datos[i][10] = p.getFechaFabricacion() != null ? p.getFechaFabricacion().toString() : "";
				datos[i][11] = p.getFechaVencimiento() != null ? p.getFechaVencimiento().toString() : "";
				datos[i][12] = p.getCreatedAt();
				datos[i][13] = p.getUpdatedAt();
			}

			table.setModel(new DefaultTableModel(datos, columnas));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Ingrese un código válido");
		}
	}
	protected void do_btnGuardarLista_actionPerformed(ActionEvent e) {
		guardarCsv();
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			if(!validarProd()) return;
			
			Producto productoMod = pDAO.readProdByCod(txtCod.getText());
			if(productoMod==null) {
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
				return;
			}
			
			Producto p = new Producto();
			p.setCodigoProducto(getCod());
			p.setProd(getProd());
			p.setMarca(getMarca());
			p.setPresentacion(getPresen());
			p.setUnidadMedida(getUniMedi());
			p.setCantidadMedida(getCantMedi());
			p.setStock(getStock());
			p.setStockMin(getStockMin());
			p.setCostoBase(getCostBas());
			p.setPorcentMargen(getPorceMarg());
			p.setFechaFabricacion(dateChooserFeFab.getDate());
			p.setFechaVencimiento(dateChooserFeVenc.getDate());
			
			Boolean isUpdated =pDAO.updateProd(p);
			if (isUpdated) {
				JOptionPane.showMessageDialog(this, "El producto fue modificado con éxito.");
				limpiarCampos();
				productos = pDAO.readProds();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al modificar el producto.");
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Error al modificar el producto.");
		}
		
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent e) {
		try {
			if(txtCod.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Ingrese un código válido.");
				return;
			}
			
			Producto productoDele = pDAO.readProdByCod(txtCod.getText());
			if(productoDele==null) {
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
				return;
			}
			
			Boolean isDeleted = pDAO.deleteProd(productoDele.getIdProducto());
			if (isDeleted) {
				JOptionPane.showMessageDialog(this, "El producto fue eliminado con éxito.");
				limpiarCampos();
				productos = pDAO.readProds();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al eliminar el producto.");
			
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Ingrese un código válido.");
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
