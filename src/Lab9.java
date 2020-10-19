import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab9 {
    public static void main(String args[]) {
        Library library =  new Library("NTB Tomsk");

        library.addBranch(new Branch("fantasy", library));
        library.addBranch(new Branch("horror", library));
        library.addBranch(new Branch("drama", library));

        Branch fantasy = (Branch)library.getBranches().get(0);
        fantasy.addEdition(new Edition("Harry Potter", "J. K. Rowling", 2000, fantasy));
        fantasy.addEdition(new Edition("The Chronics of Narnia", "C. S. Lewis", 2005, fantasy));
        fantasy.addEdition(new Edition("Hobbits", "J. R. R. Tolkien", 2000, fantasy));

        Branch horror = (Branch)library.getBranches().get(1);
        horror.addEdition(new Edition("It", "Stephen King", 1986, horror));

        Branch drama = (Branch)library.getBranches().get(2);
        drama.addEdition(new Edition("Pride and Prejudice", "Jane Austin", 2000, drama));


        //Выводим книги во всех отделах
        System.out.println("Each of the books in " + library.getName() + ": ");
        for (Branch item : library.getBranches()) {
            Branch branch = item;
            System.out.println(item.calculateEditionCount() + " books in " + item.getName() + ": ");
            for(Edition ed : item.getEditions()) {
                System.out.println((item.getEditions().indexOf(ed))+1 + ". \"" +ed.getName() + "\" " + ed.getAuthor() + " - " + ed.getYear());
            }
            System.out.print("\n");
        }

        int year;
        System.out.print("Enter the year of searching: ");
        Scanner scan = new Scanner(System.in);
        year = scan.nextInt();

        System.out.println("List of the books from " + year + ": ");
        for(Edition edition: library.findEdition(year)) {
            System.out.println("\"" +edition.getName() + "\" " + edition.getAuthor() + " - " + edition.getYear() + ", branch: " + edition.getBranch().getName());
        }
    }
}

class Library {
    /*Fields*/
    private String name = "";
    private List<Branch> branches = new ArrayList<>();
    /*Constructors*/
    public Library(String name) {
        this.name = name;
    }

    public Library() {
        this.name = "none";
    }

    /*Getters*/
    public String getName() {
        return this.name;
    }

    /*Setters*/
    public void setName(String name) {
        this.name = name;
    }

    /*Methods*/
    public List<Edition> findEdition(int year) {
        List<Edition> editions = new ArrayList<>();
        for(Branch item :this.getBranches()) {
            for(Edition edition : item.getEditions()) {
                if(edition.getYear() == year) {
                    editions.add(edition);
                }
            }
        }
        return editions;
    }

    public List<Branch> getBranches() {
        return this.branches;
    }

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    public void removeBranch(Branch branch) {
        this.branches.remove(branch);
    }
}

class Branch {
    /*Fields*/
    private String name = "";
    private int EditionCount = 0;
    private Library library;
    private List<Edition> editions = new ArrayList<>();
    /*Constructors*/
    public Branch(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public Branch() {
        this.name = "none";
        this.EditionCount = -1;
        this.library = null;
    }

    /*Getters*/
    public String getName() {
        return this.name;
    }

    public Library getLibrary() {
        return this.library;
    }

    public List<Edition> getEditions() {
        return this.editions;
    }

    /*Setters*/
    public void setName(String name) {
        this.name = name;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    /*Methods*/
    public void addEdition(Edition edition) {
        this.editions.add(edition);
    }

    public void removeEdition(Edition edition) {
        this.editions.remove(edition);
    }

    public int calculateEditionCount() {
        EditionCount = editions.size();
        return EditionCount;
    }
}

class Edition {
    /*Fields*/
    private String name = "";
    private String author = "";
    private int year;
    private Branch branch;
    /*Constructors*/
    public Edition(String name, String author, int year, Branch branch) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.branch = branch;
    }

    public Edition() {
        this.name = "none";
        this.author = "none";
        this.year = -1;
        this.branch = null;
    }

    /*Getters*/
    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public Branch getBranch() {
        return this.branch;
    }

    /*Setters*/
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
