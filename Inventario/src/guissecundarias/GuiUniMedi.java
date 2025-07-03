package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import claseshijo.Marca;
import claseshijo.UnidadMedida;
import mysql.MarcaDAO;
import mysql.UnidadMedidaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GuiUniMedi extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblUnidadDeMedida = new JLabel("Unidad de medida");
	private final JTextField txtUniMedi = new JTextField();
	private final JButton btnRegistrar = new JButton("Registrar");
	private final JLabel lblId = new JLabel("ID");
	private final JTextField txtId = new JTextField();
	private final JButton btnModificar = new JButton("Modificar");
	private final JTextField txtNewUniMedi = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private UnidadMedidaDAO uDAO = new UnidadMedidaDAO();
	private ArrayList<UnidadMedida> unidadesMedi = uDAO.readUnidadesMedidas();
	private String[] columnas = { "ID", "NOMBRE", "CREATED_AT", "UPDATED_AT" };
	private JButton btnModificar_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiUniMedi frame = new GuiUniMedi();
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
	public GuiUniMedi() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 917, 511);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblUnidadDeMedida.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUnidadDeMedida.setBounds(13, 73, 154, 24);
			contentPane.add(lblUnidadDeMedida);
			showTable();
		}
		{
			txtUniMedi.setColumns(10);
			txtUniMedi.setBounds(13, 108, 86, 20);
			contentPane.add(txtUniMedi);
		}
		{
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(13, 139, 89, 23);
			contentPane.add(btnRegistrar);
		}
		{
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblId.setBounds(13, 173, 112, 24);
			contentPane.add(lblId);
		}
		{
			txtId.setColumns(10);
			txtId.setBounds(13, 205, 86, 20);
			contentPane.add(txtId);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(10, 236, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			txtNewUniMedi.setColumns(10);
			txtNewUniMedi.setBounds(112, 205, 86, 20);
			contentPane.add(txtNewUniMedi);
		}
		{
			scrollPane.setBounds(252, 84, 582, 304);
			contentPane.add(scrollPane);
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			btnModificar_1 = new JButton("SALIR");
			btnModificar_1.addActionListener(this);
			btnModificar_1.setBounds(13, 363, 89, 23);
			contentPane.add(btnModificar_1);
		}
	}
	
	private void showTable() {
		Object[][] datos = new Object[unidadesMedi.size()][4];

		for (int i = 0; i < unidadesMedi.size(); i++) {
			UnidadMedida p = unidadesMedi.get(i);
			datos[i][0] = p.getId();
			datos[i][1] = p.getName();
			datos[i][2] = p.getCreatedAt();
			datos[i][3] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar_1) {
			do_btnModificar_1_actionPerformed(e);
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

			if (txtUniMedi.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
				return;
			}

			UnidadMedida m = new UnidadMedida();
			m.setName(txtUniMedi.getText().trim());

			Boolean isCreated = uDAO.createUnidadMedida(m);

			if (isCreated) {
				JOptionPane.showMessageDialog(this, "La unidad de medida fue registrada con éxito.");
				txtUniMedi.setText("");
				unidadesMedi = uDAO.readUnidadesMedidas();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar la unidad de medida.");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
			// TODO: handle exception
		}
	}
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtId.getText());
			if (txtNewUniMedi.getText().isBlank() || txtId.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			
			Boolean exits = false;
			for (int i = 0; i < unidadesMedi.size(); i++) {
				if(unidadesMedi.get(i).getId() == id){
					exits = true;
				}
			}
			
			if(!exits) {
				JOptionPane.showMessageDialog(this, "No existe una unidad de medida con ese ID.");
				return;
			}

			UnidadMedida u = new UnidadMedida();
			u.setName(txtNewUniMedi.getText().trim());
			u.setId(id);

			if (uDAO.updateUnidadMedida(u)) {
				JOptionPane.showMessageDialog(this, "Unidad de medida actualizada.");
				txtNewUniMedi.setText("");
				txtId.setText("");
				unidadesMedi = uDAO.readUnidadesMedidas();
				showTable();
			}else {
				JOptionPane.showMessageDialog(this, "Error al modificar la unidad de medida.");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
	}
	protected void do_btnModificar_1_actionPerformed(ActionEvent e) {
		dispose();
	}
}
