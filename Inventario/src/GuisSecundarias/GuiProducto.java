package GuisSecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiProducto extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNom;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JButton btnAgregar;

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
		setModal(true);
		setTitle("Producto");
		setBounds(100, 100, 548, 422);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(109, 104, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnBuscarxNombre = new JButton("Buscar por nombre");
		btnBuscarxNombre.setBounds(338, 104, 123, 23);
		contentPanel.add(btnBuscarxNombre);
		
		JButton btnBuscarxCod = new JButton("Buscar por código");
		btnBuscarxCod.setBounds(208, 104, 117, 23);
		contentPanel.add(btnBuscarxCod);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(226, 18, 63, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock: 10");
		lblNewLabel_2.setBounds(10, 46, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(226, 57, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.setBounds(95, 12, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(301, 15, 153, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(95, 54, 86, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(301, 54, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 483, 177);
		contentPanel.add(scrollPane);
		
		JTextArea txtLstProducto = new JTextArea();
		scrollPane.setViewportView(txtLstProducto);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modificar stock:");
		lblNewLabel_2_1.setBounds(10, 60, 75, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		JButton btnEliminar = new JButton("Eliminar por código");
		btnEliminar.setBounds(10, 149, 123, 23);
		contentPanel.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(143, 149, 89, 23);
		contentPanel.add(btnSalir);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(10, 104, 89, 23);
		contentPanel.add(btnAgregar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
	}
}
