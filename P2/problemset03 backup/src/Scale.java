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
public class Scale extends Translate implements ITransformation{

	private Point2D p;
	private double skalierung;
	/**
	 * @param skalierung 
	 * 
	 */
	public Scale(double skalierung) {
		super(null);
		this.skalierung=skalierung;
		
		// TODO Auto-generated constructor stub
	}
	
	public Point2D transform(Point2D p)
	{
		Double xnew=this.p.getX()*this.skalierung;
		Double ynew=this.p.getY()*this.skalierung;
		
	
		Point2D pnew=new Point2D.Double(xnew, ynew);
		
		return pnew;
		
	}
}
