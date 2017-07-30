 (ns flatten-array)

 (defn flatten [array]
   (->> array
        clojure.core/flatten
        (remove nil?)))
