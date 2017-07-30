import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Etl {
   private static class Tuple {
      private final String _1;
      private final Integer _2;


      public Tuple(String _1, Integer _2) {
         this._1 = _1;
         this._2 = _2;
      }
   }


   public static Tuple toTuple(String _1, Integer _2) {
      return new Tuple(_1, _2);
   }

   public Map<String, Integer> transform(Map<Integer, List<String>> old) {
      return old.entrySet().stream().flatMap(entry -> {
         final Integer value = entry.getKey();
         return entry.getValue().stream().map(s -> toTuple(s.toLowerCase(), value));
      }).collect(Collectors.toMap(tuple -> tuple._1, tuple -> tuple._2));
   }
}
