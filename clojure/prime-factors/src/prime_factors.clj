 (ns prime-factors)

 (defn of [val] (loop [remaining val
                       factors []
                       possible-factors (drop 2 (range))]
                  (if (= remaining 1)
                    factors
                    (let [factor (first possible-factors)]
                      (if (zero? (mod remaining factor))
                        (recur (/ remaining factor) (conj factors factor) possible-factors)
                        (recur remaining factors (rest possible-factors))
                        )))))
