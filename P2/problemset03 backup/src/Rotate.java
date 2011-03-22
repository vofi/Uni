import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform; //NEW
/**
 * 
 */

/**
 * @author lukas
 *
 */
public class Rotate extends Translate implements ITransformation {

	/**
	 * @param x 
	 * @param richtung 
	 * 
	 */
	private double winkel;
	private String richtung;
	private Point2D p;
	
	public Rotate(double winkel, String richtung) {
		super(null);
		if (richtung.toLowerCase().matches("clockwise"))
		{
			this.winkel=winkel;
		}
		else if(richtung.toLowerCase().matches("anticlockwise"))
		{
			this.winkel=-winkel;
		}
		else
		{
			System.out.println("Fehler in der Klasse Rotate in der Methode Rotate(): Richtung nicht klar!");
			//TODO: Execption machen
		}
		
	}
	
	public Point2D transform(Point2D p)
	{
		this.p=p;
		AffineTransform trans = new AffineTransform();
		
		trans.rotate(this.winkel);
		
		return this.MatrixMalVektor(p,trans);
		
		
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
