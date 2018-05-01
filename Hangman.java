import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    Scanner input = new Scanner(System.in);
    ArrayList geradenLijst = new ArrayList();
    ArrayList woordLijst = new ArrayList();
    ArrayList goedGeraden = new ArrayList();
    int beurten = 11;
    boolean play = true;

    void spelen() {
        System.out.println("Welkom bij galgje!");
        String woord = vraagWoord();
        ontleedWoord(woord);
        while(play) {
            if(beurten != 0){
                vraagLetter();
                printWoord();
            } else {
                System.out.println("Game over.");
                play = false;
            }

        }
    }

    String vraagWoord() {
        System.out.println("Typ een woord om te raden:");
        return input.nextLine().toLowerCase();
    }

    void ontleedWoord(String woord) {
        for (int i = 0; i < woord.length(); i++) {
            woordLijst.add(woord.charAt(i));
        }
    }

    void vraagLetter() {
        System.out.println("Typ een letter:");
        String letter = input.nextLine().toLowerCase();
        if(letter.length() == 1) {
            char let = letter.charAt(0);
            if (geradenLijst.contains(let)) {
                System.out.println("Deze letter heb je al geraden.");
            } else {
                if (woordLijst.contains(let)) {
                    System.out.println(let + " zat in het woord!");
                    goedGeraden.add(let);
                } else {
                    beurten--;
                    System.out.println(let + " zat niet in het woord, " + beurten + " beurten over.");
                }
            }
        } else {
            System.out.println("Gelieve 1 letter invoeren.");
        }
    }

    void printWoord() {
        String woord = "";
        for (int i = 0; i < woordLijst.size(); i++){
            if (goedGeraden.contains(woordLijst.get(i))){
                woord = woord + woordLijst.get(i);
            } else {
                woord =  woord + "_";
            }
        }
        if (!woord.contains("_")) {
            System.out.println("Gefeliciteerd u hebt gewonnen! Het woord was " + woord + ".");
            play = false;
        } else {
            System.out.println(woord);
        }
    }
}
