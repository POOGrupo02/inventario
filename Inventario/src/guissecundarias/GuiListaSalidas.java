package guissecundarias;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clasepadre.Producto;
import claseshijo.SalidaProducto;
import mysql.SalidasDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiListaSalidas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private SalidasDAO sDAO = new SalidasDAO();
	private ArrayList<SalidaProducto> salidas = sDAO.readSalidas();
	private String[] columnas = { "ID", "CLIENTE", "CODIGO PRODUCTO", "PRODUCTO", "CANTIDAD",
			"MONTO", "FORMA DE PAGO", "CREATED_AT"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiListaSalidas frame = new GuiListaSalidas();
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
	public GuiListaSalidas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			scrollPane.setBounds(56, 192, 872, 265);
			contentPane.add(scrollPane);
			
			Object[][] datos = new Object[salidas.size()][8];

			for (int i = 0; i < salidas.size(); i++) {
				SalidaProducto sP = salidas.get(i);
				datos[i][0] = sP.getId();
				datos[i][1] = sP.getCliente();
				datos[i][2] = sP.getCodProd();
				datos[i][3] = sP.getProducto();
				datos[i][4] = sP.getCantidad();
				datos[i][5] = String.valueOf(sP.getMonto());
				datos[i][6] = sP.getFormaPago();
				datos[i][7] = sP.getCreatedAt();
			}

			table.setModel(new DefaultTableModel(datos, columnas));
		}
		{
			scrollPane.setViewportView(table);
		}
	}
}
