package guissecundarias;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import claseshijo.Cliente;
import claseshijo.FormaPago;
import mysql.ClienteDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiCliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("DNI");
	private final JTextField txtDni = new JTextField();
	private final JButton btnModificar = new JButton("Modificar");
	private final JLabel lblNombre = new JLabel("Nombre");
	private final JTextField txtNombre = new JTextField();
	private final JLabel lblApellido = new JLabel("Apellido");
	private final JTextField txtApellido = new JTextField();
	private final JLabel lblSexo = new JLabel("Sexo");
	private final JComboBox cboSexo = new JComboBox();
	private final JLabel lblCelular = new JLabel("Celular");
	private final JTextField txtCelular = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private ClienteDAO cDAO = new ClienteDAO();
	private ArrayList<Cliente> clientes = cDAO.readClientes();
	private String[] columnas = { "DNI", "NOMBRE", "APELLIDO", "SEXO" , "CELULAR", "CREATED_AT", "UPDATED_AT"};
	private final JButton btnSalir = new JButton("SALIR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCliente frame = new GuiCliente();
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
	public GuiCliente() {
		txtDni.setBounds(10, 50, 86, 20);
		txtDni.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 959, 457);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel.setBounds(10, 25, 46, 14);
			contentPane.add(lblNewLabel);
			
			showTable();
		}
		{
			contentPane.add(txtDni);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(10, 312, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			lblNombre.setBounds(10, 81, 46, 14);
			contentPane.add(lblNombre);
		}
		{
			txtNombre.setColumns(10);
			txtNombre.setBounds(10, 106, 86, 20);
			contentPane.add(txtNombre);
		}
		{
			lblApellido.setBounds(10, 137, 46, 14);
			contentPane.add(lblApellido);
		}
		{
			txtApellido.setColumns(10);
			txtApellido.setBounds(10, 160, 86, 20);
			contentPane.add(txtApellido);
		}
		{
			lblSexo.setBounds(10, 192, 46, 14);
			contentPane.add(lblSexo);
		}
		{
			cboSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Femenino", "Masculino"}));
			cboSexo.setBounds(10, 217, 126, 22);
			contentPane.add(cboSexo);
		}
		{
			lblCelular.setBounds(10, 256, 46, 14);
			contentPane.add(lblCelular);
		}
		{
			txtCelular.setColumns(10);
			txtCelular.setBounds(10, 281, 86, 20);
			contentPane.add(txtCelular);
		}
		{
			scrollPane.setBounds(254, 50, 553, 293);
			contentPane.add(scrollPane);
		}
		{
			table.setEnabled(false);
			scrollPane.setViewportView(table);
		}
		{
			btnSalir.addActionListener(this);
			btnSalir.setBounds(155, 312, 89, 23);
			contentPane.add(btnSalir);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
	}
	
	private void showTable() {
		Object[][] datos = new Object[clientes.size()][7];

		for (int i = 0; i < clientes.size(); i++) {
			Cliente p = clientes.get(i);
			datos[i][0] = p.getDni();
			datos[i][1] = p.getNombre();
			datos[i][2] = p.getApellido();
			datos[i][3] = p.getSexo();
			datos[i][4] = p.getCelular();
			datos[i][5] = p.getCreatedAt();
			datos[i][6] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		if(txtDni.getText().isBlank() || txtNombre.getText().isBlank() || txtApellido.getText().isBlank() || cboSexo.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "Los campos obligatorios para cliente no pueden estar.");
			return;
		}
		
		if(txtDni.getText().length()!=8) {
			JOptionPane.showMessageDialog(this, "La cantidad de números en un DNI solo es de 8.");
			return;
		}
		
		Cliente c = cDAO.readClienteByDni(txtDni.getText().trim());
		if(c==null) {
			JOptionPane.showMessageDialog(this, "No se encontró a un cliente con ese DNI.");
			return;
		}
		
		Cliente cliente = new Cliente();
		cliente.setDni(txtDni.getText());
		cliente.setNombre(txtNombre.getText());
		cliente.setApellido(txtApellido.getText());
		cliente.setSexo(cboSexo.getSelectedItem().toString());
		cliente.setCelular(txtCelular.getText());
		
		 if (cDAO.updateCliente(cliente)) {
			 JOptionPane.showMessageDialog(this, "Cliente modificadO con éxito.");
			 txtDni.setText("");
			 txtNombre.setText("");
			 txtApellido.setText("");
			 cboSexo.setSelectedIndex(0);
			 txtCelular.setText("");
			 clientes = cDAO.readClientes();
			 showTable();
		 }else {
			 JOptionPane.showMessageDialog(this, "Hubo un error al momento de modificar el cliente.");
		 }
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
