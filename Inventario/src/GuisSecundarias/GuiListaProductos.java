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

import ClasePadre.ProductSingleton;
import ClasePadre.Producto;
import ClasesHijo.ControlStock;

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

public class GuiListaProductos extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JButton btnGuardarLista = new JButton("Guardar Lista");
	private final JButton btnBuscarxCod = new JButton("Buscar por código");
	private final JButton btnBuscarxNombre = new JButton("Buscar por nombre");
	private final JLabel lblNewLabel = new JLabel("ID:");
	private final JTextField txtID = new JTextField();
	private final JLabel lblNewLabel_1 = new JLabel("Nombre:");
	private final JTextField txtNom = new JTextField();
	private ProductSingleton pS = ProductSingleton.getInstance();
	private String[] columnas = { "ID_PRODUCTO", "NOMBRE", "PRECIO", "CATEGORÍA", "STOCK"};

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
			scrollPane.setBounds(72, 183, 795, 345);
			contentPanel.add(scrollPane);
			
			Object[][] datos = new Object[pS.getSize()][5];

			for (int i = 0; i < pS.getSize(); i++) {
				Producto p = pS.getProducto(i);
				datos[i][0] = p.getId();
				datos[i][1] = p.getNombre();
				datos[i][2] = p.getPrecio();
				datos[i][3] = p.getCategoría();
				datos[i][4] = p.getStock();
			}
			table.setModel(new DefaultTableModel(datos, columnas));
		}
		{
			scrollPane.setViewportView(table);
		}
		{
			btnGuardarLista.addActionListener(this);
			btnGuardarLista.setBounds(748, 122, 119, 23);
			contentPanel.add(btnGuardarLista);
		}
		{
			btnBuscarxCod.addActionListener(this);
			btnBuscarxCod.setBounds(72, 122, 153, 23);
			contentPanel.add(btnBuscarxCod);
		}
		{
			btnBuscarxNombre.addActionListener(this);
			btnBuscarxNombre.setBounds(375, 122, 165, 23);
			contentPanel.add(btnBuscarxNombre);
		}
		{
			lblNewLabel.setBounds(72, 35, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			txtID.setColumns(10);
			txtID.setBounds(110, 32, 86, 20);
			contentPanel.add(txtID);
		}
		{
			lblNewLabel_1.setBounds(257, 35, 63, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtNom.setColumns(10);
			txtNom.setBounds(322, 32, 153, 20);
			contentPanel.add(txtNom);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarxNombre) {
			do_btnBuscarxNombre_actionPerformed(e);
		}
		if (e.getSource() == btnBuscarxCod) {
			do_btnBuscarxCod_actionPerformed(e);
		}
		if (e.getSource() == btnGuardarLista) {
			do_btnGuardarLista_actionPerformed(e);
		}
	}
	protected void do_btnGuardarLista_actionPerformed(ActionEvent e) {
		File archivo=new File("productos.csv");
    	try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(archivo), "UTF-8");
    		     PrintWriter pw = new PrintWriter(writer)) {
    		    
    		    writer.write('\uFEFF');
    		    
    		    pw.println("ID;Nombre;Precio;Categoria;Stock");

    		    for (int i = 0; i < pS.getSize(); i++) {
    		        Producto p = pS.getProducto(i);
    		        pw.println(p.getId() + ";" + p.getNombre() + ";" + p.getPrecio() + ";" +
    		                   p.getCategoría() + ";" + p.getStock());
    		    }

    		    JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en la carpeta del proyecto");

    		} catch (Exception e1) {
    		    JOptionPane.showMessageDialog(null, "Error al guardar el archivo");
    		}
	}
	protected void do_btnBuscarxCod_actionPerformed(ActionEvent e) {
		try {
			if(LeerID().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo está vacío.");
				return;
			}
			Producto p= pS.BuscarId(LeerID());
	        if (p!=null) {
	        	JOptionPane.showMessageDialog(this, "Producto encontrado");
	        	table.setModel(new DefaultTableModel());
	        	Object[][] datos = new Object[1][5];
	        	datos[0][0] = p.getId();
				datos[0][1] = p.getNombre();
				datos[0][2] = p.getPrecio();
				datos[0][3] = p.getCategoría();
				datos[0][4] = p.getStock();
	        	table.setModel(new DefaultTableModel(datos, columnas));
			}
	        else 
	        {
				JOptionPane.showMessageDialog(this, "El producto no existe");
				return;
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Ingrese un código válido");
		}
	}
	protected void do_btnBuscarxNombre_actionPerformed(ActionEvent e) {
		try {
			if(LeerNombre().isBlank()) {
				JOptionPane.showMessageDialog(this, "El campo está vacío.");
				return;
			}
			Producto p=pS.BuscarNombre(LeerNombre());
	        if (p!=null) {
	        	JOptionPane.showMessageDialog(this, "Producto encontrado");
	        	table.setModel(new DefaultTableModel());
	        	Object[][] datos = new Object[1][5];
	        	datos[0][0] = p.getId();
				datos[0][1] = p.getNombre();
				datos[0][2] = p.getPrecio();
				datos[0][3] = p.getCategoría();
				datos[0][4] = p.getStock();
	        	table.setModel(new DefaultTableModel(datos, columnas));
			}
	        else {
	        	JOptionPane.showMessageDialog(this, "El producto no existe");
			}
		}catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Ingrese un código válido");
		}
		
	}
	
	private String LeerID() {
		return txtID.getText();
	} 
	private String LeerNombre() {
		return txtNom.getText();
	}
}
