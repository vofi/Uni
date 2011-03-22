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
	
	private Point2D p;
	private Point2D q;
	private double xnew;
	private double ynew;
	/**
	 * 
	 */
	public Translate(Point2D q) 
	{
		this.q=q;
	}
	public AffineTransform transform(AffineTransform aTrans)
	{	
		aTrans.translate(q.getX(), q.getY());
		
		return aTrans;
	}
	

	


}
