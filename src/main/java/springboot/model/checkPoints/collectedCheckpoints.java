package springboot.model.checkPoints;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class collectedCheckpoints {
    private Set<CheckPoint> set;

    public collectedCheckpoints() {
            this.set = new HashSet<CheckPoint>();
    }

    public void addToBasket(CheckPoint cp){
        set.add(cp);
    }

    public Set<CheckPoint> getSet() {
        return set;
    }

//    public boolean hasAll(CheckPointSet setall){
//        return (set.containsAll((Collection<CheckPoint>) setall));
//    }

}
