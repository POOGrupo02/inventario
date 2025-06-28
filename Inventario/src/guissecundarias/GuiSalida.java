package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.FormaPago;
import mysql.FormaPagoDAO;
import mysql.ProductoDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
	private final JTextField textField_1 = new JTextField();
	private final JLabel lblNewLabel_2_1_2_1 = new JLabel("(opcional)");
	private ProductoDAO pDAO = new ProductoDAO();
	private ArrayList<Producto> products = new ArrayList<Producto>();
	private String[] columnas = { "CODIGO PRODUCTO", "NOMBRE", "PRECIO", "CANTIDAD" ,"TOTAL"};
	private final JButton btnPlus = new JButton("");
	private final JButton btnMinus = new JButton("");
	private final JTextField txtCantProd = new JTextField();
	private ArrayList<Integer> listCantProd = new ArrayList<Integer>();
	private int cantProd = 1;
	private Object[][] datos = null;
	private FormaPagoDAO fPgDAO = new FormaPagoDAO();
	private ArrayList<FormaPago> fPg = fPgDAO.readFormasPagos();
	ArrayList<Integer> formasPago = new ArrayList<>();
	private final JTextField txtCodProdElim = new JTextField();
	private final JLabel lblNewLabel_1_2 = new JLabel("Eliminar producto del carrito");
	private final JButton btnEliminarDelCarrito = new JButton("Eliminar del carrito");
	private final JButton btnRegistrarVenta = new JButton("Registrar venta");
	private final JLabel lblNewLabel_2_1_2_2 = new JLabel("Formas de pago");
	private final JComboBox<String> cboFormPag = new JComboBox<>();
	private final JButton btnAgregarFormPag = new JButton("Agregar forma de pago");
	private final JLabel lblFormPag = new JLabel("Formas de pago seleccionadas:");
	
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
		txtCantProd.setBounds(315, 64, 39, 20);
		txtCantProd.setColumns(10);
		txtDni.setBounds(83, 125, 126, 20);
		txtDni.setColumns(10);
		txtCodProd.setBounds(10, 58, 86, 20);
		txtCodProd.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 939, 523);
		wqe = new JPanel();
		wqe.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(wqe);
		wqe.setLayout(null);
		{
			scrollPane.setBounds(566, 60, 347, 335);
			wqe.add(scrollPane);
			datos = new Object[products.size()][columnas.length];

			table.setModel(new DefaultTableModel(datos, columnas));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			txtCantProd.setText(cantProd+"");
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
			lblNewLabel_1.setBounds(10, 35, 140, 14);
			wqe.add(lblNewLabel_1);
		}
		{
			wqe.add(txtCodProd);
		}
		{
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(10, 89, 86, 14);
			wqe.add(lblNewLabel_1_1);
		}
		{
			btnAgregarProd.addActionListener(this);
			btnAgregarProd.setBounds(114, 57, 157, 23);
			wqe.add(btnAgregarProd);
		}
		{
			lblNewLabel_2.setBounds(10, 128, 46, 14);
			wqe.add(lblNewLabel_2);
		}
		{
			wqe.add(txtDni);
		}
		{
			lblNewLabel_2_1.setBounds(10, 169, 46, 14);
			wqe.add(lblNewLabel_2_1);
		}
		{
			txtNombre.setColumns(10);
			txtNombre.setBounds(83, 166, 126, 20);
			wqe.add(txtNombre);
		}
		{
			lblNewLabel_2_1_1.setBounds(10, 208, 46, 14);
			wqe.add(lblNewLabel_2_1_1);
		}
		{
			txtApellido.setColumns(10);
			txtApellido.setBounds(83, 205, 126, 20);
			wqe.add(txtApellido);
		}
		{
			lblNewLabel_2_1_1_1.setBounds(10, 247, 46, 14);
			wqe.add(lblNewLabel_2_1_1_1);
		}
		{
			cboSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Femenino", "Masculino"}));
			cboSexo.setBounds(83, 243, 126, 22);
			wqe.add(cboSexo);
		}
		{
			lblNewLabel_2_1_2.setBounds(10, 287, 46, 14);
			wqe.add(lblNewLabel_2_1_2);
		}
		{
			textField_1.setColumns(10);
			textField_1.setBounds(83, 284, 126, 20);
			wqe.add(textField_1);
		}
		{
			lblNewLabel_2_1_2_1.setBounds(219, 287, 78, 14);
			wqe.add(lblNewLabel_2_1_2_1);
		}
		{
			btnPlus.addActionListener(this);
			btnPlus.setIcon(new ImageIcon(GuiSalida.class.getResource("/images/mas.png")));
			btnPlus.setBounds(368, 60, 24, 23);
			wqe.add(btnPlus);
		}
		{
			btnMinus.addActionListener(this);
			btnMinus.setIcon(new ImageIcon(GuiSalida.class.getResource("/images/menos.png")));
			btnMinus.setBounds(281, 60, 24, 23);
			wqe.add(btnMinus);
		}
		{
			wqe.add(txtCantProd);
		}
		{
			txtCodProdElim.setColumns(10);
			txtCodProdElim.setBounds(10, 435, 86, 20);
			wqe.add(txtCodProdElim);
		}
		{
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_2.setBounds(10, 409, 239, 14);
			wqe.add(lblNewLabel_1_2);
		}
		{
			btnEliminarDelCarrito.addActionListener(this);
			btnEliminarDelCarrito.setBounds(114, 434, 157, 23);
			wqe.add(btnEliminarDelCarrito);
		}
		{
			btnRegistrarVenta.addActionListener(this);
			btnRegistrarVenta.setBounds(566, 434, 157, 23);
			wqe.add(btnRegistrarVenta);
		}
		{
			lblNewLabel_2_1_2_2.setBounds(10, 325, 105, 14);
			wqe.add(lblNewLabel_2_1_2_2);
		}
		{
			cboFormPag.setBounds(114, 321, 126, 22);
			wqe.add(cboFormPag);
		}
		{
			btnAgregarFormPag.addActionListener(this);
			btnAgregarFormPag.setBounds(250, 321, 157, 23);
			wqe.add(btnAgregarFormPag);
		}
		{
			lblFormPag.setBounds(10, 361, 504, 14);
			wqe.add(lblFormPag);
		}
		
		cboFormPag.addItem("");
		
		for (int i = 0; i < fPg.size(); i++) {
			cboFormPag.addItem(fPg.get(i).getNombre());
		}
	}
	
	private void showTable() {
		datos = new Object[products.size()][columnas.length];
		for(int i = 0; i < products.size(); i++) {
			Producto p = products.get(i);
			datos[i][0] = p.getCodigoProducto();
			datos[i][1] = p.getProd();
			datos[i][2] = p.getCostoBase() + p.getCostoBase() * (p.getPorcentMargen()/100);
			datos[i][3] = listCantProd.get(i);
			datos[i][4] = String.valueOf( (p.getCostoBase() + p.getCostoBase() * (p.getPorcentMargen()/100)) * listCantProd.get(i));
		}
		table.setModel(new DefaultTableModel(datos, columnas));
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
	
	
	public void actionPerformed(ActionEvent e) {
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
			if(txtCodProd.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo de código producto está vacío.");
				return;
			}
			
			boolean isAgregado = false;
			for (int i = 0; i < products.size(); i++) {
				if(products.get(i).getCodigoProducto().equalsIgnoreCase(txtCodProd.getText())) {
					isAgregado = true;
				}
			}
			
			if(isAgregado) {
				JOptionPane.showMessageDialog(this, "El producto ya está agregado en el carrito.");
				return;
			}
			
			Producto producto = pDAO.readProdByCod(txtCodProd.getText());
			
			if(producto == null) {
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
				return;
			}
			
			products.add(producto);
			listCantProd.add(cantProd);
			showTable();
			cantProd = 1;
			txtCantProd.setText(cantProd+"");
			txtCodProd.setText("");
		}catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Producto no encontrado.");
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
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getCodigoProducto().equalsIgnoreCase(prodElim)) {
				products.remove(i);
				listCantProd.remove(i);
				isDeleted = true;
			}
		}
		
		if(isDeleted) {
			txtCodProdElim.setText("");
			showTable();
		}else {
			JOptionPane.showMessageDialog(this, "El producto no está agregado en el carrito.");
			return;
		}
	}
	protected void do_btnRegistrarVenta_actionPerformed(ActionEvent e) {
		
		
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
		
		String t = "";
		for (int i = 0; i < formasPago.size(); i++) {
			for (int k = 0; k < fPg.size(); k++) {
				if(formasPago.get(i) == fPg.get(k).getId()) {
					t += i > 0 ? (", "+fPg.get(k).getNombre()) : fPg.get(k).getNombre();
				}
			}
		}
		
		lblFormPag.setText("Formas de pago seleccionadas: "+t);
	}
}
