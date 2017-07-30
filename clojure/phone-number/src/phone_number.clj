 (ns phone-number)

 (defn number
   [input]
   (let [cleaned-number (clojure.string/replace input #"[\(\)\s\-\.]" "")]
     (cond (= (count cleaned-number) 10) cleaned-number
           (and
             (= (count cleaned-number) 11)
             (clojure.string/starts-with? cleaned-number "1")) (subs cleaned-number 1)
           :else "0000000000")))

 (defn area-code
   [input]
   (subs (number input) 0 3))

 (defn pretty-print
   [input]
   (let [correct-number (number input)]
     (str "(" (subs correct-number 0 3) ") " (subs correct-number 3 6) "-" (subs correct-number 6 10))))
