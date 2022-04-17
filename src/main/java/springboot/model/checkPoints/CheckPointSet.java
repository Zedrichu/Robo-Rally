package springboot.model.checkPoints;

import io.cucumber.java.hu.Ha;
import springboot.model.cards.Card;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// set of individual checkpoints
public class CheckPointSet {
    CheckPoint cp;
    // Creating an empty HashSet
    //HashSet<Integer> h = new HashSet<Integer>();

    Set<CheckPoint> set = new HashSet<CheckPoint>();

    CheckPointSet(int number){
        for (int i = 0; i <= number ; i++){
            cp = new CheckPoint();
            set.add(cp);

        }
    }

}


