(ns perfect-numbers)

(defn factors [n]
  (filter #(= (mod n %) 0) (range 1 n)))

(defn sum-of-factors [n]
  (reduce + (factors n)))

(defn classify [n]
  (if (< n 0)
    (throw (IllegalArgumentException. "Negative number"))
    (let [sum (sum-of-factors n)]
      (cond
        (= sum n) :perfect
        (> sum n) :abundant
        :else :deficient))))
