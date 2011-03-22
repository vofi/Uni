import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform; //NEW
/**
 * 
 */

/**
 * @author lukas
 *
 */
public class Rotate implements ITransformation {

	/**
	 * @param x 
	 * @param richtung 
	 * 
	 */
	private double winkel;
	private String richtung;
	private  Point2D p;
	
	public Rotate(double winkel, String richtung) {
		System.out.println("RICHTUNG " +richtung);
		if (richtung.toLowerCase().matches("clockwise"))
		{
			this.winkel=winkel;
		}
		else if(richtung.toLowerCase().matches("anticlockwise"))
		{
			this.winkel=-1*winkel;
		}
		else
		{
			System.out.println("Fehler in der Klasse Rotate in der Methode Rotate(): Richtung nicht klar!");
			//TODO: Execption machen
		}
		
	
		
	}
	
	public AffineTransform transform(AffineTransform aTrans)
	{
	
		
		
		aTrans.rotate(this.winkel);
		
		return aTrans;
		
		
	}
	
	
	


}
