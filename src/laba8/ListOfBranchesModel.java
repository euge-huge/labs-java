package laba8;

import javax.swing.*;

public class ListOfBranchesModel extends DefaultListModel {
    String[] namesOfBranches;

    public ListOfBranchesModel(String[] namesOfBranches) {
        this.namesOfBranches = namesOfBranches;

        for (int i = 0; i < namesOfBranches.length; i++) {
            this.addElement(namesOfBranches[i]);
        }
    }
}
