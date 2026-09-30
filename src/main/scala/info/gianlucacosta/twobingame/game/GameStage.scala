package info.gianlucacosta.twobingame.game

import javafx.scene.layout.BorderPane

import info.gianlucacosta.helios.apps.AppInfo
import info.gianlucacosta.helios.fx.Includes._
import info.gianlucacosta.helios.fx.dialogs.InputDialogs
import info.gianlucacosta.helios.fx.scene.fxml.FxmlScene
import info.gianlucacosta.helios.fx.stage.StackedStage
import info.gianlucacosta.twobinmanager.sdk.server.TwoBinManagerServer
import info.gianlucacosta.twobinpack.core.ProblemBundle

import scalafx.Includes._
import scalafx.stage.WindowEvent

/**
  * Stage where the game actually takes place
  *
  * @param appInfo
  * @param previousStage
  */
class GameStage(
                 appInfo: AppInfo,
                 val previousStage: javafx.stage.Stage
               ) extends StackedStage {

  title =
    appInfo.name

  this.setMainIcon(appInfo)

  private var currentController: GameController = _


  /**
    * Starts a new game
    *
    * @param problemBundle       The problem bundle
    * @param managerServerOption Connection to a TwoBinManager server
    */
  def startGame(
                 problemBundle: ProblemBundle,
                 managerServerOption: Option[TwoBinManagerServer]): Unit = {
    val fxmlScene =
      new FxmlScene[GameController, BorderPane](classOf[GameController]) {
        override protected def preInitialize(): Unit = {
          currentController =
            controller

          controller.stage =
            GameStage.this

          controller.managerServerOption =
            managerServerOption

          controller.problemBundle =
            problemBundle
        }
      }


    scene =
      fxmlScene

    maximized =
      true

    show()
  }


  handleEvent(WindowEvent.WindowCloseRequest) {
    (event: WindowEvent) => {
      if (!canClose) {
        event.consume()
      }
    }
  }


  handleEvent(WindowEvent.WindowHidden) {
    (event: WindowEvent) => {
      currentController.clock.stop()

      event.consume()
    }
  }


  private def canClose: Boolean =
    InputDialogs.askYesNoCancel(
      "Return to the main screen without saving?"
    ).contains(true)
}
