package familytree;

import java.util.*;
import java.util.stream.Collectors;

public class Tree{
    private Map<Integer, Relative> map = new TreeMap<>();

    public void addElement(Integer key, Relative relative) {
        map.put(key, relative);
    }

    public void printMap() {
        map.forEach((key, relative) -> System.out.println("key(PARENT ID): " + key + " " + relative.getNames() + " " + relative.getGivenName() + " id: " + relative.getId() + " parent id:  " + relative.getParentId()));
    }

    public Map<Integer, Relative> representTree(Collection<Relative> relatives) {
        if (relatives instanceof Set<Relative> || relatives instanceof List<Relative>) {
            Map<Integer, Relative> toMap = relatives.stream().collect(Collectors.toMap(Relative::getParentId, relative -> relative));
            Map<Integer, Relative> toTree = toMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue, newValue) -> newValue, TreeMap::new));
            toTree.forEach((key, relative) -> System.out.println("key(PARENT ID): " + key + " " + relative.getNames() + " " + relative.getGivenName() + " id: " + relative.getId() + " parent id:  " + relative.getParentId()));

            return toTree;
        }
        return null;
    }
}
