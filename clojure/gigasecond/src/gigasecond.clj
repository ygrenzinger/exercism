(ns gigasecond
  (:import (java.time LocalDateTime Duration)))

(defn exp [x n]
  (reduce * (repeat n x)))

(def ^:private gigaseconds-duration (Duration/ofSeconds (exp 10 9)))

(defn format-output [date]
  [(.getYear date) (.getMonthValue date) (.getDayOfMonth date)])

(defn from [year month day]
  (-> (LocalDateTime/of year month day 0 0)
      (.plus gigaseconds-duration)
      format-output))
