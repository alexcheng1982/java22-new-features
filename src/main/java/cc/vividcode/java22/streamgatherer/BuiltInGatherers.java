package cc.vividcode.java22.streamgatherer;

import java.util.stream.Gatherers;
import java.util.stream.Stream;

public class BuiltInGatherers {
  void fold() {
    Stream.of(1, 2, 3, 4 ,5).gather(
        Gatherers.fold(
            () -> "",
            (output, value) -> output + value + ", "
        )
    ).findFirst();
  }
}
