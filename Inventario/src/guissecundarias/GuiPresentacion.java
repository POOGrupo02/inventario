package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import claseshijo.Marca;
import claseshijo.Presentacion;
import mysql.MarcaDAO;
import mysql.PresentacionDAO;

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

public class GuiPresentacion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblPresentacin = new JLabel("Presentación");
	private final JTextField txtPresen = new JTextField();
	private final JButton btnRegistrar = new JButton("Registrar");
	private final JLabel lblId = new JLabel("ID");
	private final JTextField txtId = new JTextField();
	private final JButton btnModificar = new JButton("Modificar");
	private final JTextField txtNewPresen = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private PresentacionDAO pDAO = new PresentacionDAO();
	private ArrayList<Presentacion> presentaciones = pDAO.readPresentaciones();
	private String[] columnas = { "ID", "NOMBRE", "CREATED_AT", "UPDATED_AT" };
	private final JButton btnSalir = new JButton("SALIR");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPresentacion frame = new GuiPresentacion();
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
	public GuiPresentacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 593);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblPresentacin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPresentacin.setBounds(13, 93, 154, 24);
			contentPane.add(lblPresentacin);
			showTable();
		}
		{
			txtPresen.setColumns(10);
			txtPresen.setBounds(13, 128, 86, 20);
			contentPane.add(txtPresen);
		}
		{
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(13, 159, 89, 23);
			contentPane.add(btnRegistrar);
		}
		{
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblId.setBounds(13, 193, 112, 24);
			contentPane.add(lblId);
		}
		{
			txtId.setColumns(10);
			txtId.setBounds(13, 225, 86, 20);
			contentPane.add(txtId);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(10, 256, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			txtNewPresen.setColumns(10);
			txtNewPresen.setBounds(112, 225, 86, 20);
			contentPane.add(txtNewPresen);
		}
		{
			scrollPane.setBounds(286, 93, 546, 288);
			contentPane.add(scrollPane);
		}
		{
			table.setEnabled(false);
			scrollPane.setViewportView(table);
		}
		{
			btnSalir.addActionListener(this);
			btnSalir.setBounds(10, 358, 89, 23);
			contentPane.add(btnSalir);
		}
	}
	
	private void showTable() {
		Object[][] datos = new Object[presentaciones.size()][4];

		for (int i = 0; i < presentaciones.size(); i++) {
			Presentacion p = presentaciones.get(i);
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

			if (txtPresen.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
				return;
			}

			Presentacion p = new Presentacion();
			p.setName(txtPresen.getText().trim());

			Boolean isCreated = pDAO.createPresentacion(p);

			if (isCreated) {
				JOptionPane.showMessageDialog(this, "La presentación fue registrada con éxito.");
				txtPresen.setText("");
				presentaciones = pDAO.readPresentaciones();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar la presentación.");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
			// TODO: handle exception
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtId.getText());
			if (txtNewPresen.getText().isBlank() || txtId.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			
			Boolean exits = false;
			for (int i = 0; i < presentaciones.size(); i++) {
				if(presentaciones.get(i).getId() == id){
					exits = true;
				}
			}
			
			if(!exits) {
				JOptionPane.showMessageDialog(this, "No existe una marca con ese ID.");
				return;
			}

			Presentacion p = new Presentacion();
			p.setName(txtNewPresen.getText().trim());
			p.setId(id);

			if (pDAO.updatePresentacion(p)) {
				JOptionPane.showMessageDialog(this, "Marca actualizada.");
				txtNewPresen.setText("");
				txtId.setText("");
				presentaciones = pDAO.readPresentaciones();
				showTable();
			}else {
				JOptionPane.showMessageDialog(this, "Error al modificar la presentación.");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
