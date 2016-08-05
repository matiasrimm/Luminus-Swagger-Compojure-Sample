(ns user
  (:require [mount.core :as mount]
            abc.core))

(defn start []
  (mount/start-without #'abc.core/repl-server))

(defn stop []
  (mount/stop-except #'abc.core/repl-server))

(defn restart []
  (stop)
  (start))


