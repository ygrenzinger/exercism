 (ns binary-search)

 (defn middle
   ([array] (middle 0 (dec (count array))))
   ([low high]
    (int (Math/floor (/ (+ low high) 2)))))

 (defn search-for
   ([val array]
     (search-for val array 0 (dec (count array))))
   ([val array low-idx high-idx]
    (if (> low-idx high-idx)
      (throw (Exception. "not found"))
      (let [middle-idx (middle low-idx high-idx)
            val-at-index (nth array middle-idx)]
        (cond
          (= val-at-index val) middle-idx
          (< val val-at-index) (recur val array low-idx (dec middle-idx))
          (> val val-at-index) (recur val array (inc middle-idx) high-idx))))))
