package laba8;

import javax.swing.*;

public class ListOfBranchesModel extends DefaultListModel {
    String[] namesOfBranches;

    public ListOfBranchesModel(String[] namesOfBranches) {
        this.namesOfBranches = namesOfBranches;

        for (String namesOfBranch : namesOfBranches) {
            this.addElement(namesOfBranch);
        }
    }
}
