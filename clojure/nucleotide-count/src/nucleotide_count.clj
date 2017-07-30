(ns nucleotide-count)

(def nucleides #{\A \T \G \C})

(defn nucleotide-counts [adn]
  (merge
    (zipmap nucleides (repeat 0))
    (frequencies adn)))

(defn count [nucleide adn]
  (if (contains? nucleides nucleide)
    (get (nucleotide-counts adn) nucleide)
    (throw (Exception. "This nucleide is incorrect"))))
