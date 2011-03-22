import java.awt.geom.Point2D;
import java.awt.geom.AffineTransform; //NEW


public interface ITransformation {
	public Point2D transform(Point2D p);		//Point in 2D
}
