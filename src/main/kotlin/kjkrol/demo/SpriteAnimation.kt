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

    private val frames: Array<Rectangle2D>

    init {
        cycleDuration = duration
        cycleCount = Animation.INDEFINITE
        interpolator = Interpolator.LINEAR
        imageView.fitHeight = height
        imageView.fitWidth = width
        frames = initFrames()
    }

    override fun interpolate(frac: Double) {
        val index: Int = Math.round((count - 1) * frac).toInt()
        imageView.viewport = frames[index]
    }

    private fun initFrames(): Array<Rectangle2D> = Array(count, {
        val xPos: Double = it % columns * width + offsetX
        val yPos: Double = it / columns * height + offsetY
        Rectangle2D(xPos, yPos, width, height)
    })

}
