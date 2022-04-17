package springboot.model.checkPoints;

import java.util.HashSet;
import java.util.Set;

public class collectedCheckpoints {
    Set<CheckPoint> set;

    public collectedCheckpoints() {
            this.set = new HashSet<CheckPoint>();
    }

    public void addCheckPoint(CheckPoint cp){
        set.add(cp);
    }

    public Set<CheckPoint> getSet() {
        return set;
    }
}
