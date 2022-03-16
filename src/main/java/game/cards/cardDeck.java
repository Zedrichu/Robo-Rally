package game.cards;

import java.util.ArrayList;
import java.util.Set;

interface Card {
    public void action();
}


public class cardDeck {
    private final int size = 84;
    private ArrayList<Card> cardArrayList;

    public void completeDeck() {
        //Very not solid - Jeppe
//        for (int i=0; i<=84;i++){
//            if (i<=18) {
//                cardArrayList.add(1 tile forward);
//            }
//            else if (i>18 && i<=30){
//                cardArrayList.add(2 tiles forward);
//            }
//            else if (i>30 && i<=36){
//                cardArrayList.add(3 tiles foward);
//            }
//            else if (i>36 && i<=54){
//                cardArrayList.add(rotate left 1);
//            }
//            else if (i>54 && i<=72){
//                cardArrayList.add(rotate  right1)
//            }
//            else if (i>72 && i<=78){
//                cardArrayList.add(U turn)
//            }
//            else if (i>78 && i<=84){
//                cardArrayList.add(1 tile backwards)
//            }
//       }


    }

    public cardDeck(){
        cardArrayList = new ArrayList<Card>();
    }

    //public int generateSetCard(){}

}
