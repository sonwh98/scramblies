(ns scramblies.server
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as r]
            [ring.middleware.params :as ring]
            [org.httpkit.server :as h]
            [taoensso.timbre :as log :include-macros true]
            [scramblies.core :as s])
  (:gen-class))

(defroutes app
  (GET "/scramble" [str1 str2 :as req]
       (str {:args [str1 str2]
             :result (s/scramble? str1 str2)}))
  (r/resources "/")
  (r/not-found "<h1>Route not defined</h1>"))

(defonce stop-fn (atom nil))

(defn start []
  (reset! stop-fn (h/run-server (ring/wrap-params app) {:port 3000})))

(defn stop []
  (when @stop-fn
    (@stop-fn :timeout 100)))


(defn -main [& args]
  (log/info "Starting server...")
  (start)
  (log/info "Server started"))
