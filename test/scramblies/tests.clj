(ns scramblies.tests
  (:require [clojure.test :refer :all]
            [scramblies.core :as sc]))

(deftest normalize
  (is (= "a" (sc/normalize "A")))
  )

(deftest min-frequencies-met?
  (is (sc/min-frequencies-met? "helllo" "hello"))
  )

(deftest scramble
  (testing "given cases"
    (is (sc/scramble? "cedewaraaossoqqyt" "codewars"))
    (is (sc/scramble? "rekqodlw" "world"))
    (is (false? (sc/scramble? "katas" "steak"))))

  (testing "duplicate letters in world"
    (is (false? (sc/scramble? "helo" "hello"))))
  
  #_(testing "foo"
      (is (false? (sc/scramble? "heloa" "hello"))))
  )


(comment
  (clojure.test/run-tests 'scramblies.tests)
  )
