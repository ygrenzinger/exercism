(ns anagram 
  (:require [clojure.string :as str]))
  
(defn anagram?
  [word tested-word] 
  (let [word (str/lower-case word) 
        tested-word (str/lower-case tested-word)] 
        (and (not= word tested-word) 
          (= (frequencies word) 
             (frequencies tested-word)))))  

(defn anagrams-for
  [word candidates] 
  (filter #(anagram? word %) candidates)) 
