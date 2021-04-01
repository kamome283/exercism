(ns meetup)

(defn- month-dates [month, year]
  (->> (java.time.LocalDate/of year month 1)
       (iterate #(.plusDays % 1))
       (take-while #(-> % .getMonthValue (= month)))))

(defn- obj->map [date]
  {:year  (.getYear date)
   :month (.getMonthValue date)
   :day   (.getDayOfMonth date)
   :dow   (-> date .getDayOfWeek clojure.string/lower-case keyword)})

(defn- dow-filter [dow]
  (fn [date] (-> date :dow (= dow))))

(def descriptors
  {:teenth (fn [dates] (->> dates
                            (filter #(-> % :day (>= 13)))
                            first))
   :first  first
   :second second
   :third  #(nth % 2)
   :fourth #(nth % 3)
   :last   last})

(defn meetup [month, year, dow, descriptor]
  (->> (month-dates month year)
       (map obj->map)
       (filter (dow-filter dow))
       ((descriptor descriptors))
       ((juxt :year :month :day))))