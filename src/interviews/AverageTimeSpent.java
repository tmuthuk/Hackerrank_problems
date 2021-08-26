package interviews;

/*
 * Click `Run` to execute the snippet below!
 */

import leetcode.arrays_strings.MovingAverage;

import java.io.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/* Definitions */
class AdvertiserEvent {
    public final int advertiserId;
    public final int timestamp;
    public final int timeSpentSec;
    public AdvertiserEvent(int advertiserId, int timestamp, int timeSpentSec) {
        this.advertiserId = advertiserId;
        this.timestamp = timestamp;
        this.timeSpentSec = timeSpentSec;
    }
}

interface AdvertiserConsumer {
    public AdvertiserEvent get() throws Exception;
}

interface MetricProducer {
    public void produce(int advertiserId, float latencySecAvg);
}
/* End definitions */

/* Mocks */
class MockConsumer implements AdvertiserConsumer {
    private Thread generate;
    private BlockingQueue<AdvertiserEvent> queue;
    private AtomicBoolean running = new AtomicBoolean(true);
    private final int MAX_EVENTS = 20;
    private int counter = 0;
    public MockConsumer() {
        this.queue = new SynchronousQueue<>();
        this.generate = new Thread() {
            private int lastTimestamp = (int)Instant.now().getEpochSecond();
            private int[] advertisers = new int[]{123, 456, 789};
            public void run() {
                while (running.get()) {
                    Random rnd = new Random();
                    int nextTimestamp = lastTimestamp + rnd.nextInt(20);
                    this.lastTimestamp = nextTimestamp;
                    try {
                        AdvertiserEvent event = new AdvertiserEvent(
                                advertisers[rnd.nextInt(this.advertisers.length)],
                                nextTimestamp,
                                rnd.nextInt(120));
                        queue.put(event);
                        Thread.sleep(rnd.nextInt(10));
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        };
        this.generate.start();
    }

    public AdvertiserEvent get() throws Exception {
        if (counter == MAX_EVENTS) {
            running.set(false);
            throw new Exception("end of messages");
        }

        AdvertiserEvent event = this.queue.take();

        if (event != null) {
            counter++;
        }

        return event;
    }
}

class MockProducer implements MetricProducer {
    public void produce(int advertiserId, float timeSpentSecAvg) {
        System.out.printf("%d: %.2fs\n", advertiserId, timeSpentSecAvg);
    }
}
/* End mocks */

public class AverageTimeSpent {
    public static void main(String[] args) {
        // Please write your code here.
        HashMap<Integer, RunningAverage> averageMap = new HashMap<>();

        MockConsumer consumer = new MockConsumer();


        try {
            while(consumer.get() != null) {
                AdvertiserEvent newEvent = consumer.get();
                RunningAverage runningAverage = null;

                if(averageMap.containsKey(newEvent.advertiserId)) {
                    runningAverage = averageMap.get(newEvent.advertiserId);
                    runningAverage.calculateAndSetNewAverage(newEvent.timeSpentSec);
                } else {
                    // Sanity check to make sure that the averages are not messed up
                    if(newEvent.timeSpentSec > 0.0)
                        runningAverage = new RunningAverage(newEvent.timeSpentSec, 1);
                }

                if(runningAverage != null)
                    // update the mapping
                    averageMap.put(newEvent.advertiserId,  runningAverage);

                // retrieve from the map
                System.out.println("Advertiser ID: " + newEvent.advertiserId + "time spent: " + newEvent.timeSpentSec);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Print out the current average for each advertiser in the map
        for(Map.Entry<Integer, RunningAverage> entry: averageMap.entrySet()) {
            System.out.println("AdvertiserID: " + entry.getKey() + ", average time spent: " + entry.getValue().getCurrentAverage());
        }
    }


}

class RunningAverage {
    private AtomicReference<Double> currentAverage = new AtomicReference<>();
    private AtomicInteger eventCounter = new AtomicInteger();
    public Double getCurrentAverage() {
        return currentAverage.get();
    }

    public RunningAverage(double avg, int count) {
        this.currentAverage.set(avg);
        this.eventCounter.set(count);
    }
//
//    public RunningAverage
    /**
     * Does two Operations:
     * 1. Increments the event Counter
     * 2. Calculates the moving average and updates the refs
     * @param timeSpentSec new time spent input
     */
    public void calculateAndSetNewAverage(double timeSpentSec) {
       currentAverage.set(((currentAverage.get() * eventCounter.get()) + timeSpentSec) / eventCounter.incrementAndGet());
    }
}
