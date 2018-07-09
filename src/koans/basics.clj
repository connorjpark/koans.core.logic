(meditations
 "What is always untrue, shall yield no answer."
 (= (run* [q] fail) ())

 "The truth always sycceeds."
 (= (run* [q] (== q true)) '(true))

 "If one falls, all fall."
 (= (run* [q]
      u#
      (== q true)) ())

 "If they all stand, we succeed."
 (= (run* [q]
      s#
      (== q true)) '(true))

 "What you want, is what you get."
 (= (run* [q]
      (== q :logic-fun)) '(:logic-fun))

 "Those that are not equal, do not talk to each other."
 (= (run* [x]
      (let [x false]
        (== true x))) ())

 "New values are fresh, and juicy, and behave as others."
 (= (run* [q]
      (fresh [x]
        (== true x)
        (== true q))) '(true))

 "Unbound success is infinite, yet, representable."
 (= (run* [q] s#) '(_0))

 "Infinity twice is two different infinities."
 (= (run* [q] (fresh [x y]
                (== q [x y]))) '([_0 _1]))

 "However, the same infinity remains the same when referred to twice."
 (= (run* [q] (fresh [x y]
                (== q [x y x]))) '([_0 _1 _0]))

 "Something which is, cannot be something else at the same time."
 (= (run* [q]
      (== q true)
      (== q false)) ())

 "Something which is, may be itself again."
 (= (run* [q]
      (== q false)
      (== q false)) '(false))

 "Something which is, is transitively so."
 (= (run* [q]
      (let [x q]
        (== x true))) '(true))

 "Something which is, is transitively so, when fresh, too."
 (= (run* [q]
      (fresh [x]
        (== q x)
        (== true x))) '(true)))
