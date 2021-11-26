public class Planet {

    public double xxPos; 
    public double yyPos; 
    public double xxVel; 
    public double yyVel; 
    public double mass; 
    public String imgFileName; 
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, 
                  double yV, double m, String img) {
        
        xxPos = xP; 
        yyPos = yP;
        xxVel = xV; 
        yyVel = yV;
        mass = m; 
        imgFileName = img;
    }

    public Planet(Planet p) {
              
        xxPos = p.xxPos; 
        yyPos = p.yyPos;
        xxVel = p.xxVel; 
        yyVel = p.yyVel;
        mass = p.mass; 
        imgFileName = p.imgFileName;
        
    }

    public double calcDistance(Planet p) {

        double dx = p.xxPos - xxPos; 
        double dy = p.yyPos - yyPos; 

        double r = Math.sqrt(dx*dx + dy*dy);

        return r;
    }

    public double calcForceExertedBy(Planet p) {

        double F = (G * mass * p.mass)/(calcDistance(p)*calcDistance(p));

        return F;
    }

    public double calcForceExertedByX(Planet p) {

        double dx = p.xxPos - xxPos; 
        double F_dx = calcForceExertedBy(p) * dx/calcDistance(p);

        return F_dx;
    }

    public double calcForceExertedByY(Planet p) {

        double dy = p.yyPos - yyPos; 
        double F_dy = calcForceExertedBy(p) * dy/calcDistance(p);

        return F_dy;
    }

    public double calcNetForceExertedByX(Planet[] ps) {

        double F_dx_store = 0;

        for (int i=0; i<ps.length; i++) {
            if (!ps[i].equals(this)) {
                F_dx_store += calcForceExertedByX(ps[i]);
            }
        }

        return F_dx_store;
    }

    public double calcNetForceExertedByY(Planet[] ps) {

        double F_dy_store = 0;

        for (int i=0; i<ps.length; i++) {
            if (!ps[i].equals(this)) {
                F_dy_store += calcForceExertedByY(ps[i]);
            }
        }

        return F_dy_store;
    }

    public void update(double dt, double fX, double fY) {

        double xxAcc = fX/mass; 
        double yyAcc = fY/mass;

        xxVel = xxVel + xxAcc * dt; 
        yyVel = yyVel + yyAcc * dt; 

        xxPos = xxPos + xxVel * dt; 
        yyPos = yyPos + yyVel * dt;

    }   

    public void draw() {

        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}