(ns space-age)

(def ratio-to-earth-orbital-period
  {
   :mercury 0.2408467,
   :venus   0.61519726
   :mars    1.8808158
   :jupiter 11.862615
   :saturn  29.447498
   :uranus  84.016846
   :neptune 164.79132
   })

(defn on-earth [seconds] (/ seconds 31557600.0))

(defn- convert-to [seconds planet]
  (/ (on-earth seconds) (planet ratio-to-earth-orbital-period)))

(defn on-mercury [seconds] (convert-to seconds :mercury))
(defn on-venus [seconds] (convert-to seconds :venus))
(defn on-mars [seconds] (convert-to seconds :mars))
(defn on-jupiter [seconds] (convert-to seconds :jupiter))
(defn on-saturn [seconds] (convert-to seconds :saturn))
(defn on-uranus [seconds] (convert-to seconds :uranus))
(defn on-neptune [seconds] (convert-to seconds :neptune))
