 (ns grains
   (:require [clojure.math.numeric-tower :as m]))

 (defn square [val] (m/expt 2 (dec val)))

 (defn total [] (apply + (map square (range 1 65))))
