package util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

public class DimensionUtil {

	public static void setCenterLocation(Component componentToCenter) {
		setCenterLocation(componentToCenter, Toolkit.getDefaultToolkit().getScreenSize(), new Point(0,0));
	}

	public static void setCenterLocation(Component componentToCenter, Component parentComponent) {
		setCenterLocation(componentToCenter, parentComponent.getSize(), parentComponent.getLocationOnScreen());
	}

	public static void setCenterLocation(Component componentToCenter, Dimension parentDimensions, Point startingPoint) {
		Dimension componentDimensions = componentToCenter.getSize();
		int xPosition = ((parentDimensions.width - componentDimensions.width)/2) + startingPoint.x;
		int yPosition = ((parentDimensions.height - componentDimensions.height)/2) + startingPoint.y;
		componentToCenter.setLocation(xPosition, yPosition);
	}


}
