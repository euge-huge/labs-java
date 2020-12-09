package laba7;


import library.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetDescriptionBtnClick implements ActionListener {
    JTable table;
    Branch currentBranch;

    public GetDescriptionBtnClick(JTable table, Branch currentBranch) {
        this.table = table;
        this.currentBranch = currentBranch;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (table.getSelectedRow() == -1) {
            new DescriptionPane("not-selected");
        } else {
            String description;

            if (currentBranch.getEditions().get(table.getSelectedRow()) instanceof Catalog) {
                description = "Вид издания: Журнал, ";
            } else {
                description = "Вид издания: Книга, ";
            }
            description += currentBranch.getEditions().get(table.getSelectedRow()).getDescription();
            new DescriptionPane(description);
        }
    }
}
