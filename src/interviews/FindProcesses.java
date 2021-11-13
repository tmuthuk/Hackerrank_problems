package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Task Description
 *
 * Multiprocessor systems use multiple CPUs to perform various tasks. This increases throughput and reduces response time. In this problem, a multiprocessor system has a certain number of processors. Each processor has the ability to schedule a limited number of processes in one second. However, after this scheduling, the processor's ability is reduced to floor(ability/2). Given the processor's abilities and the number of processes, what is the minimum time required to schedule all the processes in the system?
 *
 *
 *
 * Example
 *
 * n = 5 (number of processors and size of ability[])
 *
 * ability = [3, 1, 7, 2, 4]
 *
 * processes = 15
 *
 *
 *
 * This optimal solution is:
 *
 * First, the processor with ability = 7 schedules 7 processes in one second. Now, ability = [3, 1, 3, 2, 4] because 7 was reduced to floor(7/2). There are 15 - 7 = 8 remaining processes.
 *
 * Second, the processor with ability = 4 is used. After that, ability = [3, 1, 3, 2, 2]. Remaining processes = 8 - 4 = 4.
 *
 * Third, a processor with ability = 3 is used. Now, ability = [1, 1, 3, 2, 2]. Remaining processes = 4 - 3 = 1.
 *
 * Finally, a processor with ability = 1 is used to schedule the final process.
 *
 *
 *
 * Each step requires one second of processing time so the answer is 4.
 *
 *
 *
 * Function Description
 *
 * Complete the function minimumTime in the editor below.
 *
 *
 *
 * minimumTime has the following parameter(s):
 *
 *     int ability[n]:  each element denotes the ability of the ith processor
 *
 *     long processes: the number of processes to be scheduled
 *
 *
 */
public class FindProcesses {
    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(150, 182, 178, 192, 121, 196, 153, 185, 178, 197, 152, 192, 106, 191, 172, 129, 137, 198,
                163, 134, 160, 190, 169, 134, 161, 128, 198, 176, 200, 188, 188, 162, 188, 164, 142, 191, 156, 162, 195,
                189, 164, 173, 187, 129, 177, 164, 138, 177, 167, 197);

        ArrayList<Integer> input = new ArrayList<>();
        input.addAll(inputArray);
        System.out.println( minimumTime(input, 13916));
    }
    public static int minimumTime(ArrayList<Integer> ability, long processes) {
        System.out.println("starting array: " + ability);
        System.out.println("starting processes: " + processes);
        // Write your code here
        Collections.sort(ability, Collections.reverseOrder());
        System.out.println("starting array: " + ability);

        // 5,3,2,1,1
        int timeCounter = 0;

        int counter = 0;
        int index = 0;
        boolean modified = false;
        while((processes != 0 || !ability.isEmpty()) && index < ability.size()) {
            int last = ability.get(index);
            // 7 => 15 - 7 and 3
            if(processes >= last) {
                processes -= last;

                 System.out.println("consuming: " + last);
                ability.remove(index);
                int newVal = (int)Math.floor(last/2);
                if(newVal!=0)
                    ability.add(index, newVal);
                modified = true;
                timeCounter++;
            }
            if(processes == 0) break;
            index++;
            if(index >= ability.size()) {
                index = 0;
                System.out.println("processes: " + processes);
                Collections.sort(ability, Collections.reverseOrder());
                System.out.println("index reset array: " + ability);

                // break when there is no matching case
                // System.out.println("counter: " + counter);
                if(!modified) break;
                else modified = false;
                // System.out.println("reset to 0");
            }
            // System.out.println("index: " + index);
//             System.out.println("abiliy size " + ability.size());
        }
        System.out.println(" array: " + ability);
        // System.out.println(ability);
        return timeCounter;
    }
}
