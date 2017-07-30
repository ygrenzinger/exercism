(ns allergies)

(def items [:eggs
            :peanuts
            :shellfish
            :strawberries
            :tomatoes
            :chocolate
            :pollen
            :cats])

(defn dec->flags
  "Convert decimal `n` into a vector of bit flags."
  [n]
  (loop [x n
         flags []]
    (if (>= x 1)
      (recur (quot x 2) (conj flags (rem x 2)))
      flags)))

(defn allergies
  [n]
  (filter some?
          (map (fn [flag item] (when (= 1 flag) item)) (dec->flags n) items)))

(defn allergic-to? [n allergy]
  (some #{allergy} (allergies n)))
