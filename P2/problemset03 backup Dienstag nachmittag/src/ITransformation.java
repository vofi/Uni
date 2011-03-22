import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform; //NEW


public interface ITransformation {
	public AffineTransform transform(AffineTransform aTrans);		//Point in 2D
}
