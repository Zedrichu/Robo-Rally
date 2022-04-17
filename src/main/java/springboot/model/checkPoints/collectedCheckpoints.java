package springboot.model.checkPoints;

import java.util.HashSet;
import java.util.Set;

public class collectedCheckpoints {
    Set<CheckPoint> set;


    collectedCheckpoints(){Set<CheckPoint> set = new HashSet<>();}


    public void addCheckPoint(CheckPoint cp){
        set.add(cp);
    }

    public Set<CheckPoint> getSet() {
        return set;
    }
}
