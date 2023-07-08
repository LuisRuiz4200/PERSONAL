package reuzable;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class RenderTable extends DefaultTableCellRenderer{

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		if(value instanceof JButton) {
			return ((JButton)value);
		}
		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}
	
	
	
	
}
