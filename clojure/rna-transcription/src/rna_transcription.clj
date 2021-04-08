(ns rna-transcription)

(def transcription-table
  {\G \C
   \C \G
   \T \A
   \A \U})

(defn to-rna [dna]
  (let [rna-seq (->> dna (keep transcription-table))]
    (assert (= (count rna-seq) (count dna)))
    (apply str rna-seq)))