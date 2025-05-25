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

import ClasesHijo.ControlStock;
import ClasesHijo.Movimientos;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GuiControlStock extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GuiControlStock dialog = new GuiControlStock();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GuiControlStock() {
		setModal(true);
		setTitle("Control de stock");
		setBounds(100, 100, 932, 601);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPane.setBounds(82, 165, 735, 344);
			contentPanel.add(scrollPane);

			List<ControlStock> listContStk = new ArrayList<ControlStock>();

			listContStk.add(new ControlStock("N001", "Leche Gloria", 10, 5, 5, 6, 9));  // 10 + (5 - 6) = 9
			listContStk.add(new ControlStock("N002", "Arroz Costeño", 8, 4, 6, 5, 9));  // 8 + (6 - 5) = 9
			listContStk.add(new ControlStock("N003", "Azúcar Rubia", 6, 2, 5, 4, 7));   // 6 + (5 - 4) = 7
			listContStk.add(new ControlStock("N004", "Aceite Primor", 12, 6, 7, 8, 11)); // 12 + (7 - 8) = 11
			listContStk.add(new ControlStock("N005", "Fideos Don Vittorio", 7, 3, 4, 2, 9)); // 7 + (4 - 2) = 9
			listContStk.add(new ControlStock("N006", "Sal Lobos", 5, 2, 3, 1, 7));       // 5 + (3 - 1) = 7
			listContStk.add(new ControlStock("N007", "Leche Ideal", 9, 5, 6, 4, 11));    // 9 + (6 - 4) = 11
			listContStk.add(new ControlStock("N008", "Pan Molde", 11, 7, 5, 6, 10));     // 11 + (5 - 6) = 10
			listContStk.add(new ControlStock("N009", "Café Altomayo", 10, 4, 8, 5, 13)); // 10 + (8 - 5) = 13
			listContStk.add(new ControlStock("N010", "Galletas Casino", 6, 3, 4, 6, 4)); // 6 + (4 - 6) = 4
			listContStk.add(new ControlStock("N011", "Atún Florida", 14, 6, 9, 7, 16));  // 14 + (9 - 7) = 16
			listContStk.add(new ControlStock("N012", "Avena Quaker", 8, 4, 3, 3, 8));    // 8 + (3 - 3) = 8
			listContStk.add(new ControlStock("N013", "Jabón Bolívar", 13, 6, 7, 6, 14)); // 13 + (7 - 6) = 14
			listContStk.add(new ControlStock("N014", "Detergente Ariel", 15, 8, 6, 7, 14)); // 15 + (6 - 7) = 14
			listContStk.add(new ControlStock("N015", "Papel Higiénico Elite", 9, 4, 3, 5, 7)); // 9 + (3 - 5) = 7

		
			String[] columnas = { "ID_PRODUCTO", "NOMBRE", "EXISTENCIA INICIALES", "STOCK MÍNIMO", "ENTRADAS", "SALIDAS", "STOCK ACTUAL" };
			Object[][] datos = new Object[listContStk.size()][7];

			for (int i = 0; i < listContStk.size(); i++) {
				ControlStock m = listContStk.get(i);
				datos[i][0] = m.getIdProducto();
				datos[i][1] = m.getNombreProducto();
				datos[i][2] = m.getExistIni();
				datos[i][3] = m.getStkMin();
				datos[i][4] = m.getEntradas();
				datos[i][5] = m.getSalidas();
				datos[i][6] = m.getStkActual();

			}
			table.setModel(new DefaultTableModel(datos, columnas));

		}
		{
			scrollPane.setViewportView(table);
		}
	}

}
