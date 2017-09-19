package kjkrol.demo

import javafx.animation.RotateTransition
import javafx.animation.ScaleTransition
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.effect.Glow
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Line
import javafx.scene.shape.LineTo
import javafx.scene.shape.MoveTo
import javafx.scene.shape.Path
import javafx.scene.shape.Rectangle
import javafx.scene.text.Font
import javafx.scene.text.Text
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Translate
import javafx.stage.Stage
import javafx.util.Duration

fun main(args: Array<String>) {
    Application.launch(FarmerGame::class.java, *args)
}

class FarmerGame : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Farmer"
        primaryStage.scene = createScene()
        primaryStage.show()
    }

    private fun createScene(): Scene {
        val scene = Scene(createGroup(), 600.0, 300.0)
        scene.fill = Color.DARKSEAGREEN
        return scene
    }

    private fun createGroup(): Group {
        val group = Group()
        val line = createLine()
        val text = createText()
        val path = createPath()
        val ciricle = createCircle()
        val rectanle = createRectangle()
        text.effect = createGlowEffect()
        rectanle.transforms.addAll(
                createRotationTransformation(),
                createScaleTransformation(),
                createTranslationTransformation())

        val rotateTransition = createRotateTransition()
        rotateTransition.node = path
        rotateTransition.play()

        val scaleTransition = createScaleTransition()
        scaleTransition.node = ciricle
        scaleTransition.play()

        group.children.add(line)
        group.children.add(text)
        group.children.add(path)
        group.children.add(rectanle)
        group.children.add(ciricle)
        return group
    }

    private fun createLine(): Line {
        val line = Line()
        line.startX = 100.0
        line.startY = 150.0
        line.endX = 500.0
        line.endY = 150.0
        return line
    }

    private fun createText(): Text {
        val text = Text()
        text.font = Font(45.0)
        text.x = 50.0
        text.y = 150.0
        text.text = "Welcome to Farmer"
        return text
    }

    private fun createPath(): Path {
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

    private fun createGlowEffect(): Glow {
        val glowEffect = Glow()
        glowEffect.level = 0.9
        return glowEffect
    }

    private fun createRectangle(): Rectangle {
        val rectangle = Rectangle(100.0, 75.0)
        rectangle.x = 0.0
        rectangle.y = 0.0
        rectangle.fill = Color.BURLYWOOD
        rectangle.stroke = Color.BLACK
        return rectangle
    }

    private fun createRotationTransformation(): Rotate {
        val rotation = Rotate()
        rotation.angle = 20.0
        rotation.pivotX = 150.0
        rotation.pivotY = 135.0
        return rotation
    }

    private fun createTranslationTransformation(): Translate {
        val translate = Translate()
        translate.x = 350.0
        translate.y = 100.0
        translate.z = 0.0
        return translate
    }

    private fun createScaleTransformation(): Scale {
        val scale = Scale()
        scale.pivotX = 300.0
        scale.pivotY = 135.0
        return scale
    }

    private fun createRotateTransition(): RotateTransition {
        val rotateTransition = RotateTransition()
        rotateTransition.duration = Duration.millis(4000.0)
        rotateTransition.byAngle = 360.0
        rotateTransition.cycleCount = 1
        rotateTransition.isAutoReverse = false
        return rotateTransition
    }

    private fun createCircle(): Circle {
        val circle = Circle()
        circle.centerX = 450.0
        circle.centerY = 60.0
        circle.radius = 30.0
        circle.fill = Color.BROWN
        circle.strokeWidth = 20.0
        return circle
    }

    private fun createScaleTransition(): ScaleTransition {
        val scaleTransition = ScaleTransition()
        scaleTransition.duration = Duration.millis(3000.0)
        scaleTransition.byX = 1.2
        scaleTransition.byY = 1.2
        scaleTransition.cycleCount = 2
        scaleTransition.isAutoReverse = true
        return scaleTransition
    }

}