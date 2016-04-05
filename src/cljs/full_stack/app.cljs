(ns full-stack.app
  (:require [full-stack.greet :as greet]
            [dommy.core :as dommy :refer-macros [sel sel1]]))

(defn click-handler [e]
  (.log js/console "Calling click handler")
  (greet/say-hello))

(dommy/listen! (sel1 :#theButton) :click click-handler)

(.log js/console "Hello Cljs, again")
