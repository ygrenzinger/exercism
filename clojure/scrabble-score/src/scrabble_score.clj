(ns scrabble-score)

(def letter-values
  [[[\A \E \I \O \U \L \N \R \S \T] 1]
   [[\D \G] 2]
   [[\B \C \B \C \M \P] 3]
   [[\F \H \V \W \Y] 4]
   [[\K] 5]
   [[\J \X] 8]
   [[\Q \Z] 10]])

(defn associate-char-to-values [chars value]
  (map #(vector % value) chars))

(def letter-values-map
  (apply hash-map (flatten (map #(associate-char-to-values (first %) (second %))  letter-values))))

(defn score-char [c]
  (get letter-values-map c 0))

(defn score-letter [c]
  (score-char (first (clojure.string/upper-case c))))

(defn score-word [w]
  (reduce + (map score-letter w)))
