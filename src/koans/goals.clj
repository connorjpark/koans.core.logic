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
