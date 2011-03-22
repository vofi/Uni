import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform; //NEW
/**
 * 
 */

/**
 * @author lukas
 *
 */
public class Translate implements ITransformation {
	
	protected Point2D p;
	protected Point2D q;
	
	/**
	 * 
	 */
	public Translate(Point2D q) 
	{
		this.q=q;
		// TODO Auto-generated constructor stub
	}
	public Point2D transform(Point2D p)
	{
		
		Double xnew=this.q.getX()+this.p.getX();
		Double ynew=this.q.getY()+this.p.getY();
		
		
		Point2D newPoint=new Point2D.Double(xnew, ynew);
		
		
		
		return newPoint;
	}
	
	private Point2D MatrixMalVektor(Point2D p, AffineTransform trans)
	{
		/*	MATRIX:
		 * 	A		B		C
		 * 	D		E		F	
		 * 	
		 * 	
		 * 
		 */
		String transStr=trans.toString();
		String[] Argument;
		Argument=transStr.split(",");
		
		
		double A=Double.parseDouble(Argument[0].substring(17));
		double B=Double.parseDouble(Argument[1].substring(1));
		double C=Double.parseDouble(Argument[2].substring(1,Argument[2].length()-1));
		double D=Double.parseDouble(Argument[3].substring(2));
		double E=Double.parseDouble(Argument[4].substring(1));
		double F=Double.parseDouble(Argument[5].substring(1,Argument[5].length()-2));
		
		double x=p.getX();
		double y=p.getY();
		
		//TODO: AB HIER WEITER MACHEN 
		double xnew=x*A+y*B+0*C;
		double ynew=x*D+y*E+0*F;
		
		Point2D pointNew=new Point2D.Double(xnew, ynew);
		return pointNew;
	}
	


}
