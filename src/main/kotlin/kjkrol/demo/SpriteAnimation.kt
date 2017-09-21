package kjkrol.demo

import javafx.animation.Animation
import javafx.animation.Interpolator
import javafx.animation.Transition
import javafx.geometry.Rectangle2D
import javafx.scene.image.ImageView
import javafx.util.Duration


class SpriteAnimation(private val imageView: ImageView,
                      duration: Duration,
                      private val count: Int, private val columns: Int,
                      private val offsetX: Double, private val offsetY: Double,
                      private val width: Double, private val height: Double) : Transition() {

    init {
        cycleDuration = duration
        cycleCount = Animation.INDEFINITE
        interpolator = Interpolator.LINEAR
        imageView.viewport = Rectangle2D(offsetX, offsetY, width, height)
    }

    override fun interpolate(frac: Double) {
        val index: Int = Math.min(Math.floor(frac * count).toInt(), count - 1)
        val x: Double = index % columns * width + offsetX
        val y: Double = index / columns * height + offsetY
        imageView.viewport = Rectangle2D(x, y, width, height)
    }
}
