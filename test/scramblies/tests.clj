(ns scramblies.tests
  (:require [clojure.test :refer :all]
            [scramblies.core :as sc]))

(deftest normalize
  (testing "lower case letters only"
    (is (= "a" (sc/normalize "A"))))

  (testing "no punctuations"
    (is (clojure.string/blank? (sc/normalize "[?.,#!$%^&*;:{}=-_`~()]"))))

  (testing "no digits"
    (is (clojure.string/blank? (sc/normalize "1234567890")))
    (sc/normalize "1234567890 a b c") "a b c"
    (is (= (sc/normalize "1234567890 a b c") "a b c"))))

(deftest scramble
  (testing "given cases"
    (is (sc/scramble? "cedewaraaossoqqyt" "codewars"))
    (is (sc/scramble? "rekqodlw" "world"))
    (is (false? (sc/scramble? "katas" "steak"))))

  (testing "duplicate letters"
    (is (sc/scramble? "hello" "hello"))
    (is (false? (sc/scramble? "helo" "hello")))
    )
  )


(comment
  (clojure.test/run-tests 'scramblies.tests)
  )
