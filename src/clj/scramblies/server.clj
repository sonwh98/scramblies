(ns scramblies.server
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as r]
            [org.httpkit.server :as h]
            [taoensso.timbre :as log :include-macros true])
  (:gen-class))

(defroutes app
  (r/resources "/")
  (r/not-found "<h1>Route not defined</h1>"))

(defonce stop-fn (atom nil))

(defn start []
  (reset! stop-fn (h/run-server app {:port 3004})))

(defn stop []
  (when @stop-fn
    (@stop-fn :timeout 100)))


(defn -main [& args]
  (log/info "Starting server...")
  (start)
  (log/info "Server started"))
