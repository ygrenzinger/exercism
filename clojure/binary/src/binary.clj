 (ns binary
   (:require [clojure.math.numeric-tower :as m]))

 (def binary-powers (cons 1 (map #(clojure.math.numeric-tower/expt 2 %) (rest (range)))))

 (defn to-decimal [binary]
   (reduce + (map #(if (= \1 (second %)) (first %) 0) (zipmap binary-powers (reverse binary)))))