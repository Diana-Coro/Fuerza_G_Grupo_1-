import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UnidadAdmin extends JFrame {

    public UnidadAdmin() {

        setTitle("Unidadadmin");
        setSize(1020, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnas = {
                "Entidad",
                "Unidad",
                "Descrip",
                "Ciudad"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 30);

        JTable tabla = new JTable(modelo);

        tabla.setRowHeight(20);

        tabla.setGridColor(Color.GRAY);

        tabla.setShowGrid(true);

        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(90);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(700);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(120);

        modelo.setValueAt("ltrw", 0, 0);
        modelo.setValueAt("awrw", 0, 1);
        modelo.setValueAt("", 0, 2);
        modelo.setValueAt("Potosi", 0, 3);

        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            UnidadAdmin ventana = new UnidadAdmin();
            ventana.setVisible(true);

        });
    }
}
