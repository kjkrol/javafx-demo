package kjkrol.demo

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.paint.Color
import javafx.stage.Stage

fun main(args: Array<String>) {
    Application.launch(JavaFxDemoApp::class.java, *args)
}

class JavaFxDemoApp : Application() {

    override fun start(primaryStage: Stage) {
        primaryStage.title = "Demo"
        primaryStage.scene = createScene()
        primaryStage.show()
    }

    private fun createScene(): Scene {
//        val rootNode = DemoGroup()
        val rootNode = SpriteAnimationGroup()
        val scene = Scene(rootNode)
//        val scene = Scene(rootNode, 600.0, 300.0)
//        scene.fill = Color.DARKSEAGREEN
        return scene
    }

}