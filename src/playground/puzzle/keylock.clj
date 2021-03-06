(ns playground.keylock
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic :only [fresh run*]])
  (:require [clojure.core.logic.fd :as fd]))

;; There is a safe, which can be opened by entering five numbers. We
;; do not know the numbers, only their relationships:
;;
;;  * The sum of the 5th and 3rd is 14.
;;  * The 4th is the 2nd plus 1.
;;  * The 1st is the double of the 2nd minus 1.
;;  * The sum of the 2nd and 3rd is 10.
;;  * The sum of all five is 30.
;;
;;  What are the numbers?"

(defn keylock
  []

  (first (run* [n1 n2 n3 n4 n5]
           (fd/in n1 n2 n3 n4 n5 (fd/interval 0 30))

           (fd/+ n3 n5 14)        ;; #5 + #3 = 14
           (fd/+ n2 1 n4)         ;; #2 + 1 = #4
           (fresh [m2]
             (fd/* n2 2 m2)
             (fd/- m2 1 n1))      ;; #1 = #2 * 2 - 1
           (fd/+ n2 n3 10)        ;; #2 + #3 = 10
           (fresh [n12 n34 n1234]
             (fd/+ n1 n2 n12)
             (fd/+ n3 n4 n34)
             (fd/+ n12 n34 n1234)
             (fd/+ n1234 n5 30)) ;; #1 + #2 + #3 + #4 + #5 = 30
           )))
