(ns rna-transcription)

(def transcription-table
  {\G \C
   \C \G
   \T \A
   \A \U})

(defn to-rna [dna]
  (let [rna (->> dna (keep transcription-table) (apply str))]
    (assert (= (count rna) (count dna)))
    rna))