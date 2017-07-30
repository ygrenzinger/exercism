(ns word-count
  (:require [clojure.string :as str]))

(defn extract-words
  [sentence]
  (re-seq #"[a-zA-Z]+|[0-9]+" sentence))

(defn word-count [sentence]
  (-> sentence
      str/lower-case
      extract-words
      frequencies))
