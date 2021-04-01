(ns grade-school)

(defn grade [school grade]  ;; <- arglist goes here
  (or (get school grade)
      []))

(defn add [school name grade]  ;; <- arglist goes here
 (merge-with into school {grade [name]}))

(defn sorted [school]  ;; <- arglist goes here
  (->> school
       (map (fn [[grade students]] [grade (sort students)]))
       (into (sorted-map))))
