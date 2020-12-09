package library;

import java.io.Serializable;
import java.util.ArrayList;

public class Branch implements Serializable {
    private String name;
    private ArrayList<Edition> editions = new ArrayList<>();

    public Branch() {}
    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAmountOfEditions() {
        return editions.size();
    }

    public ArrayList<Edition> getEditions() {
        return editions;
    }

    public void setEditions(ArrayList<Edition> editions) {
        this.editions = editions;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEdition(Edition edition) {
        editions.add(edition);
    }

}
