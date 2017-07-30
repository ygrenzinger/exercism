 (ns hamming)

 (defn ^:private compare-dna-by-strand
   [dna-1 dna-2]
   (map #(= (first %) (second %)) (map vector dna-1 dna-2)))

 (defn distance
   [dna-1 dna-2]
   (if (= (count dna-1) (count dna-2))
     (count (filter false? (compare-dna-by-strand dna-1 dna-2)))))
