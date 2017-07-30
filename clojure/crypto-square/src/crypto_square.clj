(ns crypto-square
  (:require [clojure.string :as s]))

(defn- remove-punctuation [text]
  (apply str (re-seq #"\w+" text)))

(defn normalize-plaintext [text]
  (->> text
       remove-punctuation
       s/lower-case))

(defn square-size
  [text]
  (int (Math/ceil (Math/sqrt (count text)))))

(defn plaintext-segments [text]
  (let [normalized-text (normalize-plaintext text)
        segment-size (square-size normalized-text)]
    (map s/join (partition-all segment-size normalized-text))))

(defn- pad-segments [segments segments-size]
  (map #(format (str "%-" segments-size "s") %) segments))

(defn- segments-in-columns [text]
  (let [segments (plaintext-segments text)
        segment-size (count (first segments))
        padded-segments (pad-segments segments segment-size)]
    (apply map #(s/trim (apply str %&)) padded-segments)))

(defn- remove-spaces [text]
  (s/replace text " " ""))

(defn normalize-ciphertext [text]
  (->> text
       segments-in-columns
       (s/join " ")))

(defn ciphertext [text]
  (remove-spaces (normalize-ciphertext text)))
