(ns full-stack.greet
  (:require [ajax.core :refer [GET POST]]
            [dommy.core :as dommy :refer-macros [sel sel1]]))

(defn handler [response]
  (.log js/console "server responded...")
  (-> (sel1 :.fromServer)
      (dommy/set-text!
       (str "Hello, " (aget (clj->js response) "greeting")))))

(defn error-handler [{:keys [status status-text]}]
  (.log js/console (str "something bad happened: " status " " status-text)))

(defn say-hello []
  (POST "/hello"
        {:params {:user "client is saying hello."}
         :handler handler
         :error-handler error-handler
         :format :json
         :response-format :json}))
