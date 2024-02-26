package cc.vividcode.java22.streamgatherer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Gatherer;
import java.util.stream.Gatherer.Integrator;

public class DistinctBy {

  static <T, R> Gatherer<T, ?, T> of(Function<? super T, ? extends R> extractor) {
    class State {

      final Map<R, T> seen = new HashMap<>();
    }

    return Gatherer.ofSequential(State::new, Integrator.of(
            ((state, element, _) -> {
              state.seen.put(extractor.apply(element), element);
              return true;
            })),
        (state, downstream) -> {
          state.seen.values().forEach(downstream::push);
        }
    );
  }
}
