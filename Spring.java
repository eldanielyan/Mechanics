public class Spring {
    double k;
    double[] array;
    public Spring() {
        k = 1;
    }

    public Spring(double k) {
        this.k = k;
    }

    public double getK() {
        return k;
    }

    public void setK(double k) {
        this.k = k;
    }

    public double calculatorW(double mass, double k){
        double toReturn = Math.sqrt(k/mass);
        return toReturn;
    }

    public double[] helper(double t0, double t1, double dt, double x0, double v0, double m){
        double[] toReturn = new double[(int) (Math.ceil(t1-t0)/dt)];
        for(int i = 0;i<(Math.ceil(t1-t0));i++){
            array[i] = x0*Math.cos(calculatorW(m,k)*(i*dt)) + (v0/calculatorW(m,k))*Math.sin(calculatorW(m,k)*(i*dt));
        }
        return array;
    }

    public double[] move(double t, double dt, double x0, double v0) {
        array = helper(0,t,dt,x0,v0,1);
        return array;
    }

   public double[] move(double t, double dt, double x0) {
       array = helper(0,t,dt,x0,0,1);
       return array;
   }

   public double[] move(double t0, double t1, double dt, double x0, double v0) {
       array = helper(t0,t1,dt,x0,v0,1);
       return array;
   }

   public  double[] move(double t0, double t1, double dt, double x0, double v0, double m) {
       array = helper(t0,t1,dt,x0,v0,m);
       return array;
   }

   //Task 2

    public Spring inSeries(Spring that) {
        double combinedK = (this.k * that.k) / (this.k + that.k);
        return new Spring(combinedK);
    }

    public Spring inParallel(Spring that) {
        double combinedK = (this.k + that.k);
        return new Spring(combinedK);
    }


}
