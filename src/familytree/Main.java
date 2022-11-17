package familytree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Relative grandFather = new Relative(1, "jorge", "rivero", null);
        Relative father = new Relative(2, "carlos", "rivero", grandFather);
        Relative child = new Relative(3, "alexis", "rivero", father);
        Relative sister = new Relative(4, "rocio", "rivero", father);
        Relative grandChild = new Relative(5, "carlos", "rivero", child);
        Tree tree = new Tree();

        List<Relative> list = new ArrayList<>();
        list.add(grandFather);
        list.add(father);
        list.add(child);
        list.add(grandChild);
        list.add(sister);


        tree.representTree(list);



//        tree.addElement(grandFather.getParentId(), grandFather);
//        tree.addElement(father.getParentId(), father);
//        tree.addElement(child.getParentId(), child);
//        tree.printMap();

    }
}
