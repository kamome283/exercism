(ns leap)

(defn leap-year? [year]
  (condp #(-> (mod %2 %1) zero?) year
    400 true
    100 false
    4 true
    false))