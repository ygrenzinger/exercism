 (ns triangle)

 (defn type [a b c]
   (let [sorted-side-length (sort [a b c])]
     (cond
       (>= (last sorted-side-length) (+ (first sorted-side-length) (second sorted-side-length))) :illogical
       (= a b c) :equilateral
       (some #(= 2 %) (vals (frequencies sorted-side-length))) :isosceles
       :else :scalene)))
