(meditations
 "The firsto relation works similarly to first first. Many interesting goals have 'output'
variables. What do you think q will be in this case?"
 (= (run* [q]
      (fresh [s]
        (== s '(a b c))
        (firsto s q)))
    '(a))

 "Relations are a bit more general than functions. We can infer inputs if we
have the output. For example firsto will give an answer that represents *any*
list that starts with the symbol a."
 (= (run* [q]
      (firsto q 'a))
    [(lcons 'a '_0)])

 "It's perhaps easier to see this in action with conso. What value of q will
satisfy this relation"
 (= (run* [q]
      (conso 'a q '(a b c)))
    '((b c)))

 "What value of q will satisfy the relation?"
 (= (run* [q]
      (conso q '(b c) '(a b c)))
    '(a))

 "What will the output value of conso be if we provide only logic vars?"
 (= (run* [q]
      (fresh [a d]
        (conso a d q)))
    [(lcons '_0 '_1)])

 "membero is an interesting relation. it checks for membership. What are
values of q that satisfy this relation?"
 (= (run* [q]
      (membero q '(cat dog bird)))
    '(cat dog bird))

 "How about now?"
 (= (run* [q]
      (membero q '(cat dog bird))
      (membero q '(dog bird zebra)))
    '(dog bird))

 "Here we give run a specific number to control how many answers we get. Think
carefully. Is there only one list in the universe that satisfies this relation?
Are there infinitely many?"
 (= (run 1 [q]
      (membero 'cat q))
    [(lcons 'cat '_0)])

 "What is the second answer? This one is quite hard. It's ok to cheat on this one :)
What does the answer mean? Does it seem like it might be dangerous to use run* on this
particular use of membero?"
 (= (second
     (run 2 [q]
       (membero 'cat q)))
    (lcons '_0 (lcons 'cat '_1)))
 )


"Apple teaser riddle"


(def n 23)
#spy/d (even? n)

#spy/d (+ (rand-int 11) 10)

#spy/d (run* [q]
         (== q 1))

#spy/d (time
        (run* [q]
          (let [non-primes '(4 6 8 9 10 12 14 15 16 18 20 21 22 24 25 26 27) odds (filter odd? (range 3 28))]
            (fresh [x y z t]
              (== x 5)
              ;;(== y 7)
              (membero y (range 1 10))
              (membero z (range 1 10))
              (!= x y)
              (!= y z)
              (!= x z)
              (membero t non-primes)
              (membero t odds)
              (project [x y z] (== t (+ x y z)))
              (== q [:you x :pip y :blossom z :total t])))))


#spy/d (run* [q]
         (fresh [x y z]
           (== x 1)
           (== y 2)
           (project [x y] (== z (+ x y)))
           (== q z)))


#spy/d (run* [q]
         (fresh [x1 x2 x3 total]
           (!= x1 x2)
           (!= x2 x3)
           (!= x1 x3)
           (== x1 5)
           (== x2 (rand-nth (remove #(= x1 %) (range 1 10))))
           (== x3 (rand-nth (remove #(= x2 %) (remove #(= x1 %) (range 1 10)))))
           (== total (filter odd? (range 8 25)))
           (== q total)))
