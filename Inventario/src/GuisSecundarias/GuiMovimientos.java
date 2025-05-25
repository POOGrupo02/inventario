package GuisSecundarias;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ClasesHijo.Movimientos;

import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GuiMovimientos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiMovimientos dialog = new GuiMovimientos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiMovimientos() {
		setModal(true);
		setTitle("Movimientos");
		setBounds(100, 100, 911, 605);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPane.setBounds(120, 174, 670, 255);
			contentPanel.add(scrollPane);
			
			List<Movimientos> movimientos = new ArrayList<Movimientos>();
			
			movimientos.add(new Movimientos(1, "N001", "Leche Gloria", "Entrada", 100, "25/06/2020"));
			movimientos.add(new Movimientos(2, "N002", "Arroz Costeño", "Entrada", 200, "26/06/2020"));
			movimientos.add(new Movimientos(3, "N003", "Azúcar Rubia", "Salida", 50, "27/06/2020"));
			movimientos.add(new Movimientos(4, "N004", "Aceite Primor", "Entrada", 80, "28/06/2020"));
			movimientos.add(new Movimientos(5, "N005", "Fideos Don Vittorio", "Salida", 40, "29/06/2020"));
			movimientos.add(new Movimientos(6, "N006", "Sal Lobos", "Entrada", 60, "30/06/2020"));
			movimientos.add(new Movimientos(7, "N007", "Leche Ideal", "Entrada", 90, "01/07/2020"));
			movimientos.add(new Movimientos(8, "N008", "Pan Molde", "Salida", 30, "02/07/2020"));
			movimientos.add(new Movimientos(9, "N009", "Café Altomayo", "Entrada", 70, "03/07/2020"));
			movimientos.add(new Movimientos(10, "N010", "Galletas Casino", "Salida", 25, "04/07/2020"));
			movimientos.add(new Movimientos(11, "N011", "Atún Florida", "Entrada", 110, "05/07/2020"));
			movimientos.add(new Movimientos(12, "N012", "Avena Quaker", "Salida", 20, "06/07/2020"));
			movimientos.add(new Movimientos(13, "N013", "Jabón Bolívar", "Entrada", 150, "07/07/2020"));
			movimientos.add(new Movimientos(14, "N014", "Detergente Ariel", "Salida", 45, "08/07/2020"));
			movimientos.add(new Movimientos(15, "N015", "Papel Higiénico Elite", "Entrada", 130, "09/07/2020"));
			
			String[] columnas = {"ID", "ID_producto", "Producto", "Movimiento", "Cantidad", "Fecha"};
			Object[][] datos = new Object[movimientos.size()][6];
			
			for (int i = 0; i < movimientos.size(); i++) {
				Movimientos m = movimientos.get(i);
				datos[i][0] = m.getId();
			    datos[i][1] = m.getIdProducto();
			    datos[i][2] = m.getProducto();
			    datos[i][3] = m.getMovimiento();
			    datos[i][4] = m.getCantidad();
			    datos[i][5] = m.getFecha();
				
			}
			table.setModel(new DefaultTableModel(datos, columnas));
		}
		{
			scrollPane.setViewportView(table);
		}
	}

}
