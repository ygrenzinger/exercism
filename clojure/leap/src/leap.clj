(ns leap
  (:require [clojure.core.match :refer [match]]))

(defn leap-year? [year]
  (match [(mod year 400) (mod year 4) (mod year 100)]
         [0 _ _] true
         [_ _ 0] false
         [_ 0 _] true
         :else false))

(def fib (lazy-cat [0 1] (map + (rest fib) fib)))



