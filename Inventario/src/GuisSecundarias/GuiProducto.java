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

public class GuiProducto extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtID;
	private JTextField txtNom;
	private JTextField txtStock;
	private JTextField txtPrecio;

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
		setTitle("Producto");
		setBounds(100, 100, 519, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 104, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(125, 104, 89, 23);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(365, 104, 89, 23);
		contentPanel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("New button");
		btnNewButton_1_1_1.setBounds(256, 104, 89, 23);
		contentPanel.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(226, 18, 228, 14);
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
		scrollPane.setBounds(10, 142, 483, 167);
		contentPanel.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modificar stock:");
		lblNewLabel_2_1.setBounds(10, 60, 75, 14);
		contentPanel.add(lblNewLabel_2_1);
	}
}
