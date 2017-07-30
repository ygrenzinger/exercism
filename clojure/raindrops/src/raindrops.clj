 (ns raindrops)

 (def elements {
                3 "Pling"
                5 "Plang"
                7 "Plong"
                })

 (defn convert [n]
   (let [result (apply str (map #(if (zero? (mod n (first %))) (second %) "") elements))]
     (if (clojure.string/blank? result)
       (str n)
       result)))
