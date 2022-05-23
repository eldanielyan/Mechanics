public class FT {
    FunctionClass f ;
    double period, delta, w0;
    int N;
    FT ( FunctionClass f ,int N, double delta) {
        this.f = f ;
        this.delta = delta ;
        this.N = N;
        period = N* delta ;
        w0 = 2*Math . PI / period ;
    }
    double getSineCoefficient(int n) {
        double sum = 0 ;
        double t = 0 ;
        for (int i = 0 ; i < N; i ++) {
            sum += f.evaluate( t ) * Math . sin ( n*w0* t ) ;
            t += delta ;
        }
        return 2* delta *sum/ period ;
    }
    double getCosineCoefficient ( int n ) {
        double sum = 0 ;
        double t = 0 ;
        for ( int i = 0 ; i < N; i ++) {
            sum += f.evaluate ( t ) * Math . cos ( n*w0* t ) ;
            t += delta ;
        }
        return 2* delta *sum/ period ;
    }
}