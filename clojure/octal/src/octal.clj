 (ns octal
   (:require [clojure.math.numeric-tower :as m]))

(def valid-octal-chars (apply hash-set (map char (range (int \0) (int \8)))))

(defn- valid? [octal]
  (every? #(contains? valid-octal-chars %) octal))

(def octal-powers (cons 1 (map #(m/expt 8 %) (rest (range)))))

(defn to-decimal [str]
  (if (valid? str)
    (reduce + (map #(* %1 (Character/digit %2 8)) octal-powers (reverse str)))
    0))