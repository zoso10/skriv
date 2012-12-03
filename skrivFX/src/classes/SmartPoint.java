package classes;


public class SmartPoint {
    
    private javafx.geometry.Point2D p;
    private boolean isLast;
    
    public SmartPoint(javafx.geometry.Point2D p, boolean isLast){
        this.p = p;
        this.isLast = isLast;
    }
    
    public SmartPoint(double x, double y, boolean isLast){
        this(new javafx.geometry.Point2D(x, y), isLast);
    }
    
    public boolean isLast(){
        return isLast;
    }
    
    public javafx.geometry.Point2D getPoint(){
        return p;
    }
    
    public double getX(){
        return p.getX();
    }
    
    public double getY(){
        return p.getY();
    }
}
