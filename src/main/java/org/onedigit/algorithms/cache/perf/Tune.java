package org.onedigit.algorithms.cache.perf;

import java.util.concurrent.Semaphore;

public class Tune
{
    public static void main(String[] args)
    {
        final int k = 500;
        final int STRIDE = 128;
        final int NUM_WAYS = 1;
        final int ARR_SIZE_0 = 1024;
        final int times = 14;
        final boolean debug = false;
        final int thrd = 25;

        int TOTAL_ACCESS = (1024 * 1024 * 128);
        boolean isVerbose = true;

        /*
         * try { times = ((new Integer(args[0])).intValue()); k = ((new
         * Integer(args[1])).intValue()); STRIDE = ((new
         * Integer(args[2])).intValue()); NUM_WAYS = ((new
         * Integer(args[3])).intValue()); thrd = ((new
         * Integer(args[4])).intValue()); isVerbose = ((new
         * Boolean(args[5])).booleanValue()); debug = ((new
         * Boolean(args[6])).booleanValue()); } catch (Exception e) {
         * System.out.println("Using default settings"); }
         */

        if (debug)
            isVerbose = true;

        double targetTime = k * 1000000;
        double thr = (double) thrd / (double) 100;
        System.out.println("Threahold = " + thr);

        int typeSize = 4;
        boolean first = true;
        int i, j, arr_size, arr_items;

        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        int s4 = 0;
        int s5 = 0;
        int s6 = 0;

        long start_time = 0;
        long stop_time = 0;
        double time_cost, cost_per_op;
        int va[];

        double[] record = new double[times];

        arr_size = ARR_SIZE_0;
        int counter = 0;
        while (counter < times) {

            /*-------- Preparing Arrays --------*/

            arr_items = arr_size / typeSize;
            // System.out.println("arr_items = " + arr_items);

            va = new int[arr_items];

            for (i = 0; i < arr_items - NUM_WAYS * STRIDE; i += NUM_WAYS
                    * STRIDE) {
                for (j = i; j < i + NUM_WAYS * STRIDE; j += STRIDE) {
                    va[j] = j + NUM_WAYS * STRIDE;
                }
            }

            for (i = 0; i < NUM_WAYS; i++) {
                va[arr_items - NUM_WAYS * STRIDE + i * STRIDE] = i * STRIDE;
            }

            switch (NUM_WAYS) {
            case 1:
                s1 = 0;
                break;
            case 2:
                s1 = 0;
                s2 = STRIDE;
                break;
            case 3:
                s1 = 0;
                s2 = STRIDE;
                s3 = s2 + STRIDE;
                break;
            case 4:
                s1 = 0;
                s2 = STRIDE;
                s3 = s2 + STRIDE;
                s4 = s3 + STRIDE;
                break;
            case 5:
                s1 = 0;
                s2 = STRIDE;
                s3 = s2 + STRIDE;
                s4 = s3 + STRIDE;
                s5 = s4 + STRIDE;
                break;
            case 6:
                s1 = 0;
                s2 = STRIDE;
                s3 = s2 + STRIDE;
                s4 = s3 + STRIDE;
                s5 = s4 + STRIDE;
                s6 = s5 + STRIDE;
                break;
            }

            /*-------- Chosing access --------*/
            if (first) {
                // chose access
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                }
                stop_time = System.nanoTime();

                if (isVerbose) {
                    System.out.print("access changed from: " + (TOTAL_ACCESS)
                            / 1000000);
                }
                TOTAL_ACCESS = (int) ((targetTime * (double) TOTAL_ACCESS / (NUM_WAYS * STRIDE)) / ((double) (stop_time - start_time)))
                        * (NUM_WAYS * STRIDE);
                if (isVerbose) {
                    System.out.println(" million of access  to: "
                            + (TOTAL_ACCESS) / 1000000 + " million of access");
                }
                first = false;
            }

            /*-------- Start measuremnts loop --------*/
            switch (NUM_WAYS) {
            case 1:
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                    s1 = va[s1];
                }
                stop_time = System.nanoTime();
                break;
            case 2:
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                    s1 = va[s1];
                    s2 = va[s2];
                }
                stop_time = System.nanoTime();
                break;
            case 3:
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];

                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                }
                stop_time = System.nanoTime();
                break;
            case 4:
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];

                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                }
                stop_time = System.nanoTime();
                break;
            case 5:
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];

                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                }
                stop_time = System.nanoTime();
                break;
            case 6:
                start_time = System.nanoTime();
                for (i = 0; i < TOTAL_ACCESS; i += NUM_WAYS * STRIDE) {
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];

                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                    s1 = va[s1];
                    s2 = va[s2];
                    s3 = va[s3];
                    s4 = va[s4];
                    s5 = va[s5];
                    s6 = va[s6];
                }
                stop_time = System.nanoTime();
                break;
            }

            time_cost = ((double) (stop_time - start_time));
            cost_per_op = (time_cost) / (TOTAL_ACCESS / (NUM_WAYS * STRIDE));

            if (isVerbose) {
                System.out.println("array " + arr_items * typeSize / 1024
                        + " KB \t time (us) " + (int) (time_cost / 1000)
                        + "\t cost in ns  " + cost_per_op);
            }

            arr_size = arr_size * 2;
            record[counter] = cost_per_op;
            counter++;
        }

        // TODO

        /*----------------------------------------------------------------------------*/

        /*-------- Now i choose correct values --------*/

        /*----- populating diff array -----*/

        // double[] diff = new double[times - 1];
        double[] diff = new double[times];
        j = 0;
        while (j < times - 1) {
            diff[j] = (record[j + 1] - record[j]) / record[j];
            if (diff[j] < 0) {
                diff[j] = 0;
            }
            if (debug)
                System.out.println((int) Math.pow((double) 2, j) + " -> "
                        + (int) Math.pow((double) 2, j + 1) + "\t " + diff[j]);
            j++;
        }
        int index = 0;
        double max = 0;
        for (int m = 1; m < diff.length; m++) {
            if (diff[m] > max) {
                max = diff[m]; // new maximum
                index = m;
            }
        }

        if (debug) {
            System.out.println("---d " + diff[index]);
            System.out.println("---d " + diff[index + 1]);
            System.out.println("---r " + record[index]);
            System.out.println("---r " + record[index + 1]);
        }

        // System.out.println("Length of diff = " + diff.length);
        // System.out.println("Length of record = " + record.length);
        // System.out.println("index = " + index);

        if (diff[index + 1] > thr && record[index + 1] > record[index]) {
            index++;
        }
        diff[index - 1] = 0;
        diff[index] = 0;
        diff[index + 1] = 0;

        double a = Math.pow((double) 2, (double) index);
        index = 0;
        max = 0;
        for (int m = 1; m < diff.length; m++) {
            if (diff[m] > max) {
                max = diff[m];
                index = m;
            }
        }

        if (debug) {
            System.out.println("---d " + diff[index]);
            System.out.println("---d " + diff[index + 1]);
            System.out.println("---r " + record[index]);
            System.out.println("---r " + record[index + 1]);
        }

        if (diff[index + 1] > thr && record[index + 1] > record[index]) {
            index++;
        }
        double b = Math.pow((double) 2, (double) index);

        int L2 = (int) Math.max(a, b);
        int L1 = (int) Math.min(a, b);

        System.out.println("L1 = " + L1 + " KB, L2 = " + L2 + " KB");

        /*-------- end of estimate --------*/

        /*----------------------------------------------------------------------------*/

        int proc = (Runtime.getRuntime()).availableProcessors();
        System.out.println("Detected " + proc + " CPUs");

        if (false) {

            TOTAL_ACCESS = TOTAL_ACCESS;
            Semaphore sem = new Semaphore(proc);
            Thread[] list = new Thread[proc];

            /*-------- start single mb --------*/
            /*-------- preparing array --------*/
            arr_items = L1 * 1024 * 3 / 4 / typeSize;
            va = new int[arr_items];

            for (i = 0; i < arr_items - NUM_WAYS * STRIDE; i += NUM_WAYS
                    * STRIDE) {
                for (j = i; j < i + NUM_WAYS * STRIDE; j += STRIDE) {
                    va[j] = j + NUM_WAYS * STRIDE;
                }
            }

            for (i = 0; i < NUM_WAYS; i++) {
                va[arr_items - NUM_WAYS * STRIDE + i * STRIDE] = i * STRIDE;
            }

            s1 = 0;
            /*-------- end preparing array --------*/
            /*-------- start single mb test--------*/

            for (int l = 0; l < 1; l++) {
                list[l] = new Cmp(va, TOTAL_ACCESS, sem);
            }// end for

            start_time = System.nanoTime();
            for (int l = 0; l < 1; l++) {
                ((Cmp) list[l]).start();
            }// end for
            try {
                Thread.sleep(10);
                sem.acquire(proc);// is blocking !!!!
            } catch (Exception e) {
                System.out.println("ERROR");
            }
            stop_time = System.nanoTime();
            sem.release(proc);

            double resl1 = 1000
                    * ((double) TOTAL_ACCESS / (double) (NUM_WAYS * STRIDE))
                    / ((double) ((stop_time - start_time)));
            System.out.println("MAPS " + resl1 + " @ " + L1 * 3 / 4 + "KB");

            /*
             * 
             * start_time = System.nanoTime(); for (i = 0; i < TOTAL_ACCESS; i
             * += NUM_WAYS * STRIDE) { s1 = va[s1]; s1 = va[s1]; s1 = va[s1]; s1
             * = va[s1]; s1 = va[s1]; s1 = va[s1]; s1 = va[s1]; s1 = va[s1]; }
             * stop_time = System.nanoTime(); double resl1 = 1000 * ((double)
             * TOTAL_ACCESS / (double) (NUM_WAYS * STRIDE)) / ((double)
             * ((stop_time - start_time))); System.out.println("MAPS " + resl1 +
             * " @ " + L1 * 3 / 4 + "KB");
             */
            /*-------- end single mb test--------*/

            /*-------- preparing array --------*/
            arr_items = L2 * 1024 * 3 / 4 / typeSize;
            va = new int[arr_items];

            for (i = 0; i < arr_items - NUM_WAYS * STRIDE; i += NUM_WAYS
                    * STRIDE) {
                for (j = i; j < i + NUM_WAYS * STRIDE; j += STRIDE) {
                    va[j] = j + NUM_WAYS * STRIDE;
                }
            }

            for (i = 0; i < NUM_WAYS; i++) {
                va[arr_items - NUM_WAYS * STRIDE + i * STRIDE] = i * STRIDE;
            }

            s1 = 0;
            /*-------- end preparing array --------*/
            /*-------- start single mb test--------*/

            for (int l = 0; l < 1; l++) {
                list[l] = new Cmp(va, TOTAL_ACCESS, sem);
            }// end for

            start_time = System.nanoTime();
            for (int l = 0; l < 1; l++) {
                ((Cmp) list[l]).start();
            }// end for
            try {
                Thread.sleep(10);
                sem.acquire(proc);// is blocking !!!!
            } catch (Exception e) {
                System.out.println("ERROR");
            }
            stop_time = System.nanoTime();
            sem.release(proc);

            double resl2 = 1000
                    * ((double) TOTAL_ACCESS / (double) (NUM_WAYS * STRIDE))
                    / ((double) ((stop_time - start_time)));
            System.out.println("MAPS " + resl2 + " @ " + L2 * 3 / 4 + "KB");

            /*
             * start_time = System.nanoTime(); for (i = 0; i < TOTAL_ACCESS; i
             * += NUM_WAYS * STRIDE) { s1 = va[s1]; s1 = va[s1]; s1 = va[s1]; s1
             * = va[s1]; s1 = va[s1]; s1 = va[s1]; s1 = va[s1]; s1 = va[s1]; }
             * stop_time = System.nanoTime(); double resl2 = 1000 * ((double)
             * TOTAL_ACCESS / (double) (NUM_WAYS * STRIDE)) / ((double)
             * ((stop_time - start_time))); System.out.println("MAPS " + resl2 +
             * " @ " + L2 * 3 / 4 + "KB");
             */
            /*-------- end single mb test--------*/

            if (proc > 1) {

                /*-------- start L1 cmp mb --------*/
                /*-------- preparing array --------*/
                arr_items = L1 * 1024 * 3 / 4 / typeSize;
                va = new int[arr_items];

                for (i = 0; i < arr_items - NUM_WAYS * STRIDE; i += NUM_WAYS
                        * STRIDE) {
                    for (j = i; j < i + NUM_WAYS * STRIDE; j += STRIDE) {
                        va[j] = j + NUM_WAYS * STRIDE;
                    }
                }

                for (i = 0; i < NUM_WAYS; i++) {
                    va[arr_items - NUM_WAYS * STRIDE + i * STRIDE] = i * STRIDE;
                }

                s1 = 0;
                /*-------- end preparing array --------*/

                for (int l = 0; l < proc; l++) {
                    list[l] = new Cmp(va, TOTAL_ACCESS, sem);
                }// end for

                start_time = System.nanoTime();
                for (int l = 0; l < proc; l++) {
                    ((Cmp) list[l]).start();
                }// end for
                try {
                    Thread.sleep(10);
                    sem.acquire();// is blocking !!!!
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
                stop_time = System.nanoTime();
                sem.release();

                double cmpresl1 = proc
                        * 1000
                        * ((double) TOTAL_ACCESS / (double) (NUM_WAYS * STRIDE))
                        / ((double) ((stop_time - start_time)));
                System.out.println("CMP MAPS ON " + proc + " CPUs " + cmpresl1
                        + " @ " + L1 * 3 / 4 + "KB");
                /*-------- end L1 cmp mb --------*/

                /*-------- start L2 cmp mb --------*/
                /*-------- preparing array --------*/
                arr_items = L2 * 1024 * 3 / 4 / typeSize;
                va = new int[arr_items];

                for (i = 0; i < arr_items - NUM_WAYS * STRIDE; i += NUM_WAYS
                        * STRIDE) {
                    for (j = i; j < i + NUM_WAYS * STRIDE; j += STRIDE) {
                        va[j] = j + NUM_WAYS * STRIDE;
                    }
                }

                for (i = 0; i < NUM_WAYS; i++) {
                    va[arr_items - NUM_WAYS * STRIDE + i * STRIDE] = i * STRIDE;
                }

                s1 = 0;
                /*-------- end preparing array --------*/
                sem = new Semaphore(proc);
                list = new Thread[proc];

                for (int l = 0; l < proc; l++) {
                    list[l] = new Cmp(va, TOTAL_ACCESS, sem);
                }// end for

                start_time = System.nanoTime();
                for (int l = 0; l < proc; l++) {
                    ((Cmp) list[l]).start();
                }// end for
                try {
                    Thread.sleep(10);
                    sem.acquire();// is blocking !!!!
                } catch (Exception e) {
                    System.out.println("ERROR");
                }
                stop_time = System.nanoTime();

                double cmpresl2 = proc
                        * 1000
                        * ((double) TOTAL_ACCESS / (double) (NUM_WAYS * STRIDE))
                        / ((double) ((stop_time - start_time)));
                System.out.println("CMP MAPS ON " + proc + " CPUs " + cmpresl2
                        + " @ " + L2 * 3 / 4 + "KB");
                /*-------- end L2 cmp mb --------*/

                if (cmpresl1 < 0.5 * proc * resl1) {
                    System.out.println("L1 seems to be shared");
                }
                if (cmpresl2 < 0.5 * proc * resl2) {
                    System.out.println("L2 seems to be shared");
                }

            }
        }
    }
}
