package kjkrol.demo

import javafx.scene.Group
import javafx.scene.effect.Glow
import javafx.scene.transform.Rotate
import javafx.scene.transform.Scale
import javafx.scene.transform.Translate

class DemoGroup : Group() {

    private val modelFactory = ModelFactory()
    private val transitionFactory = TransitionFactory()

    init {
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

        children.add(line)
        children.add(text)
        children.add(star)
        children.add(rectangle)
        children.add(brownCircle)
        children.add(redCircle)
    }
}