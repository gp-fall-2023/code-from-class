(ns code-from-class.class5)

(def more-nums '(1 2 3 4 5))

(def cube
  (fn [x]
    (* x x x)))

;; equivalent to

(defn cube-again
  [x]
  (* x x x))

(comment

  more-nums
  ;; => (1 2 3 4 5)

  (cube 6)
  ;; => 216

  (cube-again 6)
  ;; => 216

  ;; we can create locally-scoped functions using let:
  (let [local-cube (fn [x] (* x x x))]
    (local-cube 6))
  ;; => 216

  (local-cube 6)
  ;; => Syntax error compiling at (src/code_from_class/class5.clj:31:3).
  ;;    Unable to resolve symbol: local-cube in this context


  ;; maps: like dictionaries in Python, or hash-maps in C++

  ; empty map:
  {}
  ;; => {}

  {:apples 4
   :bananas 12
   :carrots 3}
  ;; => {:apples 4, :bananas 12, :carrots 3}

  ;; in Clojure, commas are treated as whitespace

  (def room-colors {:dining-room :red
                    :kitchen :blue
                    :living-room :green
                    :bedroom :blue})

  room-colors
  ;; => {:dining-room :red, :kitchen :blue, :living-room :green, :bedroom :blue}

  ;; Adds a key-value pair to a map and returns the resulting map
  (assoc room-colors :bathroom :cerulean)
  ;; => {:dining-room :red, :kitchen :blue, :living-room :green, :bedroom :blue, :bathroom :cerulean}

  room-colors
  ;; => {:dining-room :red, :kitchen :blue, :living-room :green, :bedroom :blue}

  (assoc room-colors :office :white)
  ;; => {:dining-room :red, :kitchen :blue, :living-room :green, :bedroom :blue, :office :white}

  (assoc room-colors :bathroom :cerulean :office :white)
  ;; => {:dining-room :red, :kitchen :blue, :living-room :green, :bedroom :blue, :bathroom :cerulean, :office :white}

  (assoc room-colors :kitchen :black)
  ;; => {:dining-room :red, :kitchen :black, :living-room :green, :bedroom :blue}

  (get room-colors :kitchen)
  ;; => :blue

  (get room-colors :den)
  ;; => nil

  (get room-colors :den :white)
  ;; => :white

  (contains? room-colors :den)
  ;; => false

  (contains? [1 2 35 4] 35)
  ;; => false

  (contains? [1 2 35 4] 3)
  ;; => true

  ;; this is actually how you'd check if 35 is in a vector
  (some #{35} [1 2 35 4])
  ;; => 35

  (some #{3} [1 2 35 4])
  ;; => nil

  (some #{3} {:a 3 :b 6})
  ;; => nil

  (some #{[:a 3]} {:a 3 :b 6})
  ;; => [:a 3]

  ;; when you run a function on a map where the function expects
  ;; the map to be treated like a sequence, it first calls
  ;; seq on the map
  (seq {:a 3 :b 6})
  ;; => ([:a 3] [:b 6])

  ;; seq on a map creates a sequence of key-value pairs as vectors

  (keys room-colors)
  ;; => (:dining-room :kitchen :living-room :bedroom)

  (vals room-colors)
  ;; => (:red :blue :green :blue)

  {1 "hi"
   "world" 72
   -23.22 true}
  ;; => {1 "hi", "world" 72, -23.22 true}

  ;; Both of these are equivalent to (get room-colors :kitchen)
  (room-colors :kitchen)
  ;; => :blue

  (:kitchen room-colors)
  ;; => :blue

  (:kitchen 6)
  ;; => nil

  (-23.44 room-colors)
  ;; => Execution error (ClassCastException) at code-from-class.class5/eval6139 (REPL:133).
  ;;    class java.lang.Double cannot be cast to class clojure.lang.IFn (java.lang.Double is in module java.base of loader 'bootstrap'; clojure.lang.IFn is in unnamed module of loader 'app')

  'dog
  ;; => dog

  dog
  ;; => Syntax error compiling at (src/code_from_class/class5.clj:0:0).
  ;;    Unable to resolve symbol: dog in this context


  ('dog {'cat 5 'dog 2})
  ;; => 2

  ('keys {'cat 5 'dog 2})
  ;; => nil

  (room-colors "hi")
  ;; => nil

  ([1 2 3] 2)
  ;; => 3

  (nth [1 2 3] 2)
  ;; => 3

  ([1 2 3] "hi")
  ;; => Execution error (IllegalArgumentException) at code-from-class.class5/eval6155 (REPL:160).
  ;;    Key must be integer

  ('(1 2 3) 2)
  ;; => Execution error (ClassCastException) at code-from-class.class5/eval6157 (REPL:164).
  ;;    class clojure.lang.PersistentList cannot be cast to class clojure.lang.IFn (clojure.lang.PersistentList and clojure.lang.IFn are in unnamed module of loader 'app')


  (range 6)
  ;; => (0 1 2 3 4 5)

  (range 4 12)
  ;; => (4 5 6 7 8 9 10 11)

  (range 4 20 3)
  ;; => (4 7 10 13 16 19)

  (def nums (range 4 12))
  ;; => #'code-from-class.class5/nums

  nums
  ;; => (4 5 6 7 8 9 10 11)

  (type nums)
  ;; => clojure.lang.LongRange


  ;; Higher-order functions - functions that take functions
  ;; as arguments or return functions

  (+ nums)
  ;; => Execution error (ClassCastException) at java.lang.Class/cast (Class.java:3991).
  ;;    Cannot cast clojure.lang.LongRange to java.lang.Number

  (apply + nums)
  ;; => 60

  ;; this is equivalent to:
  (+ 4 5 6 7 8 9 10 11)
  ;; => 60

  ;; apply takes a function and a sequence
  ;; it calls the function with all elements in sequence as arguments

  ;; ariatic functions -- functions that take different numbers of arguments

  (str nums)
  ;; => "(4 5 6 7 8 9 10 11)"

  (apply str nums)
  ;; => "4567891011"

  (max nums)
  ;; => (4 5 6 7 8 9 10 11)

  (apply max nums)
  ;; => 11


  (inc 5)
  ;; => 6

  (dec 5)
  ;; => 4

  ;; map function - different from map data structures
  ;; function that applies a function to every element of
  ;; a sequence and returns a new sequence of those applied elements

  nums
  ;; => (4 5 6 7 8 9 10 11)

  (map inc nums)
  ;; => (5 6 7 8 9 10 11 12)

  (map cube nums)
  ;; => (64 125 216 343 512 729 1000 1331)

  ;; we can use map with anon functions
  (map (fn [x] (* x 5))
       nums)
  ;; => (20 25 30 35 40 45 50 55)

  ;; this is equivalent to above, and used for simple anon fns
  (map #(* % 5)
       nums)
  ;; => (20 25 30 35 40 45 50 55)

  (def words '("truck" "elephant" "balloon" "tiger"))
  ;; => #'code-from-class.class5/words


  words
  ;; => ("truck" "elephant" "balloon" "cat")

  (map str
       nums
       words)
  ;; => ("4truck" "5elephant" "6balloon" "7cat")

  (map + nums (range 100))
  ;; => (4 6 8 10 12 14 16 18)

  (+ 4)
  ;; => 4

  (map + nums)
  ;; => (4 5 6 7 8 9 10 11)

  (map #(nth %1 %2)
       words
       (range 100))
  ;; => (\t \l \l \e)

  \t
  ;; => \t

  \space
  ;; => \space

  (println \space)
  ;; => nil

  (defn multi-arity
    [& the-args]
    (map str the-args))

  (multi-arity 5 6)
  ;; => ("5" "6")

  (multi-arity 1 2 3 :cat)
  ;; => ("1" "2" "3" ":cat")


  (< 3 5 6 8)
  ;; => true


  (defn sorted-by-length?
    "Takes a list of strings and returns true if they are
     sorted by length."
    [strings]
    (let [lengths (map count strings)]
      (apply <= lengths)))
  
  (sorted-by-length? '("cat" "elephant" "dog"))
  ;; => false

  (sorted-by-length? '("cat" "wolf" "elephant"))
  ;; => true










  )