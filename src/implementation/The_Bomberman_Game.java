package implementation;

import java.util.*;

public class The_Bomberman_Game {
   static Map<Integer, String> cells;
    static int nextDetonateSecond = 3;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int _R = in.nextInt(); // rows
        int _C = in.nextInt(); // columns
        int _N = in.nextInt(); // seconds

        // the actual grid
        cells = new HashMap<>();
        Map<Integer, String> detonateCells = new HashMap<>();

        String detonateCols = "";
        int i=0;
        for (int k=0; k<_R; k++) {
            String cols = in.nextLine();
            cells.put(i, cols);

            StringBuilder sb = new StringBuilder();
            // find all the index locations at which "o" is present and put it into the map
            for (int j=0; j < cols.length(); j++) {
               if(cols.charAt(j) == 79) {
                   sb.append(j + ",");
               }
            }

            if(!sb.toString().isEmpty()) {
                if(sb.subSequence(sb.length() -1, sb.length()).toString().equals(",")) {
                     detonateCols = sb.substring(0, sb.length() - 1);
                }
                detonateCells.put(i, detonateCols);
            }
            i++;
        }


        System.out.println("here");

        // first, create a list of initial Bomb locations
        // DS - HashMap<Integer (At which second this should be detonated, HashMap<Integer(Row), ArrayList<Integer> (List of Columns)>>
        // Initial Setup :: put that in another map
        HashMap<Integer, Map<Integer, String>> secondsData = new HashMap<>();
        secondsData.put(3,detonateCells);

        // initial setup

        // FILLUP
        Map<Integer, String> nextDetonateCells ;

        // Have a list of cells that needs to be detonated next

        // have a loop to iterate through N seconds
        for(int l=1; l<_N; l++) {

            // if some cells has to be detonated at this second
            if (secondsData.containsKey(i)) {
                // detonate
            } else if (i == nextDetonateSecond -1) {
                // then do a fillup
                nextDetonateCells = The_Bomberman_Game.fillupCells();
            }

        }
    }


    public static Map<Integer, String> fillupCells() {
        Map<Integer, String> nextDetonateCells = new HashMap<>();
        for(Map.Entry<Integer, String> map: cells.entrySet()) {

            StringBuilder sb = new StringBuilder();
            String nextDetonateCols = "";

            // iterate through every item and replace '.' with 'o'

            if(map.getValue().contains(".")) {

                char[] bombs = map.getValue().toCharArray();

                // iterate
                for(int i = 0; i< bombs.length; i++) {
                    if(bombs[i] == '.') {
                        bombs[i] = 'o';
                        sb.append(i + ",");
                    }
                }
                //TODO: this needs to fixed to record the cells that needs to be detonated
                if(!sb.toString().isEmpty()) {
                    if(sb.subSequence(sb.length() -1, sb.length()).toString().equals(",")) {
                        nextDetonateCols = sb.substring(0, sb.length() - 1);
                    }
                    nextDetonateCells.put(map.getKey(), nextDetonateCols);
                    cells.put(map.getKey(), nextDetonateCols);
                }
            }
        }
        return nextDetonateCells;
    }

    }