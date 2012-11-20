package classes;


public class SmartPoint{
    
    private java.awt.Point p;
    private Boolean b; // Last point before the pen has been lifted
    public int x, y;
    
    public SmartPoint(java.awt.Point p, Boolean b){
        this.p = p;
        this.b = b;
        this.x = p.x;
        this.y = p.y;
    }
    
    public java.awt.Point getPoint(){
        return p;
    }
    
    public Boolean isLast(){
        return b;
    }
}