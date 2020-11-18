package laba5;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private String name;
    private ArrayList<Branch> branches = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void addBranch(Branch branch) {
        branches.add(branch);
    }
}
