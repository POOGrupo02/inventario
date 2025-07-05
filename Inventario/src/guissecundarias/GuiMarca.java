package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import claseshijo.Marca;
import claseshijo.ProductoGeneral;
import mysql.MarcaDAO;
import mysql.ProductoGeneralDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiMarca extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JLabel lblMarca = new JLabel("Marca");
	private final JTextField txtMarca = new JTextField();
	private final JButton btnRegistrar = new JButton("Registrar");
	private final JLabel lblId = new JLabel("ID");
	private final JTextField txtId = new JTextField();
	private final JButton btnModificar = new JButton("Modificar");
	private final JTextField txtNewMarca = new JTextField();
	private MarcaDAO mDAO = new MarcaDAO();
	private ArrayList<Marca> marcas = mDAO.readMarcas();
	private String[] columnas = { "ID", "NOMBRE", "CREATED_AT", "UPDATED_AT" };
	private final JButton btnSalir = new JButton("SALIR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiMarca frame = new GuiMarca();
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
	public GuiMarca() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 735, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane.setBounds(217, 31, 460, 363);
			contentPane.add(scrollPane);
			showTable();
		}
		{
			table.setEnabled(false);
			scrollPane.setViewportView(table);
		}
		{
			lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblMarca.setBounds(13, 60, 154, 24);
			contentPane.add(lblMarca);
		}
		{
			txtMarca.setColumns(10);
			txtMarca.setBounds(13, 95, 86, 20);
			contentPane.add(txtMarca);
		}
		{
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(13, 126, 89, 23);
			contentPane.add(btnRegistrar);
		}
		{
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblId.setBounds(13, 160, 112, 24);
			contentPane.add(lblId);
		}
		{
			txtId.setColumns(10);
			txtId.setBounds(13, 192, 86, 20);
			contentPane.add(txtId);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(10, 223, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			txtNewMarca.setColumns(10);
			txtNewMarca.setBounds(112, 192, 86, 20);
			contentPane.add(txtNewMarca);
		}
		{
			btnSalir.addActionListener(this);
			btnSalir.setBounds(13, 368, 89, 23);
			contentPane.add(btnSalir);
		}
	}
	
	private void showTable() {
		Object[][] datos = new Object[marcas.size()][4];

		for (int i = 0; i < marcas.size(); i++) {
			Marca p = marcas.get(i);
			datos[i][0] = p.getId();
			datos[i][1] = p.getName();
			datos[i][2] = p.getCreatedAt();
			datos[i][3] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}
	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {
		try {

			if (txtMarca.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
				return;
			}

			Marca m = new Marca();
			m.setName(txtMarca.getText().trim());

			Boolean isCreated = mDAO.createMarca(m);

			if (isCreated) {
				JOptionPane.showMessageDialog(this, "La marca fue registrada con éxito.");
				txtMarca.setText("");
				marcas = mDAO.readMarcas();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar la marca.");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
			// TODO: handle exception
		}
		
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtId.getText());
			if (txtNewMarca.getText().isBlank() || txtId.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			
			Boolean exits = false;
			for (int i = 0; i < marcas.size(); i++) {
				if(marcas.get(i).getId() == id){
					exits = true;
				}
			}
			
			if(!exits) {
				JOptionPane.showMessageDialog(this, "No existe una marca con ese ID.");
				return;
			}

			Marca m = new Marca();
			m.setName(txtNewMarca.getText().trim());
			m.setId(id);

			if (mDAO.updateMarca(m)) {
				JOptionPane.showMessageDialog(this, "Marca actualizada.");
				txtNewMarca.setText("");
				txtId.setText("");
				marcas = mDAO.readMarcas();
				showTable();
			}else {
				JOptionPane.showMessageDialog(this, "Error al modificar la marca.");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
