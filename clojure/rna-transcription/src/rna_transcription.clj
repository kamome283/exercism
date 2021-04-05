(ns rna-transcription)

(def transcription-table
  {\G \C
   \C \G
   \T \A
   \A \U})

(defn valid-dna? [dna]
  (->> dna
       (every? (-> transcription-table keys set))))

(defn to-rna [dna]
  {:pre [(valid-dna? dna)]}
  (->> dna (map transcription-table) (apply str)))
