(meditations
 "If a question is false, it does not succeed, but true does."
 (= (run* [q]
      (conde
       [u# s#]
       [s# (== q true)])) '(true))

 "All questions shall be answered."
 (= (run* [q]
      (conde
       [(== q :apple)]
       [(== q :orange)])) '(:apple :orange))

 "When asked a single question, we shall receive a single answer."
 (= (run 1 [q]
      (conde
       [(== q :orange)]
       [(== q :apple)])) '(:orange))

 "Failures do not matter, but succeess always does!"
 (= (run* [q]
      (conde
       [(== q :pear) u#]
       [(== q :apple)]
       [s# s#]
       [(== q :orange)])) '(:apple _0 :orange))

 "Every part of a question needs an answer, or the question itself
 shall fail."
 (= (run* [q]
      (conde
       [(== q :logic)]
       [(== q :is) fail]
       [(== q :fun)]))
    '(:logic :fun))
 )
