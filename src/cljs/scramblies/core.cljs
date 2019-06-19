(ns scramblies.core
  (:require [reagent.core :as r]
            [reagent.dom :as dom]
            [goog.Uri]
            [goog.net.XhrIo :as xhr]
            [cljs.reader]))

(enable-console-print!)
(def app-state (r/atom {}))

(defn get-value [id]
  (.. (js/document.getElementById id)
      -value))

(defn scramble-ui [state]
  [:div
   "(scramble "
   [:input#str1 {:placeholder "str1"}]
   [:input#str2 {:placeholder "str2"}]
   ")  "
   "= " (-> @state :result str)
   [:br]
   [:button {:on-click (fn [evt]
                         (let [str1 (get-value "str1")
                               str2 (get-value "str2")
                               uri-str (str "/scramble?str1=" str1 "&str2=" str2)
                               uri (goog.Uri. uri-str)]
                           (prn "uri-str=" uri-str)
                           (xhr/send uri  (fn [reply]
                                            (let [edn-str (.. reply -target getResponse)
                                                  edn (cljs.reader/read-string edn-str)
                                                  result (:result edn)]
                                              (prn "result=" result)
                                              (swap! state assoc :result result)))))
                         )} "evaluate"]]
  )

(defn init []
  (r/render-component [scramble-ui app-state] (js/document.getElementById "app"))    
  )

(init)
