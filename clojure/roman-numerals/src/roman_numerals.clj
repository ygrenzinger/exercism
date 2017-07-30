(ns roman-numerals)

(def roman-special-forms
  [[1000 "M"] [900 "CM"] [500 "D"] [400 "CD"]
   [100 "C"] [90 "XC"] [50 "L"] [40 "XL"]
   [10 "X"] [9 "IX"] [5 "V"] [4 "IV"] [1 "I"]])

(defn find-special-form [val]
  (first (filter #(>= val (first %)) roman-special-forms)))

(defn numerals [val]
  (loop [remaining val
         result ""]
    (if (zero? remaining)
      result
      (let [current-special-forms (find-special-form remaining)]
        (recur
          (- remaining (first current-special-forms))
          (str result (second current-special-forms)))))))
