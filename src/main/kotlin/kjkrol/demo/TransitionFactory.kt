package kjkrol.demo

import javafx.animation.PathTransition
import javafx.animation.RotateTransition
import javafx.animation.ScaleTransition
import javafx.scene.shape.CubicCurveTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.util.Duration

class TransitionFactory {

    fun createRotateTransition(): RotateTransition {
        val rotateTransition = RotateTransition()
        rotateTransition.duration = Duration.millis(4000.0)
        rotateTransition.byAngle = 360.0
        rotateTransition.cycleCount = 1
        rotateTransition.isAutoReverse = false
        return rotateTransition
    }

    fun createScaleTransition(): ScaleTransition {
        val scaleTransition = ScaleTransition()
        scaleTransition.duration = Duration.millis(3000.0)
        scaleTransition.byX = 1.2
        scaleTransition.byY = 1.2
        scaleTransition.cycleCount = 2
        scaleTransition.isAutoReverse = true
        return scaleTransition
    }

    fun createPathTransition(): PathTransition {
        val pathTransition = PathTransition()

        val path = Path()
        val startingPoint = MoveTo(100.0, 150.0)
        val cubicCurveTo = CubicCurveTo(400.0, 40.0, 175.0, 250.0, 500.0, 150.0)
        path.elements.addAll(startingPoint, cubicCurveTo)

        pathTransition.path = path
        pathTransition.duration = Duration.seconds(3.0)
        pathTransition.orientation = PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
        pathTransition.cycleCount = 1
        pathTransition.isAutoReverse = false
        return pathTransition
    }

}