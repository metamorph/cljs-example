(defproject full-stack "0.1.0-SNAPSHOT"
  :description "Testing Cljs AND Compojure"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.0"]
                 [ring/ring-defaults "0.2.0"]
                 [ring/ring-json "0.4.0"]
                 ;; Clojurescript
                 [org.clojure/clojurescript "1.8.40"]
                 [cljs-ajax "0.5.4"]
                 [prismatic/dommy "1.1.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-figwheel "0.5.2"]
            [lein-cljsbuild "1.1.3"]]
  :ring {:handler full-stack.handler/app}
  :cljsbuild {:builds [{:id "full-stack"
                        :source-paths ["src/cljs"]
                        :figwheel true
                        :compiler {:main full-stack.app
                                   :asset-path "js/out"
                                   :output-to "resources/public/js/app.js"
                                   :output-dir "resources/public/js/out"
                                   }}]}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]}})
