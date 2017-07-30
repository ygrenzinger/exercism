(ns meetup
  (:import
    (java.time DayOfWeek YearMonth)))

(def day-table {:monday DayOfWeek/MONDAY
                :tuesday DayOfWeek/TUESDAY
                :wednesday DayOfWeek/WEDNESDAY
                :thursday DayOfWeek/THURSDAY
                :friday DayOfWeek/FRIDAY
                :saturday DayOfWeek/SATURDAY
                :sunday DayOfWeek/SUNDAY})

(def teens (set (range 13 20)))

(defn get-day-by-ordinal [days ordinal]
  (case ordinal
    :first (first days)
    :second (second days)
    :third (nth days 2)
    :fourth (nth days 3)
    :last (last days)
    :teenth (some teens days)))

(defn meetup [month year day ordinal]
  (let [year-month (YearMonth/of year month)
        target-day (day-table day)
        month-length (.lengthOfMonth year-month)
        days-in-month
        (->> (range 1 (inc month-length))
             (map (fn [d] (. year-month (atDay d))))
             (filter (fn [d] (= target-day (.getDayOfWeek d))))
             (map #(.getDayOfMonth %)))]
    (conj [year month] (get-day-by-ordinal days-in-month ordinal))))
