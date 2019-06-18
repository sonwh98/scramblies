(ns scramblies.core
  (:require [clojure.string :as str]
            [clojure.set :as set]))

(defn normalize [a-str]
  (-> a-str
      str/lower-case
      ))

(defn subset? [c a-set]
  (set/subset? #{c} (set a-set)))

(defn min-frequencies-met?
  "returns true of frequencies of str1 is greater than or equal to frequencies of str2"
  [str1 str2]
  (let [freq-a (frequencies str1)
        freq-b (frequencies str2)]
    (every? #(>= % 0)
            (for [[ch count-b] freq-b
                  :let [count-a (freq-a ch) ]]
              (if count-a
                (- count-a count-b)
                -1)))))

(defn scramble? [str1 str2]
  (let [frq-a (frequencies str1)
        set-a (-> str1 normalize set)

        frq-b (frequencies str2)
        set-b (-> str2 normalize set)

        intersection-a-b (set/intersection set-a set-b)]
    (and 
     (= intersection-a-b set-b))
    
    #_(and (>= (count str1)
               (count str2))
           (= subset-a set-b))))

(comment
  (scramble? "cedewaraaossoqqyt" "codewars")
  (scramble? "rekqodlw" "world")

  (scramble? "katas" "steak")
  (set/difference #{1 2 3 4} #{1 2 3})
  

  (scramble? "heloa" "hello")


  (frequencies "helo")

  (let [freq-a (frequencies "hello")
        freq-b (frequencies "helo")]
    (boolean (some #(not= % 0) (for [[ch count-b] freq-b
                                     :let [count-a (freq-a ch)]]
                                 (- count-b count-a)))))

  (some (fn [i]
          (> i 0)) [1 0 0])

  (some even? [1 2 3 4])
  (some (fn [i]
          (> i 0)) [1 2 3 4])

  (boolean (every? #(> % 0) [0 0 0]))

  (min-frequencies-met? "hella" "hello")
  
  (> 0 -1)
  )
