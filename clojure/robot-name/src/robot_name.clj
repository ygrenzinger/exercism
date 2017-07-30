(ns robot-name)

(defn ^:private random-int
  ([] (rand-nth (range 0 10)))
  ([length] (apply str (take length (repeatedly random-int)))) )

(def ^:private characters
  (map char (range 66 92)))

(defn ^:private random-string ([n]
   (->> (fn [] (rand-nth characters))
        repeatedly
        (take n)
        (apply str))))

(defn ^:private generate-name []
  (str (random-string 2) (random-int 3)))

(defn robot []
  (atom (generate-name)))

(defn robot-name [robot]
  @robot)

(defn reset-name [robot]
  (reset! robot (generate-name))
  @robot)
