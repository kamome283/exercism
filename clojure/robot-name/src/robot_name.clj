(ns robot-name)

(def db (atom {}))

(defn- update-db [id, name]
  (swap! db #(assoc % id name))
  id)

(defn- rand-id []
  (->> (repeatedly #(java.util.UUID/randomUUID))
       (filter #(-> % (@db) not))
       first))

(defn- rand-name* []
  (let [s (->> (repeatedly #(-> (range 65 91) rand-nth char))
               (take 2)
               (apply str))
        n (-> (range 100 1000) rand-nth)]
    (str s n)))

(defn- rand-name []
  (->> (repeatedly rand-name*)
       (filter #(-> @db vals vec (contains? %) not))
       first))

(defn robot
  ([] (update-db (rand-id) (rand-name)))
  ([id] (update-db id (rand-name))))

(defn robot-name [id] (@db id))

(defn reset-name [id] (robot id))