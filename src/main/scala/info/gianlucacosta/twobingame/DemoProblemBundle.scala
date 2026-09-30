package info.gianlucacosta.twobingame

import java.time.Duration

import info.gianlucacosta.twobinpack.core._

/**
  * Example problem bundle shown in the "Demo" game feature
  */
private object DemoProblemBundle extends ProblemBundle(List(
  Problem(
    FrameTemplate(
      FrameDimension(
        3,
        3
      ),

      FrameMode.Strip,

      BlockPool.create(
        canRotateBlocks = true,

        BlockDimension(
          3,
          1
        ) -> 2,

        BlockDimension(
          2,
          2
        ) -> 2
      ),

      FrameTemplate.SuggestedBlockColorsPool,

      40
    ),

    Some(
      Duration.ofMinutes(2)
    ),

    "Example problem"
  )
))
