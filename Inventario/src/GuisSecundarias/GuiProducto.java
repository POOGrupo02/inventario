package GuisSecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ClasePadre.Producto;
import ClasesHijo.Marca;
import ClasesHijo.Presentacion;
import ClasesHijo.ProductoGeneral;
import ClasesHijo.UnidadMedida;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

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
	private List<ProductoGeneral> pg = pgDAO.listarProductosGenerales();
	private List<Marca> m = mDAO.listarMarcas();
	private List<Presentacion> pr = prDAO.listarPresentaciones();
	private List<UnidadMedida> u = uDAO.listarUnidadesMedidas();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiProducto dialog = new GuiProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiProducto() {
		txtDiaFab.setBounds(187, 390, 31, 20);
		txtDiaFab.setColumns(10);
		setModal(true);
		setTitle("Producto");
		setBounds(100, 100, 824, 614);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

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

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(341, 13, 146, 23);
		contentPanel.add(btnLimpiar);

		lblNewLabel_5 = new JLabel("Fecha de fabricación");
		lblNewLabel_5.setBounds(25, 393, 152, 14);
		contentPanel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Fecha de vencimiento");
		lblNewLabel_6.setBounds(25, 435, 152, 14);
		contentPanel.add(lblNewLabel_6);
		{
			contentPanel.add(txtDiaFab);
		}
		{
			txtMesFab.setColumns(10);
			txtMesFab.setBounds(228, 390, 31, 20);
			contentPanel.add(txtMesFab);
		}
		{
			txtAnioFab.setColumns(10);
			txtAnioFab.setBounds(269, 390, 46, 20);
			contentPanel.add(txtAnioFab);
		}
		{
			txtDiaVenc.setColumns(10);
			txtDiaVenc.setBounds(187, 432, 31, 20);
			contentPanel.add(txtDiaVenc);
		}
		{
			txtMesVenc.setColumns(10);
			txtMesVenc.setBounds(228, 432, 31, 20);
			contentPanel.add(txtMesVenc);
		}
		{
			txtAnioVenc.setColumns(10);
			txtAnioVenc.setBounds(269, 432, 46, 20);
			contentPanel.add(txtAnioVenc);
		}
		{
			lblNewLabel_7.setBounds(194, 463, 24, 14);
			contentPanel.add(lblNewLabel_7);
		}
		{
			lblNewLabel_7_1.setBounds(235, 463, 24, 14);
			contentPanel.add(lblNewLabel_7_1);
		}
		{
			lblNewLabel_7_1_1.setBounds(279, 463, 24, 14);
			contentPanel.add(lblNewLabel_7_1_1);
		}
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

		cboProd.addItem("");
		cboMarca.addItem("");
		cboPresen.addItem("");
		cboUniMedi.addItem("");

		for (int i = 0; i < pg.size(); i++) {
			cboProd.addItem(pg.get(i).getName());
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
		if (e.getSource() == btnLimpiar) {
			do_btnLimpiar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}

	private JLabel lblNewLabel_4;
	private final JTextField txtStockMin = new JTextField();
	private JButton btnLimpiar;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	Date fechaActual = new Date();
	private final JTextField txtDiaFab = new JTextField();
	private final JTextField txtMesFab = new JTextField();
	private final JTextField txtAnioFab = new JTextField();
	private final JTextField txtDiaVenc = new JTextField();
	private final JTextField txtMesVenc = new JTextField();
	private final JTextField txtAnioVenc = new JTextField();
	private final JLabel lblNewLabel_7 = new JLabel("Día");
	private final JLabel lblNewLabel_7_1 = new JLabel("Mes");
	private final JLabel lblNewLabel_7_1_1 = new JLabel("Año");
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

	private Date getFechFabri() throws ParseException {
		String dia = txtDiaFab.getText().trim();
		String mes = txtMesFab.getText().trim();
		String anio = txtAnioFab.getText().trim();
		String fechaTexto = anio + "-" + mes + "-" + dia;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(fechaTexto);
		return date;
	}

	private Date getFechVenci() throws ParseException {
		String dia = txtDiaVenc.getText().trim();
		String mes = txtMesVenc.getText().trim();
		String anio = txtAnioVenc.getText().trim();
		String fechaTexto = anio + "-" + mes + "-" + dia;

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(fechaTexto);
		return date;
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

	private void limpiarCampos() {
		// Limpiar los JTextField
		txtCod.setText("");
		txtCantMedi.setText("");
		txtStock.setText("");
		txtStockMin.setText("");
		txtCostBas.setText("");
		txtPorceMarg.setText("");

		txtDiaFab.setText("");
		txtMesFab.setText("");
		txtAnioFab.setText("");

		txtDiaVenc.setText("");
		txtMesVenc.setText("");
		txtAnioVenc.setText("");

		// Reiniciar JComboBox al primer ítem
		cboProd.setSelectedIndex(0);
		cboMarca.setSelectedIndex(0);
		cboPresen.setSelectedIndex(0);
		cboUniMedi.setSelectedIndex(0);
	}

	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			if (getCod().isBlank() || getIdProd() < 0 || getIdMarca() < 0 || getIdPresen() < 0 || getIdUniMedi() < 0
					|| txtCantMedi.getText().isBlank() || txtStock.getText().isBlank()
					|| txtStockMin.getText().isBlank() || txtCostBas.getText().isBlank()
					|| txtPorceMarg.getText().isBlank() || txtAnioFab.getText().isBlank()
					|| txtMesFab.getText().isBlank() || txtAnioVenc.getText().isBlank()
					|| txtMesVenc.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			} else if (getCantMedi() < 0 || getStock() < 0 || getStockMin() < 0 || getCostBas() < 0
					|| getPorceMarg() < 0) {
				JOptionPane.showMessageDialog(this, "No se pueden registrar números negativos.");
				return;
			} else {

				if (pDAO.readProdByCod(getCod()) != null) {
					JOptionPane.showMessageDialog(this, "El código del producto ya existe");
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
				p.setFechaFabricacion(getFechFabri());
				p.setFechaVencimiento(getFechVenci());

				Boolean isCreated = pDAO.createProd(p);
				if (isCreated) {
					JOptionPane.showMessageDialog(this, "El producto fue registrado con éxito.");
					limpiarCampos();
				} else
					JOptionPane.showMessageDialog(this, "Error al registrar el producto.");

			}
		} catch (Exception e2) {
			System.out.println(e2);
			JOptionPane.showMessageDialog(this, "Error al registrar el producto, verifique los datos ingresados");
			// TODO: handle exception
		}
	}

	protected void do_btnLimpiar_actionPerformed(ActionEvent e) {
		limpiarCampos();
	}
}
