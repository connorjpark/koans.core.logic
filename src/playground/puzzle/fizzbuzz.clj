(ns playground.keylock
  (:refer-clojure :exclude [==])
  (:use [clojure.core.logic :refer :all])
  (:require [clojure.core.logic.fd :as fd]))

(defn multc
  "Ensure that `n` is a multiplicate of `div`."
  [n div]

  (fresh [x]
         (fd/quot n div x)))

(defnc !multc
  [n div]

  (when (number? n)
    (not (zero? (rem n div)))))

(defn fizzbuzzo
  [?n q]

  (conde
   [(multc  ?n 3) (multc  ?n 5) (== q :fizzbuzz)]
   [(multc  ?n 3) (!multc ?n 5) (== q :fizz)]
   [(multc  ?n 5) (!multc ?n 3) (== q :buzz)]
   [(!multc ?n 3) (!multc ?n 5) (== q ?n)]))

(defn fizzbuzz
  [n]

  (first (run* [q]
           (fizzbuzzo n q))))

(defn fizzbuzz-seq*
  [start end list]

  (conde
   [(== start end) (== list [])]
   [(!= start end) (fresh [s+1 tail r]
                     (fd/+ start 1 s+1)
                     (fizzbuzzo start r)
                     (fizzbuzz-seq* s+1 end tail)
                     (conso r tail list))]))

(defn fizzbuzz-seq
  [stop]

  (first (run* [q] (fizzbuzz-seq* 1 (inc stop) q))))

(defn find-fizzbuzz-index-for
  [v & opts]

  (let [opts# (apply hash-map opts)
        limit (:limit opts#)
        max (get opts# :max Integer/MAX_VALUE)]
    (if limit
      (run limit [q]
           (fizzbuzzo q v)
           (fd/in q (fd/interval 1 max)))
      (run* [q]
            (fizzbuzzo q v)
            (fd/in q (fd/interval 1 max))))))
