(meditations
 "What is always untrue, shall yield no answer."
 (= (run* [q] fail) ())

 "The truth always sycceeds."
 (= (run* [q] (== q true)) '(true))

 "If one falls, all fall."
 (= (run* [q]
      u#
      (== q true)) __)

 "If they all stand, we succeed."
 (= (run* [q]
      s#
      (== q true)) __)

 "What you want, is what you get."
 (= (run* [q]
      (== q :logic-fun)) __)

 "Those that are not equal, do not talk to each other."
 (= (run* [x]
      (let [x false]
        (== true x))) __)

 "New values are fresh, and juicy, and behave as others."
 (= (run* [q]
      (fresh [x]
        (== true x)
        (== true q))) __)

 "Unbound success is infinite, yet, representable."
 (= (run* [q] s#) __)

 "Infinity twice is two different infinities."
 (= (run* [q] (fresh [x y]
                (== q [x y]))) __)

 "However, the same infinity remains the same when referred to twice."
 (= (run* [q] (fresh [x y]
                (== q [x y x]))) __)

 "Something which is, cannot be something else at the same time."
 (= (run* [q]
      (== q true)
      (== q false)) __)

 "Something which is, may be itself again."
 (= (run* [q]
      (== q false)
      (== q false)) __)

 "Something which is, is transitively so."
 (= (run* [q]
      (let [x q]
        (== x true))) __)

 "Something which is, is transitively so, when fresh, too."
 (= (run* [q]
      (fresh [x]
        (== q x)
        (== true x))) __))
