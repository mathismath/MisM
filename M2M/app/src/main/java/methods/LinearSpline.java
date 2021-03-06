package methods;

import android.util.Log;

import java.math.BigDecimal;
import java.math.MathContext;
import methods.com.udojava.evalex.Expression;
import java.math.BigDecimal;


public class LinearSpline {
    private double[] points;
    private double[] f;
    private String[] polinomio;
    private MathContext mc;

    public LinearSpline(double[] points, double[] f){
        this.points = points;
        this.f = f;
        this.polinomio = new String[this.points.length - 1];
        this.mc = new MathContext(5);
        this.makePolinomio();
    }

    public double getResult(double x){
        double result = 0;
        double m = 0;
        for (int i = 0; i < this.points.length - 1; i++) {
            if(x >= this.points[i] && x < this.points[i + 1]){

                System.out.println(polinomio[i]);
                Expression expression = new Expression(polinomio[i].split("     ")[0]).setPrecision(16);
                return expression.setVariable("x", String.valueOf(x)).eval().doubleValue();
            }
        }
        return -6.66; // Error, the polynomial is not defined at this point
    }

    public void makePolinomio() {
        double m;
        for (int i = 0; i < this.polinomio.length; i++) {
            m = new BigDecimal((this.f[i + 1] - this.f[i]) / (this.points[i + 1] - this.points[i])).round(mc).doubleValue();
            this.polinomio[i] = m+"*x + " + (-m*this.points[i] + this.f[i]) +"      "+ this.points[i] + " <= x <= " + this.points[i+1];
        }
    }

    public String[] getPolinomio() {
        return polinomio;
    }


    public static void main(String[] args) {
        double[] points = {1,2,3};
        double[] f = {1,2,3};
        LinearSpline a = new LinearSpline(points, f);
        for (int i = 0; i < a.getPolinomio().length; i++) {
            System.out.println(a.getPolinomio()[i]);    
        }
        
    }


    
}