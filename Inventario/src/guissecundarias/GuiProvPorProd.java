package guissecundarias;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.Marca;
import claseshijo.ProvPorProd;
import claseshijo.Proveedor;
import mysql.ProveedorDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiProvPorProd extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JComboBox<String> cboProv = new JComboBox<>();
	private ProveedorDAO pDAO = new ProveedorDAO();
	private ArrayList<Proveedor> proveedores = pDAO.readProveedores();
	private ArrayList<ProvPorProd> provsPorProds = pDAO.readProvPorProd();
	private String[] columnas = { "PROVEEDOR", "CODIGO PRODUCTO", "PRODUCTO"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiProvPorProd frame = new GuiProvPorProd();
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
	public GuiProvPorProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane.setBounds(50, 122, 338, 276);
			contentPane.add(scrollPane);
		}
		{
			table.setEnabled(false);
			scrollPane.setViewportView(table);
		}
		{
			cboProv.addActionListener(this);
			cboProv.setBounds(50, 62, 104, 22);
			contentPane.add(cboProv);
			
			showTable();
		}
		
		cboProv.addItem("");
		
		for (int i = 0; i < proveedores.size(); i++) {
			cboProv.addItem(proveedores.get(i).getNombreEmpresa());
		}
	}
	
	private void showTable() {
		Object[][] datos = new Object[provsPorProds.size()][columnas.length];

		for (int i = 0; i < provsPorProds.size(); i++) {
			ProvPorProd p = provsPorProds.get(i);
			datos[i][0] = p.getProveedor();
			datos[i][1] = p.getCodigoProducto();
			datos[i][2] = p.getProducto();
		}

		table.setModel(new DefaultTableModel(datos, columnas));
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboProv) {
			do_cboProv_actionPerformed(e);
		}
	}
	protected void do_cboProv_actionPerformed(ActionEvent e) {
		
		try {
			provsPorProds = pDAO.readProvPorProdByProv(cboProv.getSelectedItem().toString());

			Object[][] datos = new Object[provsPorProds.size()][columnas.length];

			for (int i = 0; i < provsPorProds.size(); i++) {
				ProvPorProd p = provsPorProds.get(i);
				datos[i][0] = p.getProveedor();
				datos[i][1] = p.getCodigoProducto();
				datos[i][2] = p.getProducto();
			}

			table.setModel(new DefaultTableModel(datos, columnas));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Verifique los datos ingresados.");
		}
		
	}
}
