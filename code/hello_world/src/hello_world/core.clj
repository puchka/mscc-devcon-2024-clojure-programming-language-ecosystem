(ns hello-world.core)

(defn Y [f]
  ((fn [x] (x x))
   (fn [x]
     (f (fn [& args]
          (apply (x x) args))))))

(def fac
     (fn [f]
       (fn [n]
         (if (zero? n) 1 (* n (f (dec n)))))))

(def fib
     (fn [f]
       (fn [n]
         (condp = n
           0 0
           1 1
           (+ (f (dec n))
              (f (dec (dec n))))))))

(defn -main [_]
  (println "Hello, world!")
  ((Y fac) 10)
  ((Y fib) 10)
  )
