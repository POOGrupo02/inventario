package guissecundarias;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Marcas");
	private final JTextField textField = new JTextField();
	private final JButton btnRegistrar = new JButton("Registrar");
	private final JButton btnModificar = new JButton("Modificar");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

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
		textField.setBounds(10, 56, 86, 20);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 31, 66, 14);
			contentPane.add(lblNewLabel);
		}
		{
			contentPane.add(textField);
		}
		{
			btnRegistrar.setBounds(10, 87, 89, 23);
			contentPane.add(btnRegistrar);
		}
		{
			btnModificar.setBounds(10, 121, 89, 23);
			contentPane.add(btnModificar);
		}
		{
			scrollPane.setBounds(217, 31, 307, 363);
			contentPane.add(scrollPane);
		}
		{
			scrollPane.setViewportView(table);
		}
	}
}
