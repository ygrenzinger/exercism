 (ns trinary
   (:require [clojure.math.numeric-tower :as m]))

 (def valid-trinary-chars #{\0 \1 \2})

 (defn- valid? [trinary]
   (every? #(contains? valid-trinary-chars %) trinary))

(def trinary-powers (cons 1 (map #(m/expt 3 %) (rest (range)))))

(defn to-decimal [trinary]
  (if (valid? trinary)
    (reduce + (map #(* (first %) (Character/digit (second %) 3)) (zipmap trinary-powers (reverse trinary))))
    0))
