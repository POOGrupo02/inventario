package GuisSecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ClasePadre.Producto;
import ClasesHijo.ControlStock;
import ClasesHijo.ProductSingleton;
import ClasesHijo.ProductoGeneral;
import mysql.ProductoDAO;
import mysql.ProductoGeneralDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GuiListaProductos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JButton btnGuardarLista = new JButton("Guardar Lista");
	private final JButton btnBuscarxCod = new JButton("Buscar por código");
	private final JLabel lblNewLabel = new JLabel("Código de producto:");
	private final JTextField txtCodProd = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Buscar por nombre:");
	private ProductoDAO pDAO = new ProductoDAO();
	private ProductoGeneralDAO pgDAO = new ProductoGeneralDAO();
	private final JComboBox<String> cboProd = new JComboBox<>();
	private List<ProductoGeneral> pg = pgDAO.listarProductosGenerales();
	private boolean comboBoxInitialized = false;
	private String[] columnas = {
		    "CÓDIGO_PRODUCTO",
		    "NOMBRE",
		    "MARCA",
		    "PRESENTACIÓN",
		    "UNIDAD DE MEDIDA",
		    "CANTIDAD_MEDIDA",
		    "STOCK",
		    "STOCK_MIN",
		    "COSTO_BASE",
		    "PORCENT_MARGEN",
		    "FECHA_FABRICACION",
		    "FECHA_VENCIMIENTO",
		    "CREATED_AT",
		    "UPDATED_AT"
		};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiListaProductos dialog = new GuiListaProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiListaProductos() {
		setModal(true);
		setBounds(100, 100, 932, 595);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPane.setBounds(54, 166, 813, 297);
			contentPanel.add(scrollPane);
			
			List<Producto> productos = pDAO.readProds();

			Object[][] datos = new Object[productos.size()][14];

			for (int i = 0; i < productos.size(); i++) {
			    Producto p = productos.get(i);
			    datos[i][0]  = p.getCodigoProducto();
				datos[i][1]  = p.getProd();
				datos[i][2]  = p.getMarca();
				datos[i][3]  = p.getPresentacion();
				datos[i][4]  = p.getUnidadMedida();
				datos[i][5]  = String.valueOf(p.getCantidadMedida());
				datos[i][6]  = String.valueOf(p.getStock());
				datos[i][7]  = String.valueOf(p.getStockMin());
				datos[i][8]  = String.valueOf(p.getCostoBase());
				datos[i][9]  = String.valueOf(p.getPorcentMargen());
				datos[i][10] = p.getFechaFabricacion() != null ? p.getFechaFabricacion().toString() : "";
				datos[i][11] = p.getFechaVencimiento() != null ? p.getFechaVencimiento().toString() : "";
				datos[i][12] = p.getCreatedAt();
				datos[i][13] = p.getUpdatedAt();
			}

			table.setModel(new DefaultTableModel(datos, columnas));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			btnGuardarLista.addActionListener(this);
			btnGuardarLista.setBounds(766, 31, 119, 23);
			contentPanel.add(btnGuardarLista);
		}
		{
			btnBuscarxCod.addActionListener(this);
			btnBuscarxCod.setBounds(72, 77, 153, 23);
			contentPanel.add(btnBuscarxCod);
		}
		{
			lblNewLabel.setBounds(72, 35, 140, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtCodProd.setColumns(10);
			txtCodProd.setBounds(241, 32, 86, 20);
			contentPanel.add(txtCodProd);
		}
		{
			lblNewLabel_1.setBounds(395, 35, 119, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			cboProd.addActionListener(this);
			cboProd.setBounds(512, 31, 119, 22);
			contentPanel.add(cboProd);
		}
		
		cboProd.addItem("");
		
		for (int i = 0; i < pg.size(); i++) {
			cboProd.addItem(pg.get(i).getName());
		}
		
		
	}
	
	private String getCodProd() {
		return txtCodProd.getText();
	}
	
	private String getProd() {
		return String.valueOf(getIdProd());
	}

	private int getIdProd() {
		String product = cboProd.getSelectedItem().toString();
		int id = -1;
		for (int i = 0; i < pg.size(); i++) {
			if (pg.get(i).getName().equals(product)) {
				id = pg.get(i).getId();
			}
		}
		return id;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboProd) {
			do_cboProd_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarxCod) {
			do_btnBuscarxCod_actionPerformed(e);
		}
		if (e.getSource() == btnGuardarLista) {
			do_btnGuardarLista_actionPerformed(e);
		}
	}

	protected void do_btnGuardarLista_actionPerformed(ActionEvent e) {
		//pS.guardarCsv();
	}

	protected void do_btnBuscarxCod_actionPerformed(ActionEvent e) {
		try {
			if (getCodProd().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo está vacío.");
				return;
			}
			Producto p = pDAO.readProdByCod(getCodProd());
			if (p != null) {
				JOptionPane.showMessageDialog(this, "Producto encontrado");
				table.setModel(new DefaultTableModel());
				Object[][] datos = new Object[1][14];
				datos[0][0]  = p.getCodigoProducto();
				datos[0][1]  = p.getProd();
				datos[0][2]  = p.getMarca();
				datos[0][3]  = p.getPresentacion();
				datos[0][4]  = p.getUnidadMedida();
				datos[0][5]  = String.valueOf(p.getCantidadMedida());
				datos[0][6]  = String.valueOf(p.getStock());
				datos[0][7]  = String.valueOf(p.getStockMin());
				datos[0][8]  = String.valueOf(p.getCostoBase());
				datos[0][9]  = String.valueOf(p.getPorcentMargen());
				datos[0][10] = p.getFechaFabricacion() != null ? p.getFechaFabricacion().toString() : "";
				datos[0][11] = p.getFechaVencimiento() != null ? p.getFechaVencimiento().toString() : "";
				datos[0][12] = p.getCreatedAt();
				datos[0][13] = p.getUpdatedAt();

				table.setModel(new DefaultTableModel(datos, columnas));
			} else {
				JOptionPane.showMessageDialog(this, "Producto no encontrado.");
				return;
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Ingrese un código válido");
		}
	}
	protected void do_cboProd_actionPerformed(ActionEvent e) {
		if (!comboBoxInitialized) {
	        comboBoxInitialized = true;
	        return;
	    }
		
		try {
			List<Producto> productos = pDAO.readProdsByProd(getProd());

			Object[][] datos = new Object[productos.size()][14];

			for (int i = 0; i < productos.size(); i++) {
			    Producto p = productos.get(i);
			    datos[i][0]  = p.getCodigoProducto();
				datos[i][1]  = p.getProd();
				datos[i][2]  = p.getMarca();
				datos[i][3]  = p.getPresentacion();
				datos[i][4]  = p.getUnidadMedida();
				datos[i][5]  = String.valueOf(p.getCantidadMedida());
				datos[i][6]  = String.valueOf(p.getStock());
				datos[i][7]  = String.valueOf(p.getStockMin());
				datos[i][8]  = String.valueOf(p.getCostoBase());
				datos[i][9]  = String.valueOf(p.getPorcentMargen());
				datos[i][10] = p.getFechaFabricacion() != null ? p.getFechaFabricacion().toString() : "";
				datos[i][11] = p.getFechaVencimiento() != null ? p.getFechaVencimiento().toString() : "";
				datos[i][12] = p.getCreatedAt();
				datos[i][13] = p.getUpdatedAt();
			}

			table.setModel(new DefaultTableModel(datos, columnas));
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Ingrese un código válido");
		}
		
		
	}
}
