 (ns grade-school)

 (defn add
  [db student grade]
  (update-in db [grade] #(concat % [student])))

 (defn grade
  [db student-grade]
  (get db student-grade []))

 (defn sort-students
  ^:private
  [pair]
  [(first pair) (sort (second pair))])

 (defn sorted
  [db]
  (into (sorted-map) (map sort-students db)))
