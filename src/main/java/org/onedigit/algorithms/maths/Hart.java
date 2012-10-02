package org.onedigit.algorithms.maths;

/**
 * 
 * Calculates the normal cumulative distribution function.
 * <p>
 * It is based upon algorithm 5666 for the error function, from:
 * <p>
 * 
 * <pre>
 *       Hart, J.F. et al, 'Computer Approximations', Wiley 1968
 * </pre>
 * <p>
 * The FORTRAN programmer was Alan Miller. The documentation in the FORTRAN code
 * claims that the function is "accurate to 1.e-15."
 * <p>
 * Steve Verrill translated the FORTRAN code (the March 30, 1986 version) into
 * Java. This translation was performed on January 10, 2001.
 * 
 * @param z
 *            The method returns the value of the normal cumulative distribution
 *            function at z.
 * 
 * @version .5 --- January 10, 2001
 * 
 * @author ahmed
 */

public class Hart
{
    public static double normp(double z)
    {
        double zabs;
        double p;
        double expntl, pdf;

        final double p0 = 220.2068679123761;
        final double p1 = 221.2135961699311;
        final double p2 = 112.0792914978709;
        final double p3 = 33.91286607838300;
        final double p4 = 6.373962203531650;
        final double p5 = .7003830644436881;
        final double p6 = .3526249659989109E-01;

        final double q0 = 440.4137358247522;
        final double q1 = 793.8265125199484;
        final double q2 = 637.3336333788311;
        final double q3 = 296.5642487796737;
        final double q4 = 86.78073220294608;
        final double q5 = 16.06417757920695;
        final double q6 = 1.755667163182642;
        final double q7 = .8838834764831844E-1;

        final double cutoff = 7.071;
        final double root2pi = 2.506628274631001;

        zabs = Math.abs(z);

        if (z > 37.0) {

            p = 1.0;

            return p;

        }

        if (z < -37.0) {

            p = 0.0;

            return p;

        }

        expntl = Math.exp(-.5 * zabs * zabs);

        pdf = expntl / root2pi;

        if (zabs < cutoff) {

            p = expntl
                    * ((((((p6 * zabs + p5) * zabs + p4) * zabs + p3) * zabs + p2)
                            * zabs + p1)
                            * zabs + p0)
                    / (((((((q7 * zabs + q6) * zabs + q5) * zabs + q4) * zabs + q3)
                            * zabs + q2)
                            * zabs + q1)
                            * zabs + q0);

        } else {

            p = pdf
                    / (zabs + 1.0 / (zabs + 2.0 / (zabs + 3.0 / (zabs + 4.0 / (zabs + 0.65)))));

        }

        if (z < 0.0) {

            return p;

        } else {

            p = 1.0 - p;

            return p;

        }

    }

}