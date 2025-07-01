package guissecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GuiProveedor extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiProveedor dialog = new GuiProveedor();
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiProveedor() {
		setModal(true);
		setBounds(100, 100, 931, 615);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(128, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			btnSalir = new JButton("SALIR");
			btnSalir.addActionListener(this);
			btnSalir.setBounds(520, 419, 89, 23);
			contentPanel.add(btnSalir);
		}
		{
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(GuiProveedor.class.getResource("/images/proveedor .jpg")));
			lblNewLabel.setBounds(498, 242, 239, 150);
			contentPanel.add(lblNewLabel);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
	}
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
