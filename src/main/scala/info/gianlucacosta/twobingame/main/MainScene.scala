package info.gianlucacosta.twobingame.main

import javafx.scene.layout.BorderPane
import javafx.stage.Stage

import info.gianlucacosta.helios.apps.AppInfo
import info.gianlucacosta.helios.fx.scene.fxml.FxmlScene

class MainScene(
                 appInfo: AppInfo,
                 primaryStage: Stage
               ) extends FxmlScene[MainController, BorderPane](
  classOf[MainController]
) {
  override protected def preInitialize(): Unit = {
    controller.appInfo =
      appInfo

    controller.stage =
      primaryStage
  }
}
