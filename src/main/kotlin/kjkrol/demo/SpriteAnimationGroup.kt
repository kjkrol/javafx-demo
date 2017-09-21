package kjkrol.demo

import javafx.geometry.Rectangle2D
import javafx.scene.Group
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.util.Duration

class SpriteAnimationGroup : Group() {

    private val IMAGE = Image(this.javaClass.classLoader.getResourceAsStream("The_Horse_in_Motion.jpg"))
    private val COLUMNS = 4
    private val COUNT = 11
    private val OFFSET_X = 18.0
    private val OFFSET_Y = 25.0
    private val WIDTH = 374.0
    private val HEIGHT = 243.0

    init {
        val imageView = ImageView(IMAGE)
        imageView.viewport = Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT)
        val animation = SpriteAnimation(
                imageView,
                Duration.millis(500.0),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        )
        animation.play()
        children.add(imageView)
    }
}