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
public class Scale implements ITransformation{

	private static Point2D p;
	private double skalierung;
	/**
	 * @param skalierung 
	 * 
	 */
	public Scale(double skalierung) {
		this.skalierung=skalierung;
	}
	
	public AffineTransform transform(AffineTransform aTrans)
	{
		
		aTrans.scale(this.skalierung, this.skalierung);
		return aTrans;
		
	}


	
	
}
