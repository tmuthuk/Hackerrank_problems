package interviews;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.TreeSet;

/**
 * Part 1:
 *
 *  * this is a two player card game
 *  * the game starts with a deck of 52 cards represented as
 *    unique integers [1...52]
 *  * the cards are randomly shuffled and then dealt out to both players evenly.
 *  * on each turn:
 *      * both players turn over their top-most card
 *      * the player with the higher valued card takes
 *        the cards and puts them in their win pile
 *        (scoring 1 point per card)
 *  * this continues until all the players have no cards left
 *  * the player with the highest score (number of cards in their win pile) wins.
 *     * if they have the same number of cards in their win pile, tiebreaker goes to the player with the highest card in their win pile.
 */
class CardGame{

    Queue<Integer> p1 = new LinkedList<>();
    Queue<Integer> p2 = new LinkedList<>();

    int highestScoreP1;
    int highestScoreP2;

    int scoreP1;
    int scoreP2;

    public void shuffle() {
        // 1..52
        TreeSet<Integer> alreadyDealt = new TreeSet<>();

        while(p1.size()<26 || p2.size()<26) {
            Random random = new Random();
            int card1 = random.nextInt(53);
            int card2 = random.nextInt(53);
            if(card1 != 0 && !alreadyDealt.contains(card1)
                    && p1.size() <26) {
                p1.add(card1);
                alreadyDealt.add(card1);
            }

            if(card2 !=0 && !alreadyDealt.contains(card2) && p2.size() < 26) {
                p2.add(card2);
                alreadyDealt.add(card2);
            }
        }

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }

    public void play() {

        while(!p1.isEmpty() || !p2.isEmpty()) {
            int p1Card = p1.poll();
            int p2Card = p2.poll();

            if(p1Card > p2Card) {
                // p1 s Win pile
                highestScoreP1 = Math.max(highestScoreP1, p1Card);
                scoreP1++;
            } else {
                // p2's Win Pile
                highestScoreP2 = Math.max(highestScoreP2, p2Card);
                scoreP2++;
            }
        }

        if(scoreP1 == scoreP2) {
            String winner;
            if(highestScoreP1 > highestScoreP2) {
                winner = "Player 1";
            } else {
                winner = "Player2";
            }
            System.out.println("The winner is...." + winner);
            return;
        }

        if(scoreP1 > scoreP2) {
            System.out.println("The winner is....PLayer1");
        } else {
            System.out.println("The winner is....Player2");
        }
    }

    public static void main(String[] args) {
        CardGame cardGame = new CardGame();
        cardGame.shuffle();
        cardGame.play();
    }
}
