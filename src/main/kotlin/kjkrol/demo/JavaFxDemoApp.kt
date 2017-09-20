package kjkrol.demo

import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.effect.Glow
import javafx.scene.paint.Color
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Translate
import javafx.stage.Stage

fun main(args: Array<String>) {
    Application.launch(JavaFxDemoApp::class.java, *args)
}

class JavaFxDemoApp : Application() {

    private val modelFactory = ModelFactory()
    private val transitionFactory = TransitionFactory()

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Demo"
        primaryStage.scene = createScene()
        primaryStage.show()
    }

    private fun createScene(): Scene {
        val rootNode = createGroup();
        val scene = Scene(rootNode, 600.0, 300.0)
        scene.fill = Color.DARKSEAGREEN
        return scene
    }

    private fun createGroup(): Group {
        val group = Group()

        val line = modelFactory.createLine()

        val rectangle = modelFactory.createRectangle()
        rectangle.transforms.addAll(
                Rotate(20.0, 150.0, 135.0),
                Scale(300.0, 135.0),
                Translate(350.0, 100.0)
        )

        val text = modelFactory.createText()
        text.effect = Glow(0.9)

        val star = modelFactory.createStar()
        val rotateTransition = transitionFactory.createRotateTransition()
        rotateTransition.node = star
        rotateTransition.play()

        val brownCircle = modelFactory.createBrownCircle()
        val scaleTransition = transitionFactory.createScaleTransition()
        scaleTransition.node = brownCircle
        scaleTransition.play()

        val redCircle = modelFactory.createRedCircle()
        val pathTransition = transitionFactory.createPathTransition()
        pathTransition.node = redCircle
        pathTransition.play()

        group.children.add(line)
        group.children.add(text)
        group.children.add(star)
        group.children.add(rectangle)
        group.children.add(brownCircle)
        group.children.add(redCircle)
        return group
    }

}