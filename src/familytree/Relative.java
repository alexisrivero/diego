package familytree;

public class Relative {
    private int id;
    private String names;
    private String givenName;
    private int parentId;
    

    public Relative(int id, String names, String givenName, Relative relative) {
        this.id= id;
        this.names = names;
        this.givenName = givenName;
        if (relative == null) {
            this.parentId = 0;
        } else{
            this.parentId = relative.getId();
        }

    }

    public int getParentId() {
        return parentId;
    }

    public int getId() {
        return id;
    }

    public String getNames() {
        return names;
    }

    public String getGivenName() {
        return givenName;
    }
}
