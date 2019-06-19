(defproject  scramblies "0.0.1"
  :dependencies [[org.clojure/clojure "1.10.0"]  
                 [org.clojure/clojurescript "1.10.520"]
                 [com.taoensso/timbre "4.10.0"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [reagent "0.8.1"]
                 [binaryage/devtools "0.9.10"]
                 [org.clojure/core.async "0.4.490"]                 
                 ]

  :plugins [[lein-figwheel "0.5.18"]
            [lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    :target-path]

  :figwheel {:server-port 3449}
  
  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/cljs" "src/cljc" ]
                :figwheel {:websocket-host :js-client-host}
                :compiler {:main scramblies.core
                           :asset-path "js/compiled/dev"
                           :output-to "resources/public/js/compiled/scramblies.js"
                           :output-dir "resources/public/js/compiled/dev"
                           :source-map-timestamp true
                           :preloads [devtools.preload]}}]}
  
  :profiles {:project/dev {:dependencies [[figwheel-sidecar "0.5.18"]
                                          [cider/piggieback "0.4.0"]]
                           :source-paths ["src/clj" "src/cljc"]}
             :dev [:project/dev]
             :test {:source-paths ["src/clj" "test"]}
             }

  )
