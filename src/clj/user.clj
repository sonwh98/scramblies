(ns user
  (:require [figwheel-sidecar.repl-api :as f]
            [scramblies.server :as s]
            [taoensso.timbre :as log :include-macros true]))

(defn start []
  (s/start)
  #_(f/start-figwheel!))

(defn stop []
  #_(f/stop-figwheel!)
  (s/stop))

(defn cljs []
  (f/cljs-repl))

(log/set-level! :info)
