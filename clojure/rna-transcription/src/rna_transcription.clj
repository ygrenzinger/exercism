(ns rna-transcription)

(def dna-to-rna {
                 \G \C,
                 \C \G,
                 \T \A,
                 \A \U
                 })

(defn convert [dna-strand]
  (if-let [rna-strand (dna-to-rna dna-strand)]
    rna-strand
    (throw (AssertionError. "unknown dna strand"))))

(defn to-rna [dna]
  (apply str (map convert dna)))
