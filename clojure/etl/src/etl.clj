(ns etl
  (:require [clojure.string :as str]))

(defn transform
  [entries]
  (into {}
        (for [score (keys entries)
              word (get entries score)]
          [(str/lower-case word) score])))