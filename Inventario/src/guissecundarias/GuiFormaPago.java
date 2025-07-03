package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.FormaPago;
import mysql.FormaPagoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GuiFormaPago extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Formas de pago");
	private final JTextField txtFormPg = new JTextField();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JButton btnRegistrar = new JButton("Registrar");
	private final JButton btnModificar = new JButton("Modificar");
	private FormaPagoDAO fPgDAO = new FormaPagoDAO();
	private ArrayList<FormaPago> formasPago = fPgDAO.readFormasPagos();
	private String[] columnas = { "ID", "NOMBRE", "CREATED_AT", "UPDATED_AT" };
	private final JTextField txtIdFormPg = new JTextField();
	private final JLabel lblId = new JLabel("ID");
	private final JTextField txtNewFormPg = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiFormaPago frame = new GuiFormaPago();
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
	public GuiFormaPago() {
		txtFormPg.setBounds(10, 64, 86, 20);
		txtFormPg.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 29, 112, 24);
			contentPane.add(lblNewLabel);

			showTable();
		}
		{
			contentPane.add(txtFormPg);
		}
		{
			scrollPane.setBounds(262, 45, 493, 238);
			contentPane.add(scrollPane);
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			btnRegistrar.addActionListener(this);
			btnRegistrar.setBounds(10, 95, 89, 23);
			contentPane.add(btnRegistrar);
		}
		{
			btnModificar.addActionListener(this);
			btnModificar.setBounds(7, 192, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			txtIdFormPg.setColumns(10);
			txtIdFormPg.setBounds(10, 161, 86, 20);
			contentPane.add(txtIdFormPg);
		}
		{
			lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblId.setBounds(10, 129, 112, 24);
			contentPane.add(lblId);
		}
		{
			txtNewFormPg.setColumns(10);
			txtNewFormPg.setBounds(109, 161, 86, 20);
			contentPane.add(txtNewFormPg);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrar) {
			do_btnRegistrar_actionPerformed(e);
		}
	}

	private void showTable() {
		Object[][] datos = new Object[formasPago.size()][4];

		for (int i = 0; i < formasPago.size(); i++) {
			FormaPago p = formasPago.get(i);
			datos[i][0] = p.getId();
			datos[i][1] = p.getNombre();
			datos[i][2] = p.getCreatedAt();
			datos[i][3] = p.getUpdatedAt();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}

	protected void do_btnRegistrar_actionPerformed(ActionEvent e) {

		try {

			if (txtFormPg.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.");
				return;
			}

			FormaPago fP = new FormaPago();
			fP.setNombre(txtFormPg.getText().trim());

			Boolean isCreated = fPgDAO.createFormaPago(fP);

			if (isCreated) {
				JOptionPane.showMessageDialog(this, "La forma de pago fue registrada con éxito.");
				txtFormPg.setText("");
				formasPago = fPgDAO.readFormasPagos();
				showTable();
			} else
				JOptionPane.showMessageDialog(this, "Error al registrar la forma de pago.");
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
			// TODO: handle exception
		}
	}

	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(txtIdFormPg.getText());
			if (txtNewFormPg.getText().isBlank() || txtIdFormPg.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Los campos no pueden estar vacíos.");
				return;
			}
			
			Boolean exits = false;
			for (int i = 0; i < formasPago.size(); i++) {
				if(formasPago.get(i).getId() == id){
					exits = true;
				}
			}
			
			if(!exits) {
				JOptionPane.showMessageDialog(this, "No existe una forma de pago con ese ID.");
				return;
			}

			FormaPago fP = new FormaPago();
			fP.setNombre(txtNewFormPg.getText().trim());
			fP.setId(id);

			if (fPgDAO.updateFormaPago(fP)) {
				JOptionPane.showMessageDialog(this, "Forma de pago actualizada.");
				txtNewFormPg.setText("");
				txtIdFormPg.setText("");
				formasPago = fPgDAO.readFormasPagos();
				showTable();
			}else {
				JOptionPane.showMessageDialog(this, "Hubo un problema al actualizar la forma de pago.");
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}

	}
}
