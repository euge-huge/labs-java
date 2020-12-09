package laba9;


import library.Branch;

import javax.swing.table.DefaultTableModel;

import static laba9.HelpMethods.getParsedTable;


public class EditionTableModel extends DefaultTableModel {
    Object[][] data;
    int rowCount;
    String[] columnNames = {"Вид издания",
            "Название",
            "Автор",
            "Год издания",
            "Дополнительно"};
    Class[] columnClasses = new Class[]{String.class, String.class, String.class, Integer.class, String.class};

    public EditionTableModel(Branch branch) {
        if (branch == null) {
            this.data = new Object[][]{
                    {"-", "-", "-", "-", "-"},
            };
        } else {
            this.data = getParsedTable(branch);
        }
        this.rowCount = this.data.length;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return columnClasses[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
}
