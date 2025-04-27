package GuisSecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Arreglo_producto;
import Clases.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
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
		setBounds(100, 100, 656, 434);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(123, 127, 89, 23);
		contentPanel.add(btnModificar);
		
		JButton btnBuscarxNombre = new JButton("Buscar por nombre");
		btnBuscarxNombre.setBounds(397, 127, 165, 23);
		contentPanel.add(btnBuscarxNombre);
		
		btnBuscarxCod = new JButton("Buscar por código");
		btnBuscarxCod.addActionListener(this);
		btnBuscarxCod.setBounds(222, 127, 153, 23);
		contentPanel.add(btnBuscarxCod);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(10, 15, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(247, 17, 63, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Stock: 10");
		lblNewLabel_2.setBounds(10, 46, 63, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio:");
		lblNewLabel_3.setBounds(247, 56, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		txtID = new JTextField();
		txtID.setBounds(116, 11, 86, 20);
		contentPanel.add(txtID);
		txtID.setColumns(10);
		
		txtNom = new JTextField();
		txtNom.setBounds(322, 14, 153, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		txtStock = new JTextField();
		txtStock.setBounds(116, 53, 86, 20);
		contentPanel.add(txtStock);
		txtStock.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(322, 53, 86, 20);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Modificar stock:");
		lblNewLabel_2_1.setBounds(10, 60, 103, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		JButton btnEliminar = new JButton("Eliminar por código");
		btnEliminar.setBounds(24, 161, 146, 23);
		contentPanel.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(386, 161, 89, 23);
		contentPanel.add(btnSalir);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(24, 127, 89, 23);
		contentPanel.add(btnAgregar);
		{
			txtCategoria = new JTextField();
			txtCategoria.setColumns(10);
			txtCategoria.setBounds(116, 95, 86, 20);
			contentPanel.add(txtCategoria);
		}
		{
			lblNewLabel_2_2 = new JLabel("Categoría:");
			lblNewLabel_2_2.setBounds(10, 101, 89, 14);
			contentPanel.add(lblNewLabel_2_2);
		}
		
		btnListar = new JButton("Listar Productos");
		btnListar.addActionListener(this);
		btnListar.setBounds(232, 161, 142, 23);
		contentPanel.add(btnListar);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 205, 441, 167);
			contentPanel.add(scrollPane);
			{
				txtLstProduc = new JTextArea();
				scrollPane.setViewportView(txtLstProduc);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscarxCod) {
			do_btnBuscarxCod_actionPerformed(e);
		}
		if (e.getSource() == btnModificar) {
			do_btnModificar_actionPerformed(e);
		}
		if (e.getSource() == btnSalir) {
			do_btnSalir_actionPerformed(e);
		}
		if (e.getSource() == btnListar) {
			do_btnListar_actionPerformed(e);
		}
		if (e.getSource() == btnAgregar) {
			do_btnAgregar_actionPerformed(e);
		}
	}
	
	Arreglo_producto ap=new Arreglo_producto();
	
	private JTextField txtCategoria;
	private JLabel lblNewLabel_2_2;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JTextArea txtLstProduc;
	private JButton btnSalir;
	private JButton btnModificar;
	private JButton btnBuscarxCod;
	
	public int LeerID() {
		return Integer.parseInt(txtID.getText());
	} 
	public String LeerNombre() {
		return txtNom.getText();
	}
	public int LeerStock() {
		return Integer.parseInt(txtStock.getText());
	}
	public String LeerCategoria() {
		return txtCategoria.getText();
	}
	public double LeerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	public void Imprimir(String s) {
		txtLstProduc.append(s+"\n");
	}
	public String Cabezal() {
		return "ID"+"\tNombre"+"\tPrecio"+"\tCategoría"+"\tStock";
	}
	public void Listado() {
		for (int i = 0; i < ap.Cant_Productos(); i++) {
			Imprimir(ap.Obtener(i).getId()+"\t"+ap.Obtener(i).getNombre()+
					"\t"+ap.Obtener(i).getPrecio()+"\t"+ap.Obtener(i).getCategoría()+
					"\t"+ap.Obtener(i).getStock());
		}
	}
	
	protected void do_btnAgregar_actionPerformed(ActionEvent e) {
		try {
			Producto p=new Producto(LeerID(),LeerStock(),LeerNombre(),LeerCategoria(),LeerPrecio());
			
			if (ap.Buscar(LeerID())!=null) {
				JOptionPane.showMessageDialog(this,"El producto ya existe");
				return;
			}
			ap.Agregar(p);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Error al registrar el producto, verifique los datos ingresados");
			// TODO: handle exception
		}
	}
	protected void do_btnListar_actionPerformed(ActionEvent e) {
		if (ap.Cant_Productos()==0) {
			JOptionPane.showMessageDialog(this,"La lista está vacía");
			return;
		}
		txtLstProduc.setText("");
		Imprimir(Cabezal());
		Listado();
	}
	
	protected void do_btnModificar_actionPerformed(ActionEvent e) {
		try {
			Producto p=ap.Buscar(LeerID());
	        if (p!=null) {
			    p.setNombre(LeerNombre());
			    p.setPrecio(LeerPrecio());
			    p.setCategoría(LeerCategoria());
			    p.setStock(LeerStock());
			}
	        else 
	        {
				JOptionPane.showMessageDialog(this, "El producto no existe");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Ingrese un código válido");
			// TODO: handle exception
		}
        
	}
	protected void do_btnBuscarxCod_actionPerformed(ActionEvent e) {
		txtLstProduc.setText("");
		try {
			Producto p=ap.Buscar(LeerID());
	        if (p!=null) {
	        	JOptionPane.showMessageDialog(this, "Producto encontrado");
	        	Cabezal();
	        	Imprimir(p.getId()+"\t"+p.getNombre()+
						"\t"+p.getPrecio()+"\t"+p.getCategoría()+
						"\t"+p.getStock());
			}
	        else 
	        {
				JOptionPane.showMessageDialog(this, "El producto no existe");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this,"Ingrese un código válido");
			// TODO: handle exception
		}
	}
	
	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		dispose();
	}
}
