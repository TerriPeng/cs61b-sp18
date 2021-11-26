public class NBody {

    public static double readRadius(String filename) {

        In in = new In(filename);

		int planet_num = in.readInt();
		double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String filename) {

        In in = new In(filename); 
        
        int planet_num = in.readInt();
        in.readDouble();

        Planet[] planet_store = new Planet[planet_num];

        for(int i = 0; i < planet_num; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();

            planet_store[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planet_store;
    }

    public static void main(String[] args) {

        String background = "./images/starfield.jpg";

        double T = Double.parseDouble(args[0]); 
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double t = 0; 

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();

        while(t < T) {
            double[] xForces = new double[planets.length]; 
            double[] yForces = new double[planets.length]; 

            StdDraw.picture(0, 0, background);

            for(int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for(int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
                planets[i].draw();
            }

            StdDraw.show();
            StdDraw.pause(10);

            t += dt;
        }

		StdDraw.show();
    
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}