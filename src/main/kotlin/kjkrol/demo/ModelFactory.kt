package kjkrol.demo

import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Line
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text

class ModelFactory {

    fun createBrownCircle(): Circle {
        val circle = Circle(450.0, 60.0, 30.0)
        circle.fill = Color.BROWN
        circle.strokeWidth = 20.0
        return circle
    }

    fun createRedCircle(): Circle {
        val circle = Circle(50.0, 30.0, 10.0)
        circle.fill = Color.RED
        circle.strokeWidth = 20.0
        return circle
    }

    fun createRectangle(): Rectangle {
        val rectangle = Rectangle(75.0, 100.0, 0.0, 0.0)
        rectangle.fill = Color.BURLYWOOD
        rectangle.stroke = Color.BLACK
        return rectangle
    }

    fun createLine(): Line = Line(100.0, 150.0, 500.0, 150.0)

    fun createStar(): Path {
        val path = Path()
        val startingPoint = MoveTo(108.0, 71.0)
        val line1 = LineTo(321.0, 161.0)
        val line2 = LineTo(126.0, 232.0)
        val line3 = LineTo(232.0, 52.0)
        val line4 = LineTo(269.0, 250.0)
        val line5 = LineTo(108.0, 71.0)
        path.elements.add(startingPoint)
        path.elements.addAll(line1, line2, line3, line4, line5)
        return path
    }

    fun createText(): Text {
        val text = Text()
        text.font = Font(45.0)
        text.x = 50.0
        text.y = 150.0
        text.text = "Welcome to Farmer"
        return text
    }

}