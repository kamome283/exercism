(ns etl
  (:require [clojure.string :as str]))

(defn- transform* [[point, keys]]
  (zipmap (map str/lower-case keys) (repeat point)))

(defn transform [source]
  (->> source (map transform*) (apply merge)))