(ns flatten-array)

(defn flatten [arr]
  (->> arr
       (tree-seq sequential? seq)
       (remove (some-fn sequential? nil?))))